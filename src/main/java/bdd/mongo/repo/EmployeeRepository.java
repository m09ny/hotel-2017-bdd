package bdd.mongo.repo;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;

import bdd.mongo.models.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	@Transactional
	long deleteEmployeeByName(String name);
	@Transactional
	long deleteEmployeeById(String id);
	
	Employee findEmployeeByName(String name);
	Employee findEmployeeById(String id);
	Set<Employee> findByDepartmentId(String departmentId);
}
