package com.example.bookappauthorization.Types.Implementation;

import com.example.bookappauthorization.Types.Implementation.Interface.AddressInterface;

import java.io.Serializable;
import java.util.Objects;

public class AddressImpl implements AddressInterface, Serializable {

    public AddressImpl() {
    }

    @Override
    public String getAddressLine1() {
        return addressLine1;
    }

    @Override
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Override
    public String getAddressLine2() {
        return addressLine2;
    }

    @Override
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int getZipCode() {
        return zipCode;
    }

    @Override
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressImpl)) return false;
        AddressImpl address = (AddressImpl) o;
        return getZipCode() == address.getZipCode() && Objects.equals(getAddressLine1(), address.getAddressLine1()) && Objects.equals(getAddressLine2(), address.getAddressLine2()) && Objects.equals(getCountry(), address.getCountry()) && Objects.equals(getCity(), address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressLine1(), getAddressLine2(), getCountry(), getCity(), getZipCode());
    }

    @Override
    public String toString() {
        return "AddressImpl{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    private String addressLine1;
    private String addressLine2;
    private String country;
    private String city;
    private int zipCode;
}
