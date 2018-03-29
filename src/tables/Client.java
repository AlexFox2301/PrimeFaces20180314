package tables;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Entity
public class Client {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    private String clientLastName;          //Фамилия
    @Basic
    private String clientFirstName;         //Имя
    @Basic
    private String clientFatherName;        //Отчество
    @Basic
    private String adressHome;              //Адрес
    @Basic
    private String clientPhoneNumder;       //Номер телефона
    @Basic
    private String e_mail;
    @Basic
    private Date dateRegistration;          //Дата регистрации


    @OneToMany(mappedBy = "client")//, fetch = FetchType.EAGER
    private Collection<Zakaz> zakazes;

    //////////////////////////Геттеры / Сеттеры//////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientFatherName() {
        return clientFatherName;
    }

    public void setClientFatherName(String clientFatherName) {
        this.clientFatherName = clientFatherName;
    }

    public String getAdressHome() {
        return adressHome;
    }

    public void setAdressHome(String adressHome) {
        this.adressHome = adressHome;
    }

    public String getClientPhoneNumder() {
        return clientPhoneNumder;
    }

    public void setClientPhoneNumder(String clientPhoneNumder) {
        this.clientPhoneNumder = clientPhoneNumder;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String  getDateRegistration() {
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy.mm.dd");
        return formatForDate.format(dateRegistration);
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public Collection<Zakaz> getZakazes() {
        return zakazes;
    }

    public void setZakazes(Collection<Zakaz> zakaz) {
        this.zakazes = zakaz;
    }
    ////////////////////////Методы///////////////////////////////////////////////


    @Override
    public String toString() {
        String lff = clientLastName + " " + clientFirstName + " " + clientFatherName;
        return lff;
    }



}
