package ModelFolder;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "BuddyInfo", path = "buddyInfos")
public interface BuddyRepo extends CrudRepository<BuddyInfo, Long> {
    List<AddressBook> findByName(String name);
    AddressBook findById(long id);
}
