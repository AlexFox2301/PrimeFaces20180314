package dao;

import tables.Client;

import javax.ejb.Stateless;
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
}
