/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dac;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Moises
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "tbl_aplicacao")
public class Aplicacao implements Serializable {		
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apl_id")
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "apl_modelo_id", nullable = false)
    @ForeignKey(name = "FK_APL_MODELO")
    private Modelo modelo;
    
    @NotNull	
    @ManyToOne
    @JoinColumn(name = "apl_ano_aplicacao_id", nullable = false)
    @ForeignKey(name="FK_APL_ANO_APLICACAO")
    private AnoAplicacao anoAplicacao;

    public Aplicacao() {
        modelo = new Modelo();
        anoAplicacao = new AnoAplicacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public AnoAplicacao getAnoAplicacao() {
        return anoAplicacao;
    }

    public void setAnoAplicacao(AnoAplicacao anoAplicacao) {
        this.anoAplicacao = anoAplicacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aplicacao other = (Aplicacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
    
    
}
