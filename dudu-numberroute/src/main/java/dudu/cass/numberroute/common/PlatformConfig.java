package dudu.cass.numberroute.common;

import java.util.HashMap;
import java.util.Map;

public class PlatformConfig {
	private static Map<String, String> platMap;
	
	public static String getGwlistByPlat(String platform) {
		if (platMap == null) {
			initPlatMap();
		}
		String gwlist = null;
		gwlist = platMap.get(platform);
		return gwlist;
	}

	public static boolean existPlat(String platform) {
		if (platMap == null) {
			initPlatMap();
		}
		return platMap.containsValue(platform);
	}
	
	private static void initPlatMap() {
		platMap = new HashMap<String, String>();
		platMap.put("HBXT", "16");
		platMap.put("YYT", "31");
		platMap.put("YYTX", "13=1,14=1");		
	}
	

}
