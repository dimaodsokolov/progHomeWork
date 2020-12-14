package tests;

import homework.HW1.BankAccount;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    BankAccount BC = new BankAccount();
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setBalance() {
        int balance = 500;
        int expectedResult = 500;
        int actualResult = BC.setBalance(balance);
        Assert.assertEquals("Test failed, setBalance method is broken",expectedResult,actualResult);
    }

    @Test
    public void credit() {
        int debitSum = 400;
        int expectedResult = BC.getBalance()+debitSum;
        int actualResult = BC.credit(debitSum);
        Assert.assertEquals("Test failed, credit method is broken",expectedResult,actualResult);

    }

    @Test
    public void debit() {
        BC.setBalance(1000);
        int debitSum1 = 800;
        int debitSum2 = 1200;
        int expectedResult1 = BC.getBalance() - debitSum1;
        int actualResult1 = BC.debit(debitSum1);
        int expectedResult2 = -1;
        int actualResult2 = BC.debit(debitSum2);
        Assert.assertEquals("Test failed, debit method is broken",expectedResult1,actualResult1);
        Assert.assertEquals("Test failed, debit method is broken",expectedResult2,actualResult2);

    }
}

