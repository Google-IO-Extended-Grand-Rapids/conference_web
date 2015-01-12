package hello.repository;

import hello.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dan90374 on 7/7/14.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}