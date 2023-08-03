package Api.BookingService.CreateBooking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
@ToString
public class BookingDates {
    String checkin;
    String checkout;
    @Builder
    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
}
