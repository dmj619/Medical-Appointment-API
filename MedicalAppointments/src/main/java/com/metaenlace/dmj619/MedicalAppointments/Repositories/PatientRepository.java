package com.metaenlace.dmj619.MedicalAppointments.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metaenlace.dmj619.MedicalAppointments.Models.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	//public Patient findByUser(String user);
}
