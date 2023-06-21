package Hospital.Application.SpringbootBasedApplication.Repository;

import Hospital.Application.SpringbootBasedApplication.Entity.HospitalStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff,Long> {
}
