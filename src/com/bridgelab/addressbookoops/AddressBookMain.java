package com.bridgelab.addressbookoops;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
	public static Map<String, AddressBook> addressBookHashMap = new HashMap<>(); //map interface created
	Scanner scanner = new Scanner(System.in); //scanner object created to take user input

	// USER INPUT
	public void addDataToAddressBook() {

		String chooseContact, chooseCity;  //string created

		do {
			System.out.println("Enter the name of city");
			String city = scanner.nextLine();
			AddressBook addressBook = new AddressBook(city); //address book object created
			for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {  // using for-each loop for iteration over Map.entrySet() 
				if (entry.getKey().equals(city)) {  //iterate over key using getKey() 
					addressBook = entry.getValue();  //iterate over value using getValue()
				}
			}
			addressBookHashMap.put(city, addressBook);  //hash map created to put values in address book
			do {
				System.out.println("Enter first name:");
				String firstName = scanner.nextLine();

				System.out.println("Enter last name:");
				String lastName = scanner.nextLine();

				System.out.println("Enter address name:");
				String address = scanner.nextLine();

				System.out.println("Enter state name:");
				String state = scanner.nextLine();

				System.out.println("Enter zip code:");
				String zip = scanner.nextLine();

				System.out.println("Enter phone number:");
				String phoneNumber = scanner.nextLine();

				System.out.println("Enter emailId number:");
				String emailID = scanner.nextLine();

				Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, emailID);

				for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) { // using for-each loop for iteration over Map.entrySet()
					if (entry.getKey().equalsIgnoreCase(city)) { 
						entry.getValue().addContact(contact);  
					}
				}
				System.out.println("Do you want to add contact again? Yes|No");
				chooseContact = scanner.nextLine();
			} while (chooseContact.equalsIgnoreCase("Yes")); 
			System.out.println("Do you want to add another city Yes|No");
			chooseCity = scanner.nextLine();
		} while (chooseCity.equalsIgnoreCase("yes"));
		System.out.println("Returning");		
	}

	// Search Contact By City or State
	public static void searchContactByCityOrState(String city, String name) {
		List<Contact> contactList = new ArrayList<>();

		for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) { // using for-each loop for iteration over Map.entrySet()
			contactList = entry.getValue().getAddressBook().stream().filter(p -> p.getCity().equalsIgnoreCase(city)) //method filter() to filter stream elements on the basis of given predicate
					.filter(p -> (p.getFirstName()).equals(name)).collect(Collectors.toList());  //collect() Function to get data out of the stream
		}                                                                                       
		for (Contact contact : contactList) {
			System.out.println("Search result: " + contact);
		}
	}

	// method to view person by city
	public static void viewContactByCityOrState(String city) {
		List<Contact> list = new ArrayList<>();
		for (Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
			list = entries.getValue().getAddressBook().stream().filter(p -> p.getCity().equalsIgnoreCase(city))
					.collect(Collectors.toList());
		}
		for (Contact person : list) {
			System.out.println(person.getFirstName() + " " + person.getLastName());
		}
	}

	// method to get number of contact persons by city
	public static void getCountByCity(String city) {
		long count1 = 0;
		for (Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
			long count = entries.getValue().getAddressBook().stream().filter(p -> p.getCity().equals(city)).count();
			count1 += count;
		}
		System.out.println(count1 + " Contacts in " + city);
	}

	// method to sort the entries alphabetically by person's Name
	public static void sortByName() {
		List<Contact> list = new ArrayList<>();
		for (Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
			list = new ArrayList<>(entries.getValue().getAddressBook());
		}
		list.stream().sorted((p1, p2) -> ((String) p1.getFirstName()).compareTo(p2.getFirstName()))
				.forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
	}
	
	// Method To sort Entries By Zip
    public static void sortByZip() {
        List<Contact> list = new ArrayList<>();
        for (Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().collect(Collectors.toList());
        }
        list.stream().sorted((p1, p2) -> ((String) p1.getZip()).compareTo(p2.getZip()))
                .forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
    }
	
	//method to sort entries by city
    public static void sortByCity(){
        List<Contact> list = new ArrayList<>();
        for (Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().collect(Collectors.toList());
        }
        list.stream().sorted((p1 , p2) -> ((String)p1.getCity()).compareTo(p2.getCity()))
                .forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getLastName()+ " From " +contact.getCity()));
    }

	// MAIN METHOD
	public static void main(String[] args) {
		System.out.println("                             Welcome To Address Book");
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1. Add new contact" + "\n" + "2. Edit contact details" + "\n"
					+ "3. Delete contact details" + "\n" + "4. Search Contact by City or State " + "\n"
					+ "5. View Contact by City" + "\n" + "6. Count Contacts by City" + "\n" + "7. Show Contact" + "\n"
					+ "8. Sort Contacts By City|Zip" + "\n" + "9. Display All Contacts" + "\n" + "0. Exit" + "\n" + "Enter your choice:");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				new AddressBookMain().addDataToAddressBook();
				break;

			case 2:
				System.out.println("Enter the address book name (city)");
				String city = scanner.next();

				System.out.println("Enter First Name of the contact you want to edit");
				String checkName1 = scanner.next();

				for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase(city)) {
						entry.getValue().editContactByFirstName(checkName1);
					} else {
						System.out.println("The" + city + " address book does not present.");
					}
				}
				break;

			case 3:
				System.out.println("Enter the address book name (city)");
				city = scanner.next();

				System.out.println("Enter First Name of the contact you want to delete");
				String checkName2 = scanner.next();

				for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
					if (entry.getKey().equalsIgnoreCase(city)) {
						entry.getValue().deleteContact(checkName2);
					} else {
						System.out.println("The" + city + " address book does not exist.");
					}
				}
				break;

			case 4:
				String name1;
				System.out.println("Enter City , First Name you want to search:");
				String city2 = scanner.next();
				name1 = scanner.next();
				searchContactByCityOrState(city2, name1);
				break;

			case 5:
				System.out.println("Enter the city you want to view");
				String city3 = scanner.next();
				viewContactByCityOrState(city3);
				break;

			case 6:
				System.out.println("Enter the city for you want to count contact");
				String city4 = scanner.next();
				getCountByCity(city4);
				break;
				
			case 7:
				System.out.println("Sorted Contacts Alphabetically");
                sortByName();
                break;
                
			case 8:
				System.out.println("Sort By Zip:");
                sortByZip();
                System.out.println("Sort By City:");
                sortByCity();
                break;

			case 9:
				for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
					System.out.println(entry.getKey() + "\t" + entry.getValue().getAddressBook());
				}
			}
		} while (choice != 0);
	}

}
