package beans;

//import View.ClientView;
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

//ClientView clientView;

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

//    /////////////Геттеры / Сеттеры /////////////////////////////////////////


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
            Client clientForDB = new Client();
            clientDAO.addMessage("0");
            clientForDB.setClientLastName(lastName);
//            clientForDB.setClientLastName(clientView.getLastName());
            clientDAO.addMessage("1");
            clientForDB.setClientFirstName(firstName);
//            clientForDB.setClientFirstName(clientView.getFirstName());
            clientDAO.addMessage("2");
            clientForDB.setClientFatherName(fatherName);
//            clientForDB.setClientFatherName(clientView.getFatherName());
            clientDAO.addMessage("3");
            clientForDB.setAdressHome(address);
//            clientForDB.setAdressHome(clientView.getAddress());
            clientDAO.addMessage("4");
            clientForDB.setClientPhoneNumder(phoneNumber);
//            clientForDB.setClientPhoneNumber(clientView.getPhoneNumber());
            clientDAO.addMessage("5");
            clientForDB.setE_mail(eMail);
//            clientForDB.setE_mail(clientView.geteMail());
            clientDAO.addMessage("6");
            clientForDB.setDateRegistration(dateRegistration);
//            clientForDB.setDateRegistration(clientView.getDateRegistration());
            clientDAO.addMessage("8");

        clientDAO.addClient(clientForDB);
        clientDAO.addMessage("9");
        }
        catch (Exception e){clientDAO.addMessage("Пиздец");}

    }

    public void deleted(){

        clientDAO.deleteClient(idInputClient);
    }//липовая заглушка
}
