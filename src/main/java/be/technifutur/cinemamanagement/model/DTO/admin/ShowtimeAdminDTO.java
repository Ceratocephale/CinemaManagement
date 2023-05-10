package be.technifutur.cinemamanagement.model.DTO.admin;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ShowtimeAdminDTO {

    private Long id;

    private LocalDateTime start;

    private LocalDateTime end;

    private boolean active;

    private List<BookingAdminDTO> bookings;


}
