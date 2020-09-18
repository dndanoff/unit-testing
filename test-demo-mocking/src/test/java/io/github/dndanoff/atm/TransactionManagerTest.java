package io.github.dndanoff.atm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class TransactionManagerTest {
	@Test
	public void transaction_is_rolledback_when_hardware_fails() {
		Account myAccount = new Account("John", 2000.00);
		TransactionManager objUnderTest = TransactionManager.forAccount(myAccount);
		objUnderTest.registerMoneyDispenser(new AlwaysFailingDispenser());
		WithdrawalResponse response = objUnderTest.withdraw(500.00);
		assertFalse(response.isSuccessfull());
		assertEquals(2000.00, myAccount.getFunds(), 0.01);
	}
}
