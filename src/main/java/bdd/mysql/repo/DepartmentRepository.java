package bdd.mysql.repo;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import bdd.mysql.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	@Transactional
	long deleteDepartmentByName(String name);
	@Transactional
	long deleteDepartmentById(long id);
	
	Department findDepartmentById(long id);
	Department findDepartmentByName(String name);
	
	Set<Department> findAll();
}
