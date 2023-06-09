package data;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerFactory {

	private static EntityManager manager;

	public static EntityManager getInstance() {
		if (manager == null) {
			manager = Persistence.createEntityManagerFactory("exemplo").createEntityManager();

		}
		return manager;
	}

}
