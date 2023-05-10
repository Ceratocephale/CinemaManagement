package be.technifutur.cinemamanagement.model.entity;

import be.technifutur.cinemamanagement.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column
    private UserRole role;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private LocalDate dob;

    @Column
    private String address;

    @Column(name = "client_active")
    private boolean active = true;

    @OneToMany(mappedBy = "client")
    private List<Booking> bookings;


}
