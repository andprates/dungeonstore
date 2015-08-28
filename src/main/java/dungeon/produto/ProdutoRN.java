package dungeon.produto;

import dungeon.produto.dao.ProdutoCronogramaDAO;
import dungeon.produto.dao.ProdutoDAO;
import dungeon.produto.entity.Produto;
import dungeon.produto.entity.ProdutoCronograma;
import dungeon.util.DAOFactory;
import dungeon.util.Mensagem;

public class ProdutoRN {
	
	private ProdutoDAO produtoDAO;
	private ProdutoCronogramaDAO produtoCronogramaDAO;

	public ProdutoRN() {
		this.produtoDAO = DAOFactory.criarProdutoDAO();
		this.produtoCronogramaDAO = DAOFactory.criarProdutoCronogramaDAO();
	}
	
	public void salvar(Produto produto, ProdutoCronograma cronograma){
			
			produto = salvarProduto(produto);
			cronograma.setProduto(produto);
			salvarCronograma(cronograma);
			Mensagem.mensagemInformacao("Cadastro salvo com sucesso!");
	}
	
	public Produto salvarProduto(Produto produto){
		try {
			return produtoDAO.salvar(produto);
		} catch (Exception e) {
			Mensagem.mensagemErro(e.getMessage());
		}
		return produto;
	}
	
	public void salvarCronograma(ProdutoCronograma cronograma){
		try {
			if(cronograma.getQtde() == 0){
				cronograma.setQtde(cronograma.getQtdeTamanhoP()+
						cronograma.getQtdeTamanhoM()+
						cronograma.getQtdeTamanhoG());
			}
			produtoCronogramaDAO.salvar(cronograma);
		} catch (Exception e) {
			Mensagem.mensagemErro(e.getMessage());
		}
	}

}
