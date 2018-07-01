package dudu.cass.numberroute.service;

import java.util.List;

import dudu.cass.numberroute.entity.NumberRouteEntity;

public interface NumberRouteService {
	
	List<NumberRouteEntity> GetNumberRouteInfo(String number)  throws Exception;

}
