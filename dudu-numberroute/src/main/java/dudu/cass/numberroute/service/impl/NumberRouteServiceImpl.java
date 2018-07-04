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
		List<NumberRouteEntity> entities = repository.findByPrefixIn( numbers);
		for(NumberRouteEntity entity : entities) {
				tmp = new NumberRouteInfo(entity);
				result.add(tmp);
		}
		return result;
	}
	@Override
	public boolean SetNumberRouteInfos(ArrayList<String> numbers, String plat) {

		List<NumberRouteEntity> entities = null;
		ArrayList<String> notExistNumbers = numbers;
		entities = repository.findByPrefixIn( numbers);
		for(NumberRouteEntity entity : entities) {
			notExistNumbers.remove(entity.getPrefix());
			entity.setDescription(plat);
		}
		for(String number : notExistNumbers) {
			NumberRouteEntity tmpEntity = new NumberRouteEntity(number,plat);
			tmpEntity.setGwlist("test");
			entities.add(tmpEntity);
		}
		repository.saveAll(entities);
		return true ;
	}

}
