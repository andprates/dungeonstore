package dungeon.produto.dao;

import dungeon.produto.entity.Produto;
import dungeon.util.DAOException;

public interface ProdutoDAO {
	
	public Produto salvar(Produto produto) throws DAOException;

}
