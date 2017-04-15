package entity;

import javax.persistence.*;

/**
 * Created by user on 4/8/2017.
 */
@Entity
@Table(name="ADDRESS")
public class Address {

    /**
     * Generate primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "COUNTRY", length = 20)
    private String country;

    @Column(name = "CITY", length = 20)
    private String city;

    @Column(name = "STREET", length = 20)
    private String street;

    @Column(name = "POST_CODE", length = 10)
    private String postcode;

    public Address() {
    }

    /**
     * If in project use more than two parameters,
     * smart mans recommended write "get" and "set" methods
     */

    public long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter for property 'country'.
     *
     * @return Value for property 'country'.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for property 'country'.
     *
     * @param country Value to set for property 'country'.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter for property 'city'.
     *
     * @return Value for property 'city'.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for property 'city'.
     *
     * @param city Value to set for property 'city'.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for property 'street'.
     *
     * @return Value for property 'street'.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for property 'street'.
     *
     * @param street Value to set for property 'street'.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for property 'postcode'.
     *
     * @return Value for property 'postcode'.
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Setter for property 'postcode'.
     *
     * @param postcode Value to set for property 'postcode'.
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
