package br.com.tokio.firstAccess.response;

import lombok.Data;

@Data
public class Contacts {

    private String[] emails;
    private String[] phones;

}
