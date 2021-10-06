package com.metaenlace.dmj619.MedicalAppointments.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaenlace.dmj619.MedicalAppointments.Services.IPatientService;
import com.metaenlace.dmj619.MedicalAppointments.Models.Doctor;
import com.metaenlace.dmj619.MedicalAppointments.Models.Patient;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private IPatientService service;
	
	@GetMapping
	public ResponseEntity<?> GetPatients(){
		List<Patient> patients = service.GetAllPatients();
		
		if(patients!=null)
			return ResponseEntity.ok(patients);
		else
			return new ResponseEntity<Object>("Ha habido un problema", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> GetPacienteById(@PathVariable Long id){
		Patient patient = service.GetPatientById(id);
		
		if(patient!=null)
			return ResponseEntity.ok(patient);
		else
			return new ResponseEntity<Object>("No se ha encontrado al paciente", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/doctors/{id}")
	public ResponseEntity<?> GetMedicosByPaciente(@PathVariable Long id){
		List<Doctor>  doctors = service.GetDoctors(id);
		
		if(doctors!=null)
			return ResponseEntity.ok(doctors);
		else
			return new ResponseEntity<Object>("No se ha encontrado al medico", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping
	public ResponseEntity<?> PostPaciente(@RequestBody Patient patient){	
		if(!service.AddPatient(patient))
			return new ResponseEntity<Object>("El paciente ya existe", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<Object>("Paciente creado", HttpStatus.CREATED);
	
	}
}
