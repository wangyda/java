package dudu.cass.numberroute.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dudu.cass.numberroute.entity.NumberGroupEntity;
import dudu.cass.numberroute.entity.NumberRouteInfoEntity;

public interface NumberGroupRepository extends JpaRepository<NumberGroupEntity,Long> {	

	List<NumberGroupEntity> findByUsernameIn(Collection<String> usernames);
	
    @Query(
            value ="select a.username , a.description as vendor , b.description as plat  from dr_groups  a LEFT JOIN dr_rules  b on a.username = b.prefix where a.username  IN (:usernames)"
            ,nativeQuery = true
            )
    List<Object> findVendorAndPlatByUsernames(@Param("usernames") List<String> usernames);
}
