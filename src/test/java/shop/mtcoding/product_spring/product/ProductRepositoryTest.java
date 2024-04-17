package shop.mtcoding.product_spring.product;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(ProductRepository.class)
@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void findById_test() {
        // given
        int id = 1;

        // when
        productRepository.findById(id);

        // then

    }

    @Test
    public void findAll_test() {
        // given

        // when
        List<Product> productList = productRepository.findAll();

        // then
        System.out.println("findAll_test : " + productList.size());

        //Assertions.assertThat(productList.size()).isEqualTo(2);

    }
}
