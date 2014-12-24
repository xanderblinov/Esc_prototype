package net.inference.sqlite;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import net.inference.database.ArticleApi;
import net.inference.database.DaoFactory;
import net.inference.database.DatabaseApi;
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
	private DaoFactory mDaoFactory = new SqliteDaoFactory();
	private ArticleApi mArticleApi = new ArticleApiImpl(this);

	Dao<ArticleImpl, ?> getArticleDao() throws SQLException
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
	public DaoFactory daoFactory()
	{
		return mDaoFactory;
	}

	@Override
	public ArticleApi article()
	{
		return mArticleApi;
	}
}
