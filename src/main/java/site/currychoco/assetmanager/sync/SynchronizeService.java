package site.currychoco.assetmanager.sync;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import site.currychoco.assetmanager.department.domain.Department;
import site.currychoco.assetmanager.department.domain.DepartmentDto;
import site.currychoco.assetmanager.department.repository.DepartmentRepository;
import site.currychoco.assetmanager.employee.domain.Employee;
import site.currychoco.assetmanager.employee.domain.EmployeeDto;
import site.currychoco.assetmanager.employee.repository.EmployeeRepository;
import site.currychoco.assetmanager.job.domain.Job;
import site.currychoco.assetmanager.job.domain.JobDto;
import site.currychoco.assetmanager.job.repository.JobRepository;
import site.currychoco.assetmanager.position.domain.Position;
import site.currychoco.assetmanager.position.domain.PositionDto;
import site.currychoco.assetmanager.position.repository.PositionRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SynchronizeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final JobRepository jobRepository;
    private final PositionRepository positionRepository;

    @Value("${hr-manager.url}")
    private String hrManagerUrl;

    @Value("${hr-manager.key}")
    private String hrManagerKey;

    @Scheduled(cron = "0 0 0/1 1/1 * ?")
    private void synchronizeHR(){
        deleteAllDepartment();
        deleteAllJob();
        deleteAllPosition();
        deleteAllEmployee();

        getAllDepartment();
        getAllJob();
        getAllPosition();
        getAllEmployee();

        System.out.println("동기화 완료");
    }

    private void getAllDepartment(){
        final String url = hrManagerUrl + "/external-api/department";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", hrManagerKey);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List<DepartmentDto>> response = new RestTemplate().exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<>() {}
        );

        for(DepartmentDto dept : response.getBody()){
            Department department = new Department(dept);
            departmentRepository.save(department);
        }
    }

    private void getAllJob(){
        final String url = hrManagerUrl + "/external-api/job";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", hrManagerKey);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List<JobDto>> response = new RestTemplate().exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<>() {}
        );

        for(JobDto jobDto : response.getBody()){
            Job job = new Job(jobDto);
            jobRepository.save(job);
        }

    }

    private void getAllPosition(){
        final String url = hrManagerUrl + "/external-api/position";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", hrManagerKey);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List<PositionDto>> response = new RestTemplate().exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<>() {}
        );

        for(PositionDto positionDto : response.getBody()){
            Position position = new Position(positionDto);
            positionRepository.save(position);
        }
    }

    private void getAllEmployee(){
        final String url = hrManagerUrl + "/external-api/employee";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", hrManagerKey);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List<EmployeeDto>> response = new RestTemplate().exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<>() {}
        );

        for(EmployeeDto empDto : response.getBody()){
            Employee emp = new Employee(empDto);
            employeeRepository.save(emp);
        }
    }

    private void deleteAllDepartment(){
        departmentRepository.deleteAll();
    }

    private void deleteAllJob(){
        jobRepository.deleteAll();
    }

    private void deleteAllPosition(){
        positionRepository.deleteAll();
    }

    private void deleteAllEmployee(){
        employeeRepository.deleteAll();
    }

}
