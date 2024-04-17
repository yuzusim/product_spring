package shop.mtcoding.product_spring.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.product_spring.product.Product;
import shop.mtcoding.product_spring.user.User;

@NoArgsConstructor
@Data
@Table(name = "order_tb")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 주문을 여러번 할수 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 상품 여러개를 주문할 수 있다.
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Product product;

    private Integer status; // 1:구매, 2:취소


}
