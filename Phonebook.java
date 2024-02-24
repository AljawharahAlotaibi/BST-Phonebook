import java.util.Scanner;
// It should have a field for
//the BST ADT that stores the contacts.
public class Phonebook {
    static DoubleLinkedList<Event> allEventsAndAppointmentsList = new DoubleLinkedList<>(); //not related to any object
    static ContactBST contactBST = new ContactBST(); //here I changed the name to contactBST



    public static void main(String[]args)
    {
        System.out.println("Welcome to the BST Phonebook!");
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println( 
                    "Please choose an option:\r\n" + 
                    "1. Add a contact\r\n" + 
                    "2. Search for a contact\r\n" + 
                    "3. Delete a contact\r\n" +
                    "4. Schedule an event/appointment\r\n" + 
                    "5. Print event details\r\n" + 
                    "6. Print contacts by first name\r\n" + 
                    "7. Print all events alphabetically\r\n" + 
                    "8. Exit");

            System.out.print("Enter your choice: ");

            int choice = input.nextInt(); 

            switch(choice){

            case 1:
            System.out.print("Enter the contact's name:");
            input.nextLine();
            String contactName = input.nextLine();
            System.out.print("Enter the contact's phone number:");
            String phoneNumber = input.nextLine();
            System.out.print("Enter the contact's email address:");
            String emailAddress = input.nextLine();
            System.out.print("Enter the contact's address:");
            String address = input.nextLine();
            System.out.print("Enter the contact's birthday:");
            String birthday = input.nextLine();
                System.out.print("Enter any notes for the contact:");
            String notes = input.nextLine();
            Contact contact = new Contact(contactName,phoneNumber,emailAddress,address,birthday,notes);
            isContactUnique(contact);
            break;

            case 2:
            System.out.println("Enter search criteria:\r\n"+
            "1.Name:\r\n"+
            "2.Phone Number:\r\n"+
            "3.Email Adress:\r\n"+
            "4.Adress:\r\n"+
            "5.Birthday:\r\n"); 
            input.nextLine();
            System.out.print("Enter your choice:");
            int criteriaChoice = input.nextInt();
            switch(criteriaChoice){
                case 1:        
                System.out.print("Enter the contact's name:");
                    break;
                case 2:
                System.out.print("Enter the Phone Number:");
                    break;
                case 3:
                System.out.print("Enter the Email Adress:");
                    break;
                case 4:
                System.out.print("Enter the Adress:");
                    break;
                case 5:
                System.out.print("Enter the Birthday date:");
                    break;
                default:
                    break;
            }
                input.nextLine();//to clean the garbage
                String searchInput = input.nextLine();
              ContactBST searchBST = contactBST.searchContact(searchInput);
               if(!searchBST.empty())     
                   {    System.out.println("Contact found!");
                        searchBST.inOrderPrint(searchBST.getRoot()); 
                   }
               else System.out.println("Contact not found!");
            break;

            case 3:
             System.out.println("Enter full name: ");
            input.nextLine();
            String fullName = input.nextLine();
            Contact removedContact =contactBST.removeContact(fullName); 
            if(removedContact!= null)
            removeEventsAndAppointments(removedContact); 

            break;


            case 4:
            System.out.print("Enter type:\r\n"+
            "1.Event:\r\n"+
            "2.Appointmen:\r\n"+
            "\nEnter your choice: ");
            int eventType = input.nextInt();
                    System.out.print(eventType==1?"Enter event title:":"Enter appointment title:");
                    input.nextLine();
                    String eventTitle = input.nextLine();
                    System.out.print(eventType==1?"Enter contacts name separated by a comma:":"Enter contact name:");
                    String names = input.nextLine();
                    System.out.print(eventType==1?"Enter event date and time (MM/DD/YYYY HH:MM):":"Enter appointment date and time (MM/DD/YYYY HH:MM):");
                    String date = input.next();
                    String time = input.next();
                    System.out.print(eventType==1?"Enter event location:":"Enter appointment location:");
                    input.nextLine();//to clean the garbage
                    String location = input.nextLine();
                   
                   if(scheduleEvenOrAppointment(eventTitle,names,date,time,location,eventType))
                        System.out.println(eventType==1?"Event scheduled successfully!":"Appointment scheduled successfully!");
                   else
                        System.out.println("faild to schedule");  
                    break;
            case 5:
            System.out.println("Enter search criteria:\r\n"+
            "1.Contact Name:\r\n"+
            "2.Event title:\r\n");
            input.nextLine();
            System.out.print("Enter your choice:");
            int critChoice = input.nextInt();
                switch(critChoice){
                case 1:        
                System.out.print("Enter the contact's name:");
                    break;
                case 2:
                System.out.print("Enter the event title:");
                break;
                default:
                break;
                }
            input.nextLine();//to clean the garbage
            String choiceInput = input.nextLine();
          if(allEventsAndAppointmentsList.searchEvent(choiceInput).empty())
                System.out.println("Event not found!");
                else System.out.println("Event found!");
               allEventsAndAppointmentsList.searchEvent(choiceInput).printList(); 
                break;

                case 6:
                System.out.print("Enter the first name:");
                input.nextLine();//to clean the garbage
                String firstName = input.next().trim();
                ContactBST resultBST = contactBST.searchForFirstName(firstName);
                  if(!resultBST.empty())     
                   {    System.out.println("\nContact found!");
                        resultBST.inOrderPrint(resultBST.getRoot()); 
                   }
               else System.out.println("\nContact not found!");
                break;
                
                case 7:
                allEventsAndAppointmentsList.printEvents();
                break;

                case 8:
                System.out.println("Goodbye!");
                System.exit(0);
                break;

                default:
                break;

            }
            System.out.println();
        }
        
    }

    public static boolean scheduleEvenOrAppointment(String eventTitle,String nameContacts,String date,String time, String location, int eventType){
        String[] names = nameContacts.split(", ");
        for (String name : names) {
            if(contactBST.searchContact(name)==null){
                System.out.println("Sorry contact "+name+" not added in the phonebook");
                return false;
            }
        }
        for (String name : names) {
            if(contactBST.searchContact(name)!=null){
                if(contactBST.searchContact(name).getRoot()!=null && !contactBST.searchContact(name).getRoot().data.contactEventsOrAppointement.searchEvent(date).empty() && !contactBST.searchContact(name).getRoot().data.contactEventsOrAppointement.searchEvent(time).empty()){
                    System.out.println("Sorry there is a conflict in a date and time");
                    return false;
                }
            }
        }
        Event requestedEvent = new Event(eventTitle,date,time,location,seperateContacts(nameContacts), eventType==1?true:false );
        for (String name : names) {
            if(contactBST.searchContact(name)!=null && contactBST.searchContact(name).getRoot()!=null ){
                contactBST.searchContact(name).getRoot().data.contactEventsOrAppointement.addElement(requestedEvent);
            }
        }
        allEventsAndAppointmentsList.addElement(requestedEvent);
        return true;
    }

    public static void isContactUnique(Contact contact){
        // Check if the contact already exists in the tree  
        //i need to check the phone number, not name?? you need to check for both.

        if (!contactBST.searchContact(contact.getContactName()).empty()||!contactBST.searchContact(contact.getPhoneNumber()).empty()) {//no need for casting here
            System.out.println("Contact already exists: " + contact.getContactName());//no need for casting here
            return;
        }
        contactBST.insert(contact.getContactName(),contact);
        System.out.println("Contact added successfully!");    
    }

   public static void removeEventsAndAppointments(Contact contact) {
   String name = contact.getContactName();
    allEventsAndAppointmentsList.findFirst();
    

    while (allEventsAndAppointmentsList.getCurrent() != null) {
        Event currentData = allEventsAndAppointmentsList.getCurrent().getData();
        
        ContactBSTNode root = currentData.getContactSharedEvents().getRoot();
        
        if((!currentData.getIsEvent()) || ((currentData.getIsEvent())&& (root.getLeft()==null || root.getRight()==null))){
        // Removing the appointment or it is an event with only one contact
              allEventsAndAppointmentsList.findFirst();

                   if(allEventsAndAppointmentsList.getCurrent() == allEventsAndAppointmentsList.getHead())
              {
                  allEventsAndAppointmentsList.setHead(allEventsAndAppointmentsList.getHead().next);
                  if(allEventsAndAppointmentsList.getHead() !=null)
                      allEventsAndAppointmentsList.getHead().previous=null;
              }
              else
              {
                  allEventsAndAppointmentsList.getCurrent().previous.next=allEventsAndAppointmentsList.getCurrent().next;
                  if(allEventsAndAppointmentsList.getCurrent().next!=null)
                      allEventsAndAppointmentsList.getCurrent().next.previous=allEventsAndAppointmentsList.getCurrent().previous;
              }

              if(allEventsAndAppointmentsList.getCurrent().next==null)
                  allEventsAndAppointmentsList.setCurrent(allEventsAndAppointmentsList.getHead());
              else
                  allEventsAndAppointmentsList.setCurrent(allEventsAndAppointmentsList.getCurrent().next);
              }             

         else if(root.getLeft()!=null || root.getRight()!=null)
        currentData.getContactSharedEvents().removeContact(name);
        //there are other contacts assosiated with the event so we remove the contact.

        allEventsAndAppointmentsList.setCurrent(allEventsAndAppointmentsList.getCurrent().next);
        }
        
        }
        
        
        
             public static ContactBST seperateContacts(String nameContacts){
                ContactBST tmpContactTree= new ContactBST();
                    String[] names = nameContacts.split(", ");
                    for (String name : names) {
                        if(contactBST.searchContact(name).getRoot()!=null)
                           tmpContactTree.insert(name,contactBST.searchContact(name).getRoot().data); 
            }
            return tmpContactTree;
         } 
}//end class