/*
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.example.services.api.controllers;

import com.google.gson.reflect.TypeToken;
import com.example.entities.generated.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import com.example.services.api.client.JSON;

import static io.restassured.http.Method.*;

public class BasicErrorControllerApi {

    private RequestSpecBuilder reqSpec;

    private BasicErrorControllerApi(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
    }

    public static BasicErrorControllerApi basicErrorController(RequestSpecBuilder reqSpec) {
        return new BasicErrorControllerApi(reqSpec);
    }


    public ErrorHtmlUsingDELETEOper errorHtmlUsingDELETE() {
        return new ErrorHtmlUsingDELETEOper(reqSpec);
    }

    public ErrorHtmlUsingGETOper errorHtmlUsingGET() {
        return new ErrorHtmlUsingGETOper(reqSpec);
    }

    public ErrorHtmlUsingHEADOper errorHtmlUsingHEAD() {
        return new ErrorHtmlUsingHEADOper(reqSpec);
    }

    public ErrorHtmlUsingOPTIONSOper errorHtmlUsingOPTIONS() {
        return new ErrorHtmlUsingOPTIONSOper(reqSpec);
    }

    public ErrorHtmlUsingPATCHOper errorHtmlUsingPATCH() {
        return new ErrorHtmlUsingPATCHOper(reqSpec);
    }

    public ErrorHtmlUsingPOSTOper errorHtmlUsingPOST() {
        return new ErrorHtmlUsingPOSTOper(reqSpec);
    }

    public ErrorHtmlUsingPUTOper errorHtmlUsingPUT() {
        return new ErrorHtmlUsingPUTOper(reqSpec);
    }

    /**
    * Customise request specification
    */
    public BasicErrorControllerApi reqSpec(Consumer<RequestSpecBuilder> consumer) {
        consumer.accept(reqSpec);
        return this;
    }

    /**
     * errorHtml
     * 
     *
     * return ModelAndView
     */
    public class ErrorHtmlUsingDELETEOper {

        public static final String REQ_URI = "/error";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ErrorHtmlUsingDELETEOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ErrorHtmlUsingDELETEOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * DELETE /error
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(DELETE, REQ_URI));
        }

        /**
         * DELETE /error
         * @return ModelAndView
         */
        public ModelAndView executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<ModelAndView>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public ErrorHtmlUsingDELETEOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ErrorHtmlUsingDELETEOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * errorHtml
     * 
     *
     * return ModelAndView
     */
    public class ErrorHtmlUsingGETOper {

        public static final String REQ_URI = "/error";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ErrorHtmlUsingGETOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ErrorHtmlUsingGETOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * GET /error
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(GET, REQ_URI));
        }

        /**
         * GET /error
         * @return ModelAndView
         */
        public ModelAndView executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<ModelAndView>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public ErrorHtmlUsingGETOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ErrorHtmlUsingGETOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * errorHtml
     * 
     *
     * return ModelAndView
     */
    public class ErrorHtmlUsingHEADOper {

        public static final String REQ_URI = "/error";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ErrorHtmlUsingHEADOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ErrorHtmlUsingHEADOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * HEAD /error
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(HEAD, REQ_URI));
        }

        /**
         * HEAD /error
         * @return ModelAndView
         */
        public ModelAndView executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<ModelAndView>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public ErrorHtmlUsingHEADOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ErrorHtmlUsingHEADOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * errorHtml
     * 
     *
     * return ModelAndView
     */
    public class ErrorHtmlUsingOPTIONSOper {

        public static final String REQ_URI = "/error";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ErrorHtmlUsingOPTIONSOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ErrorHtmlUsingOPTIONSOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * OPTIONS /error
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(OPTIONS, REQ_URI));
        }

        /**
         * OPTIONS /error
         * @return ModelAndView
         */
        public ModelAndView executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<ModelAndView>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public ErrorHtmlUsingOPTIONSOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ErrorHtmlUsingOPTIONSOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * errorHtml
     * 
     *
     * return ModelAndView
     */
    public class ErrorHtmlUsingPATCHOper {

        public static final String REQ_URI = "/error";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ErrorHtmlUsingPATCHOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ErrorHtmlUsingPATCHOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * PATCH /error
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(PATCH, REQ_URI));
        }

        /**
         * PATCH /error
         * @return ModelAndView
         */
        public ModelAndView executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<ModelAndView>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public ErrorHtmlUsingPATCHOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ErrorHtmlUsingPATCHOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * errorHtml
     * 
     *
     * return ModelAndView
     */
    public class ErrorHtmlUsingPOSTOper {

        public static final String REQ_URI = "/error";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ErrorHtmlUsingPOSTOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ErrorHtmlUsingPOSTOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /error
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

        /**
         * POST /error
         * @return ModelAndView
         */
        public ModelAndView executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<ModelAndView>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public ErrorHtmlUsingPOSTOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ErrorHtmlUsingPOSTOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * errorHtml
     * 
     *
     * return ModelAndView
     */
    public class ErrorHtmlUsingPUTOper {

        public static final String REQ_URI = "/error";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public ErrorHtmlUsingPUTOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        public ErrorHtmlUsingPUTOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("text/html");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * PUT /error
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(PUT, REQ_URI));
        }

        /**
         * PUT /error
         * @return ModelAndView
         */
        public ModelAndView executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<ModelAndView>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * Customise request specification
         */
        public ErrorHtmlUsingPUTOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public ErrorHtmlUsingPUTOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
}