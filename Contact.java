
// The Contact class should implement the Comparable interface so that contacts can be sorted by name
// when added to the linked list.

//Is it in the phone book as user or in the contact as implementer?
// • When you search for a contact by email address, address, or birthday, you should return all contacts
// that have these values

//implements Comparable
public class Contact {
    private String contactName;
    //phone number string or int?
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;

    public Contact()
    {
    }
    public Contact(String contactName,String phoneNumber,String emailAddress,String address,String birthday, String notes)
    {
        this.contactName=contactName;
        this.phoneNumber=phoneNumber;
        this.emailAddress=emailAddress;
        this.address=address;
        this.birthday=birthday;
        this.notes=notes;
    }


    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
