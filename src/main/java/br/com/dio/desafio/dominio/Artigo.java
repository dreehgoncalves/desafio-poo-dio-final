package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Artigo {
    private String titulo;
    private String conteudo;
    private final LocalDate dataInicial = LocalDate.now();
}