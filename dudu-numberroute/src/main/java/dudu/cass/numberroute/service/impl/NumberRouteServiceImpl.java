package dudu.cass.numberroute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dudu.cass.numberroute.entity.NumberRouteEntity;
import dudu.cass.numberroute.repository.NumberRouteRepository;
import dudu.cass.numberroute.service.NumberRouteService;


public class NumberRouteServiceImpl implements NumberRouteService {

	@Autowired
	private NumberRouteRepository repository;
	@Override
	public List<NumberRouteEntity> GetNumberRouteInfo(String number) throws Exception {
		// TODO Auto-generated method stub
		
		return repository.findByNumber(number);
	}

}
