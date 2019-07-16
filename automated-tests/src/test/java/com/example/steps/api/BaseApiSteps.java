package com.example.steps.api;

import com.example.services.api.client.ApiClient;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.ErrorLoggingFilter;

import static com.example.services.api.client.GsonObjectMapper.gson;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public abstract class BaseApiSteps {

    protected static ApiClient apiClient = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
            () -> new RequestSpecBuilder().setConfig(
                    RestAssuredConfig.config()
                            .objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                    .addFilter(new ErrorLoggingFilter())
                    .setBaseUri("http://localhost:8080")
    ));

}
