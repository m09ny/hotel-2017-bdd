package bdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bdd.mongo.models.Employee;
import bdd.mongo.repo.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/employee")
	public String employee(@RequestParam(required = false) String departmentId, Model model) {
		if(null != departmentId && departmentId != "") {
			model.addAttribute("employee", employeeRepository.findByDepartmentId(departmentId));
		} else {
			model.addAttribute("employee", employeeRepository.findAll());
		}
        return "employee";
    }
	
	@RequestMapping("/addEmployee")
    public String create(Model model) {
        return "addEmployee";
    }
    @RequestMapping("/save")
    public String save(@RequestParam String name, @RequestParam String email, @RequestParam String address, 
    		@RequestParam String role, @RequestParam Double salary, @RequestParam String departmentId) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setRole(role);
		employee.setSalary(salary);
		employee.setDepartmentId(departmentId);
        employeeRepository.save(employee);

        return "redirect:/showEmployee/" + employee.getId();
    }

    @RequestMapping("/showEmployee/{id}")
    public String showEmployee(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeRepository.findEmployeeById(id));
        return "showEmployee";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        employeeRepository.delete(employee);

        return "redirect:/employee";
    }

    @RequestMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeRepository.findEmployeeById(id));
        return "editEmployee";
    }

    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String name, @RequestParam String email, 
    		@RequestParam String address, @RequestParam String role, @RequestParam Double salary, @RequestParam String departmentId) {
        Employee employee = employeeRepository.findEmployeeById(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setRole(role);
		employee.setSalary(salary);
		employee.setDepartmentId(departmentId);
        employeeRepository.save(employee);

        return "redirect:/showEmployee/" + employee.getId();
    }
}
