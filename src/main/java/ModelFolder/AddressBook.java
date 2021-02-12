package ModelFolder;
import javax.persistence.*;
import java.util.*;

/**
 * AddressBook class
 */
@Entity
public class AddressBook{

    //Attributes
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.PERSIST)
    private Collection<BuddyInfo> buddies;

    //Name getter & setters
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public AddressBook() {
        buddies = new ArrayList();
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Collection<BuddyInfo> getBuddies() {
        return buddies;
    }
    public void setBuddies(Collection<BuddyInfo> buddies) {
        this.buddies = buddies;
    }
    public void addBuddy(BuddyInfo friend){
        buddies.add(friend);
    }


}