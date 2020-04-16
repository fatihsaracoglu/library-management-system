package saracoglu.fatih.librarymanagementsystem.dto;

import saracoglu.fatih.librarymanagementsystem.validation.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "Parolalar eşleşmiyor"),
})
public class UserDto {

    @NotEmpty
    private String fullName;

    @NotEmpty
    private String username;

    @NotEmpty
    @Min(6)
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}