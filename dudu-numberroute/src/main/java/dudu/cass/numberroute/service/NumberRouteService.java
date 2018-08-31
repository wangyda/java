package dudu.cass.numberroute.service;

import java.util.ArrayList;
import java.util.List;

import dudu.cass.numberroute.model.NumberRouteInfo;

public interface NumberRouteService {
	
	//NumberRouteInfo GetNumberRouteInfo(String number)  throws Exception;
	List<NumberRouteInfo> getNumberRouteInfos(ArrayList<String> numbers) ;
	List<NumberRouteInfo> getNumberVendorInfos(ArrayList<String> numbers) ;
	List<NumberRouteInfo> getNumberAllInfos(ArrayList<String> numbers) ;
	boolean setNumberRouteInfos(ArrayList<String> numbers, String platform);
	boolean reloadNumberRoute();
    public  boolean isValidPlat(String platform) ;
}
