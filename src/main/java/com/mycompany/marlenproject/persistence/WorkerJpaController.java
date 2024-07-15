/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence;

import com.mycompany.marlenproject.logic.Worker;
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


public class WorkerJpaController implements Serializable {

    public WorkerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public WorkerJpaController() { 
        this.emf = Persistence.createEntityManagerFactory("MarlenProjectPU"); 
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Worker worker) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(worker);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Worker worker) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            worker = em.merge(worker);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = worker.getWorkerId();
                if (findWorker(id) == null) {
                    throw new NonexistentEntityException("The worker with id " + id + " no longer exists.");
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
            Worker worker;
            try {
                worker = em.getReference(Worker.class, id);
                worker.getWorkerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The worker with id " + id + " no longer exists.", enfe);
            }
            em.remove(worker);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Worker> findWorkerEntities() {
        return findWorkerEntities(true, -1, -1);
    }

    public List<Worker> findWorkerEntities(int maxResults, int firstResult) {
        return findWorkerEntities(false, maxResults, firstResult);
    }

    private List<Worker> findWorkerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Worker.class));
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

    public Worker findWorker(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Worker.class, id);
        } finally {
            em.close();
        }
    }

    public int getWorkerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Worker> rt = cq.from(Worker.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Worker> getNodeletedWorker(){
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Worker> query = em.createQuery(
                "SELECT w FROM Worker w WHERE w.IsDelete = false", Worker.class);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Worker findWorkerByDNI(int dni){
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Worker> query = em.createQuery(
                "SELECT w FROM Worker w WHERE w.person.identificationNumber = :dni", Worker.class);
            query.setParameter("dni", dni);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
