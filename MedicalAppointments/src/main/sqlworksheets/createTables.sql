CREATE TABLE USUARIO( 
    id					    NUMBER(20)      NOT NULL,
    password				VARCHAR2(20)    NOT NULL, 
    first_name				VARCHAR2(30)    NOT NULL, 
    last_name				VARCHAR2(50)    NOT NULL, 
    name_user				VARCHAR2(20)    NOT NULL, 
    CONSTRAINT  user_pk	    PRIMARY KEY(id) 
);

CREATE TABLE SYSTEM.PATIENT(
    id					    NUMBER(20)      NOT NULL,
    nss					    VARCHAR2(11)    NOT NULL,
    card_number				VARCHAR2(30)    NOT NULL,
    telephone				VARCHAR2(9)     NOT NULL,
    direction				VARCHAR2(100)   NOT NULL,
    CONSTRAINT patient_pk          	PRIMARY KEY(id),
    CONSTRAINT patient_user_fk       	FOREIGN KEY(id)             REFERENCES USUARIO(id)  ON DELETE CASCADE
);

CREATE TABLE SYSTEM.DOCTOR(
    id              NUMBER(20)      NOT NULL,
    num_colegiado   VARCHAR2(9)     NOT NULL,
    CONSTRAINT doctor_pk            PRIMARY KEY(id),
    CONSTRAINT doctor_user_fk       FOREIGN KEY(id)             REFERENCES USUARIO(id)  ON DELETE CASCADE
);

CREATE TABLE SYSTEM.DOCTOR_PATIENT(
    doctor 		NUMBER(20)      NOT NULL,
    patient		NUMBER(20)      NOT NULL,
    CONSTRAINT doctor_patient_pk           	PRIMARY KEY(doctor, patient),
    CONSTRAINT doctor_patient_fk_doctor       	FOREIGN KEY(doctor)         REFERENCES DOCTOR(id)   ON DELETE CASCADE,
    CONSTRAINT doctor_patient_fk_patient      	FOREIGN KEY(patient)       REFERENCES PATIENT(id) ON DELETE CASCADE
);

CREATE TABLE SYSTEM.DIAGNOSIS(
    id				NUMBER(20)      NOT NULL,
    specialist_assessment	VARCHAR2(200)   NOT NULL,
    disease			VARCHAR2(50)    NOT NULL,
    CONSTRAINT diagnosis_pk              PRIMARY KEY(id)
);

CREATE TABLE SYSTEM.APPOINTMENT(
    id				NUMBER(20)      NOT NULL,
    date_appointment		TIMESTAMP(2)    NOT NULL,
    motive_appointment		VARCHAR2(500)   NOT NULL,
    doctor			NUMBER(20)      NOT NULL,
    patient			NUMBER(20)      NOT NULL,
    diagnosis			NUMBER(20)      ,
    CONSTRAINT appointment_pk              PRIMARY KEY(id),
    CONSTRAINT appointment_doctor_fk       FOREIGN KEY(doctor)         REFERENCES DOCTOR(id)   ON DELETE CASCADE,
    CONSTRAINT appointment_patient_fk      FOREIGN KEY(patient)       REFERENCES PATIENT(id) ON DELETE CASCADE,
    CONSTRAINT appointment_diagnosis_fk    FOREIGN KEY(diagnosis)    REFERENCES DIAGNOSIS(id)
);