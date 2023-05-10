package be.technifutur.cinemamanagement.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column
    private String title;

    @Column
    private String language;

    @Column
    private String genres;

    @Column
    private String description;

    @Column
    private String directors;

    @Column
    private String producers;

    @Column
    private String staff;

    @Column
    private String actors;

    @Column(name = "movie_active")
    private boolean active = true;

    @OneToMany(mappedBy = "movie")
    private List<Showtime> showtimes;

}
