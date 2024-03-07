package ma.enset.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private boolean disease;
    private Integer score;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<Appointment> appointment;
}
