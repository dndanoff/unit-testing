package io.github.dndanoff.atm;

import java.math.BigDecimal;

public class TransactionManager {

	private Account acc;
	private Dispenser dispenser;
	
	private TransactionManager(Account acc) {
		this.acc = acc;
	}
	
	public static TransactionManager forAccount(Account myAccount) {
		return new TransactionManager(myAccount);
	}

	public void registerMoneyDispenser(Dispenser dispenser) {
		this.dispenser = dispenser;
	}

	public WithdrawalResponse withdraw(double d) {
		try {
			dispenser.dispense(new BigDecimal(d));
		} catch (DispenserFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  new WithdrawalResponse(false);
		}
		acc.setFunds(acc.getFunds()-d);
		return new WithdrawalResponse(true);
	}

}
