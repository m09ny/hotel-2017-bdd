package bdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bdd.mongo.models.Client;
import bdd.mongo.repo.ClientRepository;

@Controller
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping("/client")
	public String client(@RequestParam(required = false) String name, Model model) {
		if (null != name && name != "") {
			model.addAttribute("client", clientRepository.findClientByName(name));
		} else {
			model.addAttribute("client", clientRepository.findAll());

		}

		return "client";
	}

	@RequestMapping("/addClient")
	public String create(Model model) {
		return "addClient";
	}

	@RequestMapping("/saveClient")
	public String save(@RequestParam String name, @RequestParam String email, @RequestParam String address) {
		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		client.setAddress(address);
		clientRepository.save(client);

		return "redirect:/showClient/" + client.getId();
	}

	@RequestMapping("/showClient/{id}")
	public String showClient(@PathVariable String id, Model model) {
		model.addAttribute("client", clientRepository.findClientById(id));
		return "showClient";
	}

	@RequestMapping("/deleteClient")
	public String delete(@RequestParam String id) {
		Client client = clientRepository.findClientById(id);
		clientRepository.delete(client);

		return "redirect:/client";
	}

	@RequestMapping("/editClient/{id}")
	public String editClient(@PathVariable String id, Model model) {
		model.addAttribute("client", clientRepository.findClientById(id));
		return "editClient";
	}

	@RequestMapping("/updateClient")
	public String update(@RequestParam String id, @RequestParam String name, @RequestParam String email,
			@RequestParam String address) {
		Client client = clientRepository.findClientById(id);
		client.setName(name);
		client.setEmail(email);
		client.setAddress(address);
		clientRepository.save(client);

		return "redirect:/showClient/" + client.getId();
	}
}
