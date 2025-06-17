package site.currychoco.assetmanager.hrinfo.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Employee {
    @Id
    @Column(name = "emp_no")
    private Long empNo;
    @Column(name = "dept_code")
    private String deptCode;
    @Column(name = "job_code")
    private String jobCode;
    @Column(name = "position_code")
    private String positionCode;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_name_en")
    private String empNameEn;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "start_date")
    private Timestamp startDate;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "zip_code")
    private String zipCode;

    public Employee(EmployeeDto dto) {
        this.empNo = dto.getEmpNo();
        this.deptCode = dto.getDeptCode();
        this.jobCode = dto.getJobCode();
        this.positionCode = dto.getPositionCode();
        this.empName = dto.getEmpName();
        this.empNameEn = dto.getEmpNameEn();
        this.gender = dto.getGender();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.startDate = new Timestamp(new Date().getTime());
        this.address1 = dto.getAddress1();
        this.address2 = dto.getAddress2();
        this.zipCode = dto.getZipCode();
    }
}
