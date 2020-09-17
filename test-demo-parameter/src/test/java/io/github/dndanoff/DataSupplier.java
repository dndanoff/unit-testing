package io.github.dndanoff;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class DataSupplier extends ParameterSupplier {
	@Override
	public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
		List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
		list.add(PotentialAssignment.forValue("String", "A"));
		list.add(PotentialAssignment.forValue("String", "B"));
		return list;
	}

}
