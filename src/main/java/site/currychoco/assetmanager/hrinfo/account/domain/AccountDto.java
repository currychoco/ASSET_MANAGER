package site.currychoco.assetmanager.hrinfo.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AccountDto {
    private Long empNo;
    private String id;
    private String password;

    public static AccountDto fromEntity(Account acc){
        if(acc == null){
            return null;
        }
        return new AccountDto(
                acc.getEmpNo(),
                acc.getId(),
                acc.getPassword()
        );
    }
}
