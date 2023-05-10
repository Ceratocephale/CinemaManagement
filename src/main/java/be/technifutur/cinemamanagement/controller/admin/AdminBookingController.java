package be.technifutur.cinemamanagement.controller.admin;

import be.technifutur.cinemamanagement.model.DTO.admin.BookingAdminDTO;
import be.technifutur.cinemamanagement.model.form.BookingForm;
import be.technifutur.cinemamanagement.model.mapper.MapperAdmin;
import be.technifutur.cinemamanagement.service.impl.BookingServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class AdminBookingController {

    private final BookingServiceImpl bookingService;

    public AdminBookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/all")
    public List<BookingAdminDTO> getAll() {
        return bookingService.getAll().stream()
                .map(MapperAdmin::from)
                .toList();
    }

    @GetMapping("/{id}")
    public BookingAdminDTO getOne(@PathVariable long id){
        return MapperAdmin.from(bookingService.getOne(id));
    }

    @PostMapping("/add")
    public BookingAdminDTO create(@RequestBody @Valid BookingForm form) {
        return MapperAdmin.from(bookingService.create(form));
    }

    @DeleteMapping("/delete/{id}")
    public BookingAdminDTO delete(@PathVariable long id) {
        return MapperAdmin.from(bookingService.delete(id));
    }


}
