package net.inference.sqlite;

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
				databaseApi.addAuthorToCluster(new AuthorToClusterImpl(i, cluster.getId()));
			}

		}


	}


	private void fillTestEvolution(final DatabaseApi databaseApi, final int size, final int clickSize)
	{


		for (int m = 0; m < size; m += clickSize)
		{


			for (int i = m; i < m + clickSize; i++)
			{
				Author author = new AuthorImpl();
				author.setName("name" + String.valueOf(i));
				author.setSurname("surname" + String.valueOf(i));
				author.setEncoding("encoding" + String.valueOf(i));
				databaseApi.addAuthor(author);
			}

			for (int i = m; i < m + clickSize; i++)
			{
				for (int j = i; j < m + clickSize; j++)
				{
					databaseApi.addCoAuthorship(new CoAuthorshipImpl(i, j));
					if (i != j)
					{
						databaseApi.addCoAuthorship(new CoAuthorshipImpl(j, i));
					}
				}
			}

			if (m + clickSize < size)
			{
				databaseApi.addCoAuthorship(new CoAuthorshipImpl(m + clickSize - 1, m + clickSize));
				databaseApi.addCoAuthorship(new CoAuthorshipImpl(m + clickSize, m + clickSize - 1));
			}

		}


	}
}
