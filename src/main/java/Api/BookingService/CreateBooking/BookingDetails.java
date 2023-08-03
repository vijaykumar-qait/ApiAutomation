package Api.BookingService.CreateBooking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
@ToString
public class BookingDetails {
    String firstname;
    String lastname;
    int totalprice;
    String depositpaid;
    String additionalneeds;
    BookingDates bookingdates;
    @Builder
    public BookingDetails(String firstname, String lastname, int totalprice, String depositpaid, String additionalneeds, BookingDates bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
        this.bookingdates = bookingdates;
    }
}
