package net.inference.sqlite.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.inference.database.dto.ClusteringSlice;

/**
 * Date: 2/1/2015
 * Time: 5:53 PM
 *
 * @author xanderblinov
 */
@DatabaseTable(tableName = ClusteringSlice.TABLE_NAME)
public class ClusteringSliceImpl implements ClusteringSlice
{     
	
	@DatabaseField(columnName = Column.id, generatedId = true)
	private int mId;
	@DatabaseField(columnName = Column.year)
	private String mYear;
	@DatabaseField(columnName = Column.time)
	private String mTime;
	@DatabaseField(columnName = Column.clustering_id)
	private long mClusteringId;

	public int getId()
	{
		return mId;
	}

	public String getYear()
	{
		return mYear;
	}

	public void setYear(final String year)
	{
		mYear = year;
	}

	public String getTime()
	{
		return mTime;
	}

	public void setTime(final String time)
	{
		mTime = time;
	}

	public long getClusteringId()
	{
		return mClusteringId;
	}

	public void setClusteringId(final long clusteringId)
	{
		mClusteringId = clusteringId;
	}
}
