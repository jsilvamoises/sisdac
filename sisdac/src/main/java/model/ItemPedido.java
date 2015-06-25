package model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tbl_item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @Column(name="itp_id")
    @GeneratedValue(strategy= GenerationType.AUTO)    
	private long id;
    
    @Column(name="itp_quantidade", nullable=false)
	private int quantidade;
    
    @Column(name="itp_valor_unitario", nullable=false, precision=10 , scale = 2)
	private BigDecimal valorUnitario;
    
    @ManyToOne
    @JoinColumn(name="itp_produto_id", nullable=false)
	private ProdutoX produto;
    
    @ManyToOne
    @JoinColumn(name="itp_pedido_id")
    private PedidoX pedido;
    

	public ItemPedido() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public ProdutoX getProduto() {
		return produto;
	}

	public void setProduto(ProdutoX produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public PedidoX getPedido() {
		return pedido;
	}

	public void setPedido(PedidoX pedido) {
		this.pedido = pedido;
	}

}
