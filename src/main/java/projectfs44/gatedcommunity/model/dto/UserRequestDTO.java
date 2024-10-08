package projectfs44.gatedcommunity.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Objects;

@Schema(description = "DTO for User_Request")
public class
UserRequestDTO {

    private Long id;

    private String picture;

    private long propositionServiceId;

    private String propositionServiceTitle;

    private String description;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime desiredDateTime;

    private long userId;

    private long addressId;

    @JsonIgnore
    private boolean active; // null / false


    @Override
    public String toString() {
        return String.format("User_request: id - %d, description - %s, proposition_service_id - %s, propositionServiceTitle - %s, desired_datetime - %s, user_id - %s, address_id - %s,  active - %s",
                id, description, propositionServiceId, propositionServiceTitle, desiredDateTime, userId, addressId, active ? "yes" : "no");
    }

    public UserRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getPropositionServiceId() {
        return propositionServiceId;
    }

    public void setPropositionServiceId(long propositionServiceId) {
        this.propositionServiceId = propositionServiceId;
    }

    public String getPropositionServiceTitle() {
        return propositionServiceTitle;
    }

    public void setPropositionServiceTitle(String propositionServiceTitle) {
        this.propositionServiceTitle = propositionServiceTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDesiredDateTime() {
        return desiredDateTime;
    }

    public void setDesiredDateTime(LocalDateTime desiredDateTime) {
        this.desiredDateTime = desiredDateTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserRequestDTO(Long id, String picture, long propositionServiceId, String propositionServiceTitle, String description, LocalDateTime desiredDateTime, long userId, long addressId, boolean active) {
        this.id = id;
        this.picture = picture;
        this.propositionServiceId = propositionServiceId;
        this.propositionServiceTitle = propositionServiceTitle;
        this.description = description;
        this.desiredDateTime = desiredDateTime;
        this.userId = userId;
        this.addressId = addressId;
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRequestDTO that = (UserRequestDTO) o;
        return propositionServiceId == that.propositionServiceId && userId == that.userId && addressId == that.addressId && active == that.active && Objects.equals(id, that.id) && Objects.equals(picture, that.picture) && Objects.equals(propositionServiceTitle, that.propositionServiceTitle) && Objects.equals(description, that.description) && Objects.equals(desiredDateTime, that.desiredDateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(picture);
        result = 31 * result + Long.hashCode(propositionServiceId);
        result = 31 * result + Objects.hashCode(propositionServiceTitle);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Objects.hashCode(desiredDateTime);
        result = 31 * result + Long.hashCode(userId);
        result = 31 * result + Long.hashCode(addressId);
        result = 31 * result + Boolean.hashCode(active);
        return result;
    }
}
