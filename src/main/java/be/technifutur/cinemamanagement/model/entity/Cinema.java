package be.technifutur.cinemamanagement.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Long id;

    @Column
    private String address;

    @Column(name = "cinema_active")
    private boolean active = true;

    @OneToMany(mappedBy = "cinema")
    private List<Hall> halls;


}
