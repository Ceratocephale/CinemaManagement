package be.technifutur.cinemamanagement.exceptions;

public class PaymentNotFoundException extends RuntimeException{

    public PaymentNotFoundException() {
        super("Requested payment was not found");

    }
}
