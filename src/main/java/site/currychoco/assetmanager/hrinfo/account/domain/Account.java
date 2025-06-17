package site.currychoco.assetmanager.hrinfo.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.codec.digest.DigestUtils;
import site.currychoco.assetmanager.hrinfo.department.domain.DepartmentDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Account {
    @Id
    @Column(name = "emp_no")
    private Long empNo;
    @Column(name = "id")
    private String id;
    @Column(name = "password")
    private String password;

    public Account(AccountDto dto){
        this.empNo = dto.getEmpNo();
        this.id = dto.getId();
        this.password = dto.getPassword();
    }
}