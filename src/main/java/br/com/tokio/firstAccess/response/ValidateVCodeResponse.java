package br.com.tokio.firstAccess.response;

import lombok.Data;

@Data
public class ValidateVCodeResponse {

    private String code;
    private boolean validated;

}