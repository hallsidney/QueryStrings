package com.galvanize.calculate;
import com.galvanize.calculate.Calculate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathService {

    @GetMapping("/math/calculate")
    public String operate(Calculate mathService){ return mathService.operate();}

    @PostMapping("/math/sum")
    public String sum(Calculate mathService) { return mathService.sum(); }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String volume(Calculate mathService){return mathService.volume();}

}
