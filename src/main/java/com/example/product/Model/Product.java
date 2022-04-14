package com.example.product.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int pid;
    private int price;
    private String name;
    private String pcategory;
    private String ptype;
    private String pdesc;
    private String sellerid;
    private String password;


    public Product() {
    }

    public Product(int pid, int price, String name, String pcategory, String ptype, String pdesc, String sellerid, String password) {
        this.pid = pid;
        this.price = price;
        this.name = name;
        this.pcategory = pcategory;
        this.ptype = ptype;
        this.pdesc = pdesc;
        this.sellerid = sellerid;
        this.password = password;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPcategory() {
        return pcategory;
    }

    public void setPcategory(String pcategory) {
        this.pcategory = pcategory;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", pcategory='" + pcategory + '\'' +
                ", ptype='" + ptype + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", sellerid='" + sellerid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
