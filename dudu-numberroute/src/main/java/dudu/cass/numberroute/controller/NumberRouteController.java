package dudu.cass.numberroute.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dudu.cass.numberroute.model.NumberRouteInfo;
import dudu.cass.numberroute.requestparam.NumberRouteParams;
import dudu.cass.numberroute.service.NumberRouteService;



@RestController
@RequestMapping("numberroute")
public class NumberRouteController {
	@Autowired
	NumberRouteService service;
	
	private final static Logger logger = LoggerFactory.getLogger(NumberRouteController.class);
	
	@RequestMapping(value="v1/get",method=RequestMethod.POST)
	public String getNumberRouteInfo(@RequestBody NumberRouteParams params) throws Exception {
		JSONObject result = new JSONObject();

		try {
			logger.info("get params: " + params);
			if(!isValidNumbers(params.getNumbers())) {
				result.put("status","000001");
				result.put("msg", "号码不正确");
				return result.toString();
			}

			List<NumberRouteInfo> plat = null ;
			plat = service.GetNumberRouteInfos(params.getNumbers());
	        result.put("status", "000000");
	        result.put("msg", "OK");
	        result.put("data", plat);

		} 
		catch (Exception e) {
			logger.error("getNumberRouteInfo 异常", e);
			result.put("status","000500");
			result.put("msg", "发生异常");
		}
		return result.toString();
	}
	
	@RequestMapping(value="v1/set",method=RequestMethod.POST)
	public String setNumberRouteInfo(@RequestBody NumberRouteParams params) throws Exception {
		JSONObject result = new JSONObject();		

		try {
			logger.info("get params: " + params);
			if(!isValidNumbers(params.getNumbers())) {
				result.put("status","000001");
				result.put("msg", "号码不正确");
				return result.toString();
			}
			String platform = params.getPlatform();

			boolean dealOK = false;
			if( service.isValidPlat(platform)) {
    			dealOK = service.SetNumberRouteInfos(params.getNumbers(), platform);
    			if (!dealOK) {
    		        result.put("status", "000001");
    		        result.put("msg", "设置失败");
    			} else {
    		        result.put("status", "000000");
    		        result.put("msg", "OK");
    			}
			} else {
                result.put("status", "000001");
                result.put("msg", "错误的平台标识");
			}

		} 
		catch (Exception e) {
			logger.error("setNumberRouteInfo 异常", e);
			result.put("status", "000500");
			result.put("msg","发生异常");
		}
		return result.toString();
	}
	
	@RequestMapping(value="v1/reload",method=RequestMethod.POST)
	public String reload( ) throws Exception{
	    JSONObject result = new JSONObject();      

	    if (service.ReloadNumberRoute()) {
            result.put("status", "000000");
            result.put("msg", "OK");
	    }
	    else
	    {                  
	        result.put("status", "000001");
	        result.put("msg", "设置失败");	        
	    }
	    return result.toString();
	}
	
	private boolean isValidNumbers(ArrayList<String> numbers){
		if(numbers == null || numbers.size() < 1) return false;
		for(String number: numbers ) {
			if(number.isEmpty()) return false;
		}
		return true;
	}
}
