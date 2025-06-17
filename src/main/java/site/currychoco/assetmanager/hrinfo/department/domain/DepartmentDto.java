package site.currychoco.assetmanager.hrinfo.department.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class DepartmentDto {

    private String deptCode;
    private String upperDeptCode;
    private Long headEmpNo;
    private String deptName;
    private String deptNameEn;
    private int deptLevel;

    public static DepartmentDto fromEntity(Department dept){
        if(dept == null){
            return null;
        }
        return new DepartmentDto(
                dept.getDeptCode(),
                dept.getUpperDeptCode(),
                dept.getHeadEmpNo(),
                dept.getDeptName(),
                dept.getDeptNameEn(),
                dept.getDeptLevel()
        );
    }
}
