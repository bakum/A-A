package ua.bakum.aa.model.session;

import java.util.List;

import javax.ejb.Remote;

import ua.bakum.aa.model.ejb.Groupmembers;
import ua.bakum.aa.model.ejb.Groups;
import ua.bakum.aa.model.ejb.Users;
import ua.bakum.aa.model.ejb.WlsSettings;

@Remote
public interface SessionBakumEJB {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    void removeWlsSettings(WlsSettings wlsSettings);

    List<WlsSettings> getWlsSettingsFindAll();

    Users persistUsers(Users users);

    Users mergeUsers(Users users);

    List<Users> getUsersFindAll();

    List<Groups> getGroupsFindAll();

    Groupmembers persistGroupmembers(Groupmembers groupmembers);

    Groupmembers mergeGroupmembers(Groupmembers groupmembers);

    void removeGroupmembers(Groupmembers groupmembers);

    List<Groupmembers> getGroupmembersFindAll();
}
