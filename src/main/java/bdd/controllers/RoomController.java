package bdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bdd.mysql.models.Room;
import bdd.mysql.repo.RoomRepository;

@Controller

public class RoomController {

	@Autowired
	private RoomRepository roomRepository;
	
	@RequestMapping("/room")
	public String room(@RequestParam(required = false) String type, Model model) {
		if(null != type && type != "") {
			model.addAttribute("room", roomRepository.findRoomByType(type));
		} else {
			model.addAttribute("room", roomRepository.findAll());
		}
        return "room";
    }
	
	@RequestMapping("/addRoom")
    public String create(Model model) {
        return "addRoom";
    }
    @RequestMapping("/saveRoom")
    public String save(@RequestParam String type, @RequestParam int capacity, @RequestParam Double price) {
        Room room = new Room();
        room.setType(type);
        room.setCapacity(capacity);
        room.setPrice(price);

        roomRepository.save(room);

        return "redirect:/showRoom/" + room.getId();
    }

    @RequestMapping("/showRoom/{id}")
    public String showRoom(@PathVariable long id, Model model) {
        model.addAttribute("room", roomRepository.findRoomById(id));
        return "showRoom";
    }

    @RequestMapping("/deleteRoom")
    public String delete(@RequestParam long id) {
        Room room = roomRepository.findRoomById(id);
        roomRepository.delete(room);

        return "redirect:/room";
    }

    @RequestMapping("/editRoom/{id}")
    public String editRoom(@PathVariable long id, Model model) {
        model.addAttribute("room", roomRepository.findRoomById(id));
        return "editRoom";
    }

    @RequestMapping("/updateRoom")
    public String update(@RequestParam long id, @RequestParam String type, @RequestParam int capacity, @RequestParam Double price) {
        Room room = roomRepository.findRoomById(id);
        room.setType(type);
        room.setCapacity(capacity);
        room.setPrice(price);
        roomRepository.save(room);

        return "redirect:/showRoom/" + room.getId();
    }
}
