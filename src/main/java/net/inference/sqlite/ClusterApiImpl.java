package net.inference.sqlite;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import net.inference.sqlite.dto.ClusterImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author gzheyts
 */
public class ClusterApiImpl {
    private static Logger logger = LoggerFactory.getLogger(ClusterApiImpl.class);


    private SqliteApi sqliteApi;

    public ClusterApiImpl(SqliteApi sqliteApi) {
        this.sqliteApi = sqliteApi;
    }

    public List<ClusterImpl> findAllClusters() {
        try {
            return sqliteApi.getClusterDao().queryForAll();
        } catch (SQLException e) {
            logger.error(e, "");

        }

        return null;
    }


}
