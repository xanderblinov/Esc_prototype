package net.inference.sqlite;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import net.inference.Config;
import net.inference.database.ArticleApi;
import net.inference.database.DaoFactory;
import net.inference.database.DatabaseApi;
import net.inference.database.dto.Article;
import net.inference.database.dto.Author;
import net.inference.database.dto.AuthorToCluster;
import net.inference.database.dto.Cluster;
import net.inference.database.dto.Clustering;
import net.inference.database.dto.ClusteringSlice;
import net.inference.database.dto.CoAuthorship;
import net.inference.sqlite.dto.ArticleImpl;
import net.inference.sqlite.dto.AuthorImpl;
import net.inference.sqlite.dto.AuthorToClusterImpl;
import net.inference.sqlite.dto.ClusterImpl;
import net.inference.sqlite.dto.ClusteringImpl;
import net.inference.sqlite.dto.ClusteringSliceImpl;
import net.inference.sqlite.dto.CoAuthorshipImpl;

/**
 * Date: 12/21/2014
 * Time: 9:33 PM
 *
 * @author xanderblinov
 */
public class SqliteApi implements DatabaseApi
{
	private final DbHelper mDbHelper;
	private DaoFactory mDaoFactory = new SqliteDaoFactory();
	private ArticleApi mArticleApi = new ArticleApiImpl(this);

	public SqliteApi(Config.Database database)
	{
		mDbHelper = new DbHelper(database);
	}

	@Override
	public void onStart()
	{
		mDbHelper.onStart();
	}

	@Override
	public void onStop()
	{
		mDbHelper.onStop();
	}


	@Override
	public DaoFactory daoFactory()
	{
		return mDaoFactory;
	}

	@Override
	public ArticleApi article()
	{
		return mArticleApi;
	}

	public Dao<ArticleImpl, ?> getArticleDao() throws SQLException
	{
		return DaoManager.createDao(mDbHelper.getConnection(), ArticleImpl.class);
	}

	Dao<AuthorImpl, ?> getInferenceAuthorDao() throws SQLException
	{
		return DaoManager.createDao(mDbHelper.getConnection(), AuthorImpl.class);
	}

	Dao<CoAuthorshipImpl, ?> getInferenceCoAuthorshipDao() throws SQLException
	{
		return DaoManager.createDao(mDbHelper.getConnection(), CoAuthorshipImpl.class);
	}

	Dao<AuthorToClusterImpl, ?> getAuthorToClusterDao() throws SQLException
	{
		return DaoManager.createDao(mDbHelper.getConnection(), AuthorToClusterImpl.class);
	}

	Dao<ClusterImpl, ?> getClusterDao() throws SQLException
	{
		return DaoManager.createDao(mDbHelper.getConnection(), ClusterImpl.class);
	}

	Dao<ClusteringImpl, ?> getClusteringDao() throws SQLException
	{
		return DaoManager.createDao(mDbHelper.getConnection(), ClusteringImpl.class);
	}

	Dao<ClusteringSliceImpl, ?> getClusteringSliceDao() throws SQLException
	{
		return DaoManager.createDao(mDbHelper.getConnection(), ClusteringSliceImpl.class);
	}


	@Override
	public Article addArticle(final Article article)
	{
		try
		{
			return getArticleDao().createIfNotExists((ArticleImpl) article);
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
		return null;
	}

	@Override
	public Author addAuthor(final Author author)
	{
		try
		{
			return getInferenceAuthorDao().createIfNotExists((AuthorImpl) author);
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
		return null;
	}

	@Override
	public CoAuthorship addCoAuthorship(final CoAuthorship author)
	{
		try
		{
			return getInferenceCoAuthorshipDao().createIfNotExists((CoAuthorshipImpl) author);
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
		return null;
	}

	@Override
	public boolean addAuthorToCluster(final AuthorToCluster authorToCluster)
	{
		try
		{
			return getAuthorToClusterDao().create((AuthorToClusterImpl) authorToCluster) == 1;
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
		return false;
	}

	@Override
	public Cluster addCluster(final Cluster cluster)
	{
		try
		{
			return getClusterDao().createIfNotExists((ClusterImpl) cluster);
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
		return null;
	}

	@Override
	public Clustering addClustering(final Clustering clustering)
	{
		try
		{
			return getClusteringDao().createIfNotExists((ClusteringImpl) clustering);
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
		return null;
	}

	@Override
	public ClusteringSlice addClusteringSlice(final ClusteringSlice clusteringSlice)
	{
		try
		{
			return getClusteringSliceDao().createIfNotExists((ClusteringSliceImpl) clusteringSlice);
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
		return null;
	}


	@Override
	public List<ArticleImpl> getAllArticles()
	{

		try
		{
			return getArticleDao().queryForAll();
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}

		return null;
	}
}
