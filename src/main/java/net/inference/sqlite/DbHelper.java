package net.inference.sqlite;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import net.inference.Config;
import net.inference.sqlite.dto.ArticleImpl;

/**
 * Date: 12/21/2014
 * Time: 5:34 PM
 *
 * @author xanderblinov
 */
class DbHelper
{
	@SuppressWarnings("FieldCanBeLocal")
	private static final String sBaseUrl = "jdbc:sqlite:";

	private ConnectionSource mConnectionSource;

	private final Config.Database mDatabase;

	public DbHelper(final Config.Database database)
	{
		mDatabase = database;
	}

	private String getUrl()
	{
		return sBaseUrl + mDatabase.getName();
	}

	ConnectionSource getConnection() throws SQLException
	{
		return mConnectionSource;
	}

	/**
	 * int tables
	 */
	public void onStart()
	{

		try
		{
			initConnection();
			ConnectionSource connectionSource = getConnection();
			TableUtils.createTableIfNotExists(connectionSource, ArticleImpl.class);

			//TODO add other tables
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
	}

	@Deprecated
	private void initConnection() throws SQLException
	{
		mConnectionSource = new JdbcPooledConnectionSource(getUrl());
	}

	public void onStop()
	{
		try
		{
			mConnectionSource.close();
		}
		catch (SQLException e)
		{
			SqliteLog.log(e);
		}
	}
}
