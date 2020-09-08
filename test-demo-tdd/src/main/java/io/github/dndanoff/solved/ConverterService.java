package io.github.dndanoff.solved;

public class ConverterService {
	public String convert(Integer number) {
		StringBuilder sb = new StringBuilder();
		if(number == null) {
			return "";
		}
		if(number%3==0) {
			sb.append("foo");
		}
		
		if(number%5==0) {
			sb.append("bar");
		}
		
		return sb.toString();
	}
}
