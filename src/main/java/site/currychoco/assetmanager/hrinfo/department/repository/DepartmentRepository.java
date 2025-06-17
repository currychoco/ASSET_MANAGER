package site.currychoco.assetmanager.hrinfo.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.hrinfo.department.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
