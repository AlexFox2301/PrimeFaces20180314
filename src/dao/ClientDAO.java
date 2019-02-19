package dao;


import tables.Client;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClientDAO {

    @PersistenceContext
    EntityManager emClient;

    public List<Client> findAll(){
        return emClient.createQuery("select c from Client c").getResultList();
    }

    public Client findClint(int findId){
        return (Client) emClient.createQuery("select c from Client c where c.id = findId");
    }

    public void addClient (Client clientEntity){

        try {
            emClient.merge(clientEntity);
            addMessage("Запись добавлена в Базу данных");
            } catch (Exception e){

            addMessage("Провал!");
            }
    }

    public void deleteClient (int idDeletedClien){
//    public void deleteClient (Client client){

        try {
            emClient.remove(emClient.find(Client.class, idDeletedClien));
//            emClient.remove(client);
            addMessage("Запись удалена!");
        }catch (Exception e){
            addMessage("Пиздец!");
        }
    }


    public void editClient(Client editClient){
        try {
            emClient.merge(editClient);
            addMessage("Изменения сохранены");
        }catch (Exception e){
            addMessage("Поломалось");
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
