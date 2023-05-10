package be.technifutur.cinemamanagement.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column
    private double amount;

    @Column
    private String description;

    @Column
    private LocalDate date;

    @Column(name = "payment_active")
    private boolean active = true;

    @OneToOne(mappedBy = "payment")
    private Booking booking;

}
