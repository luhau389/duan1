package czzz.luhau.myapplication.Model;

public class Bread {
    String name,dic, price,image;
    boolean permission;

    public Bread() {
    }

    public Bread(String name, String dic, String price, String image,boolean permission) {
        this.name = name;
        this.dic = dic;
        this.price = price;
        this.image = image;
        this.permission=permission;
    }

    public boolean getPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
