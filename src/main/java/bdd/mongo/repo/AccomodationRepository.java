package bdd.mongo.repo;

import javax.transaction.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;
import bdd.mongo.models.Accomodation;

public interface AccomodationRepository extends MongoRepository<Accomodation, String> {
	@Transactional
	long deleteAccomodationById(String id);
	
	Accomodation findAccomodationByIdRoom(String idRoom);
	Accomodation findAccomodationById(String id);
}
