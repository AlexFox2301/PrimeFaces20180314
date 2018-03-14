package beans;

import dao.FittingDAO;
import tables.Fitting;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class FittingBean implements Serializable {

    @EJB
    FittingDAO fittingDAO;

    public List<Fitting> getFittings() {
        return fittingDAO.findAll();
    }

    ////////////Переменные/////////////////////////////////////////////////

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
