package ma.enset.demo;

import ma.enset.demo.entities.*;
import ma.enset.demo.repositories.AppointmentRepo;
import ma.enset.demo.repositories.ConsultationRepo;
import ma.enset.demo.repositories.DoctorRepo;
import ma.enset.demo.repositories.PatientRepo;
import ma.enset.demo.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean //Methode qui va s'exucuter dans le démarage :
	CommandLineRunner start(IHospitalService hospitalService, PatientRepo patientRepo, DoctorRepo doctorRepo, AppointmentRepo appointmentRepo, ConsultationRepo consultationRepo)
	{
		return args -> {
			Stream.of("Mohamed","Hassan","Najat")
					.forEach(name->{
						Patient patient = new Patient();
						patient.setName(name);
						patient.setBirthDate(new Date());
						patient.setDisease(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("GHALI","OMARI","HANANE")
					.forEach(name->{
						Doctor doctor = new Doctor();
						doctor.setName(name);
						doctor.setEmail(name+"@gmail.com");
						doctor.setSpeciality(Math.random()>0.5?"Cardio":"Dentiste");
						hospitalService.saveDoctor(doctor);
					});

			Patient patient = patientRepo.findById(1L).orElse(null);
			Patient patient1=patientRepo.findByName("Mohamed");

			Doctor doctor = doctorRepo.findByName("OMARI");

			Appointment appointment = new Appointment();
			appointment.setApointementDate(new Date());
			appointment.setStatusAPP(StatusAPP.DONE);
			appointment.setPatient(patient);
			appointment.setDoctor(doctor);
			appointmentRepo.save(appointment);

			Appointment appointment1 = appointmentRepo.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setConsultationDate(new Date());
			consultation.setAppointment(appointment1);
			consultation.setRepport("Rapport de la consultation ....");
			consultationRepo.save(consultation);




		};
	}

}
