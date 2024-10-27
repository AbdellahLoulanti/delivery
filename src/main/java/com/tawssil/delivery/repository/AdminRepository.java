package com.tawssil.delivery.repository;

import com.tawssil.delivery.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
