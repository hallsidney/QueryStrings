package com.galvanize.calculate;

import java.util.List;

public class Calculate {
    private String x;
    private String y;
    private String operation = "add";

    public List<String> getN() {
        return n;
    }

    public void setN(List<String> n) {
        this.n = n;
    }

    private List<String> n;

    public String operate() {
        switch (this.operation) {
            case ("add"):
                return add();
            case ("multiply"):
                return multiply();
            case ("subtract"):
                return subtract();
            case ("divide"):
                return divide();
        }
        return "";
    }

    public String add(){
        int value = Integer.parseInt(this.x) + Integer.parseInt(this.y);
        String ret_val = this.x + " + " + this.y + " = " + Integer.toString(value);
        return ret_val;
    }

    public String subtract(){
        int value = Integer.parseInt(this.x) - Integer.parseInt(this.y);
        String ret_val = this.x + " - " + this.y + " = " + Integer.toString(value);
        return ret_val;
    }

    public String multiply(){
        int value = Integer.parseInt(this.x) * Integer.parseInt(this.y);
        String ret_val = this.x + " * " + this.y + " = " + Integer.toString(value);
        return ret_val;
    }

    public String divide(){
        int value = Integer.parseInt(this.x) - Integer.parseInt(this.y);
        String ret_val = this.x + " / " + this.y + " = " + Integer.toString(value);
        return ret_val;
    }

    public String sum(){
        if(this.n.size() == 0 || this.n.size() == 1){
            return "0 = 0";
        }else if( this.n.size() == 1)
            return this.n.get(1) + " = " + this.n.get(1);

        int val = 0;
        String ret_val = "";
        for(String num: this.n)
        {
            ret_val += num + " + ";
            val += Integer.parseInt(num);
        }

        ret_val = ret_val.substring(0, ret_val.length() - 3) + " = " + Integer.toString(val);
        return ret_val;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
