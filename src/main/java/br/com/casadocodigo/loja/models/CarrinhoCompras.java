package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();

	public void add(CarrinhoItem carrinhoItem) {
		itens.put(carrinhoItem, getQuantidade(carrinhoItem));
	}

	public Integer getQuantidade(CarrinhoItem carrinhoItem) {
		Integer qtd = Integer.valueOf(0);
		if (itens.containsKey(carrinhoItem)) {
			qtd = itens.get(carrinhoItem);
		}
		qtd++;
		return qtd;
	}

	public Integer getQuantidade() {
		Integer qtd = itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
		return qtd;
	}
	
	public BigDecimal getTotal(CarrinhoItem carrinhoItem) {
		return carrinhoItem.getTotal(getQuantidade(carrinhoItem));
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (CarrinhoItem item : itens.keySet()) {
			total = total.add(getTotal(item));
		}
		return total;
	}

	public void remover(Integer id, TipoPreco tipoPreco) {
		Produto produto = new Produto(id);
		itens.remove(new CarrinhoItem(produto, tipoPreco));
	}
}
