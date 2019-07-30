package net.javaguides.springmvc.repository.user;

import net.javaguides.springmvc.entity.user.User;
import net.javaguides.springmvc.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User> {

    /*boolean existsByIdAndDeletedIsNull(String id);*/

    /*boolean existsByEmailAndDeletedIsNull(String email);*/

    boolean existsByEmail(String email);
}