package net.javaguides.springmvc.service.user;

import net.javaguides.springmvc.entity.user.User;

import java.util.List;

public interface UserService {

    User get(String id);

    User update(UserUpdateRequest userUpdateRequest);

    User create(UserCreationRequest userCreationRequest);

    List<User> getUsers();

    void delete(String id);
}