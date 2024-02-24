// This class will represent an event or an appointment that can be scheduled with a contact
// or multiple contacts. An event can be scheduled with multiple contacts, where an appointment
// can be scheduled only with one contact. It should have fields to represent if it is an event or an
// appointment, the title, date and time, location, and the contacts involved in this event or
// appointment.
public class Event implements Comparable<Event> {
    private String eventTitle;
    private String date;
    private String time;
    private String location;
    private Contact contact;
    private ContactBST contactSharedEvents;
    private boolean isEvent; //if not then appointment

    public Event(String eventTitle, String date, String time, String location, ContactBST contact,boolean isEvent) {
        this.eventTitle = eventTitle;
        this.date = date;
        this.time = time;
        this.location = location;
        this.isEvent=isEvent;
        if(!isEvent){
            this.contact = contact.getRoot().data;
        }else
        contactSharedEvents=contact;
    }
    public Event(Event event)
    {
        this.eventTitle = event.eventTitle;
        this.date=event.date;
        this.time=event.time;
        this.location=event.location;
    } 
    public void add(Event val)//moved to class Contact
    {
        //Make sure before adding an event that the contact in the event exist in the contact list.
        // There should be no conflict in event scheduling. A new event should not be scheduled for a contact if
        // it has a conflict with a current scheduled event.
    }
    
    

    public String getEventTitle() {
        return eventTitle;
    }


    public String getDate() {
        return date;
    }


    public String getTime() {
        return time;
    }


    public String getLocation() {
        return location;
    }


    public Contact getContact() {
        return contact;
    }
    
      public ContactBST getContactSharedEvents(){
    return contactSharedEvents;
    }
    
    public boolean getIsEvent(){
    return isEvent;
    }

    @Override
    public int compareTo(Event event) {
        return this.eventTitle.compareTo(((Event)event).getEventTitle());
    }
    @Override
    public String toString(){
        if(isEvent){
            System.out.println("Event title:"+eventTitle);
            System.out.print("Contact names:"); contactSharedEvents.inOrderPrintName(contactSharedEvents.getRoot());
            
            System.out.println("\nEvent date and time(MM/DD/YYYY HH:MM):"+date+" "+time+"\nEvent location:"+location);
            return "";
        }else 
            return "Event title:"+eventTitle+"\nContact name:"+contact.getContactName()+"\nEvent date and time(MM/DD/YYYY HH:MM):"+date+" "+time+"\nEvent location:"+location;
    }
}//end class