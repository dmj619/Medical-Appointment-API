package com.metaenlace.dmj619.MedicalAppointments.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8756947843079322798L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "date_appointment")
    private Date dateAppointment;

	@Column(name = "motive_appointment")
    private String motiveAppointment;

	@OneToOne
	@JoinColumn(name = "doctor")
    private Doctor doctor;

	@OneToOne
	@JoinColumn(name = "patient")
    private Patient patient;
	
	@OneToOne
	@JoinColumn(name = "diagnosis")
    private Diagnosis diagnosis;

	public Appointment(){}

	public Appointment(Date dateAppointment, String motiveAppointment, Diagnosis diagnosis, Doctor doctor,
			Patient patient) {
		super();
		this.dateAppointment = dateAppointment;
		this.motiveAppointment = motiveAppointment;
		this.diagnosis = diagnosis;
		this.doctor = doctor;
		this.patient = patient;
	}
	
	public boolean isToday(Date date) {
		return date.equals(new Date());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateAppointment() {
		return dateAppointment;
	}

	public void setDateAppointment(Date dateAppointment) {
		this.dateAppointment = dateAppointment;
	}

	public String getMotiveAppointment() {
		return motiveAppointment;
	}

	public void setMotiveAppointment(String motiveAppointment) {
		this.motiveAppointment = motiveAppointment;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", dateAppointment=" + dateAppointment + ", motiveAppointment="
				+ motiveAppointment + ", diagnosis=" + diagnosis + ", doctor=" + doctor + ", patient=" + patient + "]";
	}
	
}
