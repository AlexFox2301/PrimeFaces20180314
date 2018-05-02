package beans;

import dao.ClientDAO;
import tables.Client;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class ClientBean {

    @EJB
    ClientDAO clientDAO;



    public List<Client> getClients(){
        return clientDAO.findAll();
    }

    /////////////Переменные/////////////////////////////////////////////////

    private int idInputClient;
    private String lastName;
    private String firstName;
    private String fatherName;
    private String address;
    private String phoneNumber;
    private String eMail;
    private Date dateRegistration;


    private String searchText;

    /////////////Геттеры / Сеттеры /////////////////////////////////////////


    public int getIdInputClient() {
        return idInputClient;
    }

    public void setIdInputClient(int idInputClient) {
        this.idInputClient = idInputClient;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

///////////////Методы//////////////////////////////////////////////////

//    public void createClient (){
//        Client client;
//        client.setClientLastName();
//        client.setClientFirstName();
//        client.setClientFatherName();
//
//    }

    public void search(){}//липовая заглушка

    public void createClient(){

        Client clientForDB = new Client();
        clientForDB.setClientLastName(lastName);
        clientForDB.setClientFirstName(firstName);
        clientForDB.setClientFatherName(fatherName);
        clientForDB.setAdressHome(address);
        clientForDB.setClientPhoneNumder(phoneNumber);
        clientForDB.setE_mail(eMail);
        clientForDB.setDateRegistration(dateRegistration);

        clientDAO.addClient(clientForDB);

    }

    public void deleted(){}//липовая заглушка
}
