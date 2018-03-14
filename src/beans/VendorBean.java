package beans;

import dao.VendorDAO;
import tables.Vendor;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class VendorBean implements Serializable {

    @EJB
    VendorDAO vendorDAO;

    public List<Vendor> getVendors(){
        return vendorDAO.findAll();
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

    public void search(){}//липовая заглушка

    public void deleted(){}//липовая заглушка
}
