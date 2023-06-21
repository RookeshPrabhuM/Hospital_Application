package Hospital.Application.SpringbootBasedApplication.Repository;

import Hospital.Application.SpringbootBasedApplication.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
