package com.metaenlace.dmj619.MedicalAppointments.Services;

import java.util.List;
import java.util.Optional;

import com.metaenlace.dmj619.MedicalAppointments.Models.Appointment;

public interface IAppointmentService {
	
	public List<Appointment> GetAllAppointments();
	
	public Optional<Appointment> GetAppointmentById(Long id);
	
	public List<Appointment> GetAppointmentByPatient(Long idPatient);
	
	public List<Appointment> GetAppointmentByDoctor(Long idDoctor);
	
	public boolean AddAppointment(Appointment appointment, Long idDoctor, Long idPatient);
	
	public void DeleteAppointment(Long idAppointment);

}
