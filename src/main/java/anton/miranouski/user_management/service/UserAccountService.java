package anton.miranouski.user_management.service;

import anton.miranouski.user_management.model.UserAccount;

import java.util.List;

/**
 * The interface User account service.
 */
public interface UserAccountService {

    /**
     * Find all list.
     *
     * @return the list of users
     */
    List<UserAccount> findAll();

    /**
     * Find by id user account.
     *
     * @param id the id
     * @return the user account
     */
    UserAccount findById(Long id);

    /**
     * Find by username user account.
     *
     * @param username the username
     * @return the user account
     */
    UserAccount findByUsername(String username);

    /**
     * Save user account.
     *
     * @param user the user
     * @return the user account
     */
    UserAccount save(UserAccount user);

    /**
     * Update user account.
     *
     * @param user the user
     * @return the user account
     */
    UserAccount update(UserAccount user);
}
