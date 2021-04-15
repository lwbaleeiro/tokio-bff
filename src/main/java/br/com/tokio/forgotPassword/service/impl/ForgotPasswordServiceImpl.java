package br.com.tokio.forgotPassword.service.impl;

import br.com.tokio.forgotPassword.client.ForgotPasswordClient;
import br.com.tokio.forgotPassword.request.ForgotPasswordRequest;
import br.com.tokio.forgotPassword.service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;

public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    @Autowired
    private ForgotPasswordClient forgotPasswordClient;

    @Override
    public void forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        this.forgotPasswordClient.forgotPassword(forgotPasswordRequest);
    }
}
