package shop.mtcoding.product_spring.product;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.product_spring.user.User;

public class ProductRequest {

    @Data
    public static class UploadDTO{
        private String title;
        private MultipartFile imgFile;

    }

    @Data
    public static class UpdateDTO{
        private String name;
        private Integer price;
        private Integer qty;
    }

    @Data
    public static class SaveDTO{
        private User user;
        private String name;
        private Integer price;
        private Integer qty;

        public Product toEntity(User user) {
            return Product.builder()
                    .name(name)
                    .price(price)
                    .qty(qty)
                    .user(user)
                    .build();

        }
    }
}
