package com.metaenlace.dmj619.MedicalAppointments.Models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "DIAGNOSIS")
public class Diagnosis  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4469921529377397450L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "specialist_assessment")
	private String specialistAssessment;
	@Column(name = "disease")
	private String disease;
	
	public Diagnosis() {
	}
	public Diagnosis(String specialistAssessment, String disease) {
		this.specialistAssessment = specialistAssessment;
		this.disease = disease;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSpecialistAssessment() {
		return specialistAssessment;
	}
	public void setSpecialistAssessment(String specialistAssessment) {
		this.specialistAssessment = specialistAssessment;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	@Override
	public String toString() {
		return "Diagnosis [id=" + id + ", specialistAssessment=" + specialistAssessment + ", disease=" + disease + "]";
	}
	
}
