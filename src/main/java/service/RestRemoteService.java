package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RestRemoteService {
	private final String SERVICE_HOME_URL = "http://service-providers/";
	
	@Autowired
    RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "sayHelloFallback")
	public String sayHello(){
		return restTemplate.getForObject(SERVICE_HOME_URL + "hi", String.class);
	}
	
	public String sayHelloFallback() {
        return "service is not avereable";
    }
}
