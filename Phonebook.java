// The Phonebook class should provide a user-friendly interface for interacting with the phonebook (e.g.,
// through a command-line menu or graphical user interface).

// The Phonebook class should have methods for printing all contacts that share an event as well as all
// contacts that share the first name

//Is it in the phone book as user or in the contact as implementer?
// • When you search for a contact by email address, address, or birthday, you should return all contacts
// that have these values

import java.util.Scanner;

public class Phonebook {
    DoubleLinkedList<Contact> field;
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
       System.out.println("Welcome to the Linked Tree Phonebook!\r\n" + 
                "Please choose an option:\r\n" + 
                "1. Add a contact\r\n" + 
                "2. Search for a contact\r\n" + 
                "3. Delete a contact\r\n" +
                "4. Schedule an event\r\n" + 
                "5. Print event details\r\n" + 
                "6. Print contacts by first name\r\n" + 
                "7. Print all events alphabetically\r\n" + 
                "8. Exit");

                System.out.println("Enter your choice: ");

                int choice = input.nextInt(); 


                switch(choice){

                case 1:
    DoubleLinkedList<Contact> contactList = new DoubleLinkedList<>();
    // Create some test contacts
    Contact contact1 = new Contact("John Doe", "1234567890", "john.doe@example.com", "123 Main St", "1990-01-01", "Some notes about John");
    Contact contact2 = new Contact("Saud moh", "9876543210", "jane.smith@example.com", "456 Elm St", "1985-05-10", "Some notes about Jane");
    Contact contact3 = new Contact("Alice Johnson", "9876543210", "alice.johnson@example.com", "789 Oak St", "1998-12-25", "Some notes about Alice");
    Contact contact4 = new Contact("John Doe", "1111111111", "bob.williams@example.com", "321 Pine St", "1977-09-15", "Some notes about Bob");

    // Test the addElement method
    contactList.addContact(contact1);
    contactList.addContact(contact2);
    contactList.addContact(contact3);
    contactList.addContact(contact4);

    // Print the contents of the contact list
    //contactList.printList();

                break;

                case 2:
                break;

                case 3:
                System.out.println("Enter name: ");
                String name = input.nextLine();
                contactList.remove(name);
                //test example
                contactList.remove("Alice Johnson");
                
                break;

                case 4:
                break;

                case 5:
                break;

                case 6:
                break;
                
                case 7:
                break;

                case 8:
                break;



                }
    

    

//printing all contacts that share an event as well as all
// contacts that share the first name.

    public static void print(Event val)
    {

    }
    public static void print(String name)
    {
        
    }
}

}
