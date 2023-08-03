package Client;


import Api.BookingService.CreateBooking.CreateBookingApi;
import Api.BookingService.CreateBooking.CreateBookingRequest;
import Api.BookingService.CreateBooking.CreateBookingResponse;
import Utilities.RequestHandler;
import io.restassured.response.Response;

public class BookingClient {
    public CreateBookingResponse createBooking(CreateBookingRequest createBookingRequest) {
        CreateBookingApi createBookingApi = new CreateBookingApi(createBookingRequest);
        Response response = new RequestHandler().processHttpRequest(createBookingApi);
        CreateBookingResponse createBookingResponse = response.as(CreateBookingResponse.class);
        createBookingResponse.setHttpStatusCode(response.getStatusCode());
        return createBookingResponse;
    }
}
