package section36;

import section36.pojo.Account;
import section36.pojo.Checking;
import section36.pojo.Credit;
import section36.repository.AccountRepository;
import section36.service.CheckingService;
import section36.service.CreditService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static void main(String[] args) {

        AccountRepository repository = new AccountRepository();
        CheckingService checkingService = new CheckingService(repository);
        CreditService creditService = new CreditService(repository);

        // Assume these were obtained from user input.
        List<Account> accounts = Arrays.asList(
                new Checking("A1234B", new BigDecimal("500.0")),
                new Checking("E3456F", new BigDecimal("300.50")),
                new Checking("I5678J", new BigDecimal("100.25")),
                new Credit("A1534B", new BigDecimal("0.50")),
                new Credit("G4567H", new BigDecimal("200.00"))
        );

        accounts.forEach(account -> {
            if( account instanceof Checking){
                checkingService.createAccount((Checking) account);
            }
            else{
                creditService.createAccount((Credit) account);
            }

        });

        Checking checking = (Checking) repository.retrieveAccount("A1234B");
        checking.setBalance(checking.getBalance().add(new BigDecimal("1000")));
        repository.updateAccount(checking);
        repository.deleteAccount("G4567H");

        CreditService creditService1 = new CreditService(repository);
        creditService1.deposit("1", new BigDecimal("100"));
        creditService1.withdraw("1", new BigDecimal("10"));
    }
}
