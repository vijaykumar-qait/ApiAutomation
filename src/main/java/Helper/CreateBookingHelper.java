package Helper;


import Api.BookingService.CreateBooking.BookingDates;
import Api.BookingService.CreateBooking.CreateBookingRequest;

public class CreateBookingHelper {
    static CreateBookingRequest createBookingRequest;

    public static CreateBookingRequest getCreateBookingRequest() {
        createBookingRequest = CreateBookingRequest.builder()
                .firstname("Nguyen")
                .lastname("Van A")
                .totalprice(100)
                .depositpaid("true")
                .additionalneeds("Breakfast")
                .bookingdates(BookingDates.builder().build().builder()
                        .checkin("2021-07-01")
                        .checkout("2021-07-02")
                        .build())
                .build();
        return createBookingRequest;
    }
}
