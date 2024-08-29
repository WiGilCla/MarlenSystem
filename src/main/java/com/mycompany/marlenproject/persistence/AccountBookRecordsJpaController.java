/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.AccountBookRecords;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AccountBookRecordsJpaController implements Serializable {

    public AccountBookRecordsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public AccountBookRecordsJpaController() {
        this.emf = Persistence.createEntityManagerFactory("MarlenProjectPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AccountBookRecords accountBookRecords) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(accountBookRecords);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AccountBookRecords accountBookRecords) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            accountBookRecords = em.merge(accountBookRecords);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = accountBookRecords.getRecordId();
                if (findAccountBookRecords(id) == null) {
                    throw new NonexistentEntityException("The accountBookRecords with id " + id + " no longer exists.");
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
            AccountBookRecords accountBookRecords;
            try {
                accountBookRecords = em.getReference(AccountBookRecords.class, id);
                accountBookRecords.getRecordId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accountBookRecords with id " + id + " no longer exists.", enfe);
            }
            em.remove(accountBookRecords);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AccountBookRecords> findAccountBookRecordsEntities() {
        return findAccountBookRecordsEntities(true, -1, -1);
    }

    public List<AccountBookRecords> findAccountBookRecordsEntities(int maxResults, int firstResult) {
        return findAccountBookRecordsEntities(false, maxResults, firstResult);
    }

    private List<AccountBookRecords> findAccountBookRecordsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AccountBookRecords.class));
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

    public AccountBookRecords findAccountBookRecords(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AccountBookRecords.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountBookRecordsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AccountBookRecords> rt = cq.from(AccountBookRecords.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<AccountBookRecords> findRecordsByBookId(AccountBook accountBook) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<AccountBookRecords> query = em.createQuery(
                    "SELECT abr FROM AccountBookRecords abr WHERE abr.accountBook = :accountBook", AccountBookRecords.class);
            query.setParameter("accountBook", accountBook);
            return query.getResultList();
        } catch (Exception e) {
            return null; 
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
