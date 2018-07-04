package dudu.cass.numberroute.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dudu.cass.numberroute.entity.NumberRouteEntity;
import dudu.cass.numberroute.model.NumberRouteInfo;
import dudu.cass.numberroute.repository.NumberRouteRepository;
import dudu.cass.numberroute.service.NumberRouteService;

@Service
public class NumberRouteServiceImpl implements NumberRouteService {

	@Autowired
	private NumberRouteRepository repository;
	@Override
	public NumberRouteInfo GetNumberRouteInfo(String number) throws Exception {
		NumberRouteInfo result = null;
		NumberRouteEntity entity = repository.findByPrefix(number);
		if (entity == null) {
			result = new NumberRouteInfo(number);
		} else {
			result = new NumberRouteInfo(entity);
		}
		return result;
	}
	@Override
	public List<NumberRouteInfo> GetNumberRouteInfos(ArrayList<String> numbers) throws Exception {
		List<NumberRouteInfo> result = new ArrayList<NumberRouteInfo>();
		NumberRouteInfo tmp = null;
		List<NumberRouteEntity> entitys = repository.findByPrefixIn( numbers);
		for(NumberRouteEntity entity : entitys) {
				tmp = new NumberRouteInfo(entity);
				result.add(tmp);
		}
		return result;
	}

}
