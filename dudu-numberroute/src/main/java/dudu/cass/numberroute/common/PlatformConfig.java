package dudu.cass.numberroute.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="dudu.numberroute")
public class PlatformConfig {

    private  String  inboundGroupid ;//= "2";    

	private  Map<String, String> platMap = new HashMap<>(); ;
	

	/*
	private static void initPlatMap() {
		platMap = new HashMap<String, String>();
		platMap.put("HBXT", "16");
		platMap.put("YYT", "31");
		platMap.put("YYTX", "13=1,14=1");		
		platMap.put("DDYH", "64");	
		platMap.put("YYTXVOS", "66");	
	}
	*/

    public String getInboundGroupid() {
        return inboundGroupid;
    }

    public void setInboundGroupid(String inboundGroupid) {
        this.inboundGroupid = inboundGroupid;
    }

    public Map<String, String> getPlatMap() {
        return platMap;
    }

    public void setPlatMap(Map<String, String> platMap) {
        this.platMap = platMap;
    }


}
