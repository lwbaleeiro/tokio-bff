package br.com.tokio.firstAccess.response;

import lombok.Data;

@Data
public class ValidateAccessResponse {

    private Contacts contacts;
    private String credential;
    private Policy[] policies;
    private boolean validateTokenPhone;

}
