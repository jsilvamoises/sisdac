/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import filter.AnoAplicacaoFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.dac.AnoAplicacao;

import repository.AnoAplicacaoRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class BeanAnoAplicacao implements Serializable{
    
    private AnoAplicacao anoAplicacao = new AnoAplicacao();
    private List<AnoAplicacao> anos = new ArrayList<>();
    
   //@Inject
    AnoAplicacaoRepository repository = new AnoAplicacaoRepository();
    
    private String idEdicao;
    
   // @Inject
    private AnoAplicacaoFilter filter = new AnoAplicacaoFilter();

    public BeanAnoAplicacao() {
        System.out.println("Criando objeto");
       anoAplicacao = new AnoAplicacao();
    }
    
    public void editar(){
        if(idEdicao!=null){
            try {
                long id = Long.parseLong(idEdicao);
                anoAplicacao = (AnoAplicacao) repository.getById(id);
            } catch (Exception e) {
            }
            
        }
    }
    
    public void listarFiltrados(){
        anos = repository.filtrados(filter);
    }
    
    
    public void init(){
        listarFiltrados();
    }
    
    public void save(){
        if(repository.saveOrUpdate(anoAplicacao)){
            clear();
        }
    }
    
    public void delete(){
        if(repository.remove(anoAplicacao)){
            clear();
        }
    }
    
    
    public void listarTodos(){
        anos = repository.listAll();
    }

    public AnoAplicacao getAnoAplicacao() {
        return anoAplicacao;
    }
    
    public void clear(){
        anoAplicacao = new AnoAplicacao();
    }

    public void setAnoAplicacao(AnoAplicacao anoAplicacao) {
        this.anoAplicacao = anoAplicacao;
    }

    public List<AnoAplicacao> getAnos() {
        return anos;
    }

    public void setAnos(List<AnoAplicacao> anos) {
        this.anos = anos;
    }

    public AnoAplicacaoFilter getFilter() {
        return filter;
    }

    public void setFilter(AnoAplicacaoFilter filter) {
        this.filter = filter;
    }

    public String getIdEdicao() {
        return idEdicao;
    }

    public void setIdEdicao(String idEdicao) {
        this.idEdicao = idEdicao;
    }
    
    
    
    
    
    
}
