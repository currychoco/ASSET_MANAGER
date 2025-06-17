package site.currychoco.assetmanager.hrinfo.job.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class JobDto {

    private String jobCode;
    private String jobName;
    private String jobNameEn;
    private int jobLevel;

    public static JobDto fromEntity(Job job){
        if(job == null){
            return null;
        }
        return new JobDto(
                job.getJobCode(),
                job.getJobName(),
                job.getJobNameEn(),
                job.getJobLevel()
        );
    }
}
