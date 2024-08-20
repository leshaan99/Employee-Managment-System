package Employee.Managment.System.backend.service;

import Employee.Managment.System.backend.dto.EmployeeDTO;
import Employee.Managment.System.backend.entity.Employee;
import Employee.Managment.System.backend.repository.EmployeeRepo;
import Employee.Managment.System.backend.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO){

        if(employeeRepo.existsById(employeeDTO.getEmpId())){
            return VarList.RSP_DUPLICATED;
        }else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
