package prj.movie.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address")
public class Address
{
    @Id
    @Column(name = "userid")
    private String userid;

    @Column(name = "name")
    String name;

    @Column(name = "country")
    String country;

    @Column(name = "area")
    String area;

    @Column(name = "city")
    String city;

    @Column(name = "street")
    String street;

    @Column(name = "number")
    String number;

    @ManyToOne
    @JoinColumn(name = "contact")
    private Contact contact;

    public Address() {
    }

    public Address(String userid, String name, String country, String area, String city, String street, String number, Contact contact) {
        this.userid = userid;
        this.name = name;
        this.country = country;
        this.area = area;
        this.city = city;
        this.street = street;
        this.number = number;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", contact=" + contact +
                '}';
    }
}
