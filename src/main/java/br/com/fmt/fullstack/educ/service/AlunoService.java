package br.com.fmt.fullstack.educ.service;
import br.com.fmt.fullstack.educ.model.Aluno;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    public Aluno cadastrar(Aluno aluno) throws Exception {
        if(validar(aluno)){
            return Aluno.inserir(aluno);
        }
        return null;
    }
    private boolean validar(Aluno aluno) throws Exception{
        if (aluno.getNome() == null || aluno.getNome().isBlank()){
            throw new Exception ("O nome do aluno é obrigatório!");
        }

        if (aluno.getDataNascimento() == null){
            throw new Exception(("A data de nascimento é obrigatória!"));
        }
        return true;
    }
    public List<Aluno> buscarAlunos(){
        return Aluno.getAlunos();
    }
    public Aluno buscarPorId(Integer id) throws Exception{
        return Aluno.buscarPorId(id);
    }

}
