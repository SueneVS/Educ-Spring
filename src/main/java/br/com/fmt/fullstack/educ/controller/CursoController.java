package br.com.fmt.fullstack.educ.controller;
import br.com.fmt.fullstack.educ.model.Aluno;
import br.com.fmt.fullstack.educ.model.Curso;
import br.com.fmt.fullstack.educ.service.CursoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @GetMapping
    public List<Curso> get() {
        return cursoService.buscarCursos();
    }
    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return cursoService.cadastrar(curso);

    }
    @PostMapping ("{id}/add-aluno")
    public Curso post(@PathVariable Integer id, @RequestBody Aluno aluno) throws Exception {
        return cursoService.matricular(id, aluno.getId());

    }
}