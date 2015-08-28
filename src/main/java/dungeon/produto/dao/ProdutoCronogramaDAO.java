package dungeon.produto.dao;

import dungeon.produto.entity.ProdutoCronograma;
import dungeon.util.DAOException;

public interface ProdutoCronogramaDAO {
	
	public void salvar(ProdutoCronograma cronograma) throws DAOException;

}
