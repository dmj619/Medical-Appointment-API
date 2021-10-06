package com.metaenlace.dmj619.MedicalAppointments.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "DOCTOR")
//@PrimaryKeyJoinColumn(referencedColumnName ="user")
public class Doctor extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID =  5455952587147449197L;

	@Column(name = "num_colegiado")
	private String NumColegiado;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "doctor_patient",
		joinColumns = @JoinColumn(name = "doctor"),
		inverseJoinColumns = @JoinColumn(name = "patient"))
	private List<Patient> patients;
	
	public Doctor() {
		super();
		patients = new ArrayList<Patient>();
	}

	public Doctor(String nameUser, String firstName, String lastName, String password, String numColegiado, List<Patient> patients) {
		super(nameUser, firstName, lastName, password);
		this.patients = patients;
	}
	
	public boolean addPatientToADoctor(Patient p) {
		if (!patients.contains(p)) return patients.add(p);
		return false;	
	}

	public String getNumColegiado() {
		return NumColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		NumColegiado = numColegiado;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [NumColegiado=" + NumColegiado + ", patients=" + patients + "]";
	}
	
}
