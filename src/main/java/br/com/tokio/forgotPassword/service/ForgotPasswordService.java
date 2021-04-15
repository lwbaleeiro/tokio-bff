package br.com.tokio.forgotPassword.service;

import br.com.tokio.forgotPassword.request.ForgotPasswordRequest;
import org.springframework.stereotype.Service;

@Service
public interface ForgotPasswordService {

    void forgotPassword(ForgotPasswordRequest forgotPasswordRequest);

}
