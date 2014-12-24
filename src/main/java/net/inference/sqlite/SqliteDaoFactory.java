package net.inference.sqlite;

import net.inference.database.DaoFactory;
import net.inference.sqlite.dto.ArticleImpl;

/**
 * Date: 12/23/2014
 * Time: 11:14 PM
 *
 * @author xanderblinov
 */
public class SqliteDaoFactory implements DaoFactory
{
	@Override
	public ArticleImpl getArticleInstance()
	{
		return new ArticleImpl();
	}
}
