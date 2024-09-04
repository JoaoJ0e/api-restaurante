package api_restaurante.entity;

import api_restaurante.enums.SexoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@MappedSuperclass
public abstract class Pessoa {

    @Column(nullable = false)
    protected String nome;

    @Column(nullable = false)
    protected String sobrenome;

    @Column(nullable = false, unique = true)
    protected String cpf;

    @Column(nullable = false)
    protected LocalDate dataNascimento;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    protected SexoEnum sexoEnum;

    @Column(nullable = false, unique = true)
    protected String telefone;
}
