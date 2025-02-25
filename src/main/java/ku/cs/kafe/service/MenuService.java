//6510405750 Phumrapee Soenvanichakul
package ku.cs.kafe.service;

import ku.cs.kafe.entity.Category;
import ku.cs.kafe.entity.Menu;
import ku.cs.kafe.repository.CategoryRepository;
import ku.cs.kafe.repository.MenuRepository;
import ku.cs.kafe.request.MenuRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {


    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Menu getOneById(UUID id) {
        return menuRepository.findById(id).get();
    }



    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }


    public void createMenu(MenuRequest request) {
        Menu record = modelMapper.map(request, Menu.class);
        Category category =
                categoryRepository.findByName(request.getCategoryName());
        record.setCategory(category);
        menuRepository.save(record);
    }
}

