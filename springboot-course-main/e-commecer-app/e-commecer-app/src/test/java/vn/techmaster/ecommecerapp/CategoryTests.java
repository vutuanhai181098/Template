package vn.techmaster.ecommecerapp;

import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.techmaster.ecommecerapp.entity.Category;
import vn.techmaster.ecommecerapp.repository.CategoryRepository;

@SpringBootTest
public class CategoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void save_categories() {
        Slugify slugify = Slugify.builder().build();
        // Create 3 categories: Rau - Củ - Trái Cây, Sữa các loại, Bánh kẹo
        Category category1 = new Category("Rau - Củ - Trái Cây");
        category1.setSlug(slugify.slugify(category1.getName()));
        Category category2 = new Category("Sữa các loại");
        category2.setSlug(slugify.slugify(category2.getName()));
        Category category3 = new Category("Bánh kẹo");
        category3.setSlug(slugify.slugify(category3.getName()));

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
    }

    @Test
    void save_sub_categories() {
        Slugify slugify = Slugify.builder().build();
        // Create 3 sub categories each of 3 categories above
        Category category1 = categoryRepository.findById(1L).get();
        Category category2 = categoryRepository.findById(2L).get();
        Category category3 = categoryRepository.findById(3L).get();

        Category category11 = new Category("Rau lá");
        Category category12 = new Category("Củ quả");
        Category category13 = new Category("Trái cây tươi");
        category11.setSlug(slugify.slugify(category11.getName()));
        category12.setSlug(slugify.slugify(category12.getName()));
        category13.setSlug(slugify.slugify(category13.getName()));

        Category category21 = new Category("Sữa tươi");
        Category category22 = new Category("Sữa bột");
        Category category23 = new Category("Sữa đặc");
        category21.setSlug(slugify.slugify(category21.getName()));
        category22.setSlug(slugify.slugify(category22.getName()));
        category23.setSlug(slugify.slugify(category23.getName()));

        Category category31 = new Category("Bánh xốp - Bánh quy");
        Category category32 = new Category("Kẹo - Chocolate");
        Category category33 = new Category("Bánh snack");
        category31.setSlug(slugify.slugify(category31.getName()));
        category32.setSlug(slugify.slugify(category32.getName()));
        category33.setSlug(slugify.slugify(category33.getName()));

        category11.setParentCategory(category1);
        category12.setParentCategory(category1);
        category13.setParentCategory(category1);

        category21.setParentCategory(category2);
        category22.setParentCategory(category2);
        category23.setParentCategory(category2);

        category31.setParentCategory(category3);
        category32.setParentCategory(category3);
        category33.setParentCategory(category3);

        categoryRepository.save(category11);
        categoryRepository.save(category12);
        categoryRepository.save(category13);

        categoryRepository.save(category21);
        categoryRepository.save(category22);
        categoryRepository.save(category23);

        categoryRepository.save(category31);
        categoryRepository.save(category32);
        categoryRepository.save(category33);
    }

    @Test
    void update_slug_category() {
        Slugify slugify = Slugify.builder().build();
        // Update slug for all categories
        categoryRepository.findAll().forEach(category -> {
            category.setSlug(slugify.slugify(category.getName()));
            categoryRepository.save(category);
        });
    }
}
