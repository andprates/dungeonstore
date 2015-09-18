package dungeon.produto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dungeon.produto.entity.Produto;
import dungeon.produto.entity.ProdutoCronograma;
import dungeon.produto.entity.TipoRoupa;

@ManagedBean
@RequestScoped
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 6759920929897774824L;

	Produto produto = new Produto();
	ProdutoCronograma cronograma = new ProdutoCronograma();
	ProdutoRN produtoRN = new ProdutoRN();
	Double estimativaVenda = 0.0;
	boolean mostrarRoupa;
	List<TipoRoupa> tipoRoupas;

	public String novo(){
		this.produto = new Produto();
		this.cronograma = new ProdutoCronograma();
		return "/restrito/cadastroProduto";
	}
	
	public void salvar(){
		produto.setRoupa(isMostrarRoupa());
		produtoRN.salvar(produto, cronograma);
		this.produto = new Produto();
		this.cronograma = new ProdutoCronograma();
	}
	/**
	 * Calcula a estimativa de venda subtraindo 10% do valor do pagseguro
	 */
	public void calcularEstimativaVenda(){
		this.estimativaVenda = cronograma.getValorPagseguro() - (cronograma.getValorPagseguro() * 10) /100 ;
	}
	/**
	 * Recupera data atual do sistema
	 * @return
	 */
	public String getDataAtual(){
		return new SimpleDateFormat("dd/MM/yyyy")
			.format(new Date());
	}
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoCronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(ProdutoCronograma cronograma) {
		this.cronograma = cronograma;
	}

	public Double getEstimativaVenda() {
		return estimativaVenda;
	}

	public void setEstimativaVenda(Double estimativaVenda) {
		this.estimativaVenda = estimativaVenda;
	}

	public boolean isMostrarRoupa() {
		return mostrarRoupa;
	}

	public void setMostrarRoupa(boolean mostrarRoupa) {
		this.mostrarRoupa = mostrarRoupa;
	}

	public List<TipoRoupa> getTipoRoupas() {
		return tipoRoupas;
	}

	public void setTipoRoupas(List<TipoRoupa> tipoRoupas) {
		this.tipoRoupas = tipoRoupas;
	}
	
	
	

}
