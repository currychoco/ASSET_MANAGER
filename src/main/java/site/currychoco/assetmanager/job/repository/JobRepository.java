package site.currychoco.assetmanager.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.job.domain.Job;

public interface JobRepository extends JpaRepository<Job, String> {
}
