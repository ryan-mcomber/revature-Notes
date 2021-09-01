package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PetStore {
	
	//every pet store has a database
	//here we'll first instantiate an arraylist and infer that it will hold Pet Objects
	private List<Pet> petDB = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		
		//instantiate Pet objects
		PetStore petco = new PetStore();
		PetStore petsmart = new PetStore();
//		
//		//2 ways to add a Pet object to petco's petDB
//		
//		// 1) First we instantiate the object, then we add it.
//		Pet p1 = new Pet("Finn",1004,"Cat","Jerry",4,Color.GREY);
//		petco.petDB.add(p1);
//		
//		// 2) immediately call the collection and add AND instantiate the object at the same time
//		petco.petDB.add(new Pet("Spot",3002,"Dog","Larry",10,Color.BROWN));
//		
//		System.out.println("Below is our ArrayList of Pets from the petco petDB");
//		
//		System.out.println("++++++++++++++");
//		//enhanced for loop
//		for(Pet p: petco.petDB) {
//			System.out.println(p.getName());
//		}
//		
//		//serialize my entire petco
//		
//		petco.serialize();
		
		petsmart.deserialize();
		
		System.out.println(petsmart.petDB);
		
	}
	
	//serialize() method
	public void serialize() {
		
		//we're writing to a file. We need to use the Java.io package
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"));){
			
			// this is the code to execute!
			oos.writeObject(this.petDB);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//deserialize() method
	
	@SuppressWarnings("unchecked")
	private void deserialize() {
		
		//we're writing to a file. We need to use the Java.io package
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"));){
			
			// When a petstore object calls this method, it will call it on its petDB array
			this.petDB = (ArrayList<Pet>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
