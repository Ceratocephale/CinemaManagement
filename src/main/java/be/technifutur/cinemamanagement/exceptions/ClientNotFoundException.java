package be.technifutur.cinemamanagement.exceptions;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(){
        super("Requested client was not found");
    }
}
