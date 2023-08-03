package Utilities;

import Core.Template.AuthType;
import Core.Template.HttpMethods;
import Core.Template.IServiceEndpoint;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestHandler {
    public Response processHttpRequest(IServiceEndpoint serviceEndpoint) {
        Response response = processIServiceEndpoint(serviceEndpoint);
        LoggingUtil.info("Response Body: " + response.getBody().asString());
        return response;
    }

    private Response processIServiceEndpoint(IServiceEndpoint iServiceEndpoint) {
        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured.registerParser("application/grpc", Parser.JSON);
        RestAssured.registerParser("text/xml", Parser.JSON);
        RestAssured.registerParser("text/json", Parser.JSON);
        RestAssured.defaultParser = Parser.JSON;
        String url = iServiceEndpoint.url();
        HttpMethods httpMethods = iServiceEndpoint.httpMethod();
        RequestSpecification requestSpecification = createRequestSpecification(iServiceEndpoint);
        LoggingUtil.info("Request URL: " + url);
        LoggingUtil.info("Request Method: " + httpMethods);
        LoggingUtil.info("Request Headers: " + iServiceEndpoint.headers());
        LoggingUtil.info("Request Body: " + iServiceEndpoint.body().getBodyAsString());
        return makeHttpCall(requestSpecification, url, httpMethods);
    }

    private RequestSpecification createRequestSpecification(IServiceEndpoint iServiceEndpoint) {
        RestAssuredConfig config = RestAssuredConfig.config().encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        RequestSpecification requestSpecification = given().config(config);
        if(iServiceEndpoint.headers()!=null){
            iServiceEndpoint.headers().forEach(i->requestSpecification.header(i.getKey(),i.getValue()));
        }
        if(iServiceEndpoint.pathParameters()!=null){
            iServiceEndpoint.pathParameters().forEach(i->requestSpecification.pathParam(i.getKey(),i.getValue()));
        }
        if(iServiceEndpoint.queryParameters()!=null){
            iServiceEndpoint.queryParameters().forEach(i->requestSpecification.queryParam(i.getKey(),i.getValue()));
        }
        if(iServiceEndpoint.body()!=null){
            requestSpecification.body(iServiceEndpoint.body().getBodyAsString());
        }

        Map<Object,Object> map = iServiceEndpoint.authType();
        Object authType = map.get("type");
        if(!authType.equals(AuthType.NONE)){
            requestSpecification.auth().basic(map.get("username").toString(), map.get("password").toString());
        }
        return requestSpecification;
    }

    private Response makeHttpCall(RequestSpecification requestSpecification, String url, HttpMethods httpMethods) {
        Response response = null;
        switch (httpMethods){
            case GET:
                response = requestSpecification.get(url);
                break;
            case POST:
                response = requestSpecification.post(url);
                break;
            case PUT:
                response = requestSpecification.put(url);
                break;
            case DELETE:
                response = requestSpecification.delete(url);
                break;
            case PATCH:
                response = requestSpecification.patch(url);
                break;
        }
        return response;
    }
}
