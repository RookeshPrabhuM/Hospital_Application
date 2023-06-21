package Hospital.Application.SpringbootBasedApplication.Controller;

import Hospital.Application.SpringbootBasedApplication.Entity.Patient;
import Hospital.Application.SpringbootBasedApplication.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hospital/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> allpatient(){
        return patientRepository.findAll();
    }
    @PostMapping
    public Patient AdmitPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

}
