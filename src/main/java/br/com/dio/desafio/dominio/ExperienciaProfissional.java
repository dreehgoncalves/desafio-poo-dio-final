package br.com.dio.desafio.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExperienciaProfissional {
    private String empresa;
    private String cargo;
    private String descricao;
    private boolean empregoAtual = false;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public ExperienciaProfissional(String empresa, String cargo, String descricao, LocalDate dataInicial, LocalDate dataFinal) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public ExperienciaProfissional(String empresa, String cargo, String descricao, LocalDate dataInicial) {
        this(empresa, cargo, descricao, dataInicial, null);
        empregoAtual = true;
    }
}