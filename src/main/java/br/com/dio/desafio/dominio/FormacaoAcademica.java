package br.com.dio.desafio.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormacaoAcademica {
    private String instituicao;
    private String formacao;
    private String curso;
    private  LocalDate dataInicial;
    private LocalDate dataFinal;
}