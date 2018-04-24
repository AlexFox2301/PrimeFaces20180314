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

    int id;
//    private String foto;
    private String lastName;
    private String firstName;
    private String fatherName;
    private String position;
    private String address;
    private String phoneNumber;
    private String e_mail;
    private String login;
    private String password;
    private Date dateAdmissiom;
    private Date dateOfDismissal;

    private boolean loginSuccess;
    private boolean createSuccess;

    private String searchText;
    private String sub;

    private UploadedFile file;

    private User user = new User();

    /////////////Конструкторы/////////////////////////////////////////

    public UserBean() {
    }


    /////////////Геттеры / Сеттеры /////////////////////////////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


//    public String getFoto() {
//        return foto;
//    }
//
//    public void setFoto(String foto) {
//        this.foto = foto;
//    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Date getDateAdmissiom() {
        return dateAdmissiom;
    }

    public void setDateAdmissiom(Date dateAdmissiom) {
        this.dateAdmissiom = dateAdmissiom;
    }

    public Date getDateOfDismissal() {
        return dateOfDismissal;
    }

    public void setDateOfDismissal(Date dateOfDismissal) {
        this.dateOfDismissal = dateOfDismissal;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public void createUser(){

        User userFromDB = new User();
        userFromDB.setLastName(lastName);
        userFromDB.setFirstName(firstName);
        userFromDB.setFatherName(fatherName);
        userFromDB.setPosition(position);
        userFromDB.setAddress(address);
        userFromDB.setPhoneNumber(phoneNumber);
        userFromDB.setE_mail(e_mail);
        userFromDB.setLogin(login);
        userFromDB.setPassword(password);
        userFromDB.setDateAdmissiom(dateAdmissiom);
        userFromDB.setDateOfDismissal(dateOfDismissal);

        userDAO.addUser(userFromDB);//();
    }


    public void checkPassword(){
        loginSuccess = userDAO.checkPassword(login, password);
    }

    public void search(){}//липовая заглушка

    public void deleted(int id){

        userDAO.deleteUser(id);

    }//липовая заглушка

    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
