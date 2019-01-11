package es.demo.bank;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Account {

    private String number;
    private BigDecimal balance;
    
}
