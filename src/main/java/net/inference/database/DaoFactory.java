package net.inference.database;

import net.inference.database.dto.Article;

/**
 * Date: 12/23/2014
 * Time: 11:13 PM
 *
 * @author xanderblinov
 */
public interface DaoFactory
{
	public Article getArticleInstance();
}
