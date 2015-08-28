package dungeon.produto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class ProdutoCronograma implements Serializable {
	
	private static final long serialVersionUID = 2622191778841862156L;

	@Id
	@GeneratedValue
	private Integer id;
	private Date dataCompra;
	private Double valorCompra;
	private Double valorPagseguro;
	private Integer qtde = 0;
	private Integer qtdeTamanhoP = 0;
	private Integer qtdeTamanhoM = 0;
	private Integer qtdeTamanhoG = 0;
	private Integer numeroNotaFiscal;
	@ManyToOne(fetch= FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "produto", nullable = false, foreignKey = @ForeignKey(name = "fk_cronograma_produto"))
	private Produto produto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Double getValorPagseguro() {
		return valorPagseguro;
	}
	public void setValorPagseguro(Double valorPagseguro) {
		this.valorPagseguro = valorPagseguro;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public Integer getQtdeTamanhoP() {
		return qtdeTamanhoP;
	}
	public void setQtdeTamanhoP(Integer qtdeTamanhoP) {
		this.qtdeTamanhoP = qtdeTamanhoP;
	}
	public Integer getQtdeTamanhoM() {
		return qtdeTamanhoM;
	}
	public void setQtdeTamanhoM(Integer qtdeTamanhoM) {
		this.qtdeTamanhoM = qtdeTamanhoM;
	}
	public Integer getQtdeTamanhoG() {
		return qtdeTamanhoG;
	}
	public void setQtdeTamanhoG(Integer qtdeTamanhoG) {
		this.qtdeTamanhoG = qtdeTamanhoG;
	}
	public Integer getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}
	public void setNumeroNotaFiscal(Integer numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCompra == null) ? 0 : dataCompra.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeroNotaFiscal == null) ? 0 : numeroNotaFiscal.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qtde == null) ? 0 : qtde.hashCode());
		result = prime * result + ((qtdeTamanhoG == null) ? 0 : qtdeTamanhoG.hashCode());
		result = prime * result + ((qtdeTamanhoM == null) ? 0 : qtdeTamanhoM.hashCode());
		result = prime * result + ((qtdeTamanhoP == null) ? 0 : qtdeTamanhoP.hashCode());
		result = prime * result + ((valorCompra == null) ? 0 : valorCompra.hashCode());
		result = prime * result + ((valorPagseguro == null) ? 0 : valorPagseguro.hashCode());
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
		ProdutoCronograma other = (ProdutoCronograma) obj;
		if (dataCompra == null) {
			if (other.dataCompra != null)
				return false;
		} else if (!dataCompra.equals(other.dataCompra))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numeroNotaFiscal == null) {
			if (other.numeroNotaFiscal != null)
				return false;
		} else if (!numeroNotaFiscal.equals(other.numeroNotaFiscal))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtde == null) {
			if (other.qtde != null)
				return false;
		} else if (!qtde.equals(other.qtde))
			return false;
		if (qtdeTamanhoG == null) {
			if (other.qtdeTamanhoG != null)
				return false;
		} else if (!qtdeTamanhoG.equals(other.qtdeTamanhoG))
			return false;
		if (qtdeTamanhoM == null) {
			if (other.qtdeTamanhoM != null)
				return false;
		} else if (!qtdeTamanhoM.equals(other.qtdeTamanhoM))
			return false;
		if (qtdeTamanhoP == null) {
			if (other.qtdeTamanhoP != null)
				return false;
		} else if (!qtdeTamanhoP.equals(other.qtdeTamanhoP))
			return false;
		if (valorCompra == null) {
			if (other.valorCompra != null)
				return false;
		} else if (!valorCompra.equals(other.valorCompra))
			return false;
		if (valorPagseguro == null) {
			if (other.valorPagseguro != null)
				return false;
		} else if (!valorPagseguro.equals(other.valorPagseguro))
			return false;
		return true;
	}
	
	
}
