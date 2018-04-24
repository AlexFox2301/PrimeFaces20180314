package dao;

import com.mysql.jdbc.StringUtils;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import tables.User;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class UserDAO {

    @PersistenceContext
    EntityManager em;


    /////////////Конструкторы/////////////////////////////////////////

    public UserDAO() {
    }


    /////////////Методы/////////////////////////////////////////

    public List<User> findAll(){
        return em.createQuery("select u from User u").getResultList();
    }

    public boolean checkPassword (String login, String password){

        if (StringUtils.isEmptyOrWhitespaceOnly(login) || StringUtils.isEmptyOrWhitespaceOnly(password)){
            addMessage("Неверно введеный Логин или Пароль");
            return false;
        }

        User user = em.find(User.class, login);
        if (user == null){
            addMessage("Неверно введеный Логин или Пароль");
            return false;
        }

        if (password.equals(user.getPassword())){
            return true;
        }

        addMessage("Неверно введеный Логин или Пароль");
        return false;

    }

    public boolean addUser(User userEntity){

        em.persist(userEntity);
        addMessage("Запись добавлена в Базу данных");
        return true;
    }

    public void deleteUser(int id){

        em.remove(em.find(User.class, id));
        addMessage("Запись удалена из базы данных");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
