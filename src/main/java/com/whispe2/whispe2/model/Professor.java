package com.whispe2.whispe2.model;

public class Professor extends Pessoa {

    private String disciplina;
    private String periodo;

    public String getDisciplina() {
        return disciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Professor(Integer id, String nome, String cpf, String disciplina, String periodo) {
        super(id, nome, cpf);
        this.disciplina = disciplina;
        this.periodo = periodo;
    }

    

}
