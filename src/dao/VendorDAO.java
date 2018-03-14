package dao;

import tables.Vendor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class VendorDAO {

    @PersistenceContext
    EntityManager emVendor;

    public List<Vendor> findAll(){
        return emVendor.createQuery("select v from Vendor v").getResultList();
    }
}
