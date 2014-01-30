package factories;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerCreator {

        private final EntityManagerFactory factory;


        @Inject
        public EntityManagerCreator(EntityManagerFactory factory) {
                this.factory = factory;
        }

        @Produces
        @RequestScoped
        public EntityManager getEntityManager() {
                return factory.createEntityManager();
        }

        public void destroy(@Disposes EntityManager entityManager) {
                if (entityManager.isOpen()) {
                        entityManager.close();
                }
        }

}