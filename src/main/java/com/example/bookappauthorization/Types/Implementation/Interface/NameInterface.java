package com.example.bookappauthorization.Types.Implementation.Interface;


public interface NameInterface {
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getShortName();
    String getFullName();

    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setMiddleName(String middleName);
    void setShortName(String shortName);
    void setFullName(String fullName);
}