package ro.aimsoft.springboot.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ro.aimsoft.springboot.rest.model.client.HubjectClientRequest;
import ro.aimsoft.springboot.rest.model.client.HubjectClientResponse;

@FeignClient
public interface HubjectClient {

    @GetMapping
    HubjectClientResponse getSomething(HubjectClientRequest request);
}
