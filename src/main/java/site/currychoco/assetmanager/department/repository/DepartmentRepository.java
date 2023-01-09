package site.currychoco.assetmanager.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.department.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
