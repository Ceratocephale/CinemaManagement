package be.technifutur.cinemamanagement.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "booking_description")
    private String description;

    @Column(name = "booking_date",nullable = false)
    private LocalDateTime date;

    @Column(name = "booking_active")
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "showtime_bookings",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "showtime_id")
    )
    private List<Showtime> showtimes;

    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;



}
