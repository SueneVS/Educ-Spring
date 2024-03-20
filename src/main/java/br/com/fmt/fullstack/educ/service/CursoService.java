package br.com.fmt.fullstack.educ.service;
import br.com.fmt.fullstack.educ.model.Aluno;
import br.com.fmt.fullstack.educ.model.Curso;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {
    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    public Curso cadastrar(Curso curso) throws Exception {
        if(validar(curso)){
            return Curso.inserir(curso);
        }
        return null;
    }
    public Curso matricular(Integer id, Integer alunoId) throws Exception {
        Curso curso = buscarPorId(id);
        Aluno aluno = alunoService.buscarPorId(alunoId);
        Curso.matricular(curso, aluno);
        return curso;
    }
    private boolean validar(Curso curso) throws Exception{
        if (curso.getNome() == null || curso.getNome().isBlank()){
            throw new Exception ("O nome do curso é obrigatório!");
        }

        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() < 100){
            throw new Exception(("Carga horária não informada ou menor que 100"));
        }
        return true;
    }
    public List<Curso> buscarCursos(){
        return Curso.getCursosCadastrados();
    }
    public Curso buscarPorId(Integer id) throws Exception{
        return Curso.buscarPorId(id);
    }

}
