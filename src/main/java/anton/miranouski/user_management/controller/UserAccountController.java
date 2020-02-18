package anton.miranouski.user_management.controller;

import anton.miranouski.user_management.dto.request.UserAccountRequest;
import anton.miranouski.user_management.dto.response.UserAccountResponse;
import anton.miranouski.user_management.model.UserAccount;
import anton.miranouski.user_management.service.UserAccountService;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type User account controller.
 */
@Controller
@RequestMapping("/user")
public class UserAccountController {

    private final UserAccountService accountService;

    private final DozerBeanMapper mapper;

    /**
     * Instantiates a new User account controller.
     *
     * @param accountService the account service
     * @param mapper         the mapper
     */
    public UserAccountController(
            UserAccountService accountService, DozerBeanMapper mapper) {
        this.accountService = accountService;
        this.mapper = mapper;
    }

    /**
     * Gets all users.
     *
     * @param model the model
     * @return the all users
     */
    @GetMapping
    public String getAll(Model model) {
        final List<UserAccount> users = accountService.findAll();
        final List<UserAccountResponse> usersResponse = users.stream()
                .map(user -> mapper.map(user, UserAccountResponse.class))
                .collect(Collectors.toList());
        model.addAttribute("users", usersResponse);
        return "users";
    }

    /**
     * Gets user by id.
     *
     * @param id    the id
     * @param model the model
     * @return user by id
     */
    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        final UserAccount user = accountService.findById(id);
        final UserAccountResponse userResponse = mapper.map(user, UserAccountResponse.class);
        model.addAttribute("user", userResponse);
        return "userDetails";
    }

    /**
     * Get user creation page.
     *
     * @return the string
     */
    @GetMapping("/new")
    public String save() {
        return "userNew";
    }

    /**
     * Create new user.
     *
     * @param userRequest the user request
     * @return all users
     */
    @PostMapping("/new")
    public String save(@Valid @ModelAttribute UserAccountRequest userRequest) {
        final UserAccount user = mapper.map(userRequest, UserAccount.class);
        accountService.save(user);
        return "redirect:/user";
    }

    /**
     * Get user update page.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        final UserAccount user = accountService.findById(id);
        final UserAccountResponse userResponse = mapper.map(user, UserAccountResponse.class);
        model.addAttribute("user", userResponse);
        return "userEdit";
    }

    /**
     * Update user.
     *
     * @param id          the id
     * @param userRequest the user request
     * @return updated user
     */
    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @Valid @ModelAttribute UserAccountRequest userRequest) {
        UserAccount user = mapper.map(userRequest, UserAccount.class);
        accountService.update(user);
        return "redirect:/user/" + id;
    }
}
