package ro.aimsoft.springboot.rest.config;

import com.aimsoft.cnas.rest.client.api.DefaultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.aimsoft.cnas.rest.client")
public class CnasClientConfig {


//    @Bean
//    public RestTemplate restTemplate(){
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//
//        return restTemplate;
//    }

}
