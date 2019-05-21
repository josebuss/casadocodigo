package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

public class CarrinhoItem {

	private Produto produto;
	private TipoPreco tipoPreco;
	

	public BigDecimal getPreco() {
		return produto.precoPara(tipoPreco);
	}
	
	public CarrinhoItem(Produto produto, TipoPreco tipoPreco) {
		this.setProduto(produto);
		this.setTipoPreco(tipoPreco);
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}


	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public BigDecimal getTotal(Integer quantidade) {
		return this.getPreco().multiply(BigDecimal.valueOf(quantidade));
	}
}
