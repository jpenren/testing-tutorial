package es.demo.bank;

import java.math.BigDecimal;

public interface BankService {

    Account getAccount(String number);
    
    void transfer(String source, String destination, BigDecimal amount);
    
}
