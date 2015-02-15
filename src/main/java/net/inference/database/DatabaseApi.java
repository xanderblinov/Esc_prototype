package net.inference.database;

import java.util.List;

import net.inference.database.dto.Article;
import net.inference.database.dto.Author;
import net.inference.database.dto.AuthorToCluster;
import net.inference.database.dto.Cluster;
import net.inference.database.dto.Evolution;
import net.inference.database.dto.EvolutionSlice;
import net.inference.database.dto.CoAuthorship;

/**
 * Date: 12/21/2014
 * Time: 9:33 PM
 *
 * @author xanderblinov
 */
public interface DatabaseApi
{

	public DaoFactory daoFactory();

	public ArticleApi article();

	/**
	 * Init database and table
	 */
	public void onStart();

	/**
	 * release connection etc.
	 */
	public void onStop();

	public Article addArticle(final Article article);

	public Author addAuthor(final Author author);

	public CoAuthorship addCoAuthorship(final CoAuthorship author);

	public boolean addAuthorToCluster(final AuthorToCluster authorToCluster);

	public Cluster addCluster(final Cluster cluster);

	public Evolution addEvolution(final Evolution evolution);

	public EvolutionSlice addEvolutionSlice(final EvolutionSlice evolutionSlice);

	public List<? extends Article> getAllArticles();
}
