package net.inference.sqlite.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.inference.database.dto.Cluster;

/**
 * Date: 2/1/2015
 * Time: 5:53 PM
 *
 * @author xanderblinov
 */
@DatabaseTable(tableName = Cluster.TABLE_NAME)
public class ClusterImpl implements Cluster
{     
	
	@DatabaseField(columnName = Column.id, generatedId = true)
	private long mId;
	@DatabaseField(columnName = Column.slice_id)
	private long mSliceId;

	public ClusterImpl()
	{
	}

	public ClusterImpl(final long sliceId)
	{
		mSliceId = sliceId;
	}

	public long getSliceId()
	{
		return mSliceId;
	}

	public void setSliceId(final long sliceId)
	{
		mSliceId = sliceId;
	}

	public long getId()
	{
		return mId;
	}

}
