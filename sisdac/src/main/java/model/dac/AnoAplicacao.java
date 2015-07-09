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
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Moises
 */
@Entity
@Table(name = "tbl_ano_aplicacao")
public class AnoAplicacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aap_id")
    private Long id;

    @NotBlank
    @Column(name = "aap_ano_aplicacao", unique = true)
    private String anoAplicacao;

    public AnoAplicacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnoAplicacao() {
        return anoAplicacao;
    }

    public void setAnoAplicacao(String anoAplicacao) {
        this.anoAplicacao = anoAplicacao.toUpperCase();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final AnoAplicacao other = (AnoAplicacao) obj;
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
