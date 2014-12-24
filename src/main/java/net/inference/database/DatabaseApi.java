package net.inference.database;

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

	public DaoFactory daoFactory();

	public ArticleApi article();
}
