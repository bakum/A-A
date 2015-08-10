package ua.bakum.aa.model.ejb;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Groups.findAll", query = "select o from Groups o") })
public class Groups implements Serializable {
    private static final long serialVersionUID = 6101731730132676847L;
    @Column(name = "G_DESCRIPTION", length = 1000)
    private String gDescription;
    @Column(name = "G_NAME", nullable = false, unique = true, length = 50)
    private String gName;
    @Id
    @Column(nullable = false, length = 50)
    private String id;
    @OneToMany(mappedBy = "groups", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Groupmembers> groupmembersList;

    public Groups() {
    }

    public Groups(String gDescription, String gName, String id) {
        this.gDescription = gDescription;
        this.gName = gName;
        this.id = id;
    }

    public String getGDescription() {
        return gDescription;
    }

    public void setGDescription(String gDescription) {
        this.gDescription = gDescription;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Groupmembers> getGroupmembersList() {
        return groupmembersList;
    }

    public void setGroupmembersList(List<Groupmembers> groupmembersList) {
        this.groupmembersList = groupmembersList;
    }

    public Groupmembers addGroupmembers(Groupmembers groupmembers) {
        getGroupmembersList().add(groupmembers);
        groupmembers.setGroups(this);
        return groupmembers;
    }

    public Groupmembers removeGroupmembers(Groupmembers groupmembers) {
        getGroupmembersList().remove(groupmembers);
        groupmembers.setGroups(null);
        return groupmembers;
    }
}
