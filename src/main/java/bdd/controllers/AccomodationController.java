package bdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bdd.mongo.models.Accomodation;
import bdd.mongo.repo.AccomodationRepository;

@Controller

public class AccomodationController {

	@Autowired
	private AccomodationRepository accomodationRepository;
	
	@RequestMapping("/accomodation")
	public String accomodation(@RequestParam(required = false) String idRoom, Model model) {
		if(null != idRoom && idRoom != "") {
			model.addAttribute("accomodation", accomodationRepository.findAccomodationByIdRoom(idRoom));
		} else {
			model.addAttribute("accomodation", accomodationRepository.findAll());
		}
        return "accomodation";
    }
	
	@RequestMapping("/addAccomodation")
    public String create(Model model) {
        return "addAccomodation";
    }
    @RequestMapping("/saveAccomodation")
    public String save(@RequestParam String idEmployee, @RequestParam String idBill, @RequestParam String idRoom, 
    		@RequestParam String arrivalDate, @RequestParam int noOfNights) {
        Accomodation accomodation = new Accomodation();
        accomodation.setIdEmployee(idEmployee);
        accomodation.setIdBill(idBill);
        accomodation.setIdRoom(idRoom);
        accomodation.setArrivalDate(arrivalDate);
        accomodation.setNoOfNights(noOfNights);
        accomodationRepository.save(accomodation);

        return "redirect:/showAccomodation/" + accomodation.getId();
    }

    @RequestMapping("/showAccomodation/{id}")
    public String showAccomodation(@PathVariable String id, Model model) {
        model.addAttribute("accomodation", accomodationRepository.findAccomodationById(id));
        return "showAccomodation";
    }

    @RequestMapping("/deleteAccomodation")
    public String delete(@RequestParam String id) {
        Accomodation accomodation = accomodationRepository.findAccomodationById(id);
        accomodationRepository.delete(accomodation);

        return "redirect:/accomodation";
    }

    @RequestMapping("/editAccomodation/{id}")
    public String editAccomodation(@PathVariable String id, Model model) {
        model.addAttribute("accomodation", accomodationRepository.findAccomodationById(id));
        return "editAccomodation";
    }

    @RequestMapping("/updateAccomodation")
    public String update(@RequestParam String id, @RequestParam String idEmployee, @RequestParam String idBill, @RequestParam String idRoom, 
    		@RequestParam String arrivalDate, @RequestParam int noOfNights) {
        Accomodation accomodation = accomodationRepository.findAccomodationById(id);
        accomodation.setIdEmployee(idEmployee);
        accomodation.setIdBill(idBill);
        accomodation.setIdRoom(idRoom);
        accomodation.setArrivalDate(arrivalDate);
        accomodation.setNoOfNights(noOfNights);
        accomodationRepository.save(accomodation);

        return "redirect:/showAccomodation/" + accomodation.getId();
    }
}
