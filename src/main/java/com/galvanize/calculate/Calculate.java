package com.galvanize.calculate;

import java.util.List;

public class Calculate {
    private String x;
    private String y;
    private String operation = "add";

    private String length, width, height;

    private List<String> n;

    public String volume() {
        int val = Integer.parseInt(this.length) * Integer.parseInt(this.width) * Integer.parseInt(this.height);
        String result = "The volume of a " + this.length + "x" + this.width+ "x" + this.height + " rectangle is "
                + Integer.toString(val);
        return result;
    }

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

    public List<String> getN() {
        return n;
    }

    public void setN(List<String> n) {
        this.n = n;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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
