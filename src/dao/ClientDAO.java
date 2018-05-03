package dao;

import tables.Client;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ClientDAO {

    @PersistenceContext
    EntityManager emClient;

    public List<Client> findAll(){
        return emClient.createQuery("select c from Client c").getResultList();
    }

    public void addClient (Client clientEntity){

        try {
            emClient.merge(clientEntity);
            addMessage("Запись добавлена в Базу данных");
            } catch (Exception e){
            addMessage("Провал!");
            }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
