package br.com.fmt.fullstack.educ.model;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Aluno {
    private static Integer proximoId = 1;
    @Getter private static List<Aluno> alunos = new ArrayList<>();

    @Setter (AccessLevel.NONE) private Integer id;
    private String nome;
    private LocalDate dataNascimento;

    private  static Integer getProximoId() {
        return proximoId++;
    }
    public static Aluno inserir(Aluno aluno){
        aluno.id = getProximoId();
        alunos.add(aluno);
        return aluno;
    }
    public static  Aluno buscarPorId(Integer id) throws Exception {
        for (Aluno aluno : alunos){
            if (aluno.getId().equals(id)){
                return aluno;
            }
        }
        throw  new Exception("Aluno não encntrado!");
    }
}
