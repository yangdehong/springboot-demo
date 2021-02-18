package com.ydh.redsheep.zes.es;

import com.ydh.redsheep.zes.pojo.Position;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionEsRepository extends CrudRepository<Position, String> {
}
