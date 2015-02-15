package net.inference.database.dto;

/**
 * Date: 12/19/2014
 * Time: 3:15 PM
 *
 * @author xanderblinov
 */

public interface ClusteringSlice
{
	public static final String TABLE_NAME = "clustering_slice";

	public static class Column
	{
		public static final String id = "_id";
		public static final String year = "year";
		public static final String time = "time";
		public static final String clustering_id = "clustering_id";
	}
	public int getId();

	public String getYear();

	public void setYear(final String year);

	public String getTime();

	public void setTime(final String time);

	public long getClusteringId();

	public void setClusteringId(final long clusteringId);
}
