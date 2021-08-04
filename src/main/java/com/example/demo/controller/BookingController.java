package com.example.demo.controller;

import com.example.demo.dto.BookingHotelDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import com.example.demo.response.*;


/**
 * @author Hashem Rashed
 */
@RestController
public class BookingController {

    /**
     * @param
     * @return
     * call search API for Booking Hotel
     */
    @GetMapping(value = "/search")
    @ApiOperation(value = "Search for Booking Hotel", notes = "Search for Booking Hotel")
    public ResponseEntity<List<BookingHotelResponseForm>> bookHotel(
            @ApiParam(name =  "city", type = "String", value = "City Name", example = "AUD", required = true) String city,
            @ApiParam(name =  "fromDate", type = "Date", value = "From Date", example = "2021-08-04", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate ,
            @ApiParam(name =  "toDate", type = "Date", value = "To Date", example = "2021-08-05", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date  toDate,
            @ApiParam(name =  "numberOfAdults", type = "Integer", value = "Number Of Adults", example = "4", required = true) int numberOfAdults) {

        List<BookingHotelDto> dummyDataList = fillDemoData();
        dummyDataList.removeIf(e -> !(e.getCity().equals(city)));

        List<BookingHotelResponseForm> response = new ArrayList<>();

        BookingHotelResponseForm objRes ;
        for (BookingHotelDto dto : dummyDataList) {
            objRes = new BookingHotelResponseForm();
            objRes.setHotelFare(dto.getHotelFare());
            objRes.setHotelName(dto.getHotelName());
            objRes.setRate(dto.getRate());
            objRes.setRoomAmenities(dto.getRoomAmenities());
            response.add(objRes);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * @return
     * fill Dummy Data of Booking Hotel Objects
     */
    private List<BookingHotelDto> fillDemoData() {

        /*************************** add Dummy1 Data *************************/
        BookingHotelDto dummy1 = new BookingHotelDto();

        dummy1.setHotelName("Marriott Hotel");
        dummy1.setRate(3.5);
        dummy1.setHotelFare(50.25);
        dummy1.setCity("AMM");
        dummy1.setFromDate(LocalDate.of(2020,01,01));
        dummy1.setToDate(LocalDate.of(2022,12,31));

        List<String> roomAmenities1 = new ArrayList<>();
        roomAmenities1.add("Sports Gym");
        roomAmenities1.add("In-Room Cocktail Station");
        roomAmenities1.add("Free WiFi internet access");
        roomAmenities1.add("Free parking");
        dummy1.setRoomAmenities(String.join(", ", roomAmenities1));


        /*************************** add Dummy2 Data *************************/
        BookingHotelDto dummy2 = new BookingHotelDto();

        dummy2.setHotelName("Ritz-Carlton Hotel");
        dummy2.setRate(3.7);
        dummy2.setHotelFare(15.0);
        dummy2.setCity("AUD");
        dummy2.setFromDate(LocalDate.of(2020,01,01));
        dummy2.setToDate(LocalDate.of(2022,12,31));

        List<String> roomAmenities2 = new ArrayList<>();
        roomAmenities2.add("Bar Or Lounge");
        roomAmenities2.add("Fitness Center");
        roomAmenities2.add("Breakfast");
        dummy2.setRoomAmenities(String.join(", ", roomAmenities2));


        /*************************** add Dummy3 Data *************************/
        BookingHotelDto dummy3 = new BookingHotelDto();

        dummy3.setHotelName("Mandarin Oriental");
        dummy3.setRate(2.6);
        dummy3.setHotelFare(32.65);
        dummy3.setCity("DOH");
        dummy3.setFromDate(LocalDate.of(2020,01,01));
        dummy3.setToDate(LocalDate.of(2022,12,31));

        List<String> roomAmenities3 = new ArrayList<>();
        roomAmenities3.add("Parking");
        roomAmenities3.add("CHECK-IN & CHECK-OUT Times");
        dummy3.setRoomAmenities(String.join(", ", roomAmenities3));

        List<BookingHotelDto> demoList = new ArrayList<>();
        demoList.add(dummy1);
        demoList.add(dummy2);
        demoList.add(dummy3);

        return demoList;

    }


}
