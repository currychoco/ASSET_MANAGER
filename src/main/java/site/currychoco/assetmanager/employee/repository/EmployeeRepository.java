package site.currychoco.assetmanager.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.employee.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
