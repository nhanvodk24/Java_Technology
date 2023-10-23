package org.example.POJO;
import javax.persistence.*;

@Entity
@Table(name = "Phone")
public class Phone {
    @Id
    private String ID;
    private String Name;
    private int Price;
    private  String Color;
    private String Country;
    private int Quantity;
    public Phone(String id, String name, int price, String color, String country, int quantity, Manufacture manufacture){
        ID = id;
        Name = name;
        Price = price;
        Color = color;
        Country = country;
        Quantity = quantity;
        this.manufacture = manufacture;
    }
    @ManyToOne
    @JoinColumn(name = "Id_Manufacture")
    private Manufacture manufacture;

    public Phone() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }
    @Override
    public String toString() {
        return "Phone{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Color='" + Color + '\'' +
                ", Country='" + Country + '\'' +
                ", Quantity=" + Quantity +
                ", manufacture=" + manufacture +
                '}';
    }
}
