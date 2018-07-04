package dudu.cass.numberroute.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dudu.cass.numberroute.model.NumberRouteInfo;
import dudu.cass.numberroute.model.NumberRouteResult;
import dudu.cass.numberroute.requestparam.NumberRouteParams;
import dudu.cass.numberroute.service.NumberRouteService;



@RestController
@RequestMapping("numberroute")
public class NumberRouteController {
	@Autowired
	NumberRouteService service;
	
	private final static Logger logger = LoggerFactory.getLogger(NumberRouteController.class);
	
	@RequestMapping(value="v1/get",method=RequestMethod.GET)
	public NumberRouteResult getNumberRouteInfo(@RequestParam("number") String number) throws Exception {
		NumberRouteInfo plat = null ;
		NumberRouteResult result = new NumberRouteResult("0000","OK");
		try {
			logger.info("get number " + number);;
			plat = service.GetNumberRouteInfo(number);
			result.setData(plat);
		} 
		catch (Exception e) {
			logger.error("getNumberRouteInfo 异常", e);
			result.setStatus("000500");
			result.setStatus("发生异常");
		}
		return result;
	}
	
	@RequestMapping(value="v1/getRouteInfo",method=RequestMethod.POST)
	public NumberRouteResult getNumberRouteInfo(@RequestBody NumberRouteParams params) throws Exception {
		List<NumberRouteInfo> plat = null ;
		NumberRouteResult result = new NumberRouteResult("0000","OK");

		try {
			plat = service.GetNumberRouteInfos(params.getNumbers());
			result.setData(plat);
		} 
		catch (Exception e) {
			logger.error("getNumberRouteInfo 异常", e);
			result.setStatus("000500");
			result.setStatus("发生异常");
		}
		return result;
	}
	
	@RequestMapping(value="v1/set",method=RequestMethod.POST)
	public NumberRouteResult setNumberRouteInfo(@RequestBody NumberRouteParams params) throws Exception {

		NumberRouteResult result = new NumberRouteResult("0000","OK");

		try {
			boolean dealOK = false;
			new NumberRouteResult("0000","OK");
			dealOK = service.SetNumberRouteInfos(params.getNumbers(), params.getPlatform());
			if (!dealOK) {
				result.setStatus("0001");
				result.setStatus("设置失败");
			}			
		} 
		catch (Exception e) {
			logger.error("setNumberRouteInfo 异常", e);
			result.setStatus("000500");
			result.setStatus("发生异常");
		}
		return result;
	}

}
