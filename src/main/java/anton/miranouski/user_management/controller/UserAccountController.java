package anton.miranouski.user_management.controller;

import anton.miranouski.user_management.dto.request.UserAccountRequest;
import anton.miranouski.user_management.dto.response.UserAccountResponse;
import anton.miranouski.user_management.model.UserAccount;
import anton.miranouski.user_management.service.UserAccountService;
import org.dozer.DozerBeanMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserAccountController {

    private final UserAccountService accountService;

    private final DozerBeanMapper mapper;

    private final PasswordEncoder passwordEncoder;

    public UserAccountController(
            UserAccountService accountService, DozerBeanMapper mapper, PasswordEncoder passwordEncoder
    ) {
        this.accountService = accountService;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getAll(Model model) {
        final List<UserAccount> users = accountService.findAll();
        final List<UserAccountResponse> usersResponse = users.stream()
                .map(user -> mapper.map(user, UserAccountResponse.class))
                .collect(Collectors.toList());
        model.addAttribute("users", usersResponse);
        return "users";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        final UserAccount user = accountService.findById(id);
        final UserAccountResponse userResponse = mapper.map(user, UserAccountResponse.class);
        model.addAttribute("user", userResponse);
        return "userDetails";
    }

    @GetMapping("/new")
    public String save() {
        return "userNew";
    }

    @PostMapping("/new")
    public String save(@Valid @ModelAttribute UserAccountRequest userRequest) {
        final UserAccount user = mapper.map(userRequest, UserAccount.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        accountService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        final UserAccount user = accountService.findById(id);
        final UserAccountResponse userResponse = mapper.map(user, UserAccountResponse.class);
        model.addAttribute("user", userResponse);
        return "userEdit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @Valid @ModelAttribute UserAccountRequest userRequest) {
        UserAccount user = mapper.map(userRequest, UserAccount.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        accountService.update(user);
        return "redirect:/user/" + id;
    }
}
