/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import com.mycompany.marlenproject.persistence.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AccountBookJpaController implements Serializable {

    public AccountBookJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public AccountBookJpaController() {
        this.emf = Persistence.createEntityManagerFactory("MarlenProjectPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AccountBook accountBook) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(accountBook);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAccountBook(accountBook.getAccountBookId()) != null) {
                throw new PreexistingEntityException("AccountBook " + accountBook + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AccountBook accountBook) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            accountBook = em.merge(accountBook);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = accountBook.getAccountBookId();
                if (findAccountBook(id) == null) {
                    throw new NonexistentEntityException("The accountBook with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AccountBook accountBook;
            try {
                accountBook = em.getReference(AccountBook.class, id);
                accountBook.getAccountBookId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accountBook with id " + id + " no longer exists.", enfe);
            }
            em.remove(accountBook);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AccountBook> findAccountBookEntities() {
        return findAccountBookEntities(true, -1, -1);
    }

    public List<AccountBook> findAccountBookEntities(int maxResults, int firstResult) {
        return findAccountBookEntities(false, maxResults, firstResult);
    }

    private List<AccountBook> findAccountBookEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AccountBook.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AccountBook findAccountBook(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AccountBook.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountBookCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AccountBook> rt = cq.from(AccountBook.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
