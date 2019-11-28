package com.example.steps.api;

import com.example.services.api.client.ApiClient;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;

import static com.example.services.api.client.ApiClient.Config.apiConfig;
import static com.example.services.api.client.ApiClient.api;
import static io.restassured.config.RestAssuredConfig.config;

public abstract class BaseApiSteps {

    protected static ApiClient apiClient = api(apiConfig().reqSpecSupplier(
            () -> new RequestSpecBuilder()
                    .setConfig(config())
                    .addFilter(new ErrorLoggingFilter())
                    .setBaseUri("http://localhost:8080")
    ));

}
