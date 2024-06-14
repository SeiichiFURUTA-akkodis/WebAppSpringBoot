package jp.co.akkodis.webapp.model;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.akkodis.webapp.bean.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item,Integer> {
	@Query("select * from T_ITEM inner join M_CATEGORY on T_ITEM.CATEGORY = M_CATEGORY.CATID")
	Iterable<Item> findAll();
	
	@Query("select * from T_ITEM inner join M_CATEGORY on T_ITEM.CATEGORY = M_CATEGORY.CATID where ITEMID = :id")
	Optional<Item> findById(@Param("id") Integer id);
}
