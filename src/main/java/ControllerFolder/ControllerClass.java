package ControllerFolder;
import ModelFolder.AddressBook;
import ModelFolder.AddressBookRepo;
import ModelFolder.BuddyInfo;
import ModelFolder.BuddyRepo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

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
    public String getAddressBook(@ModelAttribute BuddyInfo buddy, Model model)
    {
        Collection<AddressBook> aBook = book.findAll();
       // model.addAttribute("buddies", aBook.getBuddies());
        model.addAttribute("newBuddy", new BuddyInfo());
        model.addAttribute("allAddressBooks", aBook);
        return "";
    }

    @GetMapping("/addressBookView")
    public String addressBook1(@ModelAttribute BuddyInfo buddy, Model model) {

        Collection<AddressBook> addressBooks = book.findAll();
        model.addAttribute("allAddressBooks", addressBooks);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressBookView";
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


    @PostMapping("/addressBook-add")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {

        AddressBook aBook  = book.findById(buddy.getId()).orElse(new AddressBook());

        aBook.addBuddy(new BuddyInfo(buddy.getName(), buddy.getPhone_num()));

        model.addAttribute("addressBook", book);
        return "addressBookStep1";
    }


}
