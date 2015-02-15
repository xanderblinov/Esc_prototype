package net.inference.sqlite.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.inference.database.dto.AuthorToCluster;

/**
 * Date: 2/15/2015
 * Time: 6:49 PM
 *
 * @author xanderblinov
 */
@DatabaseTable(tableName = AuthorToCluster.TABLE_NAME)
public class AuthorToClusterImpl implements AuthorToCluster
{
	@DatabaseField(columnName = Column.author_id)
	private long mAuthorId;
	@DatabaseField(columnName = Column.cluster_id)
	private long mClusterId;


	public AuthorToClusterImpl()
	{
	}

	public AuthorToClusterImpl(final long authorId, final long clusterId)
	{
		mAuthorId = authorId;
		mClusterId = clusterId;
	}

	public long getAuthorId()
	{
		return mAuthorId;
	}

	public void setAuthorId(final long authorId)
	{
		mAuthorId = authorId;
	}

	public long getClusterId()
	{
		return mClusterId;
	}

	public void setClusterId(final long clusterId)
	{
		mClusterId = clusterId;
	}
}
