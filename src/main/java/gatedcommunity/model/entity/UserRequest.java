package gatedcommunity.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;


import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "requests")
@Schema(description = "Class that describes proposition_service")
public class UserRequest {

    @Schema(description = "user_request unique identifier", example = "777", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "picture")
    private String picture;

    @Schema(description = "user_request  proposition_service_id", example = "023")
    @Column(name = "proposition_service_id")
    private long propositionServiceId;

    @Schema(description = "user_request description", example = "change old lamp nach new")
    @Column(name = "description")
    private String description;


    @Schema(description = "user_request timestamp", example = "2028-12-12T18:05:45")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "desired_datetime")
    private LocalDateTime desiredDateTime;


    @Schema(description = "user_request  user_id", example = "013")
    @Column(name = "user_id")
    private long userId;

    @Schema(description = "user_request  address_id", example = "013")
    @Column(name = "address_id")
    private long addressId;

    @Schema(description = "Is user_request available", accessMode = Schema.AccessMode.READ_ONLY)
    @Column
    private boolean active; // null / false

    public UserRequest() {

    }

    @Override
    public String toString() {
        return String.format("User_request: id - %d, description - %s, proposition_service_id - %s, desired_datetime - %s, user_id - %s, address_id - %s,  active - %s",
                id, description, propositionServiceId, desiredDateTime, userId, addressId, active ? "yes" : "no");
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

    public UserRequest(Long id, String picture, long propositionServiceId, String description, LocalDateTime desiredDateTime, long userId, long addressId, boolean active) {
        this.id = id;
        this.picture = picture;
        this.propositionServiceId = propositionServiceId;
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

        UserRequest that = (UserRequest) o;
        return propositionServiceId == that.propositionServiceId && userId == that.userId && addressId == that.addressId && active == that.active && Objects.equals(id, that.id) && Objects.equals(picture, that.picture) && Objects.equals(description, that.description) && Objects.equals(desiredDateTime, that.desiredDateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(picture);
        result = 31 * result + Long.hashCode(propositionServiceId);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Objects.hashCode(desiredDateTime);
        result = 31 * result + Long.hashCode(userId);
        result = 31 * result + Long.hashCode(addressId);
        result = 31 * result + Boolean.hashCode(active);
        return result;
    }


}
