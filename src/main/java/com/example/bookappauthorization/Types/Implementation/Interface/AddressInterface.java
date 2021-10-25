package com.example.bookappauthorization.Types.Implementation.Interface;

public interface AddressInterface {
    String getAddressLine1();

    String getAddressLine2();

    String getCity();

    String getCountry();

    int getZipCode();

    void setAddressLine1(String addressLine1);

    void setAddressLine2(String addressLine2);

    void setCity(String city);

    void setCountry(String country);

    void setZipCode(int zipCode);
}