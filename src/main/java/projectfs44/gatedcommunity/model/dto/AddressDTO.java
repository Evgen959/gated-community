package projectfs44.gatedcommunity.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;


@Schema(description = "DTO for address")

public class AddressDTO {

    private Long id;

    private String street;

    private String numberHouse;

    private String city;

    private int index;

    @JsonIgnore
    private boolean active;

    public AddressDTO(Long id, String street, String numberHouse, String city, int index, boolean active) {
        this.id = id;
        this.street = street;
        this.numberHouse = numberHouse;
        this.city = city;
        this.index = index;
        this.active = active;
    }

    public AddressDTO() {
    }

    @Override
    public String toString() {
        return String.format("Address: id - %d, street - %s, numberHouse - %s, city - %s, index - %d",
                id, street, numberHouse, city, index);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDTO that = (AddressDTO) o;
        return index == that.index && active == that.active && Objects.equals(id, that.id) && Objects.equals(street, that.street) && Objects.equals(numberHouse, that.numberHouse) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(street);
        result = 31 * result + Objects.hashCode(numberHouse);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + index;
        result = 31 * result + Boolean.hashCode(active);
        return result;
    }
}
