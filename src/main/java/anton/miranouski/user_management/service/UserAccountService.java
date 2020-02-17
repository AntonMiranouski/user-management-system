package anton.miranouski.user_management.service;

import anton.miranouski.user_management.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    List<UserAccount> findAll();

    UserAccount findById(Long id);

    UserAccount findByUsername(String username);

    UserAccount save(UserAccount user);

    void update(UserAccount user);
}
