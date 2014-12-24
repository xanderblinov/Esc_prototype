package net.inference.sqlite;

import net.inference.Config;
import net.inference.database.DatabaseApi;
import net.inference.database.dto.Article;
import net.inference.sqlite.dto.ArticleImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Date: 12/23/2014
 * Time: 11:59 PM
 *
 * @author xanderblinov
 */
public class ArticleTest
{
	@Test
	public void canConstructAPersonWithAName() {
		DatabaseApi databaseApi = new SqliteApi(Config.Database.TESt);
		databaseApi.onStart();

		// create an instance of ArticleImpl
		Article article = new ArticleImpl();
		article.setName("Article 1");
		databaseApi.article().addArticle(article);


		Article article2 = databaseApi.article().getAllArticles().get(0);

		databaseApi.onStop();

		assertEquals(article.getName(), article2.getName());
	}
}
