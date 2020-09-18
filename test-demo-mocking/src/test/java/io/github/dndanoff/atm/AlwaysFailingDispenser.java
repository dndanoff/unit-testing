package io.github.dndanoff.atm;

import java.math.BigDecimal;

public class AlwaysFailingDispenser implements Dispenser{

	@Override
	public void dispense(BigDecimal amount) throws DispenserFailed {
		throw new DispenserFailed();
	}

}
