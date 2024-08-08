/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence;

import com.mycompany.marlenproject.logic.AccountBook;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.marlenproject.logic.AccountBookRecords;
import com.mycompany.marlenproject.persistence.exceptions.IllegalOrphanException;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import com.mycompany.marlenproject.persistence.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author willy
 */
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
        if (accountBook.getListBookRecords() == null) {
            accountBook.setListBookRecords(new ArrayList<AccountBookRecords>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<AccountBookRecords> attachedListBookRecords = new ArrayList<AccountBookRecords>();
            for (AccountBookRecords listBookRecordsAccountBookRecordsToAttach : accountBook.getListBookRecords()) {
                listBookRecordsAccountBookRecordsToAttach = em.getReference(listBookRecordsAccountBookRecordsToAttach.getClass(), listBookRecordsAccountBookRecordsToAttach.getRecordId());
                attachedListBookRecords.add(listBookRecordsAccountBookRecordsToAttach);
            }
            accountBook.setListBookRecords(attachedListBookRecords);
            em.persist(accountBook);
            for (AccountBookRecords listBookRecordsAccountBookRecords : accountBook.getListBookRecords()) {
                AccountBook oldAccountBookIdOfListBookRecordsAccountBookRecords = listBookRecordsAccountBookRecords.getAccountBookId();
                listBookRecordsAccountBookRecords.setAccountBookId(accountBook);
                listBookRecordsAccountBookRecords = em.merge(listBookRecordsAccountBookRecords);
                if (oldAccountBookIdOfListBookRecordsAccountBookRecords != null) {
                    oldAccountBookIdOfListBookRecordsAccountBookRecords.getListBookRecords().remove(listBookRecordsAccountBookRecords);
                    oldAccountBookIdOfListBookRecordsAccountBookRecords = em.merge(oldAccountBookIdOfListBookRecordsAccountBookRecords);
                }
            }
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

    public void edit(AccountBook accountBook) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AccountBook persistentAccountBook = em.find(AccountBook.class, accountBook.getAccountBookId());
            List<AccountBookRecords> listBookRecordsOld = persistentAccountBook.getListBookRecords();
            List<AccountBookRecords> listBookRecordsNew = accountBook.getListBookRecords();
            List<String> illegalOrphanMessages = null;
            for (AccountBookRecords listBookRecordsOldAccountBookRecords : listBookRecordsOld) {
                if (!listBookRecordsNew.contains(listBookRecordsOldAccountBookRecords)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AccountBookRecords " + listBookRecordsOldAccountBookRecords + " since its accountBookId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<AccountBookRecords> attachedListBookRecordsNew = new ArrayList<AccountBookRecords>();
            for (AccountBookRecords listBookRecordsNewAccountBookRecordsToAttach : listBookRecordsNew) {
                listBookRecordsNewAccountBookRecordsToAttach = em.getReference(listBookRecordsNewAccountBookRecordsToAttach.getClass(), listBookRecordsNewAccountBookRecordsToAttach.getRecordId());
                attachedListBookRecordsNew.add(listBookRecordsNewAccountBookRecordsToAttach);
            }
            listBookRecordsNew = attachedListBookRecordsNew;
            accountBook.setListBookRecords(listBookRecordsNew);
            accountBook = em.merge(accountBook);
            for (AccountBookRecords listBookRecordsNewAccountBookRecords : listBookRecordsNew) {
                if (!listBookRecordsOld.contains(listBookRecordsNewAccountBookRecords)) {
                    AccountBook oldAccountBookIdOfListBookRecordsNewAccountBookRecords = listBookRecordsNewAccountBookRecords.getAccountBookId();
                    listBookRecordsNewAccountBookRecords.setAccountBookId(accountBook);
                    listBookRecordsNewAccountBookRecords = em.merge(listBookRecordsNewAccountBookRecords);
                    if (oldAccountBookIdOfListBookRecordsNewAccountBookRecords != null && !oldAccountBookIdOfListBookRecordsNewAccountBookRecords.equals(accountBook)) {
                        oldAccountBookIdOfListBookRecordsNewAccountBookRecords.getListBookRecords().remove(listBookRecordsNewAccountBookRecords);
                        oldAccountBookIdOfListBookRecordsNewAccountBookRecords = em.merge(oldAccountBookIdOfListBookRecordsNewAccountBookRecords);
                    }
                }
            }
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

    public void destroy(int id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<AccountBookRecords> listBookRecordsOrphanCheck = accountBook.getListBookRecords();
            for (AccountBookRecords listBookRecordsOrphanCheckAccountBookRecords : listBookRecordsOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This AccountBook (" + accountBook + ") cannot be destroyed since the AccountBookRecords " + listBookRecordsOrphanCheckAccountBookRecords + " in its listBookRecords field has a non-nullable accountBookId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
