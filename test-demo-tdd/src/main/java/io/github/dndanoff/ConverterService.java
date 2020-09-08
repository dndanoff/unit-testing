package io.github.dndanoff;

public class ConverterService {

	public String convert(int i) {
		StringBuilder sb = new StringBuilder();
		if(i % 3 == 0) {
			sb.append("foo");
		}
		
		if(i % 5 == 0) {
			sb.append("bar");
		}
		return sb.toString();
	}

}
