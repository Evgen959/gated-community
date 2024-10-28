package projectfs44.gatedcommunity.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "address")
@Schema(description = "Class that describes address")

public class Address {

    @Schema(description = "address unique identifier", example = "777", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number_house")
    private String numberHouse;

    @Column(name = "city")
    private String city;

    @Column(name = "index")
    private int index;

    @Column(name = "active")
    private boolean active;


    public Address() {

    }

    @Override
    public String toString() {
        return String.format("Address: id - %d, street - %s, numberHouse - %s, city - %s, index - %d, active - %s",
                id, street, numberHouse, city, index, active ? "yes" : "no" );
    }

    public Address(Long id, String street, String numberHouse, String city, int index, boolean active) {
        this.id = id;
        this.street = street;
        this.numberHouse = numberHouse;
        this.city = city;
        this.index = index;
        this.active = active;
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

        Address address = (Address) o;
        return index == address.index && active == address.active && Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(numberHouse, address.numberHouse) && Objects.equals(city, address.city);
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
