package dungeon.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dungeon");
		return factory.createEntityManager();
	}

}
