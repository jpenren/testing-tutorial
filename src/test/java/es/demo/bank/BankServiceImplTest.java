package es.demo.bank;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BankServiceImplTest {
    
    private AccountRepository accountRepository = mock(AccountRepository.class);
    private BankService service = new BankServiceImpl(accountRepository);

    @Test
    public void shouldGetAccount() {
        // given
        String number = "1234";
        Account expected = new Account();
        expected.setNumber(number);
        given(accountRepository.find(number)).willReturn(expected);
        
        // when
        Account actual = service.getAccount(number);
        
        // then
        assertEquals(expected, actual);
    }
    
    @Test
    public void shoudTransferAmount() {
        // given
        Account sourceAccount = new Account();
        sourceAccount.setNumber("1");
        sourceAccount.setBalance(BigDecimal.valueOf(100));
        given(accountRepository.find("1")).willReturn(sourceAccount);
        
        Account dAccount = new Account();
        dAccount.setNumber("2");
        dAccount.setBalance(BigDecimal.valueOf(100));
        given(accountRepository.find("2")).willReturn(dAccount);
        
        // when
        service.transfer("1", "2", BigDecimal.valueOf(50));
        
        // then
        then(accountRepository).should(times(1)).save(sourceAccount);
        then(accountRepository).should(times(1)).save(dAccount);
        
        BigDecimal expected = BigDecimal.valueOf(50);
        BigDecimal sourceAccountBalance = service.getAccount("1").getBalance();
        assertEquals(expected, sourceAccountBalance);
        BigDecimal dAccountBalance = service.getAccount("1").getBalance();
        assertEquals(expected, dAccountBalance);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldFailWithoutBalance() {
        // given
        Account sourceAccount = new Account();
        sourceAccount.setNumber("1");
        sourceAccount.setBalance(BigDecimal.ZERO);
        given(accountRepository.find("1")).willReturn(sourceAccount);
        
        // when
        service.transfer("1", "2", BigDecimal.valueOf(50));
        
        // then
        fail("Se esperaba ex");
    }
    
    @Test(expected=AccountNotFoundException.class)
    public void shouldFailSourceAccountNotExists() {
        // given
        Account account = new Account();
        given(accountRepository.find("2")).willReturn(account);
        
        // when
        service.transfer("0", "2", BigDecimal.valueOf(1));
        
        // then
        fail("Se esperaba ex");
    }
    
    @Test(expected=AccountNotFoundException.class)
    public void shouldFailDestinationAccountNotExists() {
        // given
        Account account = new Account();
        account.setBalance(BigDecimal.ZERO);
        given(accountRepository.find("1")).willReturn(account);
        
        // when
        service.transfer("1", "0", BigDecimal.ZERO);
        
        // then
        fail("Se esperaba ex");
    }

}
