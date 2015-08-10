package ua.bakum.aa.model.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Groupmembers.findAll", query = "select o from Groupmembers o") })
public class Groupmembers implements Serializable {
    private static final long serialVersionUID = -6701911344534320252L;
    @Column(name = "G_MEMBER", nullable = false, length = 30)
    private String gMember;
    @Id
    @Column(nullable = false, length = 50)
    private String id;
    @ManyToOne
    @JoinColumn(name = "G_NAME")
    private Groups groups;

    public Groupmembers() {
    }

    public Groupmembers(String gMember, Groups groups, String id) {
        this.gMember = gMember;
        this.groups = groups;
        this.id = id;
    }

    public String getGMember() {
        return gMember;
    }

    public void setGMember(String gMember) {
        this.gMember = gMember;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
}
