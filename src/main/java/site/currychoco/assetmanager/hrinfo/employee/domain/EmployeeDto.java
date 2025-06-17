package site.currychoco.assetmanager.hrinfo.employee.domain;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {

    private Long empNo;
    private String deptCode;
    private String jobCode;
    private String positionCode;
    private String empName;
    private String empNameEn;
    private String gender;
    private String email;
    private String phone;
    private Timestamp startDate;
    private String address1;
    private String address2;
    private String zipCode;

    public static EmployeeDto fromEntity(Employee emp){
        if(emp == null){
            return null;
        }
        return new EmployeeDto(
                emp.getEmpNo(),
                emp.getDeptCode(),
                emp.getJobCode(),
                emp.getPositionCode(),
                emp.getEmpName(),
                emp.getEmpNameEn(),
                emp.getGender(),
                emp.getEmail(),
                emp.getPhone(),
                emp.getStartDate(),
                emp.getAddress1(),
                emp.getAddress2(),
                emp.getZipCode()
        );
    }
}
