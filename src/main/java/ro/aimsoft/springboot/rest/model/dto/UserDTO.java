package ro.aimsoft.springboot.rest.model.dto;

import javax.validation.constraints.*;
import java.util.UUID;

public class UserDTO {

    @NotNull
    private UUID id;

    @Email
    private String email;

    @Size(min=8, max=20)
    private String firstName;

    @Size(min=8, max=20)
    private String lastName;

    @Min(0)
    @Max(4)
    private long status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
