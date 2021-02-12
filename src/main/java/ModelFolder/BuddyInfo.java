package ModelFolder;
import javax.persistence.*;

/**
 * BuddyInfo class
 */
@Entity
public class BuddyInfo{

    //Attributes
    @Id
    @GeneratedValue
    private Long id;
    private String phone_num;
    private String name = null;
    private String address = null;

    @ManyToOne
    private AddressBook addressBook;

    //Default constructor
    public BuddyInfo() {
    }

    public BuddyInfo(String name, String phone_num) {
        this.name = name;
        this.phone_num = phone_num;
    }

    //Id getter & setters
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //name getter & setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num()
    {
        return this.phone_num;
    }
    public void setPhone_num(String phone_num) { this.phone_num = phone_num; }

    //address book setter & getters
    public AddressBook getAddressBook() {
        return addressBook;
    }
    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }


    @Override
    public String toString() {
        return "Buddy: Name: " + name + " Phone Number: " + phone_num;
    }
}
