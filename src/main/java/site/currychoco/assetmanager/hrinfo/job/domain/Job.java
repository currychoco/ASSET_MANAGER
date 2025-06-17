package site.currychoco.assetmanager.hrinfo.job.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
@NoArgsConstructor
@Getter
@ToString
public class Job {
    @Id
    @Column(name = "job_code")
    private String jobCode;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_name_en")
    private String jobNameEn;
    @Column(name = "job_level")
    private int jobLevel;

    public Job(JobDto jobDto){
        this.jobCode = jobDto.getJobCode();
        this.jobName = jobDto.getJobName();
        this.jobNameEn = jobDto.getJobNameEn();
        this.jobLevel = jobDto.getJobLevel();
    }

}
