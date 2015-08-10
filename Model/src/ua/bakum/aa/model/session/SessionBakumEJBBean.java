package ua.bakum.aa.model.session;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ua.bakum.aa.model.ejb.Groupmembers;
import ua.bakum.aa.model.ejb.Groups;
import ua.bakum.aa.model.ejb.Users;
import ua.bakum.aa.model.ejb.WlsSettings;

@Stateless(name = "SessionBakumEJB", mappedName = "A&A-Model-SessionBakumEJB")
public class SessionBakumEJBBean implements SessionBakumEJB, SessionBakumEJBLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    public SessionBakumEJBBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public void removeWlsSettings(WlsSettings wlsSettings) {
        wlsSettings = em.find(WlsSettings.class, wlsSettings.getId());
        em.remove(wlsSettings);
    }

    /** <code>select o from WlsSettings o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<WlsSettings> getWlsSettingsFindAll() {
        return em.createNamedQuery("WlsSettings.findAll", WlsSettings.class).getResultList();
    }

    public Users persistUsers(Users users) {
        em.persist(users);
        return users;
    }

    public Users mergeUsers(Users users) {
        return em.merge(users);
    }

    /** <code>select o from Users o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersFindAll() {
        return em.createNamedQuery("Users.findAll", Users.class).getResultList();
    }

    /** <code>select o from Groups o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Groups> getGroupsFindAll() {
        return em.createNamedQuery("Groups.findAll", Groups.class).getResultList();
    }

    public Groupmembers persistGroupmembers(Groupmembers groupmembers) {
        em.persist(groupmembers);
        return groupmembers;
    }

    public Groupmembers mergeGroupmembers(Groupmembers groupmembers) {
        return em.merge(groupmembers);
    }

    public void removeGroupmembers(Groupmembers groupmembers) {
        groupmembers = em.find(Groupmembers.class, groupmembers.getId());
        em.remove(groupmembers);
    }

    /** <code>select o from Groupmembers o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Groupmembers> getGroupmembersFindAll() {
        return em.createNamedQuery("Groupmembers.findAll", Groupmembers.class).getResultList();
    }
}
