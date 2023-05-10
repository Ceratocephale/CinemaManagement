package be.technifutur.cinemamanagement.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showtime_id")
    private Long id;

    @Column(name = "showtime_begin")
    private LocalDateTime start;

    @Column(name = "showtime_end")
    private LocalDateTime end;

    @Column(name = "showtime_active")
    private boolean active = true;

    @ManyToMany(mappedBy = "showtimes")
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}
