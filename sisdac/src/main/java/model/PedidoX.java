package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.FormaPagamento;
import enums.StatusPedido;

@Entity
@Table(name = "tbl_pedido")
public class PedidoX implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ped_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ped_data_criacao", nullable = false)
	private Calendar dataCriacao;

	

	@Temporal(TemporalType.DATE)
	@Column(name = "ped_data_entrega", nullable = false)
	private Calendar dataEntrega;

	@Column(name = "ped_valor_frete", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorFrete;

	@Column(name = "ped_valor_desconto", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorDesconto;

	@Column(name = "ped_valor_total", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "ped_cliente_id", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "ped_vendedor_id", nullable = false)
	private UsuarioX vendedor;

	@Enumerated(EnumType.STRING)
	@Column(name = "ped_forma_pagamento")
	private FormaPagamento formaPagamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "ped_status_pedido")
	private StatusPedido statusPedido;
    
	@Embedded
	private EnderecoEntrega enderecoEntrega;
	
	@OneToMany(mappedBy="pedido", cascade =CascadeType.ALL, orphanRemoval = true)
	private List<ItemPedido> itensPedido;	

	public PedidoX() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public UsuarioX getVendedor() {
		return vendedor;
	}

	public void setVendedor(UsuarioX vendedor) {
		this.vendedor = vendedor;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public EnderecoEntrega getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
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
		PedidoX other = (PedidoX) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
