package shop.mtcoding.product_spring.product;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductRepository productRepository;
    private final HttpSession session;

    @GetMapping({"/product", "/"})
    public String list(HttpServletRequest request) {
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList", productList);

        // 페이지 리턴
        return "product/list";
    }

    //
    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id) {

        // 페이지 리턴
        return "product/detail";
    }

    @GetMapping("/product/saveForm")
    public String saveForm() {
        return "product/saveForm";
    }

    @GetMapping("/product/{id}/updateForm")
    public String updateForm(@PathVariable int id) {

        // 페이지 리턴
        return "product/updateForm";
    }

    @PostMapping("product/add")
    public String save() {

        // 페이지 리턴
        return "redirect:/product/" + 1;
    }

    @PostMapping("/product/{id}/edit")
    public String update(@PathVariable int id) {

        // 페이지 리턴
        return "redirect:/product/" + 1;
    }

    @PostMapping("/product/{id}/delete")
    public String delete(@PathVariable int id) {

        // 페이지 리턴
        return "redirect:/";
    }
}
