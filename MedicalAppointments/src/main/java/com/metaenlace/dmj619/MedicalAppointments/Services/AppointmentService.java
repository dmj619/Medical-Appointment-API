package com.metaenlace.dmj619.MedicalAppointments.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaenlace.dmj619.MedicalAppointments.Models.Appointment;
import com.metaenlace.dmj619.MedicalAppointments.Models.Doctor;
import com.metaenlace.dmj619.MedicalAppointments.Models.Patient;
import com.metaenlace.dmj619.MedicalAppointments.Repositories.AppointmentRepository;
import com.metaenlace.dmj619.MedicalAppointments.Repositories.DoctorRepository;
import com.metaenlace.dmj619.MedicalAppointments.Repositories.PatientRepository;

@Service
public class AppointmentService implements IAppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;


	@Override
	@Transactional(readOnly = true)
	public List<Appointment> GetAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Appointment> GetAppointmentById(Long id) {
		return appointmentRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Appointment> GetAppointmentByPatient(Long idPatient) {
		Optional<Patient> patient = patientRepository.findById(idPatient);
		if(!patient.isPresent()) return null;
		return appointmentRepository.findByPatient(patient.get());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Appointment> GetAppointmentByDoctor(Long idDoctor) {
		Optional<Doctor> doctor = doctorRepository.findById(idDoctor);
		if(!doctor.isPresent()) return null;
		return appointmentRepository.findByDoctor(doctor.get());
	}

	@Override
	@Transactional
	public boolean AddAppointment(Appointment appointment, Long idDoctor, Long idPatient) {
		Optional<Doctor> doctor = doctorRepository.findById(idDoctor);
		Optional<Patient> patient = patientRepository.findById(idPatient);
		
		if(!patient.isPresent() || !doctor.isPresent()) return false;
		
		if(appointmentRepository.findById(appointment.getId()).isPresent()) return false;
		
		appointmentRepository.save(appointment);
		
		return true;
	}

	@Override
	@Transactional
	public void DeleteAppointment(Long idAppointment) {
		appointmentRepository.deleteById(idAppointment);
	}

}
