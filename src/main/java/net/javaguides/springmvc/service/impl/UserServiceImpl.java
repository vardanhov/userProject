package net.javaguides.springmvc.service.impl;

import net.javaguides.springmvc.entity.user.User;
import net.javaguides.springmvc.exception.EmailAlreadyExistException;
import net.javaguides.springmvc.exception.UserNotFoundException;
import net.javaguides.springmvc.repository.user.UserRepository;
import net.javaguides.springmvc.service.user.UserCreationRequest;
import net.javaguides.springmvc.service.user.UserService;
import net.javaguides.springmvc.service.user.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public User get(final String id) {
        Assert.hasText(id, "id cannot be null or empty.");
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User update(final UserUpdateRequest userUpdateRequest) {
        Assert.notNull(userUpdateRequest, "userUpdateRequest cannot be null.");

        final User user = get(userUpdateRequest.getId());

        final String email = userUpdateRequest.getEmail();
        if (!user.getEmail().equalsIgnoreCase(email)) {
            checkIfExistsByEmail(userUpdateRequest.getEmail());
        }
        user.setEmail(userUpdateRequest.getEmail());
        user.setLastName(userUpdateRequest.getLastName());
        user.setFirstName(userUpdateRequest.getFirstName());

        return userRepository.save(user);
    }

    @Override
    public User create(final UserCreationRequest userCreationRequest) {
        Assert.notNull(userCreationRequest, "userCreationRequest cannot be null.");

        final String email = userCreationRequest.getEmail();

        checkIfExistsByEmail(email);

        final User user = new User();
        user.setEmail(email);
        user.setLastName(userCreationRequest.getLastName());
        user.setFirstName(userCreationRequest.getFirstName());

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        final List<User> users = userRepository.findAll();
        return CollectionUtils.isEmpty(users) ? Collections.emptyList() : users;
    }

    @Override
    public void delete(final String id) {
        final User user = get(id);

        user.setDeleted(LocalDateTime.now());

        userRepository.delete(user);
    }

    private void checkIfExistsByEmail(final String email) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistException(email);
        }
    }
}