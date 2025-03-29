package com.whispe2.whispe2.model;

public class Aluno extends Pessoa{
    private String curso;
    private String periodo;

    public String getCurso() {
        return curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Aluno(Integer id, String nome, String cpf, String curso, String periodo) {
        super(id, nome, cpf);
        this.curso = curso;
        this.periodo = periodo;
    }
    
}
