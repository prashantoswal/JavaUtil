package com.xoriant.JavaUtil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8BinaryOperator4 {
	
	public static Function<Developer, BigDecimal> getSalry = dev->dev.getSalary();

    public static void main(String[] args) {

        Developer dev1 = new Developer("1jordan", BigDecimal.valueOf(9999));

        Developer dev2 = new Developer("jack1", BigDecimal.valueOf(8888));
        Developer dev3 = new Developer("jaden2", BigDecimal.valueOf(10000));
        Developer dev4 = new Developer("ali", BigDecimal.valueOf(2000));
        Developer dev5 = new Developer("mkyong", BigDecimal.valueOf(1));
        Developer dev6 = new Developer("Prasahnt", BigDecimal.valueOf(10000));
        Developer dev7 = new Developer("John", BigDecimal.valueOf(10000));



        List<Developer> list = Arrays.asList(dev1, dev2, dev3, dev4, dev5,dev6);
        
        
       Map<BigDecimal,List<Developer>> groupBySalary = list.stream().collect(Collectors.groupingBy(t -> t.getSalary()));
       
       System.out.println(groupBySalary);
        
        

        // 1. Create a Comparator
        Comparator<Developer> comparing = Comparator.comparing(Developer::getSalary);
        
       // Comparator<Developer> comparing = Comparator.comparing(Developer dev)->dev.);

        // 2. BinaryOperator with a custom Comparator
        BinaryOperator<Developer> bo = BinaryOperator.maxBy(comparing);

        Developer result = find(list, bo);

        System.out.println(result);     // Developer{name='jaden', salary=10000}

        // one line

        // find developer with highest pay
        Developer developer = find(list, BinaryOperator.maxBy(Comparator.comparing(Developer::getSalary)));
        System.out.println(developer);  // Developer{name='jaden', salary=10000}

        // find developer with lowest pay
        Developer developer2 = find(list, BinaryOperator.minBy(Comparator.comparing(Developer::getSalary)));
        System.out.println(developer2); // Developer{name='mkyong', salary=1}

    }

    public static Developer find(List<Developer> list, BinaryOperator<Developer> accumulator) {
        Developer result = null;
        for (Developer t : list) {
            if (result == null) {
                result = t;
            } else {
                result = accumulator.apply(result, t);
            }
        }
        return result;
    }

}