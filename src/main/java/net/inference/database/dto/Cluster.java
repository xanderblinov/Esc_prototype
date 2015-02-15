package net.inference.database.dto;

/**
 * Date: 12/19/2014
 * Time: 3:15 PM
 *
 * @author xanderblinov
 */

public interface Cluster
{
	public static final String TABLE_NAME = "cluster";

	public static class Column
	{
		public static final String id = "_id";
		public static final String slice_id = "slice_id";
	}

	public long getSliceId();

	public void setSliceId(final long sliceId);

	public long getId();

}
