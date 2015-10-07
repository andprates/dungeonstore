package dungeon.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dungeon.produto.dao.ProdutoCronogramaDAO;
import dungeon.produto.dao.ProdutoDAO;
import dungeon.produto.entity.Produto;
import dungeon.produto.entity.ProdutoCronograma;
import dungeon.util.Mensagem;

@Service
public class ProdutoRN {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	@Autowired
	private ProdutoCronogramaDAO produtoCronogramaDAO;

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
