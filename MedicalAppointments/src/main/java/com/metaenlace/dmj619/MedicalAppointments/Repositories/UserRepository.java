package com.metaenlace.dmj619.MedicalAppointments.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metaenlace.dmj619.MedicalAppointments.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
