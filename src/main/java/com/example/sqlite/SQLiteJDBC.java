package com.example.sqlite;

/**
 * Date: 12/19/2014
 * Time: 2:59 PM
 *
 * @author xanderblinov
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteJDBC
{
	public static void main(String args[])
	{
		Connection c;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.getAutoCommit();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}