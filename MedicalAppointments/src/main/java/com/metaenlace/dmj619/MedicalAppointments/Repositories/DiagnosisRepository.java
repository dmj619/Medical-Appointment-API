package com.metaenlace.dmj619.MedicalAppointments.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metaenlace.dmj619.MedicalAppointments.Models.Diagnosis;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long>{

}
