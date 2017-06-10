package gugahh.faculdade;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import gugahh.faculdade.persistence.JPAUtil;
import gugahh.faculdade.util.PopulaEntidadesUtil;

public class TestePaises {

	public static void main(String[] args) {

		final Logger logger = Logger.getLogger(Teste2.class.getName());
		logger.info("=== Iniciando Execucao ===");
		
		EntityManager entityManager = null;
		
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
			
			logger.info(">>>>> Finalizado com Sucesso");
			
			PopulaEntidadesUtil.cadastraPaises(entityManager);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			logger.error(">>>>> Erro na Transacao 1: ", e);
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
			JPAUtil.shutdown();
			System.exit(0);
		}

	}

}
