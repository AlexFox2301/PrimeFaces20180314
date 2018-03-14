package dao;

import tables.Fitting;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FittingDAO {

    @PersistenceContext
    EntityManager emFitting;

    public List<Fitting> findAll(){
        return emFitting.createQuery("select f from Fitting f").getResultList();
    }
}
