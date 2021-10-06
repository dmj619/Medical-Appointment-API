package com.metaenlace.dmj619.MedicalAppointments.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaenlace.dmj619.MedicalAppointments.Models.Diagnosis;
import com.metaenlace.dmj619.MedicalAppointments.Services.IDiagnosisService;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {
	
	@Autowired
	private IDiagnosisService service;
	
	@GetMapping
	public ResponseEntity<?> GetPatients(){
		List<Diagnosis> diagnosis = service.GetAllDiagnosis();
		
		if(diagnosis!=null)
			return ResponseEntity.ok(diagnosis);
		else
			return new ResponseEntity<Object>("Ha habido un problema", HttpStatus.BAD_REQUEST);
	}

}
