package ro.aimsoft.springboot.rest.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    @Bean
    public RestTemplate omniRestTemplate() {
        // Setting up a httpclient for the restTemplate object

        return new RestTemplate();
    }
}
