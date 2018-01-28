package bdd.mongo.repo;

import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;
import bdd.mongo.models.Bill;

public interface BillRepository extends MongoRepository<Bill, String> {
	@Transactional
	long deleteBillById(String id);
	
	Bill findBillById(String id);
	Set<Bill> findByIdClient(String idClient);
	Set<Bill> findByAmountGreaterThan(double amount);
}
