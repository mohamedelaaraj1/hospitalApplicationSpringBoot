package ma.enset.demo.repositories;

import ma.enset.demo.entities.Appointment;
import ma.enset.demo.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
