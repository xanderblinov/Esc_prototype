package net.inference.sqlite.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.inference.database.dto.EvolutionSlice;

/**
 * Date: 2/1/2015
 * Time: 5:53 PM
 *
 * @author xanderblinov
 */
@DatabaseTable(tableName = EvolutionSlice.TABLE_NAME)
public class EvolutionSliceImpl implements EvolutionSlice
{     
	
	@DatabaseField(columnName = Column.id, generatedId = true)
	private int mId;
	@DatabaseField(columnName = Column.year)
	private String mYear;
	@DatabaseField(columnName = Column.time)
	private String mTime;
	@DatabaseField(columnName = Column.evolution_id)
	private long mEvolutionId;

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

	public long getEvolutionId()
	{
		return mEvolutionId;
	}

	public void setEvolutionId(final long clusteringId)
	{
		mEvolutionId = clusteringId;
	}
}
