package bdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bdd.mongo.models.Bill;
import bdd.mongo.repo.BillRepository;

@Controller

public class BillController {

	@Autowired
	private BillRepository billRepository;
	
	@RequestMapping("/bill")
	public String bill(@RequestParam(required = false) String idClient, Model model) {
		if(null != idClient && idClient != "") {
			model.addAttribute("bill", billRepository.findByIdClient(idClient));
		} else {
			model.addAttribute("bill", billRepository.findAll());
		}
        return "bill";
    }
	
	@RequestMapping("/addBill")
    public String create(Model model) {
        return "addBill";
    }
    @RequestMapping("/saveBill")
    public String save(@RequestParam String idEmployee, @RequestParam String idClient, @RequestParam String date, 
    		@RequestParam Double amount) {
        Bill bill = new Bill();
        bill.setIdEmployee(idEmployee);
        bill.setIdClient(idClient);
        bill.setDate(date);
        bill.setAmount(amount);
        billRepository.save(bill);

        return "redirect:/showBill/" + bill.getId();
    }

    @RequestMapping("/showBill/{id}")
    public String showBill(@PathVariable String id, Model model) {
        model.addAttribute("bill", billRepository.findBillById(id));
        return "showBill";
    }

    @RequestMapping("/deleteBill")
    public String delete(@RequestParam String id) {
        Bill bill = billRepository.findBillById(id);
        billRepository.delete(bill);

        return "redirect:/bill";
    }

    @RequestMapping("/editBill/{id}")
    public String editBill(@PathVariable String id, Model model) {
        model.addAttribute("bill", billRepository.findBillById(id));
        return "editBill";
    }

    @RequestMapping("/updateBill")
    public String update(@RequestParam String id, @RequestParam String idEmployee, @RequestParam String idClient, @RequestParam String date, 
    		@RequestParam Double amount) {
        Bill bill = billRepository.findBillById(id);
        bill.setIdEmployee(idEmployee);
        bill.setIdClient(idClient);
        bill.setDate(date);
        bill.setAmount(amount);
        billRepository.save(bill);

        return "redirect:/showBill/" + bill.getId();
    }
}
