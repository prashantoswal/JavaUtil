package com.xoriant.JavaUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Stream {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Prashant","Kapil", "Manoj","prashant");

		names = names.stream().filter(name->name.equalsIgnoreCase("Prashant") || name.equalsIgnoreCase("Manoj")).collect(Collectors.toList());
		
		System.out.println(names);
		
		Map<Integer,List<String>> count = names.stream().collect(Collectors.groupingBy(t -> t.length()));
	}

}
