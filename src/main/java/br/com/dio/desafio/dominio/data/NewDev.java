package br.com.dio.desafio.dominio.data;

import br.com.dio.desafio.dominio.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class NewDev {

    private  List<Curso> cursos = new ArrayList<>();
    private List<Mentoria> mentoriaList = new ArrayList<>();
    private List<Bootcamp> bootcampList = new ArrayList<>();
    private List<Artigo> artigoList = new ArrayList<>();

    private Curriculo curriculo;
    private ExperienciaProfissional experiencia;
    private FormacaoAcademica formacao;

    public void createCurso(String titulo, String descricao, int cargaHoraria) {

        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        cursos.add(curso);
    }

    public void createMentoria(String titulo, String descricao) {

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(LocalDate.now());
        mentoriaList.add(mentoria);
    }

    public void bootcamp(String nome, String descricao, List<Curso> cursos, List<Mentoria> mentorias) {

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome(nome);
        bootcamp.setDescricao(descricao);

        for (Curso curso : cursos) {
            bootcamp.getConteudos().add(curso);
        }

        for (Mentoria mentoria : mentorias) {
            bootcamp.getConteudos().add(mentoria);
        }

        bootcampList.add(bootcamp);

    }

    public void createFormacaoAcademica( String instituicao, String formacao, String curso, LocalDate dataInicial, LocalDate dataFinal) {

        FormacaoAcademica formacaoAcademica = new FormacaoAcademica();
        formacaoAcademica.setInstituicao(instituicao);
        formacaoAcademica.setFormacao(formacao);
        formacaoAcademica.setCurso(curso);
        formacaoAcademica.setDataInicial(dataInicial);
        formacaoAcademica.setDataFinal(dataFinal);

        this.formacao = formacaoAcademica;
    }

    public void createArtigo(String titulo, String conteudo) {

        Artigo artigo = new Artigo();
        artigo.setTitulo(titulo);
        artigo.setConteudo(conteudo);
        artigoList.add(artigo);
    }

    public void createExperienciaProfissional(String empresa, String cargo, String descricao, LocalDate dataInicial) {

        ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional();
        experienciaProfissional.setEmpresa(empresa);
        experienciaProfissional.setCargo(cargo);
        experienciaProfissional.setDataInicial(dataInicial);
        experienciaProfissional.setDescricao(descricao);

        this.experiencia = experienciaProfissional;
    }

    public void createCurriculo(  String nomeCompleto, String contato, String email,  double pretencaoSalarial){
        Curriculo meuCurriculo = new Curriculo();
        meuCurriculo.setNomeCompleto(nomeCompleto);
        meuCurriculo.setContato(contato);
        meuCurriculo.setEmail(email);
        meuCurriculo.setPretencaoSalarial(pretencaoSalarial);
        this.curriculo = meuCurriculo;
    }
}
