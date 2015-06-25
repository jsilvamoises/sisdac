package repository;

import filter.AnoAplicacaoFilter;
import interfaces.InterfaceRepository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import util.FacesUtil;
import model.dac.AnoAplicacao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AnoAplicacaoRepository implements Serializable, InterfaceRepository {

    private static final long serialVersionUID = 1L;

    @Inject
    EntityManager manager;

    @Override
    public boolean save(Object object) {
        try {
            manager.getTransaction().begin();
            manager.persist(object);
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

    @Override
    public boolean saveOrUpdate(Object object) {
        try {
            manager.getTransaction().begin();
            if (((AnoAplicacao) object).getId() > 0) {
                manager.merge(object);

            } else {
                manager.persist(object);
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

    @Override
    public boolean merge(Object object) {
        try {

            manager.merge(object);
            FacesUtil.addInfoMessage(
                    "Salvo com sucesso!!!!");
            return true;
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao salvar!!!!\n" + e.getMessage()
                    + " - " + e.getMessage());
            return false;

        }
    }

    @Override
    public boolean remove(Object object) {
        try {
            manager.getTransaction().begin();
            AnoAplicacao obj = manager.find(AnoAplicacao.class,
                    ((AnoAplicacao) object).getId());
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

    @Override
    public Object getById(Long id) {
        try {
            return manager.find(AnoAplicacao.class, (long) id);
        } catch (Exception e) {
            return null;

        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public List listAll() {
        try {
            return manager.createQuery("from AnoAplicacao").getResultList();
        } catch (Exception e) {
            return null;

        }
    }
    
    public List filtrados(AnoAplicacaoFilter filter){
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(AnoAplicacao.class);
        
        if(filter.getId()>0){
            criteria.add(Restrictions.eq("id", filter.getId()));
        }
        
        
        if(filter.getAno()!=null){
            criteria.add(Restrictions.ilike("anoAplicacao", filter.getAno(), MatchMode.ANYWHERE) );
        }
        
        return criteria.addOrder(Order.asc("anoAplicacao")).list();
    }

}
