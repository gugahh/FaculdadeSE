package gugahh.faculdade.util;

import java.util.Date;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import gugahh.faculdade.dao.CursoDAO;
import gugahh.faculdade.dao.ProfessorDAO;
import gugahh.faculdade.dao.UfDAO;
import gugahh.faculdade.entity.Curso;
import gugahh.faculdade.entity.Pais;
import gugahh.faculdade.entity.Professor;
import gugahh.faculdade.entity.UF;

public class PopulaEntidadesUtil {
	
	final static Logger logger = Logger.getLogger(PopulaEntidadesUtil.class.getName());
	
	//Professores
	public static final String EDUARDO_CUNHA = "Eduardo Cunha";
	public static final String MICHEL_TEMER = "Michel Temer";
	public static final String OSCAR_NIEMEYER = "Oscar Niemeyer";
	public static final String FRANK_LLOYD_RIGHT = "Frank Lloyd Right";
	
	//Cursos
	public static final String CURSO_ADVOCACIA = "Advocacia";
	public static final String CURSO_ARQUITETURA = "Arquitetura";
	public static final String CURSO_COMUNICACAO = "Comunicação";
	public static final String CURSO_ENG_CIVIL = "Engenharia Civil";
	public static final String CURSO_ENG_PROD = "Engenharia de Produção";
	public static final String CURSO_ENG_ELETR = "Engenharia Elétrica";
	
	//UFs
	public static final String SIGLA_UF_RJ = "RJ";
	public static final String SIGLA_UF_SP = "SP";
	public static final String SIGLA_UF_ES = "ES";
	public static final String SIGLA_UF_MG = "MG";
	
	// Paises
	public static final int ID_BRASIL = 1;
	public static final int ID_ARGENTINA = 2;
	public static final int ID_BOLIVIA = 3;
	
	@SuppressWarnings("unused")
	public static void cadastraCursos(EntityManager em) {
		logger.info("Persistindo Novos Cursos");
		CursoDAO cursoDAO = CursoDAO.getDAO(em);
		Curso novoCurso1 = cursoDAO.novoCurso(CURSO_ADVOCACIA);
		Curso novoCurso2 = cursoDAO.novoCurso(CURSO_ARQUITETURA);
		Curso novoCurso3 = cursoDAO.novoCurso(CURSO_COMUNICACAO);
		Curso novoCurso4 = cursoDAO.novoCurso(CURSO_ENG_CIVIL);
		Curso novoCurso5 = cursoDAO.novoCurso(CURSO_ENG_PROD);
		Curso novoCurso6 = cursoDAO.novoCurso(CURSO_ENG_ELETR);
	}
	
	@SuppressWarnings("unused")
	public static void cadastraProfessores(EntityManager em) {
		logger.info("Persistindo Novos Professores");
		ProfessorDAO professorDAO = ProfessorDAO.getDAO(em);
		Professor frank = professorDAO.novoProfessor(FRANK_LLOYD_RIGHT, new Date());
		Professor niemeyer = professorDAO.novoProfessor(OSCAR_NIEMEYER, new Date());
		Professor temer = professorDAO.novoProfessor(MICHEL_TEMER, new Date());
		Professor cunha = professorDAO.novoProfessor(EDUARDO_CUNHA, new Date()); 
	}
	
	public static void cadastraPaises(EntityManager em) {
		logger.info("Persistindo Paises");
		Pais brasil = new Pais("Brasil");
		em.persist(brasil);
		Pais argentina = new Pais("Argentina");
		em.persist(argentina);
		Pais bolivia = new Pais("Bolivia");
		em.persist(bolivia);
	}
	
	@SuppressWarnings("unused")
	public static void cadastraUFs(EntityManager em) {
		Pais brasil = em.getReference(Pais.class, ID_BRASIL);
		logger.info("Persistindo UFs");
		UfDAO ufDAO = UfDAO.getDAO(em);
		UF rj = ufDAO.novaUF(SIGLA_UF_RJ, "Rio de Janeiro", brasil);
		UF sp = ufDAO.novaUF(SIGLA_UF_SP, "São Paulo", brasil);
		UF es = ufDAO.novaUF(SIGLA_UF_ES, "Espírito Santo", brasil);
		UF mg = ufDAO.novaUF(SIGLA_UF_MG, "Minas Gerais", brasil);
	} 

}
