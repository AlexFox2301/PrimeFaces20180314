package beans;


import dao.ClientDAO;
import org.primefaces.event.RowEditEvent;
import tables.Client;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@Named
@ManagedBean
@SessionScoped
//@ManagedBean

public class ClientBean implements Serializable {

    @EJB
    ClientDAO clientDAO;

    public List<Client> getClients(){
        return clientDAO.findAll();
    }

    /////////////Переменные/////////////////////////////////////////////////

    private Client client;

    private int idInputClient;

    private String lastName;
    private String firstName;
    private String fatherName;
    private String address;
    private String phoneNumber;
    private String eMail;
    private Date dateRegistration;


    private String searchText;

//    /////////////Геттеры / Сеттеры /////////////////////////////////////////


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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

        public void search(){}//липовая заглушка

    public void createClient(){

        try{

//            client = clientDAO.
            Client clientForDB = new Client();
            clientDAO.addMessage("Создано");

            clientForDB.setClientLastName(this.lastName);
            clientDAO.addMessage(lastName);

            clientForDB.setClientFirstName(firstName);
            clientDAO.addMessage(firstName);

            clientForDB.setClientFatherName(fatherName);
            clientDAO.addMessage(fatherName);

            clientForDB.setAdressHome(address);
            clientDAO.addMessage(address);

            clientForDB.setClientPhoneNumder(phoneNumber);
            clientDAO.addMessage(phoneNumber);

            clientForDB.setE_mail(eMail);
            clientDAO.addMessage(eMail);

            clientForDB.setDateRegistration(dateRegistration);
            clientDAO.addMessage("Some date");

        clientDAO.addClient(clientForDB);
        clientDAO.addMessage("Добавлено");
        }
        catch (Exception e){clientDAO.addMessage("Пиздец");}
        lastName = null;
        firstName = null;
        fatherName = null;
        address = null;
        phoneNumber = null;
        eMail = null;
        dateRegistration = null;

    }

    public void deleted(){

        clientDAO.deleteClient(idInputClient);

//        clientDAO.deleteClient(client);
//        client = null;

    }

    public void editClient(){
        client = clientDAO.findClint(idInputClient);

        if (lastName.isEmpty()){client.getClientLastName();}
        else client.setClientLastName(lastName);

        if (firstName.isEmpty()){client.getClientFirstName();}
        else client.setClientFirstName(firstName);

        if (fatherName.isEmpty()){client.getClientFatherName();}
        else client.setClientFatherName(fatherName);

        if (address.isEmpty()){client.getAdressHome();}
        else client.setAdressHome(address);

        if (phoneNumber.isEmpty()){client.getClientPhoneNumder();}
        else client.setClientPhoneNumder(phoneNumber);

        if (eMail.isEmpty()){client.getE_mail();}
        else client.setE_mail(eMail);

        if (dateRegistration == null){client.getDateRegistration();}
        else client.setDateRegistration(dateRegistration);


        clientDAO.editClient(client);

        client = null;
    }
}
