package br.com.tokio.firstAccess.request;

import lombok.Data;

@Data
public class CreateVCodeRequest {

    private String credential;
    private String sendTo;

}

