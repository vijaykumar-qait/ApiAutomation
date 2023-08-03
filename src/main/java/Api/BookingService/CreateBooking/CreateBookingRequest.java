package Api.BookingService.CreateBooking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@JsonIgnoreProperties
@ToString
public class CreateBookingRequest {
    String firstname;
    String lastname;
    int totalprice;
    String depositpaid;
    String additionalneeds;
    BookingDates bookingdates;
}
