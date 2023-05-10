package be.technifutur.cinemamanagement.repository;

import be.technifutur.cinemamanagement.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
