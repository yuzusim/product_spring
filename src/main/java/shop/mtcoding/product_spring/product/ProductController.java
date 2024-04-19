package shop.mtcoding.product_spring.product;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.product_spring.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductRepository productRepository;
    private final HttpSession session;

    @PostMapping("/upload")
    public String upload(ProductRequest.UploadDTO reqDTO){
        // 1. 데이터 전달 받고
        String title = reqDTO.getTitle();
        MultipartFile imgFile = reqDTO.getImgFile();

        // 2. 파일저장 위치 설정해서 파일을 저장 (UUID 붙여서 롤링)
        String imgFilename = UUID.randomUUID()+"_"+imgFile.getOriginalFilename();
        Path imgPath = Paths.get("./upload/"+imgFilename);
        try {
            Files.write(imgPath, imgFile.getBytes());

            // 3. DB에 저장 (title, realFileName)
            //picRepository.insert(title, imgFilename);
            productRepository.insert(title, imgFilename);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/";
    }

    // 상품목록보기
    @GetMapping({"/product", "/"})
    public String list(HttpServletRequest request) {
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList", productList);

        // 페이지 리턴
        return "product/list";
    }

    // 상품 상세보기
    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) {
        Product product = productRepository.findById(id);
        request.setAttribute("product", product);

        // 페이지 리턴
        return "product/detail";
    }

    // 상품 등록하기
    @GetMapping("/product/saveForm")
    public String saveForm() {
        return "product/saveForm";
    }

    @PostMapping("product/add")
    public String save(ProductRequest.SaveDTO reqDTO) {
//        System.out.println("name : "+name);
//        System.out.println("number : "+number);
//        System.out.println("qty : "+qty);

        User sessionUser = (User) session.getAttribute("sessionUser");
        productRepository.save(reqDTO.toEntity(sessionUser));

        // 페이지 리턴
        return "redirect:/";
    }

    // 상품 수정하기
    @GetMapping("/product/{id}/updateForm")
    public String updateForm(@PathVariable int id, HttpServletRequest request) {
        Product product = productRepository.findById(id);
        request.setAttribute("product", product);

        // 페이지 리턴
        return "product/updateForm";
    }

    @PostMapping("/product/{id}/update")
    public String update(@PathVariable int id, ProductRequest.UpdateDTO reqDTO) {
        productRepository.updeteById(id, reqDTO.getName(), reqDTO.getPrice(), reqDTO.getQty());
        // 페이지 리턴
        return "redirect:/product/" + id;
    }

    // 상품 삭제하기
    @PostMapping("/product/{id}/delete")
    public String delete(@PathVariable int id) {
        productRepository.deleteById(id);
        // 페이지 리턴
        return "redirect:/";
    }
}
