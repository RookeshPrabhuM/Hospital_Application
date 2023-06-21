package Hospital.Application.SpringbootBasedApplication.Controller;

import Hospital.Application.SpringbootBasedApplication.Entity.HospitalStaff;
import Hospital.Application.SpringbootBasedApplication.Repository.HospitalStaffRepository;
import Hospital.Application.SpringbootBasedApplication.Service.HospitalStaffservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/staff")
public class HospitalStaffController {
    @Autowired
    private HospitalStaffRepository staffRepository;

    @Autowired
    private HospitalStaff hospitalStaff;

    @Autowired
    private HospitalStaffservice hospitalStaffservice;

    @GetMapping("/staff-all")
    public List<HospitalStaff> allstaff() {
        return staffRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody HospitalStaff request) {
        // Validate input
        if (request.getUsername().isEmpty() || request.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Username and password are required.");
        }

        // Check if the username is already taken
        if (hospitalStaffservice.findByUsername(request.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }

        // Create a new staff member
        HospitalStaff staff = new HospitalStaff();
        staff.setUsername(request.getUsername());
        staff.setPassword(request.getPassword());
        // Set other necessary details

        // Save the staff member
        staffRepository.save(staff);

        return ResponseEntity.ok("Staff member registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody HospitalStaff request) {
        // Retrieve the staff member by username
        HospitalStaff staff = hospitalStaffservice.findByUsername(request.getUsername());

        // Check if staff member exists and password matches
        if (staff == null || !staff.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid username or password.");
        }

        // Successful login
        return ResponseEntity.ok("Login successful.");

    }
}
