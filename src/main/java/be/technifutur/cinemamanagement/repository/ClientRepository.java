package be.technifutur.cinemamanagement.repository;

import be.technifutur.cinemamanagement.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
