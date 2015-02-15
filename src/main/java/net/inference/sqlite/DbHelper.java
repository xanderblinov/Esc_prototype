package net.inference.sqlite;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import net.inference.Config;
import net.inference.sqlite.dto.ArticleImpl;
import net.inference.sqlite.dto.ClusterImpl;
import net.inference.sqlite.dto.EvolutionImpl;
import net.inference.sqlite.dto.EvolutionSliceImpl;
import net.inference.sqlite.dto.AuthorImpl;
import net.inference.sqlite.dto.AuthorToClusterImpl;
import net.inference.sqlite.dto.CoAuthorshipImpl;
import net.inference.sqlite.dto.ParameterImpl;
import net.inference.sqlite.dto.PrimitiveAuthorImpl;
import net.inference.sqlite.dto.PrimitiveCoAuthorshipImpl;

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
			TableUtils.createTableIfNotExists(connectionSource, ClusterImpl.class);
			TableUtils.createTableIfNotExists(connectionSource, EvolutionImpl.class);
			TableUtils.createTableIfNotExists(connectionSource, EvolutionSliceImpl.class);
			TableUtils.createTableIfNotExists(connectionSource, AuthorImpl.class);
			TableUtils.createTableIfNotExists(connectionSource, AuthorToClusterImpl.class);
			TableUtils.createTableIfNotExists(connectionSource, CoAuthorshipImpl.class);
			TableUtils.createTableIfNotExists(connectionSource, ParameterImpl.class);
			TableUtils.createTableIfNotExists(connectionSource, PrimitiveAuthorImpl.class);
			TableUtils.createTableIfNotExists(connectionSource, PrimitiveCoAuthorshipImpl.class);

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
