package anton.miranouski.user_management.dto.request;

import anton.miranouski.user_management.model.Role;
import anton.miranouski.user_management.model.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

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

    private List<Role> roles;

    private List<Status> status;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }
}
