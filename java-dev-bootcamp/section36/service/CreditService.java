package section36.service;

import section36.pojo.Account;
import section36.pojo.Checking;
import section36.pojo.Credit;
import section36.repository.AccountRepository;

import java.math.BigDecimal;

public class CreditService implements AccountService {

    AccountRepository accountRepository;

    @Override
    public void deposit(String id, BigDecimal amount) {
        Credit account = (Credit) retrieveAccount(id);
        account.setCredit(account.getCredit().subtract(amount));
        updateAccount(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        Credit account = (Credit) retrieveAccount(id);
        account.setCredit(account.getCredit().add(amount));
        updateAccount(account);
    }

    public CreditService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    public void createAccount(Credit account) {
        this.accountRepository.createAccount(account);
    }

    public Account retrieveAccount(String id) {
        return this.accountRepository.retrieveAccount(id);
    }

    public void updateAccount(Credit account) {
        this.accountRepository.updateAccount(account);
    }

    public void deleteAccount(String id) {
        this.accountRepository.deleteAccount(id);
    }
}
