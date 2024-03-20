package br.com.fmt.fullstack.educ.model;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Data
public class Curso {

   private static Integer proximoId = 1;
   @Getter private static List<Curso> cursosCadastrados = new ArrayList<>();

   @Setter (AccessLevel.NONE) private Integer id;
   private String nome;
   private String descricao;
   private Integer cargaHoraria;
   private List<Aluno> alunosMatriculados = new ArrayList<>();

   private  static Integer getProximoId() {
      return proximoId++;
   }
   public static Curso inserir(Curso curso){
      curso.id = getProximoId();
      cursosCadastrados.add(curso);
      return curso;
   }
   public static  Curso buscarPorId(Integer id) throws Exception {
      for (Curso curso : cursosCadastrados){
         if (curso.getId().equals(id)){
            return curso;
         }
      }
      throw  new Exception("Curso não encntrado!");
   }
   public static void matricular(Curso curso, Aluno aluno){
      curso.getAlunosMatriculados().add(aluno);
   }
}





