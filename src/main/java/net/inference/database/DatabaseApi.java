package net.inference.database;

import java.util.List;

import net.inference.database.dto.Article;

/**
 * Date: 12/21/2014
 * Time: 9:33 PM
 *
 * @author xanderblinov
 */
public interface DatabaseApi
{
	/**
	 * Init database and table
	 */
	public void onStart();

	/**
	 * release connection etc.
	 */
	public void onStop();

	public void addArticle(Article article);
	public List<? extends Article> getAllArticles();
}
