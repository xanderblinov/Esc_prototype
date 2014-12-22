package net.inference.sqlite;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import net.inference.database.DatabaseApi;
import net.inference.database.dto.Article;
import net.inference.sqlite.dto.ArticleImpl;

/**
 * Date: 12/21/2014
 * Time: 9:33 PM
 *
 * @author xanderblinov
 */
public class SqliteApi implements DatabaseApi
{
	private DbHelper mDbHelper = new DbHelper();

	public Dao<ArticleImpl, ?> getArticleDao() throws SQLException
	{
		return DaoManager.createDao(mDbHelper.getConnection(), ArticleImpl.class);
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
	public void addArticle(final Article article)
	{
		try
		{
			getArticleDao().createIfNotExists((ArticleImpl) article);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
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
