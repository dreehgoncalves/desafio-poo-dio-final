package br.com.dio.desafio.dominio;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curriculo {

    private String nomeCompleto;
    private String contato;
    private String email;
    private double pretencaoSalarial;
}