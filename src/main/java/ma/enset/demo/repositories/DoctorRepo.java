package ma.enset.demo.repositories;

import ma.enset.demo.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Doctor findByName(String name);

}
