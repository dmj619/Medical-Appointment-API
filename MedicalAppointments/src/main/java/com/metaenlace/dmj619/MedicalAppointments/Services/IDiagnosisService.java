package com.metaenlace.dmj619.MedicalAppointments.Services;

import java.util.List;

import com.metaenlace.dmj619.MedicalAppointments.Models.Diagnosis;

public interface IDiagnosisService {

	public List<Diagnosis> GetAllDiagnosis();

    public Diagnosis GetDiagnosisById(Long idDiagnosis);

    public Diagnosis AddDiagnosis(Diagnosis diagnosis);

    public Diagnosis DeleteDiagnosis(Long idDiagnosis);
}
