package dudu.cass.numberroute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dudu.cass.numberroute.entity.NumberRouteEntity;

public interface NumberRouteRepository extends JpaRepository<NumberRouteEntity,Long> { 
	
	List<NumberRouteEntity> findByNumber(String Number);

}
