package Hospital.Application.SpringbootBasedApplication;

import Hospital.Application.SpringbootBasedApplication.Entity.HospitalStaff;
import Hospital.Application.SpringbootBasedApplication.Repository.HospitalStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBasedApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootBasedApplication.class, args);
//		System.out.println("Hi");
	}
    @Autowired
	private HospitalStaffRepository staffRepository;


	@Override
	public void run(String... args) throws Exception {
		HospitalStaff staff=new HospitalStaff();
		staff.setUsername("us1");
		staff.setPassword("us12345");
		staffRepository.save(staff);
		HospitalStaff staff1=new HospitalStaff();
		staff.setUsername("us2");
		staff.setPassword("us23456");
		staffRepository.save(staff1);
	}
}
