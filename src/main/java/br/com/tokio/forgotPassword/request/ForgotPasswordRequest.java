package br.com.tokio.forgotPassword.request;

import lombok.Data;

@Data
public class ForgotPasswordRequest {

    private String credentials;
    private String password;

}
