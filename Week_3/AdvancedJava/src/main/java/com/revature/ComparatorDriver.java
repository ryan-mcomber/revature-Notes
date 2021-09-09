package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import com.revature.model.Employee;

public class ComparatorDriver {

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
		
		// When we call forEach() we need to specify the functionality for the Consumer Interface's accept() method.
		employees.forEach((e)->System.out.println(e));
		
		// Remember that Consumer comes from the java.util.function package which is where a lot of functional interface come from.
		System.out.println("============================= SORTING TAKES PLACE ====================================");
		NameSorter ns = new NameSorter();
		
		Collections.sort(employees, ns);
		employees.forEach((e)->System.out.println(e));
		
		// Challenge 1: call the Collections.sort() method and create a Comparator anonymous class to sort in DESCENDING order
		Collections.sort(employees, new Comparator<Employee> (){
			@Override
			public int compare(Employee emp1, Employee emp2) {
				
				return emp2.getName().compareTo(emp1.getName());
			}
		});
		System.out.println("============================= SORTING 2 TAKES PLACE (Anon Class) ====================================");
		employees.forEach((e)->System.out.println(e));
		
		// Challenge 2: call the Collections.sort() method and create a LAMBDA function to sort the employees by age in ascending order. 
		Collections.sort(employees, (e1,e2) -> ((Integer)e1.getAge()).compareTo(e2.getAge()));
		System.out.println("============================= SORTING 3 TAKES PLACE (Lambda) ====================================");
		employees.forEach((e)->System.out.println(e));
		
	}
}

// When we use the Comparator interface, we define an EXTERNAL class to the object that we want to sort
// We implement the comparator interface on this class and then override the compare() method
// Note: this is different from the compareTo() method from the comparable interface.

class NameSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.getName().compareTo(emp2.getName());
	}
	
}




