package cinema.dao.impl;

import cinema.dao.AbstractDao;
import cinema.dao.RoleDao;
import cinema.exception.DataProcessingException;
import cinema.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory,Role.class);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Role> getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Role r WHERE r.roleType = :role", Role.class)
                    .setParameter("role", Role.RoleType.valueOf(name))
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find any role with name " + name, e);
        }
    }
}
