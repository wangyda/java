package dudu.cass.numberroute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dudu.cass.numberroute.entity.NumberRouteEntity;

public interface PstnRepository extends JpaRepository<NumberRouteEntity,Long> { 

}
