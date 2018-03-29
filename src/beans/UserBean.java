package beans;

import dao.UserDAO;
import org.primefaces.model.UploadedFile;
import tables.User;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class UserBean implements Serializable{
    @EJB
    UserDAO userDAO;

    public List<User> getUsers(){
        return userDAO.findAll();
    }

    /////////////Переменные/////////////////////////////////////////////////

    private String login;
    private String password;

    private boolean loginSuccess;
    private boolean createSuccess;

    private String searchText;
    private String sub;

    private UploadedFile file;

    private User user;

    /////////////Геттеры / Сеттеры /////////////////////////////////////////


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean isCreateSuccess() {
        return createSuccess;
    }

    public void setCreateSuccess(boolean createSuccess) {
        this.createSuccess = createSuccess;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    ///////////////Методы//////////////////////////////////////////////////

    public User createUser(){

        String lastName = "";
        String firstName = "";
        String fatherName = "";
        String position = "";
        String address = "";
        String phoneNumber = "";
        String e_mail = "";
        String login = "";
        String password = "";
        Date dateAdmissiom = null;
        Date dateOfDismissal = null;

        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setFatherName(fatherName);
        user.setPosition(position);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        user.setE_mail(e_mail);
        user.setLogin(login);
        user.setPassword(password);
        user.setDateAdmissiom(dateAdmissiom);
        user.setDateOfDismissal(dateOfDismissal);

        return user;
    }

    public void addUser(User user){
        userDAO.addUser(user);
        user = null;
    }

    public void checkPassword(){
        loginSuccess = userDAO.checkPassword(login, password);
    }

    public void search(){}//липовая заглушка

    public void deleted(){}//липовая заглушка

    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
