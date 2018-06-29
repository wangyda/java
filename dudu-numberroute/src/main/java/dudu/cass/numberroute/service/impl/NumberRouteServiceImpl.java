package dudu.cass.numberroute.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dudu.cass.numberroute.repository.PstnRepository;
import dudu.cass.numberroute.service.NumberRouteService;


public class NumberRouteServiceImpl implements NumberRouteService {

	@Autowired
	private PstnRepository pstnRepository;
	@Override
	public String GetNumberRouteInfo(String number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
