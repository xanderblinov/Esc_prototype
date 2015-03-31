package net.inference.sqlite.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import net.inference.database.dto.Cluster;
import net.inference.database.dto.EvolutionSlice;

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
	@DatabaseField(foreign = true, columnName = Column.slice_id)
	private EvolutionSliceImpl evolutionSlice;

	public ClusterImpl()
	{
	}

	public ClusterImpl(final EvolutionSlice slice)
	{
		setEvolutionSlice(slice);
	}

    @Override
    public EvolutionSlice getEvolutionSlice() {
        return evolutionSlice;
    }

    @Override
    public void setEvolutionSlice(EvolutionSlice slice) {
        evolutionSlice = (EvolutionSliceImpl) slice;
    }

    public long getId()
	{
		return mId;
	}

}
