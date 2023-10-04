import javax.swing.text.html.parser.Element;

public class DoubleLinkedList<T> implements List{
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
    public void update(T val)
    {
        current.data=val;
    }
    //adding contact need to reWrite
    // Each contact in the phonebook should be unique. You can ensure this by checking if a contact with
// the same name or phone number already exists in the list before adding a new contact.
    public void insert(T element){
        if(element instanceof Contact)
            if(!addContact(element)){
                System.out.println("contact already exixsts");
                return;
            }
        if(element instanceof Event)
            if(!addEvent(element)){
                System.out.println("there is conflict with a current schedueld event");                
                return;
            }
            }
    //searching contact
// When you search for a contact by email address, address, or birthday, you should return all contacts
// that have these values

// the search for an event is based on the event title or contact name
    public void search(T val){

    }
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
    

    public boolean addContact(T val)
    {
        while(current!=null)
        {
            current.data.getContactName
            current=current.next;
        }
    } 
    public boolean addEvent(Event event)
    {
        //check schedule
        if(!true)
        event.getDate();
        else
        {
            Node<T> tmp=new Node<T> (event);
                if(empty()){
                    head=current=tmp;
                }
                else{
                    tmp.next=current.next;
                    tmp.previous=current;
                    if(current.next != null)
                        current.next.previous=tmp;
                    current.next=tmp;
                    current=tmp;
                }   
        }
    }   
}