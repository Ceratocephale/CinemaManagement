package be.technifutur.cinemamanagement.model.DTO.admin;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ClientAdminDTO {

    private Long id;

    private String role;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate dob;

    private String address;

    private boolean active;

    private List<BookingAdminDTO> bookings;
}
