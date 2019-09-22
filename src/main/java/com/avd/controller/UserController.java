package com.avd.controller;

import com.avd.entity.Guest;
import com.avd.entity.Room;
import com.avd.entity.User;
import com.avd.service.UserService;
import com.avd.service.booking.BookService;
import com.avd.service.guest.GuestService;
import com.avd.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;
    @Autowired
    public BookService bookService;
    @Autowired
    public RoomService roomService;
    @Autowired
    public GuestService guestService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }




    @GetMapping("/checkAvailableRooms")
    public String checkAvailableRooms() {
        return "checkAvailableRooms";
    }

    @PostMapping("/availableRooms")
    public String getAllAvailableRooms (@ModelAttribute("rooms") Room room, Model model) {

        model.addAttribute("rooms", bookService.findAllAvailableRooms(room.getCheckIn(), room.getCheckOut()) );  ///!!!!!!!
        model.addAttribute("dateCheckIn", room.getCheckIn()  );
        model.addAttribute("dateCheckOut", room.getCheckOut()  );
        return "availableRooms";
    }

    @PostMapping("/bookRoom")
    public String bookRoom   (@ModelAttribute("rooms") Room room, @ModelAttribute("guest") Guest guest, Model model) throws Exception {

       String nomAndPrice = room.getRoomNoAndPrice();
        String[] values = nomAndPrice.split(",");

        room.setRoom_no( Integer.valueOf(values[0]));
        room.setRoomPrice( Integer.valueOf(values[1]));

        guestService.recordGuest(guest);
        List<Guest> guestId = new ArrayList<Guest>(guestService.findbyIdGuest(guest ));
        Random rnd = new Random(System.currentTimeMillis());
        int book_no = rnd.nextInt(1000);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date dateCheckIn = formatter.parse(room.getCheckIn()) ;
        java.util.Date dateCheckOut = formatter.parse(room.getCheckOut()) ;

        bookService.recordBook(book_no, guestId.get(0).getId(), dateCheckIn, dateCheckOut, room.getRoom_no(), room.getRoomPrice());
        model.addAttribute("books", bookService.ShowGuestBook(book_no));
        return "showCurrentBook";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }


    @GetMapping("/user/{id}")
    public String getById (@PathVariable("id")int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String createUserPage() {
        return "createUser";
    }


    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) throws Exception {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

}



