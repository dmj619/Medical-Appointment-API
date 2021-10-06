package com.metaenlace.dmj619.MedicalAppointments.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaenlace.dmj619.MedicalAppointments.Models.Appointment;
import com.metaenlace.dmj619.MedicalAppointments.Services.IAppointmentService;
import com.metaenlace.dmj619.MedicalAppointments.Services.IDoctorService;
import com.metaenlace.dmj619.MedicalAppointments.Services.IPatientService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private IAppointmentService service;
	
	/**@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPatientService patientService;*/
	
	@GetMapping
	public ResponseEntity<?> GetPatients(){
		List<Appointment> appointments = service.GetAllAppointments();
		
		if(appointments!=null)
			return ResponseEntity.ok(appointments);
		else
			return new ResponseEntity<Object>("Ha habido un problema", HttpStatus.BAD_REQUEST);
	}
	
}