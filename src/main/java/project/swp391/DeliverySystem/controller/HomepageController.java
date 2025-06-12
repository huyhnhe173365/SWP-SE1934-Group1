package project.swp391.DeliverySystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    /**
     * Định nghĩa 2 đường dẫn "/" và "/home" cùng xử lý bởi 1 phương thức.
     * Trả về view có tên "index" → Thymeleaf sẽ tìm file:
     * src/main/resources/templates/index.html
     */
    @GetMapping({"/", "/home"})
    public String showHomepage() {
        return "index";
    }
}

