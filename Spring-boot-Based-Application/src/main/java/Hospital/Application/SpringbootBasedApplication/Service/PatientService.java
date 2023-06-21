package Hospital.Application.SpringbootBasedApplication.Service;

import Hospital.Application.SpringbootBasedApplication.Entity.Patient;
import Hospital.Application.SpringbootBasedApplication.Entity.Status;
import Hospital.Application.SpringbootBasedApplication.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> ListOfAllAdmittedPatients(){
        List<Patient> admittedPatients=new ArrayList<Patient>();
        List<Patient> allPatients=patientRepository.findAll();
        for(Patient admitted:allPatients)
        {
            if(admitted.getStatus()== Status.ADMITTED)
            {
                admittedPatients.add(admitted);
            }

        }
        return admittedPatients;

    }

    public List<Patient> ListOfAllDischargedPatients(){
        List<Patient> dischargedPatients=new ArrayList<Patient>();
        List<Patient> allPatients=patientRepository.findAll();
        for(Patient admitted:allPatients)
        {
            if(admitted.getStatus()== Status.DISCHARGED)
            {
                dischargedPatients.add(admitted);
            }

        }
        return dischargedPatients;

    }
}

