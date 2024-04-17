package shop.mtcoding.product_spring.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepository {
    private final EntityManager em;

    public List<Product> findAll(){
        Query query =
                em.createQuery("select p from Product p order by p.id desc", Product.class);
        return query.getResultList();
    }

    public Product findById(int id){
        Product product = em.find(Product.class, id);
        return product;
    }

    @Transactional
    public Product save(Product product) {    // 순수했던 애가 (우유가)
        em.persist(product);   // 어딘가에 잠깐 담겼죠? (초코우유가 됨)
        return product;   // return도 안해도 됨
    }

}
