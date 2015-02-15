package net.inference.sqlite.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.inference.database.dto.Author;

/**
 * Date: 12/19/2014
 * Time: 3:15 PM
 *
 * @author xanderblinov
 */

@DatabaseTable(tableName = Author.TABLE_NAME)
public class AuthorImpl implements Author
{
	@DatabaseField(columnName = Column.id, generatedId = true)
	private int mId;
	@DatabaseField(columnName = Column.name)
	private String mName;
	@DatabaseField(columnName = Column.surname)
	private String mSurname;
	@DatabaseField(columnName = Column.encoding)
	private String mEncoding;

	public AuthorImpl()
	{
		// ORMLite needs a no-arg constructor
	}

	public AuthorImpl(final int id, final String name, final String Surname)
	{
		mId = id;
		mName = name;
		mSurname = Surname;
	}

	public String getName()
	{
		return mName;
	}

	public void setName(final String name)
	{
		mName = name;
	}

	public String getSurname()
	{
		return mSurname;
	}

	public void setSurname(final String surname)
	{
		mSurname = surname;
	}

	public String getEncoding()
	{
		return mEncoding;
	}

	public void setEncoding(final String encoding)
	{
		mEncoding = encoding;
	}
}
