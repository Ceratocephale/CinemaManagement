package be.technifutur.cinemamanagement.service;

import be.technifutur.cinemamanagement.model.DTO.admin.BookingAdminDTO;
import be.technifutur.cinemamanagement.model.entity.Booking;
import be.technifutur.cinemamanagement.model.form.BookingForm;

import java.util.List;


public interface BookingService  {

    List<Booking> getAll();

    Booking getOne(long id);

    Booking create(BookingForm form);

    Booking update(BookingForm form);

    Booking delete(Long id);


}
