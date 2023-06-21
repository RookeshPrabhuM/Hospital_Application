package Hospital.Application.SpringbootBasedApplication.Service;

import Hospital.Application.SpringbootBasedApplication.Entity.HospitalStaff;
import Hospital.Application.SpringbootBasedApplication.Exception.ResourcenotFoundException;
import Hospital.Application.SpringbootBasedApplication.Repository.HospitalStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalStaffservice {


    @Autowired
    private HospitalStaffRepository staffRepository;

    public HospitalStaff findByUsername(String name){
        HospitalStaff result=null;
        List<HospitalStaff> allStaff=staffRepository.findAll();
        for(HospitalStaff required:allStaff)
        {
            if(required.getUsername()==name)
            {
                result=required;
            }
            else{
                throw new ResourcenotFoundException("Username not found");
            }
        }
        return result;
    }

}
