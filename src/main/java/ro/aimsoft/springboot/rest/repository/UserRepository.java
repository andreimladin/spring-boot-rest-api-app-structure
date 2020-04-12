package ro.aimsoft.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.aimsoft.springboot.rest.model.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

//    Optional<User> findByEmailAndFirstName(String email, String firstName);

}


///// Proxy - Spring
//public class UserRepositoryImpl implements UserRepository {
//
//
//
//}