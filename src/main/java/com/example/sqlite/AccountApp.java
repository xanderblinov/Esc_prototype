package com.example.sqlite;

import net.inference.database.DatabaseApi;
import net.inference.database.dto.Article;
import net.inference.sqlite.SqliteApi;
import net.inference.sqlite.dto.ArticleImpl;

/**
 * Date: 12/19/2014
 * Time: 3:29 PM
 *
 * @author xanderblinov
 */


public class AccountApp
{

	public static void main(String[] args) throws Exception
	{

		DatabaseApi databaseApi = new SqliteApi();
		databaseApi.onStart();

		// create an instance of ArticleImpl
		Article article = new ArticleImpl();
		article.setName("Article 1");
		databaseApi.addArticle(article);


		Article article2 = databaseApi.getAllArticles().get(0);

		System.out.println("Article: " + article2.getName());

		databaseApi.onStop();
	}
}
