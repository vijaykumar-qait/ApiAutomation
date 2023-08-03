package test;

import Client.BookingClient;
import Api.BookingService.CreateBooking.CreateBookingRequest;
import Api.BookingService.CreateBooking.CreateBookingResponse;
import Helper.CreateBookingHelper;
import Utilities.Retry;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestCreateBookingApi {
    private BookingClient bookingClient;

    public TestCreateBookingApi() {
        bookingClient = new BookingClient();
    }

    @Test(description = "testing bca va charge")
    @Description("Testing web application")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateBooking() {
        CreateBookingRequest createBookingRequest = CreateBookingHelper.getCreateBookingRequest();
        CreateBookingResponse createBookingResponse = bookingClient.createBooking(createBookingRequest);
        Assert.assertTrue(createBookingResponse.getHttpStatusCode() == 200);
    }

}
