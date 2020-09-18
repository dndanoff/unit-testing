package io.github.dndanoff.atm;

import java.math.BigDecimal;

public interface Dispenser {
	void dispense(BigDecimal amount) throws DispenserFailed;
}
