package be.technifutur.cinemamanagement.model.mapper;

import be.technifutur.cinemamanagement.model.DTO.admin.BookingAdminDTO;
import be.technifutur.cinemamanagement.model.DTO.admin.ClientAdminDTO;
import be.technifutur.cinemamanagement.model.DTO.admin.PaymentAdminDTO;
import be.technifutur.cinemamanagement.model.DTO.admin.ShowtimeAdminDTO;
import be.technifutur.cinemamanagement.model.entity.Booking;
import be.technifutur.cinemamanagement.model.entity.Client;
import be.technifutur.cinemamanagement.model.entity.Payment;
import be.technifutur.cinemamanagement.model.entity.Showtime;

public class MapperAdmin {

    public static BookingAdminDTO from(Booking entity) {

        if (entity == null) {
            return null;
        }

        return BookingAdminDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .date(entity.getDate())
                .client(ClientAdminDTO.builder()
                        .id(entity.getClient().getId())
                        .role(entity.getClient().getRole().toString())
                        .firstName(entity.getClient().getFirstName())
                        .lastName(entity.getClient().getLastName())
                        .email(entity.getClient().getEmail())
                        .dob(entity.getClient().getDob())
                        .address(entity.getClient().getAddress())
                        .active(entity.getClient().isActive())
                        .build()
                )
                .showtimes(entity.getShowtimes().stream()
                        .map(
                                s -> ShowtimeAdminDTO.builder()
                                        .id(s.getId())
                                        .start(s.getStart())
                                        .end(s.getEnd())
                                        .active(s.isActive())
                                        .build()
                        )
                        .toList()
                )
                .payment(PaymentAdminDTO.builder()
                        .id(entity.getPayment().getId())
                        .amount(entity.getPayment().getAmount())
                        .description(entity.getPayment().getDescription())
                        .date(entity.getPayment().getDate())
                        .active(entity.getPayment().isActive())
                        .build())
                .build();


    }

    public static ClientAdminDTO from(Client entity) {
        if (entity == null) {
            return null;
        }

        return ClientAdminDTO.builder()
                .id(entity.getId())
                .role(entity.getRole().toString())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .dob(entity.getDob())
                .address(entity.getAddress())
                .active(entity.isActive())
                .bookings(entity.getBookings().stream()
                        .map(
                                b -> BookingAdminDTO.builder()
                                        .id(b.getId())
                                        .description(b.getDescription())
                                        .date(b.getDate())
                                        .showtimes(b.getShowtimes().stream()
                                                .map(
                                                        s -> ShowtimeAdminDTO.builder()
                                                                .id(s.getId())
                                                                .start(s.getStart())
                                                                .end(s.getEnd())
                                                                .active(s.isActive())
                                                                .build()
                                                ).toList()
                                        )
                                        .payment(PaymentAdminDTO.builder()
                                                .id(b.getPayment().getId())
                                                .amount(b.getPayment().getAmount())
                                                .description(b.getPayment().getDescription())
                                                .date(b.getPayment().getDate())
                                                .active(b.getPayment().isActive())
                                                .build())
                                        .build()
                        ).toList())
                .build();

    }

    public static PaymentAdminDTO from(Payment entity) {
        if (entity == null) {
            return null;
        }

        return PaymentAdminDTO.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .description(entity.getDescription())
                .date(entity.getDate())
                .active(entity.isActive())
                .booking(
                        BookingAdminDTO.builder()
                                .id(entity.getBooking().getId())
                                .description(entity.getBooking().getDescription())
                                .date(entity.getBooking().getDate())
                                .client(ClientAdminDTO.builder()
                                        .id(entity.getBooking().getClient().getId())
                                        .firstName(entity.getBooking().getClient().getFirstName())
                                        .lastName(entity.getBooking().getClient().getLastName())
                                        .build())
                                .showtimes(entity.getBooking().getShowtimes().stream()
                                        .map(
                                                s -> ShowtimeAdminDTO.builder()
                                                        .id(s.getId())
                                                        .start(s.getStart())
                                                        .end(s.getEnd())
                                                        .active(s.isActive())
                                                        .build()
                                        ).toList())

                                .build())

                .build();
    }

    public static ShowtimeAdminDTO from(Showtime entity) {
        if (entity == null) {
            return null;
        }

        return ShowtimeAdminDTO.builder()
                .id(entity.getId())
                .start(entity.getStart())
                .end(entity.getEnd())
                .active(entity.isActive())
                .bookings(entity.getBookings().stream()
                        .map(
                                b -> BookingAdminDTO.builder()
                                        .id(b.getId())
                                        .description(b.getDescription())
                                        .date(b.getDate())
                                        .client(ClientAdminDTO.builder()
                                                .id(b.getClient().getId())
                                                .firstName(b.getClient().getFirstName())
                                                .lastName(b.getClient().getLastName())
                                                .build())
                                        .payment(PaymentAdminDTO.builder()
                                                .id(b.getPayment().getId())
                                                .amount(b.getPayment().getAmount())
                                                .date(b.getPayment().getDate())
                                                .build())

                                        .build()
                        ).toList())
                .build();
    }
}
