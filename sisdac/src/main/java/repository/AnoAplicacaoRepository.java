package repository;

import filter.AnoAplicacaoFilter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import util.FacesUtil;
import model.dac.AnoAplicacao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.JpaUtil;

public class AnoAplicacaoRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    //@Inject
    EntityManager manager;

    public boolean save(AnoAplicacao ano) {
        try {
            manager = JpaUtil.getEntityManager();
            manager.getTransaction().begin();
            manager.persist(ano);
            manager.getTransaction().commit();
            FacesUtil.addInfoMessage(
                    "Salvo com sucesso!!!!");
            return true;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            FacesUtil.addErrorMessage("Erro ao salvar!!!!\n" + e.getMessage()
                    + " - " + e.getMessage());

            return false;

        }

    }

    public boolean saveOrUpdate(AnoAplicacao ano) {
        manager = JpaUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            if (ano.getId() > 0) {
                manager.merge(ano);

            } else {
                manager.persist(ano);
            }
            manager.getTransaction().commit();
            FacesUtil.addInfoMessage(
                    "Salvo com sucesso!!!!");
            return true;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            FacesUtil.addErrorMessage("Erro ao salvar!!!!\n" + e.getMessage()
                    + " - " + e.getMessage());
            return false;

        }
    }

    public boolean merge(AnoAplicacao ano) {
        try {
            manager = JpaUtil.getEntityManager();
            manager.merge(ano);
            FacesUtil.addInfoMessage(
                    "Salvo com sucesso!!!!");
            return true;
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao salvar!!!!\n" + e.getMessage()
                    + " - " + e.getMessage());
            return false;

        }
    }

    public boolean remove(AnoAplicacao ano) {
        try {
             manager = JpaUtil.getEntityManager();
            manager.getTransaction().begin();
            AnoAplicacao obj = manager.find(AnoAplicacao.class,ano.getId());
            manager.remove(obj);
            manager.getTransaction().commit();
            FacesUtil.addInfoMessage(
                    "Exclu�do com sucesso!!!!");
            return true;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            FacesUtil.addErrorMessage("Erro ao excluir!!!!\n" + e.getMessage()
                    + " - " + e.getMessage());
            return false;

        }
    }

    public Object getById(Long id) {
        try {
             manager = JpaUtil.getEntityManager();
            return manager.find(AnoAplicacao.class, (long) id);
        } catch (Exception e) {
            return null;

        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})

    public List listAll() {
        try {
             manager = JpaUtil.getEntityManager();
            return manager.createQuery("from AnoAplicacao").getResultList();
        } catch (Exception e) {
            return null;

        }
    }

    public List filtrados(AnoAplicacaoFilter filter) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(AnoAplicacao.class);

        if (filter.getId() > 0) {
            criteria.add(Restrictions.eq("id", filter.getId()));
        }

        if (filter.getAno() != null) {
            criteria.add(Restrictions.ilike("anoAplicacao", filter.getAno(), MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("anoAplicacao")).list();
    }

}
