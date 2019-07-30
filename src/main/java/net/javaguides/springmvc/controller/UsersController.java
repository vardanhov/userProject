package net.javaguides.springmvc.controller;

import net.javaguides.springmvc.dto.UserCreationRequestDto;
import net.javaguides.springmvc.dto.UserUpdateRequestDto;
import net.javaguides.springmvc.entity.user.User;
import net.javaguides.springmvc.exception.EmailAlreadyExistException;
import net.javaguides.springmvc.service.user.UserCreationRequest;
import net.javaguides.springmvc.service.user.UserService;
import net.javaguides.springmvc.service.user.UserUpdateRequest;
import net.javaguides.springmvc.util.ApplicationStorage;
import net.javaguides.springmvc.util.constant.MessageKeys;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    private final UserService userService;

    @Autowired
    public UsersController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(final Model model) {
        final List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(final Model model) {
        final UserCreationRequestDto userCreationRequest = new UserCreationRequestDto();
        model.addAttribute("creationRequest", userCreationRequest);
        return "user-create";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("creationRequest") final UserCreationRequestDto request,
                             final BindingResult bindingResult,
                             final RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "user-create";
        }
        final String email = request.getEmail();
        try {
            if (ApplicationStorage.getInstance().processEmail(email)) {
                final UserCreationRequest userCreationRequest = new UserCreationRequest(
                        email, request.getFirstName(), request.getLastName()
                );
                userService.create(userCreationRequest);

                redirectAttributes.addFlashAttribute(MessageKeys.MESSAGE, "User created successfully");
                return "redirect:/user/list";
            }
            redirectAttributes.addFlashAttribute(MessageKeys.MESSAGE, "Email already in process!!!!!!");
            return "redirect:/user/list";
        } finally {
            ApplicationStorage.getInstance().unProcessEmail(email);
        }
    }


    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("id") @NotBlank(message = "") final String id, final Model model) {
        final User user = userService.get(id);

        model.addAttribute("request", user);

        return "user-update";
    }

    @PostMapping(value = "/update")
    public String updateUser(@Valid @ModelAttribute("request") final UserUpdateRequestDto request,
                             final BindingResult bindingResult,
                             final RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            return "user-update";
        }

        final UserUpdateRequest userUpdateRequest = new UserUpdateRequest(
                request.getId(), request.getEmail(), request.getFirstName(), request.getLastName()
        );

        try {
            userService.update(userUpdateRequest);
        } catch (EmailAlreadyExistException e) {
            LOGGER.info("Email Already Exist");
        }

        redirectAttributes.addFlashAttribute(MessageKeys.MESSAGE, "User updated successfully");

        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") String theId) {
        userService.delete(theId);
        return "redirect:/user/list";
    }

}




/*    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") UserDto user,
                           BindingResult bindingResult,
                           RedirectAttributes attributes) {

        try {
            userService.saveUser(user);
        } catch (EmailAlreadyExistException e) {
            bindingResult.addError(
                    new FieldError(
                            "user", "email", user.getEmail(), true,
                            new String[]{"err.msg.email.exist"},
                            null,
                            "err.msg.email.exist"));
            return "user-form";
        }
        attributes.addFlashAttribute(MessageKeys.MESSAGE, "User created successfully");
        return "redirect:/user/list";
    }*/
