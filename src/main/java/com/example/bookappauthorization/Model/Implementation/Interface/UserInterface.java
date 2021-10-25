package com.example.bookappauthorization.Model.Implementation.Interface;

import com.example.bookappauthorization.Types.Implementation.AddressImpl;
import com.example.bookappauthorization.Types.Implementation.NameImpl;

import java.sql.Timestamp;

public interface UserInterface {
    String getId();
    NameImpl getName();
    AddressImpl getAddress();
    Boolean isOnline();
    Timestamp getLastLogin();
    Timestamp getCreatedAt();
    Timestamp getUpdatedAt();

    void setName(NameImpl name);
    void setAddress(AddressImpl address);
    void setOnline(Boolean online);
    void setLastLogin(Timestamp lastLogin);
    void setCreatedAt(Timestamp createdAt);
    void setUpdatedAt(Timestamp updatedAt);
}
