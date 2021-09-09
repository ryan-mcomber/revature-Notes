package com.revature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.model.Employee;

public class PredicateDriver {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee zayn = new Employee("Zayn Smith", 40);
		Employee mary = new Employee("Mary Shelly",60);
		Employee abby = new Employee("Abby McCormick",30);
		Employee xavier = new Employee("Xavier Hall",25);
		
		employees.add(zayn);
		employees.add(mary);
		employees.add(abby);
		employees.add(xavier);
		
		//first with anon class, then with lambda
		printEmployeesByAge(employees, "All Employees under 50", new Predicate<Employee>() {

			@Override
			public boolean test(Employee e) {
				return e.getAge()<50;}
		});
		
		// passing a predicate witha  lambda
		System.out.println("===============================================X");
		printEmployeesByAge(employees, "All Employees over 30",(e)-> e.getAge()>30);
		
		// Primitive functional Interfaces. Predefine Predicates for specific data types
		
		IntPredicate greaterThan15 = i -> i> 15;
		System.out.println("Is 10 greater than 15? : "+greaterThan15.test(10));
		
		IntPredicate lessThan100 = i -> i<100;
		System.out.println(greaterThan15.and(lessThan100).test(78));
		
		//All sorts of primitive functional interfaces
		DoublePredicate accountOverdrawn = i -> i<0;
		
		/*
		 * Iterable: root interface of the collections hierarchy
		 * 
		 * Iterator is an object we use to iterate over a data structure.
		 */
		
		Iterator<Employee> it = employees.iterator();
		System.out.println(it.next());

	}
	
	private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
		
		// This represents the conditions by which we're sorting the employees by their age
		System.out.println(ageText);
		
		for (Employee e: employees) {
			
			if (ageCondition.test(e)) 
				System.out.println(e.getName() + " is "+e.getAge()+" years old.");
			
		}
	}

}
