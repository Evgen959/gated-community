package projectfs44.gatedcommunity.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class AddressDTO {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")*/
    private long id;

   /* @Column(name = "street")*/
    private String street;

    /*@Column(name = "number_house")*/
    private String numberHouse;

    /*@Column(name = "city")*/
    private String city;

   /* @Column(name = "index")*/
    private int index;

   /* @Column(name = "active")*/
    @JsonIgnore
    private boolean active;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String street, String numberHouse, String city, int index, boolean active) {
        this.id = id;
        this.street = street;
        this.numberHouse = numberHouse;
        this.city = city;
        this.index = index;
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("Address: id - %d, street - %s, numberHouse - %s, city - %s, index - %d",
                id, street, numberHouse, city, index);
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
}
