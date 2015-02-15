package net.inference.sqlite.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.inference.database.dto.CoAuthorship;
import net.inference.database.dto.PrimitiveCoAuthorship;

/**
 * Date: 12/19/2014
 * Time: 3:15 PM
 *
 * @author xanderblinov
 */

@DatabaseTable(tableName = CoAuthorship.TABLE_NAME)
public class CoAuthorshipImpl implements CoAuthorship
{
	@DatabaseField(columnName = Column.id, generatedId = true)
	private int mId;
	@DatabaseField(columnName = Column.author)
	private long mAuthor;
	@DatabaseField(columnName = Column.coauthor)
	private long mCoauthor;
	@DatabaseField(columnName = PrimitiveCoAuthorship.Column.year)
	private int mYear;
	@DatabaseField(columnName = PrimitiveCoAuthorship.Column.article_id)
	private long mArticleId;

	public CoAuthorshipImpl()
	{
		// ORMLite needs a no-arg constructor
	}

	public CoAuthorshipImpl(final long author, final long coauthor)
	{
		mAuthor = author;
		mCoauthor = coauthor;
	}

	public long getAuthor()
	{
		return mAuthor;
	}

	public void setAuthor(final long author)
	{
		mAuthor = author;
	}

	public long getCoauthor()
	{
		return mCoauthor;
	}

	public void setCoauthor(final long coauthor)
	{
		mCoauthor = coauthor;
	}

	public int getYear()
	{
		return mYear;
	}

	public void setYear(final int year)
	{
		mYear = year;
	}

	public long getArticleId()
	{
		return mArticleId;
	}

	public void setArticleId(final long articleId)
	{
		mArticleId = articleId;
	}
}
