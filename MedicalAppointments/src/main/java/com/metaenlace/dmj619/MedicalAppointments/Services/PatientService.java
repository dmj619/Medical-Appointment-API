package com.metaenlace.dmj619.MedicalAppointments.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaenlace.dmj619.MedicalAppointments.Models.Doctor;
import com.metaenlace.dmj619.MedicalAppointments.Models.Patient;
import com.metaenlace.dmj619.MedicalAppointments.Repositories.PatientRepository;

@Service
public class PatientService implements IPatientService{
	
	@Autowired
	private PatientRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Patient> GetAllPatients() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Patient GetPatientById(Long id) {
		Optional<Patient> pac = repository.findById(id);
		if(pac.isPresent())return pac.get();
		return null;
	}

	@Override
	@Transactional
	public boolean AddPatient(Patient patient) {
		//if(repository.findByUser(patient.getNameUser()) != null) return false;
		repository.save(patient);
		return true;
	}

	@Override
	@Transactional
	public boolean AddDoctor(long idPatient, Long idDoctor) {
		Patient patient = this.GetPatientById(idPatient);
		if(patient == null) return false;
		
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Doctor> GetDoctors(Long idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean DeletePatient(Long idPatient) {
		repository.deleteById(idPatient);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean Login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
