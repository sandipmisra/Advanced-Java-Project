package dev.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /*@Length(min = 5, message = "You have a problem in your fullname")*/
    @NotNull(message = "Must not be Empty")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Must not be Empty")
    @Column(name = "price")
    private String price;

    @NotNull(message = "Must not be Empty")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Must not be Empty")
    @Column(name = "location")
    private String location;

    @NotNull(message = "Must not be Empty")
    @Column(name = "appartment")
    private String appartment;

    @NotNull(message = "Must not be Empty")
    @Column(name = "mobile")
    private String mobile;

    public Rent() {
    }

    public Rent(int id, String name, String price, String email, String location, String appartment, String mobile) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.email = email;
        this.location = location;
        this.appartment = appartment;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", appartment='" + appartment + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
