package site.currychoco.assetmanager.hrinfo.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.hrinfo.employee.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
