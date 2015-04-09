package net.inference.database;

import net.inference.sqlite.dto.ClusterImpl;

import java.util.List;

/**
 * @author gzheyts
 */
public interface ClusterApi {

    List<ClusterImpl> findAllClusters();

}
