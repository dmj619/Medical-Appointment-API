package com.metaenlace.dmj619.MedicalAppointments.Services;

import java.util.List;

import com.metaenlace.dmj619.MedicalAppointments.Models.Doctor;
import com.metaenlace.dmj619.MedicalAppointments.Models.Patient;

public interface IPatientService {
	public List<Patient> GetAllPatients();

    public Patient GetPatientById(Long id);

    public boolean AddPatient(Patient patient);

    public boolean AddDoctor(long idPatient, Long idDoctor);

    public List<Doctor> GetDoctors(Long idPaciente);

    //public List<Doctor> GetMedicosNot(Long idPaciente);

    public boolean DeletePatient(Long idPatient);

    public boolean Login(String username, String password);
}
