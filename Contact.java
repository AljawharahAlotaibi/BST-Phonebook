public class Contact implements Comparable<String>{
    private String contactName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    public DoubleLinkedList<Event> contactEventsOrAppointement = new DoubleLinkedList<Event>(); 

    public Contact()
    {
    }


    public Contact(String contactName, String phoneNumber, String emailAddress, String address, String birthday,
    String notes) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        contactEventsOrAppointement=new DoubleLinkedList<>();

    }


    public String getContactName() {
        return contactName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getAddress() {
        return address;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getNotes() {
        return notes;
    }

    @Override
    public int compareTo(String fullName) {
           return this.contactName.compareTo(fullName);
    }
@Override
    public String toString(){
        return "Contact name:"+contactName+"\nPhone Number:"+phoneNumber+"\nEmail Adress:"+emailAddress+"\nAdress:"+address+"\nBirthday:"+birthday+"\nNotes:"+notes+"\n";
    }
}//end class