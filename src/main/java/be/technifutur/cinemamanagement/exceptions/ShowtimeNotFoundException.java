package be.technifutur.cinemamanagement.exceptions;

public class ShowtimeNotFoundException extends RuntimeException{

    public ShowtimeNotFoundException(){
        super("Requested showtime was not found");
    }
}
