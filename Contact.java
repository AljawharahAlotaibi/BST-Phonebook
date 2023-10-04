
// The Contact class should implement the Comparable interface so that contacts can be sorted by name
// when added to the linked list.

//Is it in the phone book as user or in the contact as implementer?
// • When you search for a contact by email address, address, or birthday, you should return all contacts
// that have these values

//implements Comparable
public class Contact implements Comparable{
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
    public int compareTo(Object o) {
        //is it just this line ???
        int a,b;
        a= this.contactName.compareTo(((Contact)(o)).getContactName());
        b= this.contactName.compareTo(((Contact)(o)).getContactName());
        return(a*b);//AND operator

    }
    
}
