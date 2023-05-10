package be.technifutur.cinemamanagement.service.impl;

import be.technifutur.cinemamanagement.exceptions.BookingNotFoundException;
import be.technifutur.cinemamanagement.exceptions.ClientNotFoundException;
import be.technifutur.cinemamanagement.exceptions.PaymentNotFoundException;
import be.technifutur.cinemamanagement.exceptions.ShowtimeNotFoundException;
import be.technifutur.cinemamanagement.model.entity.Booking;
import be.technifutur.cinemamanagement.model.form.BookingForm;
import be.technifutur.cinemamanagement.repository.BookingRepository;
import be.technifutur.cinemamanagement.repository.ClientRepository;
import be.technifutur.cinemamanagement.repository.PaymentRepository;
import be.technifutur.cinemamanagement.repository.ShowtimeRepository;
import be.technifutur.cinemamanagement.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    public final BookingRepository bookingRepository;
    public final ClientRepository clientRepository;
    public final ShowtimeRepository showtimeRepository;
    public final PaymentRepository paymentRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, ClientRepository clientRepository, ShowtimeRepository showtimeRepository, PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
        this.showtimeRepository = showtimeRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getOne(long id) {
        return bookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
    }

    @Override
    public Booking create(BookingForm form) {
        Booking booking = form.toEntity();
        booking.setClient(clientRepository.findById(form.getClientId()).orElseThrow(ClientNotFoundException::new));
        booking.setShowtimes(form.getShowtimeIds().stream()
                .map(i -> showtimeRepository.findById(i).orElseThrow(ShowtimeNotFoundException::new))
                .toList()
        );
        booking.setPayment(paymentRepository.findById(form.getPaymentId()).orElseThrow(PaymentNotFoundException::new));
        return booking;
    }

    @Override
    public Booking update(BookingForm form) {

    }

    @Override
    public Booking delete(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
        booking.setActive(false);
        return bookingRepository.save(booking);
    }
}
