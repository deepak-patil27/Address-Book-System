package com.bridgelab.addressbookoops;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		HashMap<String, AddressBookOperations> map = new HashMap<>();
		System.out.println("Welcome To Address Book");		
        Scanner sc = new Scanner(System.in);
        
        
        boolean exit = true;
        while(exit){
            AddressBookOperations add = new AddressBookOperations();
            System.out.println("Enter address book name");
            String addressBookName = sc.next().toLowerCase();
            if(map.containsKey(addressBookName)){
                System.out.println("address book already exist");
            }
            else {
                map.put(addressBookName, add);
            }
           
            System.out.println("""
                    Enter options:
                    1) To add contact
                    2) To edit Contact
                    3) To display Contacts
                    4) To delete contact
                    5) To exit""");
        int option = sc.nextInt();
        switch (option) {
        case 1:
            map.get(addressBookName).addContact();
            break;
        case 2:
            map.get(addressBookName).editContact();
            break;
        case 3:
           map.get(addressBookName).displayContacts();
            break;
        case 4:
            map.get(addressBookName).deleteContact();
            break;
        case 5:
            exit = false;
            break;
        case 6:

        default:
            break;
    }
}
System.out.println(map);
}

}
