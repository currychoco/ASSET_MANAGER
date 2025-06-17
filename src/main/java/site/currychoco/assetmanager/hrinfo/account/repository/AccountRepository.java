package site.currychoco.assetmanager.hrinfo.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.hrinfo.account.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByIdAndPassword(String id, String password);
}
