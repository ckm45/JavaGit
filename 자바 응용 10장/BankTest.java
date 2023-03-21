package com.ckm.ddd;

import static org.junit.Assert.*;
import org.junit.Test;
import com.ckm.eee.Bank;

public class BankTest {

    @Test
    public void setter_테스트() {
        Bank bank = new Bank();
        bank.setName("하나은행");

        assertEquals("하나은행", bank.getName());
    }

    @Test
    public void 예외테스트() {
        IllegalArgumentException illegal =
                assertThrows(IllegalArgumentException.class, () -> new Bank().setName("경민"));
        String message = illegal.getMessage();
        assertEquals("이름이 잘못 되었음", message);

    }

}
