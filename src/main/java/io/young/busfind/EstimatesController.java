package io.young.busfind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstimatesController {
    @PostMapping("/")
    public String create() {
        return "index";
    }

}
