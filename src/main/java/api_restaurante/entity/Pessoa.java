package api_restaurante.entity;

import api_restaurante.enums.SexoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Pessoa {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private SexoEnum sexoEnum;

    @Column(nullable = false, unique = true)
    private String telefone;
}
