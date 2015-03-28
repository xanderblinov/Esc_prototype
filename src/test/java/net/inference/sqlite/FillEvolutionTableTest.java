package net.inference.sqlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import net.inference.Config;
import net.inference.database.DatabaseApi;
import net.inference.database.dto.Author;
import net.inference.database.dto.Cluster;
import net.inference.database.dto.Evolution;
import net.inference.database.dto.EvolutionSlice;
import net.inference.database.dto.ClusteringType;
import net.inference.sqlite.dto.AuthorImpl;
import net.inference.sqlite.dto.AuthorToClusterImpl;
import net.inference.sqlite.dto.ClusterImpl;
import net.inference.sqlite.dto.EvolutionImpl;
import net.inference.sqlite.dto.EvolutionSliceImpl;
import net.inference.sqlite.dto.CoAuthorshipImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 12/19/2014
 * Time: 3:29 PM
 *
 * @author xanderblinov
 */


public class FillEvolutionTableTest
{

	public static void main(String[] args) throws Exception
	{
		FillEvolutionTableTest accountApp = new FillEvolutionTableTest();
		accountApp.execute();

	}

	private void execute()
	{
		DatabaseApi databaseApi = new SqliteApi(Config.Database.TEST);
		databaseApi.onStart();

		// create an instance of ArticleImpl
		/*Article article = new ArticleImpl();
		article.setName("Article 1");
		databaseApi.addArticle(article);


		Article article2 = databaseApi.getAllArticles().get(0);

		System.out.println("Article: " + article2.getName());*/

		fillTestEvolution(databaseApi, 15, 5);
		addEvolution(databaseApi,15,5,1991);
		databaseApi.onStop();
	}

	private void addEvolution(final DatabaseApi databaseApi, final int size, final int clickSize, final int year)
	{
		Evolution evolution = new EvolutionImpl();
		evolution.setType(ClusteringType.SCAN);

		evolution = databaseApi.addEvolution(evolution);

		for (int m = 0, i = year; m < size; m += clickSize, i++)
		{
			addSlice(databaseApi, size - m, clickSize, String.valueOf(i), evolution);
		}
	}

	private void addSlice(final DatabaseApi databaseApi, final int size, final int clickSize, final String year, final Evolution evolution)
	{
        AuthorUtils authorUtils = new AuthorUtils(databaseApi);

		EvolutionSlice evolutionSlice = new EvolutionSliceImpl();
		evolutionSlice.setTime(year);
		evolutionSlice.setYear(year);
		evolutionSlice.setEvolutionId(evolution.getId());
		evolutionSlice = databaseApi.addEvolutionSlice(evolutionSlice);


		for (int m = 0; m < size; m += clickSize)
		{
			Cluster cluster = new ClusterImpl(evolutionSlice.getId());
			databaseApi.addCluster(cluster);
			for (int i = m; i < m + clickSize; i++)
			{
				databaseApi.addAuthorToCluster(new AuthorToClusterImpl(authorUtils.queryAuthorIdForName("name" + i), cluster.getId()));
			}

		}


	}


	private void fillTestEvolution(final DatabaseApi databaseApi, final int size, final int clickSize)
	{

        AuthorUtils authorUtils = new AuthorUtils(databaseApi);
        long firstId, secondId;
		for (int m = 0; m < size; m += clickSize)
		{


			for (int i = m; i < m + clickSize; i++)
			{
				Author author = new AuthorImpl();
				author.setName("name" + String.valueOf(i));
				author.setSurname("surname" + String.valueOf(i));
				author.setEncoding("encoding" + String.valueOf(i));
                author.setClick("click" + (m / clickSize));
				databaseApi.addAuthor(author);
			}

			for (int i = m; i < m + clickSize; i++)
			{
				for (int j = i; j < m + clickSize; j++)
				{
                    firstId = authorUtils.queryAuthorIdForName("name" + i);
                    secondId = authorUtils.queryAuthorIdForName("name" + j);

                    databaseApi.addCoAuthorship(new CoAuthorshipImpl(firstId, secondId));
					if (i != j)
					{
						databaseApi.addCoAuthorship(new CoAuthorshipImpl(secondId, firstId));
					}
				}
			}

			if (m + clickSize < size)
			{
                firstId = authorUtils.queryAuthorIdForName("name" + (m + clickSize - 2));
                secondId = authorUtils.queryAuthorIdForName("name" + (m + clickSize-1));

				databaseApi.addCoAuthorship(new CoAuthorshipImpl(firstId, secondId));
				databaseApi.addCoAuthorship(new CoAuthorshipImpl(secondId, firstId));
			}

		}


	}

    /**
     * Utility class only for test data
     */
    private class AuthorUtils {
        private Dao<AuthorImpl, Integer> authorDao;
        private final Logger logger = LoggerFactory.getLogger(AuthorUtils.class);

        public AuthorUtils(DatabaseApi databaseApi) {
            try {
                authorDao =  ((SqliteApi) databaseApi).getInferenceAuthorDao();
            } catch (SQLException e) {
                logger.error("Failed to obtain Author dao", e);
            }
        }

        long queryAuthorIdForName(final String authorName) {
            Map<String, Object> values = new HashMap<String, Object>();
            values.put("name", authorName);
            try {
                List<AuthorImpl> authors = authorDao.queryForFieldValues(values);
                if (authors == null || authors.size() == 0) {
                    return -1;
                }
                return authorDao.extractId(authors.get(0)).longValue();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -1;
        }
    }
}
