package gatedcommunity.model.dto;

import gatedcommunity.model.entity.Address;
import gatedcommunity.model.entity.Role;

import java.util.Objects;
import java.util.Set;

public class UserDTO {

    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Address> addresses;
    private Set<Role> roles;
    private boolean active;

    @Override
    public String toString() {
        return String.format("User : id - %d, userName - %s, firstName - %s, lastName -%s, addresses - %s, roles - %s, active - %s",
                id, userName, firstName, lastName, addresses == null ? "[]" : addresses, roles == null ? "[]" : roles, active ? "yes" : "no");
    }

    public UserDTO(Long id, String userName, String password,
                   String firstName, String lastName,
                   String email, Set<Address> addresses,
                   Set<Role> roles, boolean active) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addresses = addresses;
        this.roles = roles;
        this.active = active;
    }

    public UserDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return active == userDTO.active && Objects.equals(id, userDTO.id)
                && Objects.equals(userName, userDTO.userName)
                && Objects.equals(password, userDTO.password)
                && Objects.equals(firstName, userDTO.firstName)
                && Objects.equals(lastName, userDTO.lastName)
                && Objects.equals(email, userDTO.email)
                && Objects.equals(addresses, userDTO.addresses)
                && Objects.equals(roles, userDTO.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, firstName,
                lastName, email, addresses, roles, active);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}