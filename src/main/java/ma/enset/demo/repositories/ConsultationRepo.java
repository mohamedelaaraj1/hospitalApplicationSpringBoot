package ma.enset.demo.repositories;

import ma.enset.demo.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
}
