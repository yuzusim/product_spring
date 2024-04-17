package shop.mtcoding.product_spring.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "user_tb")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)//널 값 허용 안하는 어노테이션
    private String password; //패스워드
    private String username; //아이디
    private String phone;//폰번호
    private String email; //이메일
    private String address; //주소
    private Integer role; // 1 -> admin, 2 -> user

    @Column(length = 15)
    private String adminName; //최고관리자

    @CreationTimestamp // pc -> db (날짜주입)
    private Timestamp createdAt;

    @Builder
    public User(Integer id, String password, String username, String phone, String email, String address, String adminName, Integer role, Timestamp createdAt) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.adminName = adminName;
        this.role = role;
        this.createdAt = createdAt;
    }
}
