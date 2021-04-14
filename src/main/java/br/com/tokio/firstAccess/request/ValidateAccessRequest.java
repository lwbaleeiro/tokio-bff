package br.com.tokio.firstAccess.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class ValidateAccessRequest {

    @NotNull @NotEmpty @Length(min = 11, max = 14)
    private String cpfCnpj;

}
