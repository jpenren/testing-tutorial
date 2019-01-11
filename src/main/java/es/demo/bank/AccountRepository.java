package es.demo.bank;

public interface AccountRepository {
    
    Account find(String accountNumber);
    
    void save(Account account);

}
