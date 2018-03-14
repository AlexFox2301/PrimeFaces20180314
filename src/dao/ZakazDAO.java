package dao;

import tables.Zakaz;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ZakazDAO {

    @PersistenceContext
    EntityManager emZakaz;

    public List<Zakaz> findAll(){
        return emZakaz.createQuery("select z from Zakaz z").getResultList();
    }
}

