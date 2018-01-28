package bdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bdd.mysql.models.Department;
import bdd.mysql.repo.DepartmentRepository;

@Controller

public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@RequestMapping("/department")
	public String department(@RequestParam(required = false) String name, Model model) {
		if(null != name && name != "") {
			model.addAttribute("department", departmentRepository.findDepartmentByName(name));
		} else {
			model.addAttribute("department", departmentRepository.findAll());
		}
        return "department";
    }
	
	@RequestMapping("/addDepartment")
    public String create(Model model) {
        return "addDepartment";
    }
    @RequestMapping("/saveDepartment")
    public String save(@RequestParam String name) {
        Department department = new Department();
        department.setName(name);

        departmentRepository.save(department);

        return "redirect:/showDepartment/" + department.getId();
    }

    @RequestMapping("/showDepartment/{id}")
    public String showDepartment(@PathVariable long id, Model model) {
        model.addAttribute("department", departmentRepository.findDepartmentById(id));
        return "showDepartment";
    }

    @RequestMapping("/deleteDepartment")
    public String delete(@RequestParam long id) {
        Department department = departmentRepository.findDepartmentById(id);
        departmentRepository.delete(department);

        return "redirect:/department";
    }

    @RequestMapping("/editDepartment/{id}")
    public String editDepartment(@PathVariable long id, Model model) {
        model.addAttribute("department", departmentRepository.findDepartmentById(id));
        return "editDepartment";
    }

    @RequestMapping("/updateDepartment")
    public String update(@RequestParam long id, @RequestParam String name) {
        Department department = departmentRepository.findDepartmentById(id);
        department.setName(name);

        departmentRepository.save(department);

        return "redirect:/showDepartment/" + department.getId();
    }
}
