package tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Entity
public class Client implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Basic
    private String clientLastName;          //Фамилия
//    @Basic
    private String clientFirstName;         //Имя
//    @Basic
    private String clientFatherName;        //Отчество
//    @Basic
    private String adressHome;              //Адрес
//    @Basic
    private String clientPhoneNumder;       //Номер телефона
//    @Basic
    private String e_mail;

//    @NotNull
    private Date dateRegistration;          //Дата регистрации




    //////////////////////////Геттеры / Сеттеры//////////////////////

//    @Id
//    @GeneratedValue (strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Basic
    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

//    @Basic
    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

//    @Basic
    public String getClientFatherName() {
        return clientFatherName;
    }

    public void setClientFatherName(String clientFatherName) {
        this.clientFatherName = clientFatherName;
    }

//    @Basic
    public String getAdressHome() {
        return adressHome;
    }

    public void setAdressHome(String adressHome) {
        this.adressHome = adressHome;
    }

//    @Basic
    public String getClientPhoneNumder() {
        return clientPhoneNumder;
    }

    public void setClientPhoneNumder(String clientPhoneNumber) {
        this.clientPhoneNumder = clientPhoneNumber;
    }

//    @Basic
    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

//    @NotNull
//    public Date  getDateRegistration() {
    public String  getDateRegistration() {
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy-MMMM-dd");
        return formatForDate.format(dateRegistration);
//        return dateRegistration;
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


    ////////////////////////Конструкторы///////////////////////////////////////////////


    public Client() {
    }

//    public Client(String clientLastName, String clientFirstName, String clientFatherName, String adressHome, String clientPhoneNumder, String e_mail, Date dateRegistration) {
//        this.clientLastName = clientLastName;
//        this.clientFirstName = clientFirstName;
//        this.clientFatherName = clientFatherName;
//        this.adressHome = adressHome;
//        this.clientPhoneNumder = clientPhoneNumder;
//        this.e_mail = e_mail;
//        this.dateRegistration = dateRegistration;
//    }


    ////////////////////////Методы///////////////////////////////////////////////

    @OneToMany(mappedBy = "client")//, fetch = FetchType.EAGER
    private Collection<Zakaz> zakazes;


    @Override
    public String toString() {
        String lff = clientLastName + " " + clientFirstName + " " + clientFatherName;
        return lff;
    }



}
