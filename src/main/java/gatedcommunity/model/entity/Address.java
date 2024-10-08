package gatedcommunity.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "address")

public class Address {

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

    public Address(Long id, String street, String house, String city, int index, boolean active) {
        this.id = id;
        this.street = street;
        this.numberHouse = house;
        this.city = city;
        this.index = index;
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("Address: id - %d, street - %s, numberHouse - %s, city - %s, index - %d, active - %s",
                id, street, numberHouse, city, index, active ? "yes" : "no" );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return index == address.index && active == address.active && Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(numberHouse, address.numberHouse) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, numberHouse, city, index, active);
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


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
