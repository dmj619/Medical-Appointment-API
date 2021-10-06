package com.metaenlace.dmj619.MedicalAppointments.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metaenlace.dmj619.MedicalAppointments.Models.*;

@Repository
public interface AppointmentRepository  extends JpaRepository<Appointment, Long>{

	List<Appointment> findByPatient(Patient patient);
	
	List<Appointment> findByDoctor(Doctor doctor);
}
