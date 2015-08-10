package ua.bakum.aa.model.ejb;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Users.findAll", query = "select o from Users o") })
public class Users implements Serializable {
    private static final long serialVersionUID = -9181081278050145644L;
    @Column(name = "DATE_BEFIRE_ACCEPT")
    private Integer dateBefireAccept;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_BEFORE")
    private Date dateBefore;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;
    @Id
    @Column(nullable = false, length = 50)
    private String id;
    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive;
    @Column(name = "IS_ADMIN", nullable = false)
    private Integer isAdmin;
    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;
    private byte[] photo;
    @Column(nullable = false)
    private Integer predefined;
    @Column(name = "U_DESCRIPTION", length = 1000)
    private String uDescription;
    @Column(name = "U_NAME", nullable = false, unique = true, length = 30)
    private String uName;
    @Column(name = "U_PASSWORD", nullable = false, length = 100)
    private String uPassword;
    @Column(nullable = false)
    private Timestamp version;

    public Users() {
    }

    public Users(Integer dateBefireAccept, Date dateBefore, String email, String firstName, String id, Integer isActive,
                 Integer isAdmin, String lastName, Integer predefined, String uDescription, String uName,
                 String uPassword, Timestamp version) {
        this.dateBefireAccept = dateBefireAccept;
        this.dateBefore = dateBefore;
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.lastName = lastName;
        this.predefined = predefined;
        this.uDescription = uDescription;
        this.uName = uName;
        this.uPassword = uPassword;
        this.version = version;
    }

    public Integer getDateBefireAccept() {
        return dateBefireAccept;
    }

    public void setDateBefireAccept(Integer dateBefireAccept) {
        this.dateBefireAccept = dateBefireAccept;
    }

    public Date getDateBefore() {
        return dateBefore;
    }

    public void setDateBefore(Date dateBefore) {
        this.dateBefore = dateBefore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getPredefined() {
        return predefined;
    }

    public void setPredefined(Integer predefined) {
        this.predefined = predefined;
    }

    public String getUDescription() {
        return uDescription;
    }

    public void setUDescription(String uDescription) {
        this.uDescription = uDescription;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }
}
