public class DoubleLinkedList<T> {
private Node<T> head; 
private Node<T> current;

public DoubleLinkedList()
{
    head=current=null;
}

public void addElement(T element) {
    Node<T> tmp = new Node<>(element);

    if (empty()) { // If the list is empty
        head = current = tmp;
        return;
    }
    if ( (element instanceof Contact &&((Contact)element).compareTo(((Contact)head.getData()).getContactName()) < 0) ||
         (element instanceof Event && ((Event)element).compareTo((Event)head.getData()) < 0) ) {// If the new contact should be inserted at the beginning of the list
        tmp.next = head;
        head.previous = tmp;
        head = tmp;
        return;
    }
    current=head;
    while (current != null) {
        // If the new contact should be inserted in the middle of the list
        if ((element instanceof Contact &&((Contact)element).compareTo(((Contact)current.getData()).getContactName()) < 0) ||
         (element instanceof Event && ((Event)element).compareTo((Event)current.getData()) < 0)) {
            tmp.next = current;
            tmp.previous = current.previous;
            if(current.previous!=null)
                current.previous.next = tmp;
            current.previous = tmp;
            current=tmp;
            return;
        }
        // If we reach the end of the list, insert the new contact at the end
        if (current.next == null) {
            current.next = tmp;
            tmp.previous = current;
            return;
        }
        current = current.next;
    }
}

public Contact remove(String name){
    //When a contact is deleted all events with that contact are also deleted
    current=head;
    while(current!=null){
    if(((Contact)(current.data)).getContactName().equalsIgnoreCase(name)){
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

         System.out.println(name + " was deleted successfully ");

         //Now after deleting the Contact we should delete the contact's events (event list) in main
         return ((Contact)current.data); 
    }

    current=current.next;
    }
        System.out.println(" Contact not found ");
        return null;

   }

public DoubleLinkedList<Contact> searchContact(String searchchoice){
    DoubleLinkedList<Contact> resultList = new DoubleLinkedList<Contact>();
    current=head;
    while(current!=null){
        if(((Contact)(current.data)).getAddress().equalsIgnoreCase(searchchoice)||
        ((Contact)(current.data)).getEmailAddress().equalsIgnoreCase(searchchoice)||
        ((Contact)(current.data)).getBirthday().equalsIgnoreCase(searchchoice) ||
            ((Contact)(current.data)).getContactName().equalsIgnoreCase(searchchoice)||
        ((Contact)(current.data)).getPhoneNumber().equalsIgnoreCase(searchchoice))//check the brackets here!!!!
        resultList.addElement((Contact)(current.data));
        current = current.next;
        }
        return resultList;
}

public DoubleLinkedList<Event> searchEvent(String criteriaChoise){
DoubleLinkedList<Event> resultList = new DoubleLinkedList<Event>();
current=head;
while(current!=null){
    if(
    ((Event)(current.data)).getEventTitle().equalsIgnoreCase(criteriaChoise)||
    ((Event)(current.data)).getDate().equalsIgnoreCase(criteriaChoise)||
    ((Event)(current.data)).getTime().equalsIgnoreCase(criteriaChoise))
        resultList.addElement((Event)current.data);
    current = current.next;
}
return resultList;
// resultList.printEvents();//call a method that prints a list of events
}


    public DoubleLinkedList<Contact> searchByFirstName(String fName){
        DoubleLinkedList<Contact> resultList = new DoubleLinkedList<Contact>();
        current=head;
        while(current!=null){
        String name = ((Contact)(current.data)).getContactName();
        String firstName = name.substring( 0 , name.indexOf(' '));
        if(firstName.equalsIgnoreCase(fName))
       resultList.addElement((Contact)(current.data));
        current=current.next;
        }
        return resultList;
        }

public boolean empty()
{
    return head==null;
}

public boolean last()
{
    return current.next==null;
}

public boolean first ()
{
    return current.previous==null;
}

public boolean full()
{
    return false;
}
public void findFirst ()
{
    current=head;
}
public void findNext ()
{
    current=current.next;
}
public void findPrevious()
{
    current=current.previous;
}

public T retrieve()
{
    return current.data;
}
public T retrieveContactByName(String name){
    current= head;
while(current!=null){
if(((Contact)(current.data)).getContactName().equalsIgnoreCase(name))
return current.data;
current = current.next;}
return null; 
}

public void update(T val)
{
    current.data=val;
}
public Node<T> getHead() {
    return head;
}

public Node<T> getCurrent() {
    return current;
}

public void setHead(Node<T> head) {
    this.head = head;
}

public void setCurrent(Node<T> current) {
    this.current = current;
}

public void printContacts(){
    System.out.println("Contacts in the list:");
    current=head;
    while (current != null) {
        System.out.println(((Contact)(current.getData())).getContactName());
        current = current.next;
    }
}

public void printEvents(){
    current=head;
    while (current != null) {
        System.out.println(((Event)(current.getData())).getEventTitle());
        current = current.next;
    }
}
public void printList(){
    current = head;
    while(current!=null){
    System.out.println(current.data.toString());
    current = current.next;}//end while
}
}//end class