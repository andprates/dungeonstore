package dungeon.util;

import dungeon.produto.dao.ProdutoCronogramaDAO;
import dungeon.produto.dao.ProdutoCronogramaDAOHibernate;
import dungeon.produto.dao.ProdutoDAO;
import dungeon.produto.dao.ProdutoDAOHibernate;
import dungeon.usuario.UsuarioDAO;
import dungeon.usuario.UsuarioDAOHibernate;

public class DAOFactory {
	
	public static UsuarioDAO criarUsuarioDAO(){
		return new UsuarioDAOHibernate(JPAUtil.getEntityManager());
	}
	
	public static ProdutoDAO criarProdutoDAO(){
		return new ProdutoDAOHibernate(JPAUtil.getEntityManager());
	}
	
	public static ProdutoCronogramaDAO criarProdutoCronogramaDAO(){
		return new ProdutoCronogramaDAOHibernate(JPAUtil.getEntityManager());
	}

}
