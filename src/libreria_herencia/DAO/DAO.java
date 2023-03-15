package libreria_herencia.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public DAO() {
        emf = Persistence.createEntityManagerFactory("libreria2");
        em = emf.createEntityManager();
    }

    protected void conect() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    protected void disconect() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void create(T object) {
        conect();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        disconect();
    }

    protected void update(T object) {
        conect();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        disconect();
    }

    protected void delete(T object) {

        conect();
        em.getTransaction().begin();
        if (!em.contains(object)) {
            object = em.merge(object);
        }
        em.remove(object);
        em.getTransaction().commit();
        disconect();
    }
}
