package com.cric.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cric.entity.RegisterAcademy;

public interface AcadmyRegister extends JpaRepository<RegisterAcademy, Integer> {

}
