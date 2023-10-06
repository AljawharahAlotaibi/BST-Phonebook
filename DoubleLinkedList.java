
public class DoubleLinkedList<T> {
    private Node<T> head; 
    private Node<T> current;

    public DoubleLinkedList()
    {
        head=current=null;
    }

    public boolean empty()
    {
        return head==null;
    }

    // public boolean last()
    // {
    //     return current.next==null;
    // }

    // public boolean first ()
    // {
    //     return current.previous==null;
    // }

    // public boolean full()
    // {
    //     return false;
    // }
    public void findFirst ()
    {
        current=head;
    }
    // public void findNext ()
    // {
    //     current=current.next;
    // }
    // public void findPrevious()
    // {
    //     current=current.previous;
    // }

    // public T retrieve()
    // {
    //     return current.data;
    // }
    // public void update(T val)
    // {
    //     current.data=val;
    // }
    // Each contact in the phonebook should be unique. You can ensure this by checking if a contact with
    // the same name or phone number already exists in the list before adding a new contact.

    public void addElement(T element){
        if(element instanceof Contact){
            addContact((element));
            return;
        }
        else if(element instanceof Event)
            if(!addEvent(element)){
                System.out.println("there is conflict with a current schedueld event");                
                return;
            }
    }
    
    public void addContact(T contact) {
        Node<T> tmp = new Node<>(contact);

        // If the list is empty
        if (empty()) {
            head = current = tmp;
            System.out.println("Contact added: " + ((Contact) contact).getContactName());
            return;
        }
    
        // Check if the contact already exists in the list 
        findFirst();
        while (current != null) {
            if (((Contact) contact).getContactName().equalsIgnoreCase(((Contact) current.getData()).getContactName()) ||
                    ((Contact) contact).getPhoneNumber().equals(((Contact) current.getData()).getPhoneNumber())) {
                System.out.println("Contact already exists: " + ((Contact) contact).getContactName());
                return;
            }
            current = current.next;
        }
    
        // If the new contact should be inserted at the beginning of the list
        if (((Contact) contact).compareTo(head.getData()) < 0) {
            tmp.next = head;
            head.previous = tmp;
            head = tmp;
            System.out.println("Contact added: " + ((Contact) contact).getContactName());
            return;
        }
    
        findFirst();
        while (current != null) {
            // If the new contact should be inserted in the middle of the list
            if (((Contact) contact).compareTo(current.getData()) < 0) {
                tmp.next = current;
                tmp.previous = current.previous;
                current.previous.next = tmp;
                current.previous = tmp;
                System.out.println("Contact added: " + ((Contact) contact).getContactName());
                return;
            }
    
            // If we reach the end of the list, insert the new contact at the end
            if (current.next == null) {
                current.next = tmp;
                tmp.previous = current;
                System.out.println("Contact added: " + ((Contact) contact).getContactName());
                return;
            }
            current = current.next;
        }
    }

public boolean addEvent(T event)
    {
        //check schedule
        if(!true);
        // event.d<Contact>.getDate();
        return false;
    }

//searching contact
// When you search for a contact by email address, address, or birthday, you should return all contacts
// that have these values
// the search for an event is based on the event title or contact name
    public void search(T val){

    }

    //Layan tst
    //deleting contact need to reWrite
    public void remove(){
        if(current == head)
        {
            head=head.next;
            if(head !=null)
                head.previous=null;
        }
        else
        {
            current.previous.next=current.next;
            if(current.next!=null)
                current.next.previous=current.previous;
        }

        if(current.next==null)
            current=head;
        else
            current=current.next;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getCurrent() {
        return current;
    } 

    public void printList() {
        findFirst();
        while (current != null) {
            Contact contact = (Contact) current.data;
            System.out.println("Contact: " + contact.getContactName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println();
            current = current.next;
        }
    }
}
