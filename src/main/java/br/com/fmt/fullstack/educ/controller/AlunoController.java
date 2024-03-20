package br.com.fmt.fullstack.educ.controller;
import br.com.fmt.fullstack.educ.model.Aluno;
import br.com.fmt.fullstack.educ.service.AlunoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    @GetMapping
    public List<Aluno> get() {
        return alunoService.buscarAlunos();
    }
    @PostMapping
    public Aluno post(@RequestBody Aluno aluno) throws Exception {
        return alunoService.cadastrar(aluno);

    }
}