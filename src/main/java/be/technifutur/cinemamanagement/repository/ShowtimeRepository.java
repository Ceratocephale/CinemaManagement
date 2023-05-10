package be.technifutur.cinemamanagement.repository;

import be.technifutur.cinemamanagement.model.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}
