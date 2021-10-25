package com.example.bookappauthorization.Repositories;

import com.example.bookappauthorization.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
