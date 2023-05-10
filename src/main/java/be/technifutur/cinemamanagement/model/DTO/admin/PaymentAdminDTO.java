package be.technifutur.cinemamanagement.model.DTO.admin;

import be.technifutur.cinemamanagement.model.entity.Booking;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PaymentAdminDTO {

    private Long id;

    private double amount;

    private String description;

    private LocalDate date;

    private boolean active;

    private BookingAdminDTO booking;
}
