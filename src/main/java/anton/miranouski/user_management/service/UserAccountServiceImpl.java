package anton.miranouski.user_management.service;

import anton.miranouski.user_management.model.UserAccount;
import anton.miranouski.user_management.repository.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService{

    private final UserAccountRepository accountRepository;

    public UserAccountServiceImpl(UserAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<UserAccount> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public UserAccount findById(Long id) {
        return accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found user with this id"));
    }

    @Override
    public UserAccount save(UserAccount user) {
        user.setId(null);
        if (accountRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("Account with this username already exists");
        }
        return accountRepository.saveAndFlush(user);
    }

    @Override
    public UserAccount update(UserAccount user) {
        return accountRepository.saveAndFlush(user);
    }
}