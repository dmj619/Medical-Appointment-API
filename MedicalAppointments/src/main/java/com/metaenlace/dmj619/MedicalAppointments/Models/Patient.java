package com.metaenlace.dmj619.MedicalAppointments.Models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "PATIENT")
//@PrimaryKeyJoinColumn(referencedColumnName ="user")
public class Patient extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8519936834699477534L;

	@NotNull
	@Column(name = "nss")
	private String NSS;
	
	@NotNull
	@Column(name = "card_number")
	private String cardNumber;
	
	@NotNull
	@Column(name = "telephone")
	private String telephone;
	
	@NotNull
	@Column(name = "direction")
	private String direction;
	
	@ManyToMany(mappedBy = "patients", fetch = FetchType.EAGER)
	private List<Doctor> doctors;
	
	public Patient() {
		doctors  = new ArrayList<Doctor>();
	}
	
	public Patient(String nameUser, String firstName, String lastName, String password, String nSS,
			String cardNumber, String telephone, String direction) {
		super(nameUser, firstName, lastName, password);
		NSS = nSS;
		this.cardNumber = cardNumber;
		this.telephone = telephone;
		this.direction = direction;
		doctors  = new ArrayList<Doctor>();
	}
	
	public boolean addDoctorToPatient(Doctor d) {
		if (!doctors.contains(d)) return doctors.add(d);
		return false;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Patient [NSS=" + NSS + ", cardNumber=" + cardNumber + ", telephone=" + telephone + ", direction="
				+ direction + ", doctors=" + doctors + "]";
	}
}
