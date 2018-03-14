package tables;

import javax.persistence.*;

@Entity
public class Vendor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    private String vendorName;
    @Basic
    private String vendorAdress;
    @Basic
    private String vendorPhoneNumber;
    @Basic
    private String e_mail;
    @Basic
    private String priceList;

    //////////////////////////Геттеры / Сеттеры//////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAdress() {
        return vendorAdress;
    }

    public void setVendorAdress(String vendorAdress) {
        this.vendorAdress = vendorAdress;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }
}
