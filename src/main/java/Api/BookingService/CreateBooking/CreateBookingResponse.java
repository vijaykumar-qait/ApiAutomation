package Api.BookingService.CreateBooking;

import Core.Template.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
@ToString
public class CreateBookingResponse extends BaseResponse {
    private String bookingid;
    private BookingDetails booking;
}
