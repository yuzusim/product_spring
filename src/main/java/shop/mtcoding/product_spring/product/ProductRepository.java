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

    //게시글 목록보기 완료
    public List<Product> findAll() {
        Query query =
                em.createQuery("select p from Product p order by p.id desc", Product.class);
        return query.getResultList();
    }

    public Product findById(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    //게시글 쓰기 완료
    @Transactional
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    @Transactional
    public void updeteById(int id, String name, Integer price, Integer qty) {
        Product product = findById(id);
        product.setName(name);
        product.setPrice(price);
        product.setQty(qty);
    }

    @Transactional
    public void deleteById(int id) {
        Query query =
                em.createQuery("delete from Product p where p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
