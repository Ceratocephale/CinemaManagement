package be.technifutur.cinemamanagement.repository;

import be.technifutur.cinemamanagement.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
