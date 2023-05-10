package be.technifutur.cinemamanagement.exceptions;

public class BookingNotFoundException extends RuntimeException{


    public BookingNotFoundException() {
        super("Requested booking was not found");
    }
}
