package web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.exception.UserNotFoundException;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

/**
 * Контроллер для управления пользователями через веб-интерфейс.
 * Обрабатывает запросы на добавление, редактирование, удаление и просмотр пользователей.
 */
@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Показать список всех пользователей.
     */
    @GetMapping
    public String getAllUsers(Model model) {
        log.info("Displaying a list of users");
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    /**
     * Показать форму для добавления нового пользователя.
     */
    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        log.info("Showing the user add form");
        model.addAttribute("user", new User());
        return "add";
    }

    /**
     * Обработать добавление нового пользователя с валидацией.
     */
    @PostMapping("/add")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.warn("Validation error when adding user: {}", bindingResult.getAllErrors());
            return "add";
        }

        try {
            userService.saveUser(user);
            log.info("User added successfully: {}", user);
            redirectAttributes.addFlashAttribute("successMessage", "User added");
        } catch (Exception e) {
            log.error("Error adding user", e);
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding user");
        }
        return "redirect:/users";
    }

    /**
     * Показать форму для редактирования пользователя по id.
     */
    @GetMapping("/edit")
    public String showEditUserForm(@RequestParam("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
            return "edit";
        } catch (UserNotFoundException e) {
            log.warn("User not found to edit: {}", id);
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/users";
        }
    }

    /**
     * Обработать обновление пользователя с валидацией.
     */
    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.warn("Validation error when updating user: {}", bindingResult.getAllErrors());
            return "edit";
        }

        try {
            userService.updateUser(user);
            log.info("User updated successfully: {}", user);
            redirectAttributes.addFlashAttribute("successMessage", "User updated");
        } catch (UserNotFoundException e) {
            log.warn("User update error: {}", e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/users";
    }

    /**
     * Удалить пользователя по id.
     */
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUser(id);
            log.info("User с id={} удален", id);
            redirectAttributes.addFlashAttribute("successMessage", "User deleted");
        } catch (UserNotFoundException e) {
            log.warn("Error deleting user: {}", e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/users";
    }
}
