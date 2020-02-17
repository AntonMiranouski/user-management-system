package anton.miranouski.user_management.repository;

import anton.miranouski.user_management.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface User account repository.
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    /**
     * Exists by username boolean.
     *
     * @param username the username
     * @return the boolean
     */
    boolean existsByUsername(String username);

    /**
     * Find by username user account.
     *
     * @param username the username
     * @return the user account
     */
    UserAccount findByUsername(String username);
}
