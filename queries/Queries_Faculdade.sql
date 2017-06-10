# -------------------------------------------------
# -- Query: Professores e Seus Cursos
Select prof.NOME_PROF, cur.NOME_CURSO, prof.*
from Professor prof
left join Curso cur 
	on prof.curso_CURSO_ID = cur.CURSO_ID;
	
# -------------------------------------------------
# -- Query: Cursos e Seus Professores
Select curso.NOME_CURSO, Professor.NOME_PROF, vaga_estacionamento.codVaga
from Curso curso
left join Professor
	on Professor.curso_CURSO_ID = Curso.CURSO_ID
left join vaga_estacionamento
	on professor.VAGA_ESTAC_ID  = vaga_estacionamento.VAGA_ESTAC_ID
order by curso.NOME_CURSO asc, professor.NOME_PROF asc;

# -------------------------------------------------
# -- Query: UFs
Select * from UF ;

/* Update Professor set Professor.VAGA_ESTAC_ID  = null where professor.PROFESSOR_ID = 157;
commit; */
/*

  Delete from Professor;
  Delete from Curso;
  commit;
*/