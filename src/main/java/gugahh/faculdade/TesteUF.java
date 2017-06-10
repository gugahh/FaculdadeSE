package gugahh.faculdade;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import gugahh.faculdade.dao.UfDAO;
import gugahh.faculdade.persistence.JPAUtil;
import gugahh.faculdade.util.PopulaEntidadesUtil;

public class TesteUF {
	
	public static void main(String[] args) {
		
		final Logger logger = Logger.getLogger(Teste2.class.getName());
		logger.info("=== Iniciando Execucao ===");
		
		EntityManager entityManager = null;
		
		/**
		 * Primeira transacao: Cria os objetos
		 */
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
			
			UfDAO ufDAO = UfDAO.getDAO(entityManager);
	
			PopulaEntidadesUtil.cadastraUFs(entityManager);
			entityManager.getTransaction().commit();
			
			logger.info(">>>>> Finalizado com Sucesso");
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
