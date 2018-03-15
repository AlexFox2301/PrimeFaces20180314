package tables;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Zakaz {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Client client;
    @Basic
    private String orderName;
    @Basic
    private Date deadLine;
    @Basic
    private int costPrice;
    @Basic
    private int valueOrder;
    @Basic
    private String adressOrder;
    @Basic
    private String measurement;
    @Basic
    private String designModel;
    @Basic
    private String techDoc;
    @Basic
    private String confirmation;
    @Basic
    private String state;
    @ManyToOne
    private User employee;
    @Basic
    private Date actualDateOfDelivery;
    @Basic
    private String foto;
    @Basic
    private String note;

    //////////////////////////Геттеры / Сеттеры//////////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getDeadLine() {
        if (deadLine != null){
            SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy.MM.dd");
            return formatForDate.format(deadLine);
        }
        return null;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getValueOrder() {
        return valueOrder;
    }

    public void setValueOrder(int valueOrder) {
        this.valueOrder = valueOrder;
    }

    public String getAdressOrder() {
        return adressOrder;
    }

    public void setAdressOrder(String adressOrder) {
        this.adressOrder = adressOrder;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getDesignModel() {
        return designModel;
    }

    public void setDesignModel(String designModel) {
        this.designModel = designModel;
    }

    public String getTechDoc() {
        return techDoc;
    }

    public void setTechDoc(String techDoc) {
        this.techDoc = techDoc;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public String getActualDateOfDelivery() {
        if (actualDateOfDelivery != null){
            SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy.MM.dd");
            return formatForDate.format(actualDateOfDelivery);
        }
        return null;
    }

    public void setActualDateOfDelivery(Date actualDateOfDelivery) {
        this.actualDateOfDelivery = actualDateOfDelivery;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
