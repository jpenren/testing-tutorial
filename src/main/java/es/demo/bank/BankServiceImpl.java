package es.demo.bank;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {

    private final AccountRepository accountRepository;

    public BankServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccount(String number) {
        return null;
    }

    @Override
    public void transfer(String source, String destination, BigDecimal amount) {
        
    }
    
}
