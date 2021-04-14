package br.com.tokio.firstAccess.service.impl;

import br.com.tokio.firstAccess.client.FirstAccessClient;
import br.com.tokio.firstAccess.request.CreateVCodeRequest;
import br.com.tokio.firstAccess.request.FirstAccessRequest;
import br.com.tokio.firstAccess.request.ValidateAccessRequest;
import br.com.tokio.firstAccess.response.ValidateAccessResponse;
import br.com.tokio.firstAccess.response.ValidateVCodeResponse;
import br.com.tokio.firstAccess.service.FirstAccessService;
import org.springframework.beans.factory.annotation.Autowired;

public class FirstAccessServiceImpl implements FirstAccessService {

    @Autowired
    private FirstAccessClient firstAccessClient;

    @Override
    public ValidateAccessResponse validateAccess(ValidateAccessRequest validateAccessRequest) {
        return this.firstAccessClient.validateAccess(validateAccessRequest);
    }

    @Override
    public void createVCode(String code, CreateVCodeRequest createVCodeRequest) {
        this.firstAccessClient.createVCode(code, createVCodeRequest);
    }

    @Override
    public ValidateVCodeResponse validateVCode(String code) {
        return this.firstAccessClient.validateVCode(code);
    }

    @Override
    public void firstAccess(FirstAccessRequest firstAccessRequest) {
        this.firstAccessClient.firstAccess(firstAccessRequest);
    }
}
