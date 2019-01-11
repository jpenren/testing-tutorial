package es.demo.bank;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {

    private final AccountRepository accountRepository;

    public BankServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccount(String number) {
        return accountRepository.find(number);
    }

    @Override
    public void transfer(String source, String destination, BigDecimal amount) {
        Account sourceAccount = accountRepository.find(source);
        if(sourceAccount==null) {
            throw new AccountNotFoundException(source);
        }
        
        checkBalance(sourceAccount, amount);

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        accountRepository.save(sourceAccount);
        
        Account destinationAccount = accountRepository.find(destination);
        if(destinationAccount==null) {
            throw new AccountNotFoundException(destination);
        }
        destinationAccount.setBalance(destinationAccount.getBalance().add(amount));
        accountRepository.save(destinationAccount);
    }

    private void checkBalance(Account sourceAccount, BigDecimal amount) {
        BigDecimal sourceAccountBalance = sourceAccount.getBalance();
        if (amount.compareTo(sourceAccountBalance) > 0) {
            throw new IllegalArgumentException("Amount > account balance");
        }
    }

    
}
