package net.inference.sqlite.dto;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.inference.database.dto.Clustering;
import net.inference.database.dto.ClusteringType;

/**
 * Date: 2/1/2015
 * Time: 5:53 PM
 *
 * @author xanderblinov
 */
@DatabaseTable(tableName = Clustering.TABLE_NAME)
public class ClusteringImpl implements Clustering
{     
	
	@DatabaseField(columnName = Column.id, generatedId = true)
	private int mId;
	@DatabaseField(columnName = Column.time)
	private String mTime;
	@DatabaseField(columnName = Column.type_id, dataType = DataType.ENUM_STRING)
	private ClusteringType mType;
	@DatabaseField(columnName = Column.from_year)
	private String mFromYear;
	@DatabaseField(columnName = Column.to_year)
	private String mToYear;

	public long getId()
	{
		return mId;
	}

	public String getTime()
	{
		return mTime;
	}

	public void setTime(final String time)
	{
		mTime = time;
	}

	public ClusteringType getType()
	{
		return mType;
	}

	public void setType(final ClusteringType type)
	{
		mType = type;
	}

	public String getFromYear()
	{
		return mFromYear;
	}

	public void setFromYear(final String fromYear)
	{
		mFromYear = fromYear;
	}

	public String getToYear()
	{
		return mToYear;
	}

	public void setToYear(final String toYear)
	{
		mToYear = toYear;
	}
}
