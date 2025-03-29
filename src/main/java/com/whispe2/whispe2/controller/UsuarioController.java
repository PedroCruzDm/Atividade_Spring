package com.whispe2.whispe2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import com.whispe2.whispe2.model.Pessoa;


@RestController
@RequestMapping("/api/v1/pessoa")
public class UsuarioController {

    @Autowired
    Validator validator;

    @GetMapping("/show")
    public List<Pessoa> getAlunos() {
        List<Pessoa> usuarios = new ArrayList<>();
        usuarios.add(new Pessoa(1, "João", "123.456.789-00"));
        usuarios.add(new Pessoa(2, "Maria", "987.654.321-00"));

        return usuarios;
    }

    @GetMapping("/show/professor")
    public List<Pessoa> getProfessor() {
        List<Pessoa> professores = new ArrayList<>();
        professores.add(new Pessoa(1, "Carlos", "111.222.333-44"));
        professores.add(new Pessoa(2, "Ana", "555.666.777-88"));
        return professores;
    }

    @GetMapping("/show/aluno")
    public List<Pessoa> getAluno() {
        List<Pessoa> alunos = new ArrayList<>();
        alunos.add(new Pessoa(1, "Lucas", "222.333.444-55"));
        alunos.add(new Pessoa(2, "Fernanda", "888.999.000-11"));
        return alunos;
    }

    @GetMapping("/all")
    public List<Pessoa> getAll(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1, "teste", "123.456.789-00"));
        pessoas.addAll(getAluno());
        pessoas.addAll(getProfessor());

        return pessoas;
    }        

    @PostMapping("/insert/aluno")
    public ResponseEntity<String> insert(@RequestBody @Validated Pessoa aluno){
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(aluno);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Pessoa> violation : violations) {
            sb.append(violation.getMessage()).append("\n");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        List<Pessoa> alunos = getAluno();
        alunos.add(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body("Aluno inserido com sucesso!");
    }
}
