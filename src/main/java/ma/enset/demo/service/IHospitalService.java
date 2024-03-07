package ma.enset.demo.service;

import ma.enset.demo.entities.Appointment;
import ma.enset.demo.entities.Consultation;
import ma.enset.demo.entities.Doctor;
import ma.enset.demo.entities.Patient;

public interface IHospitalService  {
    Patient savePatient(Patient patient);
    Doctor saveDoctor(Doctor doctor);
    Appointment saveAppointment(Appointment appointment);
    Consultation saveConsultation(Consultation consultation);
}
