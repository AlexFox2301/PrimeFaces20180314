package tables;

import javax.persistence.*;

@Entity
public class Fitting {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    private String nameFitting;
    @Basic
    private int quantity;           //количество
    @Basic
    private int priceFittings;   //цена в копейках

    /////////////////////Геттеры / Сеттеры//////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFitting() {
        return nameFitting;
    }

    public void setNameFitting(String nameFittings) {
        this.nameFitting = nameFittings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceFittings() {
        return priceFittings;
    }

    public void setPriceFittings(int priceFittings) {
        this.priceFittings = priceFittings;
    }
}
