package shop.mtcoding.product_spring.product;

import lombok.Data;
import shop.mtcoding.product_spring.user.User;

public class ProductRequest {
    @Data
    public static class SaveDTO{
        private String name;
        private Integer price;
        private Integer qty;

        public Product toEntity(User user) {
            return Product.builder()
                    .name(name)
                    .price(price)
                    .qty(qty)
                    //.user(user)
                    .build();

        }
    }
}
