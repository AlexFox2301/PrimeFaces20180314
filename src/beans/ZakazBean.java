package beans;

import dao.ZakazDAO;
import tables.Zakaz;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ZakazBean implements Serializable {

    @EJB
    ZakazDAO zakazDAO;

    public List<Zakaz> getZakazes(){
        return zakazDAO.findAll();
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

