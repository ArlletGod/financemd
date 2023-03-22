package md.finance.financemd.service;

import md.finance.financemd.model.Item;
import md.finance.financemd.repositories.ItemRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItems (){
        return itemRepository.findAll();
    }

   public Item findItemById(int id){
       Optional<Item> itemOptional = itemRepository.findById(id);
        return itemOptional.orElse(null);
   }


   @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void update(int id, Item updatedItem) {
        updatedItem.setId(id);
        itemRepository.save(updatedItem);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void delete(int id) {
        itemRepository.deleteById(id);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

}
