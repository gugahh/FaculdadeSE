package gugahh.faculdade;

import static gugahh.faculdade.util.PopulaEntidadesUtil.CURSO_ADVOCACIA;
import static gugahh.faculdade.util.PopulaEntidadesUtil.CURSO_ARQUITETURA;
import static gugahh.faculdade.util.PopulaEntidadesUtil.CURSO_COMUNICACAO;
import static gugahh.faculdade.util.PopulaEntidadesUtil.CURSO_ENG_CIVIL;
import static gugahh.faculdade.util.PopulaEntidadesUtil.EDUARDO_CUNHA;
import static gugahh.faculdade.util.PopulaEntidadesUtil.FRANK_LLOYD_RIGHT;
import static gugahh.faculdade.util.PopulaEntidadesUtil.MICHEL_TEMER;
import static gugahh.faculdade.util.PopulaEntidadesUtil.OSCAR_NIEMEYER;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import gugahh.faculdade.dao.CursoDAO;
import gugahh.faculdade.dao.ProfessorDAO;
import gugahh.faculdade.embeddable.Endereco;
import gugahh.faculdade.entity.Curso;
import gugahh.faculdade.entity.Professor;
import gugahh.faculdade.persistence.JPAUtil;
import gugahh.faculdade.util.PopulaEntidadesUtil;

/**
 * Teste utilizando uma unica transacao
 * @author Gugahh
 *
 */
public class MainTest {

	public static void main(String[] args) {

		final Logger logger = Logger.getLogger(MainTest.class.getName());
		logger.info("=== Iniciando Execucao ===");
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {

			// Check database version
			//checkDatabaseVersion(entityManager);
			
			//Inicializando DAOs
			CursoDAO cursoDAO = CursoDAO.getDAO(entityManager);
			ProfessorDAO professorDAO = ProfessorDAO.getDAO(entityManager);
	
			//PopulaEntidadesUtil.cadastraCursos(entityManager);
			//PopulaEntidadesUtil.cadastraProfessores(entityManager);
			
			logger.info("== Obtendo Cursos Especificos ==");
			Curso advocacia = cursoDAO.findByName(CURSO_ADVOCACIA);
			Curso arquitetura = cursoDAO.findByName(CURSO_ARQUITETURA);
			Curso comunicacao = cursoDAO.findByName(CURSO_COMUNICACAO);
			Curso engCivil = cursoDAO.findByName(CURSO_ENG_CIVIL);
			
			logger.info("== Obtendo Professores Especificos ==");
			Professor frank = professorDAO.findByName(FRANK_LLOYD_RIGHT);
			Professor niemeyer = professorDAO.findByName(OSCAR_NIEMEYER);
			Professor temer = professorDAO.findByName(MICHEL_TEMER);
			Professor cunha = professorDAO.findByName(EDUARDO_CUNHA);
			
			logger.info("== Adicionando Professores aos cursos =="); /*
			frank.setCurso(arquitetura);
			niemeyer.setCurso(arquitetura);
			temer.setCurso(advocacia);
			cunha.setCurso(advocacia); */
			
			/*
			logger.info("== Atribuindo Endereco a um dos Professores ==");
			Endereco endTemer1 = new Endereco();
			endTemer1.setPais("Brasil");
			endTemer1.setMunicipio("Brasília");
			endTemer1.setLogradouro("SQN 115 (Norte) Bloco J");
			endTemer1.setNumeroApto("118");
			endTemer1.setComplemento("Ao lado da Pizzaria");
			temer.setEndereco(endTemer1); */
		
			//Atualizando os professores
			/*
			professorDAO.persist(temer);
			professorDAO.persist(cunha);
			professorDAO.persist(frank);
			professorDAO.persist(niemeyer); */
			
			//Forcando a atualizacao do BD
			//entityManager.getTransaction().commit();
			//entityManager.flush();
			
			//Uma nova transacao!!
			//entityManager.getTransaction().begin();

			//Re-obtendo os Cursos e seus Professores
			logger.info(" == Re-obtendo os Cursos ==");
			List<Curso> cursos = cursoDAO.findAll();
			for (Curso curso : cursos) {
				//cursoDAO.merge(curso);
				logger.info(">> Curso: " + curso.getNomeCurso());
				if (curso.getProfessores() != null && curso.getProfessores().size() > 0) {
					for (Professor professor : curso.getProfessores()) {
						
						logger.info("\tProfessor: " + professor.getNome());
						logger.info("\t\tPossui Vaga?: " + (professor.getVagaEstacionamento() != null ? "Sim" : "Não"));
						if (professor.getVagaEstacionamento() != null) {
							logger.info("\t\tVaga: " + professor.getVagaEstacionamento().getCodVaga());
						}
					}
				} else {
					logger.info("\t(Curso nao possui professores)");
				}
			}
			logger.info("== Fim do Loop ==");
	
			entityManager.getTransaction().commit();
			logger.info(">>>>> Execucao Terminada (Com Sucesso).");
		} catch (Exception e) {
			logger.error(">>>> Erro na Transacao: ", e);
			logger.info(">>>>> Execucao Terminada (Com Erro).");
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
	
	@SuppressWarnings("unused")
	private static void checkDatabaseVersion(EntityManager em) {
		String sql = "select version()";
		String result = (String) em.createNativeQuery(sql).getSingleResult();
		System.out.println(result);
	}

}
