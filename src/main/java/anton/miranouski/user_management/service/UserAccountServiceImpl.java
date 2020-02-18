package anton.miranouski.user_management.service;

import anton.miranouski.user_management.model.UserAccount;
import anton.miranouski.user_management.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type User account service.
 */
@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new User account service.
     *
     * @param accountRepository the account repository
     * @param passwordEncoder   the password encoder
     */
    public UserAccountServiceImpl(UserAccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserAccount> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public UserAccount findById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Not found user with this id"));
    }

    @Override
    public UserAccount findByUsername(String username) {
        if (!accountRepository.existsByUsername(username)) {
            throw new RuntimeException("Not found user with this username");
        }
        return accountRepository.findByUsername(username);
    }

    @Override
    public UserAccount save(UserAccount user) {
        user.setId(null);
        if (accountRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Account with this username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountRepository.saveAndFlush(user);
    }

    @Override
    public UserAccount update(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountRepository.saveAndFlush(user);
    }
}
