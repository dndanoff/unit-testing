package io.github.dndanoff.atm;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

public class TransactionManagerMockTest {
	@Mock
	Dispenser failingDispenser;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void transaction_is_rolledback_when_hardware_fails() throws DispenserFailed {
		Account myAccount = new Account("John", 2000.00);
		doThrow(new DispenserFailed()).when(failingDispenser).dispense(any(BigDecimal.class));
		
		TransactionManager objUnderTest = TransactionManager.forAccount(myAccount);
		objUnderTest.registerMoneyDispenser(failingDispenser);
		objUnderTest.withdraw(500);
		
		assertEquals(2000.00, myAccount.getFunds(), 0.1);
		verify(failingDispenser, new Times(1)).dispense(any(BigDecimal.class));
	}
}
