package beans;

import dao.ClientDAO;
import tables.Client;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
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

    private String searchText;

    /////////////Геттеры / Сеттеры /////////////////////////////////////////

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

    public void deleted(){}//липовая заглушка
}
