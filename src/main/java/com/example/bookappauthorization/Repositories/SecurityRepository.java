package com.example.bookappauthorization.Repositories;

import com.example.bookappauthorization.Model.Security;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<Security, String> {
}
