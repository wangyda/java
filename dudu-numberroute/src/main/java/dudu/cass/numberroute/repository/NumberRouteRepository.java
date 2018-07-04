package dudu.cass.numberroute.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dudu.cass.numberroute.entity.NumberRouteEntity;

public interface NumberRouteRepository extends JpaRepository<NumberRouteEntity,Long> { 
	
	NumberRouteEntity findByPrefix(String prefix);
	List<NumberRouteEntity> findByPrefixIn(Collection<String> prefixs);
}
