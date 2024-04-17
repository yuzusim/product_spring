package shop.mtcoding.product_spring.product;

import lombok.Data;

public class ProductRequest {
    @Data
    public static class saveDTO{
        private String name;
        private Integer price;
        private Integer qty;

        public Product toEntity(Product product) {
            return Product.builder()
                    .name(name)
                    .price(price)
                    .qty(qty)
                    .id(product.getId())
                    .build();

        }
    }
}
