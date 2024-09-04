package api_restaurante.dto;

import api_restaurante.enums.SexoEnum;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@MappedSuperclass
public abstract class PessoaDto {
    protected String nome;
    protected String sobrenome;
    protected String cpf;
    protected LocalDate dataNascimento;
    protected SexoEnum sexoEnum;
    protected String telefone;
}
