package site.currychoco.assetmanager.hrinfo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.hrinfo.job.domain.Job;

public interface JobRepository extends JpaRepository<Job, String> {
}
