package dudu.cass.numberroute.service;

import java.util.ArrayList;
import java.util.List;

import dudu.cass.numberroute.model.NumberRouteInfo;

public interface NumberRouteService {
	
	//NumberRouteInfo GetNumberRouteInfo(String number)  throws Exception;
	List<NumberRouteInfo> GetNumberRouteInfos(ArrayList<String> numbers) ;
	boolean SetNumberRouteInfos(ArrayList<String> numbers, String platform);
	boolean ReloadNumberRoute();
    public  boolean isValidPlat(String platform) ;
}
