package ControllerFolder;
import ModelFolder.AddressBook;
import ModelFolder.AddressBookRepo;
import ModelFolder.BuddyRepo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controller class
 */

@Controller
public class ControllerClass {

    @Autowired
    private AddressBookRepo book;

    @Autowired
    private BuddyRepo buddy;

    @GetMapping("/")
    public String getAddressBook(Model model)
    {
        AddressBook aBook = book.findAll().get(0);
        model.addAttribute("buddies", aBook.getBuddies());
        return "book";
    }

    @PostMapping("/addbuddy")
    public String addBuddy(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name, Model model)
    {
        AddressBook aBook = book.findAll().get(0);
        aBook.addBuddy(buddy.findById(id).get());
        book.save(aBook);
        model.addAttribute("buddies", aBook.getBuddies());
        return "book";
    }


}
