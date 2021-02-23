package com.galvanize.calculate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CalculateController{
    @GetMapping("/math/calculate")
    public String getOperation(@RequestParam Map<String, String> op) {
        int value = 0;
        String ret_val = "";
        if(!op.containsKey("operation"))
        {
            op.put("operation", "add");
        }

        switch(op.get("operation")){
            case "add":
                value = Integer.parseInt(op.get("x")) + Integer.parseInt(op.get("y"));
                ret_val = op.get("x") +  " + " + op.get("y") + " = " + Integer.toString(value);
                break;
            case "subtract":
                value = Integer.parseInt(op.get("x")) - Integer.parseInt(op.get("y"));
                ret_val = op.get("x") +  " - " + op.get("y") + " = " + Integer.toString(value);
                break;
            case "multiply":
                value = Integer.parseInt(op.get("x")) * Integer.parseInt(op.get("y"));
                ret_val = op.get("x") +  " * " + op.get("y") + " = " + Integer.toString(value);
                break;
            case "divide":
                value = Integer.parseInt(op.get("x")) / Integer.parseInt(op.get("y"));
                ret_val = op.get("x") +  " / " + op.get("y") + " = " + Integer.toString(value);
                break;
        }
        return ret_val;
    }

    @PostMapping("/math/sum")
    public String postOperation(@RequestParam List<String> n){

        if(n.size() == 0 || n.size() == 1){
            return "0 = 0";
        }else if( n.size() == 1)
            return n.get(1) + " = " + n.get(1);

        int val = 0;
        String ret_val = "";
        for(String num: n)
        {
            ret_val += num + " + ";
            val += Integer.parseInt(num);
        }

        ret_val = ret_val.substring(0, ret_val.length() - 3) + " = " + Integer.toString(val);
        return ret_val;
    }

}
