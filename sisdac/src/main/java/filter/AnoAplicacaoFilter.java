/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.Serializable;

/**
 *
 * @author MOISES
 */
public class AnoAplicacaoFilter implements Serializable{
    private long id;
    private String ano;

    public AnoAplicacaoFilter() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
}
