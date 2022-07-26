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

	Contacts display() {
		return contact;
	}

}
