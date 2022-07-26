package com.bridgelab.addressbookoops;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookOperations {
	ArrayList<Contacts> list = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    void addContact(){
        Contacts contact = new Contacts();
        System.out.print("Enter first name: ");
        contact.setFirstName(sc.next());
        System.out.print("Enter last name:");
        contact.setLastName(sc.next());
        System.out.print("Enter city: ");
        contact.setCity(sc.next());
        System.out.print("Enter state: ");
        contact.setState(sc.next());
        System.out.print("Enter address:  ");
        sc.nextLine();
        contact.setAddress(sc.nextLine());
        System.out.print("Enter Zipcode: ");
        contact.setZip(sc.next());
        System.out.print("Enter phone Number: ");
        contact.setPhoneNumber(sc.next());
        System.out.print("Enter email address: ");
        contact.setEmail(sc.next());
        list.add(contact);
    }

    void editContact(){
        System.out.println("Enter the first name of person to edit");
        String firstName = sc.next().toLowerCase();

        boolean found = false;
        for (Contacts contact : list){
        if(firstName.equals(contact.getFirstName().toLowerCase())) {
            System.out.println("Edit the details of person");
            System.out.print("Enter first name: ");
            contact.setFirstName(sc.next());

            System.out.print("Enter last Name: ");
            contact.setLastName(sc.next());

            System.out.print("Enter Email: ");
            contact.setEmail(sc.next());

            System.out.print("Enter address: ");
            sc.nextLine();
            contact.setAddress(sc.nextLine());

            System.out.print("Enter phone number: ");
            contact.setPhoneNumber(sc.next());

            System.out.print("Enter state: ");
            contact.setState(sc.next());

            System.out.print("Enter city: ");
            contact.setCity(sc.next());

            System.out.print("Enter zip: ");
            contact.setZip(sc.next());
            found = true;
            break;
            }
        }
        if (!found){
            System.out.println("No contact found");
        }
    }


    void deleteContact(){
        System.out.println("Enter the first name of person to delete");
        String firstName = sc.next().toLowerCase();
        boolean found = false;
        for (Contacts contact : list){
            if (firstName.equals(contact.getFirstName().toLowerCase())){
                list.remove(contact);
                found = true;
                System.out.println("Contact deleted successfully");
                break;
            }
        }
        if (!found){
            System.out.println("No contact found");
        }

    }

   void displayContacts(){
        if(list.isEmpty()){
            System.out.println("No contacts to display");
        }
        else {
            for (Contacts contact : list) {
                System.out.println(contact);
            }
        }

    }

}
