package bdd.mongo.repo;

import javax.transaction.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;
import bdd.mongo.models.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
	@Transactional
	long deleteClientByName(String name);
	@Transactional
	long deleteClientById(String id);
	
	Client findClientByName(String name);
	Client findClientById(String id);
}
