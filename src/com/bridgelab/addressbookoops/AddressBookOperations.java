package com.bridgelab.addressbookoops;

import java.util.Scanner;

public class AddressBookOperations {
	Contacts contact = new Contacts();
	Scanner sc = new Scanner(System.in);

	void addContact() {

		System.out.println("Enter first name");
		contact.setFirstName(sc.next());
		System.out.println("Enter last name");
		contact.setLastName(sc.next());
		System.out.println("Enter city");
		contact.setCity(sc.next());
		System.out.println("Enter state");
		contact.setState(sc.next());
		System.out.print("Enter address:  ");
		sc.nextLine();
		contact.setAddress(sc.nextLine());
		System.out.println("Enter Zipcode");
		contact.setZip(sc.next());
		System.out.println("Enter phone Number");
		contact.setPhoneNumber(sc.next());
		System.out.println("Enter email address");
		contact.setEmail(sc.next());

	}

	void editContact() {
		System.out.println("Enter the first name of person to edit");
		String firstName = sc.next();
		if (firstName.equals(contact.getFirstName())) {
			System.out.println("Edit the details of person");
			System.out.println("Enter first name");
			contact.setFirstName(sc.next());

			System.out.println("Enter last Name");
			contact.setLastName(sc.next());

			System.out.println("Enter Email");
			contact.setEmail(sc.next());

			System.out.print("Enter address:  ");
			sc.nextLine();
			contact.setAddress(sc.nextLine());

			System.out.println("Enter phone number");
			contact.setPhoneNumber(sc.next());

			System.out.println("Enter state");
			contact.setState(sc.next());

			System.out.println("Enter city");
			contact.setCity(sc.next());

			System.out.println("Enter zip");
			contact.setZip(sc.next());

		} else {
			System.out.println("Person not found");
		}

	}

	Contacts display() {
		return contact;
	}

}
