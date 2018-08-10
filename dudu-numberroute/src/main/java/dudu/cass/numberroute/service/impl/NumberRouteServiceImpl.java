package dudu.cass.numberroute.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import dudu.cass.numberroute.common.PlatformConfig;
import dudu.cass.numberroute.entity.NumberRouteEntity;
import dudu.cass.numberroute.model.NumberRouteInfo;
import dudu.cass.numberroute.repository.NumberRouteRepository;
import dudu.cass.numberroute.service.NumberRouteService;

@Service
public class NumberRouteServiceImpl implements NumberRouteService {

    @Autowired
    private PlatformConfig platfomConfig;
    
	@Autowired
	private NumberRouteRepository repository;
	
    @Value("${dudu.numberroute.opensipsMiUrl}")
    private String OpensipsMiUrl;

    
	@Override
	public List<NumberRouteInfo> GetNumberRouteInfos(ArrayList<String> numbers)  {
		List<NumberRouteInfo> result = new ArrayList<NumberRouteInfo>();
		NumberRouteInfo tmp = null;
		List<NumberRouteEntity> entities = repository.findByGroupidAndPrefixIn(platfomConfig.getInboundGroupid(), numbers);
		for(NumberRouteEntity entity : entities) {
				tmp = new NumberRouteInfo(entity.getPrefix(), entity.getDescription());
				result.add(tmp);
		}
		return result;
	}

	@Override
	public boolean SetNumberRouteInfos(ArrayList<String> numbers, String platform) {
	    if(isValidPlat(platform) == false) { 
	        return false;
	    }
		List<NumberRouteEntity> entities = null;
		ArrayList<String> notExistNumbers = numbers;
		String gwList = getGwlistByPlat(platform);
		entities = repository.findByGroupidAndPrefixIn(platfomConfig.getInboundGroupid(), numbers);
		for(NumberRouteEntity entity : entities) {
			notExistNumbers.remove(entity.getPrefix());
			entity.setDescription(platform);
			entity.setGwlist(gwList);
		}
		for(String number : notExistNumbers) {
			NumberRouteEntity tmpEntity = new NumberRouteEntity(number,platform,gwList,platfomConfig.getInboundGroupid());
			tmpEntity.setGwlist(gwList);
			entities.add(tmpEntity);
		}
		repository.saveAll(entities);
		return true ;
	}
	
   private  String getGwlistByPlat(String platform) {

        String gwlist = null;
        gwlist = platfomConfig.getPlatMap().get(platform);
        return gwlist;
    }
   @Override
    public  boolean isValidPlat(String platform) {
        
        return platfomConfig.getPlatMap().containsKey(platform);
    }

   /**
    * 重新加载路由信息，使设置生效
    */
    @Override
    public boolean ReloadNumberRoute() {
        try {
            //HttpHeaders requestHeaders = new HttpHeaders();
            //HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> tempResult = restTemplate.getForEntity(OpensipsMiUrl + "/dr_reload",  String.class);
            
            return tempResult.getStatusCode().is2xxSuccessful();
 
        }catch (HttpServerErrorException e){
            return false;
        }

    }

}
