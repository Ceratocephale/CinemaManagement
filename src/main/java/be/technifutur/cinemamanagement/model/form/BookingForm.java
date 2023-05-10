package be.technifutur.cinemamanagement.model.form;

import be.technifutur.cinemamanagement.model.entity.Booking;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingForm {

    @NotNull
    @FutureOrPresent
    private LocalDateTime date;

    @NotNull
    private Long clientId;

    private String description;

    @NotNull
    private List<Long> showtimeIds;

    @NotNull
    private Long paymentId;


    public Booking toEntity() {
        Booking booking = new Booking();

        booking.setDate(date);
        booking.setDescription(description);

        return booking;

    }


}
