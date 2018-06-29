package dudu.cass.numberroute.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dudu.cass.numberroute.service.NumberRouteService;



@RestController
public class NumberRouteController {
	@Autowired
	NumberRouteService service;
	
	private final static Logger logger = LoggerFactory.getLogger(NumberRouteController.class);
	
	@RequestMapping(value="numberroute/v1/get")
	String getNumberRouteInfo(@RequestParam("number") String number) throws Exception {
		String plat ;
		try {
			plat = service.GetNumberRouteInfo(number);
		} 
		catch (Exception e) {
			logger.error("findExtensionInfoByMac操纵失误", e);
			plat = "exception";
		}
		return plat;
	}

}
