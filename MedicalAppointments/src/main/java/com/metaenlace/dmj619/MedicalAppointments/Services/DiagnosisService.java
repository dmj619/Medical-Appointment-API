package com.metaenlace.dmj619.MedicalAppointments.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaenlace.dmj619.MedicalAppointments.Models.Diagnosis;
import com.metaenlace.dmj619.MedicalAppointments.Repositories.DiagnosisRepository;

@Service
public class DiagnosisService implements IDiagnosisService {
	
	@Autowired
	private DiagnosisRepository repository;

	@Override
	public List<Diagnosis> GetAllDiagnosis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diagnosis GetDiagnosisById(Long idDiagnosis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diagnosis AddDiagnosis(Diagnosis diagnosis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diagnosis DeleteDiagnosis(Long idDiagnosis) {
		// TODO Auto-generated method stub
		return null;
	}

}
