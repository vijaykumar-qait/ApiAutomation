package Api.BookingService.CreateBooking;

import Core.Entities.Param;
import Core.Entities.RequestBody;
import Core.Template.HttpMethods;
import Core.Template.IServiceEndpoint;
import Utilities.ConfigReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateBookingApi implements IServiceEndpoint {
    ConfigReader configReader = new ConfigReader();
    private final CreateBookingRequest createBookingRequest;

    public CreateBookingApi(CreateBookingRequest createBookingRequest) {
        this.createBookingRequest = createBookingRequest;
    }

    @Override
    public HttpMethods httpMethod() {
        return HttpMethods.POST;
    }

    @Override
    public String url() {
        return configReader.getBookingApplicationUrl() + "/booking";
    }

    @Override
    public List<Param> headers() {
        List<Param> header = new ArrayList<>();
        Param contentType = new Param("Content-Type", "application/json");
        header.add(contentType);
        return header;
    }

    @Override
    public List<Param> pathParameters() {
        return null;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public RequestBody body() {
        return new RequestBody(CreateBookingRequest.class, createBookingRequest);
    }

    @Override
    public Map<Object, Object> authType() {
        return IServiceEndpoint.super.authType();
    }
}
