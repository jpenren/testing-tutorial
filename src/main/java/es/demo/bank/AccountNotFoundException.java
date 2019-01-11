package es.demo.bank;

public class AccountNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AccountNotFoundException(String account) {
        super("Account '"+account+"' not found");
    }

}
