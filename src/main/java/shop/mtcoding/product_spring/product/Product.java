package shop.mtcoding.product_spring.product;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.product_spring.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "product_tb")
@Entity
public class Product {
    // 테이블 모델링 하기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer qty;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

//    private String imgTitle; // 이미지 이름
//    private String imgFilename; // 파일 패스

    @CreationTimestamp // pc -> db (날짜주입)
    private Timestamp createdAt;

    @Builder
    public Product(Integer id, String name, Integer price, Integer qty, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.createdAt = createdAt;
    }
}