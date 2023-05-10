package be.technifutur.cinemamanagement.model.DTO.admin;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BookingAdminDTO {

    private Long id;

    private String description;

    private LocalDateTime date;

    private ClientAdminDTO client;

    private List<ShowtimeAdminDTO> showtimes;

    private PaymentAdminDTO payment;

}
