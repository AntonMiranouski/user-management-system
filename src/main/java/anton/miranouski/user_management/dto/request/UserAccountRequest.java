package anton.miranouski.user_management.dto.request;

import anton.miranouski.user_management.model.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * The type User account request.
 */
public class UserAccountRequest {

    private Long id;

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 16, message = "Username can be from 3 to 16 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only latin letters available")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 3, max = 16, message = "Password can be from 3 to 16 characters")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[\\w]+$",
            message = "Password must contain at least one latin letter and one digit"
    )
    private String password;

    @NotBlank(message = "First Name cannot be empty")
    @Size(min = 1, max = 16, message = "First Name can be from 1 to 16 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only latin letters available")
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @Size(min = 1, max = 16, message = "Last Name can be from 1 to 16 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only latin letters available")
    private String lastName;

    private boolean active;

    private Set<Role> roles;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Is active boolean.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
