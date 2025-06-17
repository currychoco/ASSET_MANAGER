package site.currychoco.assetmanager.hrinfo.account.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import site.currychoco.assetmanager.hrinfo.account.domain.Account;
import site.currychoco.assetmanager.hrinfo.account.domain.AccountDto;
import site.currychoco.assetmanager.hrinfo.account.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountDto login(String id, String password) {
        final String hexedPassword = DigestUtils.sha256Hex(password);
        Account selectedAcc = accountRepository.findAccountByIdAndPassword(id, hexedPassword);
        if(selectedAcc == null){
            return null;
        } else{
            AccountDto accDto = AccountDto.fromEntity(selectedAcc);
            return accDto;
        }
    }
}
