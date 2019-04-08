package am.itspace.webflux.repository;

import am.itspace.webflux.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository <User,String> {

}
