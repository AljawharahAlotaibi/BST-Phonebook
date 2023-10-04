// In the event class, use any data structure you choose to store the events. You might have to include
// the event class object in another class. This problem is for you to solve.

// When a contact is deleted all events with that contact are also deleted.

// Write a method that will list all events available ordered alphabetically by event name in O(n) time
public class Event<T> {
    private String eventTitle;
    private String date;
    private String time;
    private String location;
    private T contact;

    public Event(Event event)
    {
        this.eventTitle = event.eventTitle;
        this.date=event.date;
        this.time=event.time;
        this.location=event.location;
    } 

    
    public Event(String eventTitle,String date,String time,String location,T contact)
    {
        this.eventTitle=eventTitle;
        this.date=date;
        this.time=time;
        this.location=location;
        //make sure it is compistion.......
        this.contact =  contact;

    }

    public void add(Event val)
    {
        //Make sure before adding an event that the contact in the event exist in the contact list.
        // There should be no conflict in event scheduling. A new event should not be scheduled for a contact if
        // it has a conflict with a current scheduled event.
    }
    
    public void eventAvailable()
    {}


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


    public T getContact() {
        return contact;
    }



}
