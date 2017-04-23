package io.young.busfind;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstimatesController {
    @PostMapping("/")
    public ResponseEntity<String> create() {
        return new ResponseEntity<>("{'eta': '12:05'}", HttpStatus.OK);
    }

}
