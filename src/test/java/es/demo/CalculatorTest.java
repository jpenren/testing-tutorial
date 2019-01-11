package es.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    
    Calculator calculator = new Calculator();
    
    @Test
    public void shouldAdd() {
        // given
        int first = 2;
        int second = 2;
        
        // when
        int actual = calculator.add(first, second);
        
        // then
        int expected = 4;
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldSubtract() {
        // given
        int first = 4;
        int second = 2;
        
        // when
        int actual = calculator.subtract(first, second);
        
        // then
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiply() {
        // given
        int first = 2;
        int second = 2;
        
        // when
        int actual = calculator.multiply(first, second);
        
        // then
        int expected = 4;
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldDivide() {
        // given
        int first = 2;
        int second = 2;
        
        // when
        int actual = calculator.divide(first, second);
        
        // then
        int expected = 1;
        assertEquals(expected, actual);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void divideByZeroShouldFail() {
        //given
        int first = 4;
        int second = 0;
        
        //when
        calculator.divide(first, second);
        
        //then
        fail("Se esperaba una excepción");
    }

}
