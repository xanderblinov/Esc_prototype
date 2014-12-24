package net.inference.sqlite;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import net.inference.Config;
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
	private final DbHelper mDbHelper;
	private DaoFactory mDaoFactory = new SqliteDaoFactory();
	private ArticleApi mArticleApi = new ArticleApiImpl(this);

	public SqliteApi(Config.Database database)
	{

		mDbHelper = new DbHelper(database);
	}

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
