package com.metaenlace.dmj619.MedicalAppointments.Services;

import java.util.List;

import com.metaenlace.dmj619.MedicalAppointments.Models.Doctor;
import com.metaenlace.dmj619.MedicalAppointments.Models.Patient;

public interface IDoctorService {

	public List<Doctor> GetAllDoctor();

    public Doctor GetDoctorById(Long idDoctor);

    public List<Patient> GetPatients(Long idDoctor);

    public Doctor AddDoctor(Doctor doctor);

    public Doctor Login(String username, String password);

    public Doctor DeleteDoctor(Long idDoctor);
}
