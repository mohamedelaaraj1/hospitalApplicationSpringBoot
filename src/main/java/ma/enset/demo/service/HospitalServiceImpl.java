package ma.enset.demo.service;

import jakarta.transaction.Transactional;
import ma.enset.demo.entities.Appointment;
import ma.enset.demo.entities.Consultation;
import ma.enset.demo.entities.Doctor;
import ma.enset.demo.entities.Patient;
import ma.enset.demo.repositories.AppointmentRepo;
import ma.enset.demo.repositories.ConsultationRepo;
import ma.enset.demo.repositories.DoctorRepo;
import ma.enset.demo.repositories.PatientRepo;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepo patientRepo;
    private DoctorRepo doctorRepo;
    private AppointmentRepo appointmentRepo;
    private ConsultationRepo consultationRepo;

    public HospitalServiceImpl(PatientRepo patientRepo, DoctorRepo doctorRepo, AppointmentRepo appointmentRepo, ConsultationRepo consultationRepo) {
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
        this.appointmentRepo = appointmentRepo;
        this.consultationRepo = consultationRepo;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {

        return doctorRepo.save(doctor);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {

        return appointmentRepo.save(appointment);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepo.save(consultation);
    }
}
