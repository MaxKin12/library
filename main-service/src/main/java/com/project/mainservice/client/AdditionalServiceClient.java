package com.project.mainservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${client.application.name}", url = "${additional-service.url}")
public interface AdditionalServiceClient {
    @PostMapping("")
    void createRecord (Long bookId);
}
