package br.com.tokio.firstAccess.service;

import br.com.tokio.firstAccess.request.CreateVCodeRequest;
import br.com.tokio.firstAccess.request.FirstAccessRequest;
import br.com.tokio.firstAccess.request.ValidateAccessRequest;
import br.com.tokio.firstAccess.response.ValidateAccessResponse;
import br.com.tokio.firstAccess.response.ValidateVCodeResponse;
import org.springframework.stereotype.Service;

@Service
public interface FirstAccessService {

    ValidateAccessResponse validateAccess(ValidateAccessRequest validateAccessRequest);

    void createVCode(String code, CreateVCodeRequest createVCodeRequest);

    ValidateVCodeResponse validateVCode(String code);

    void firstAccess(FirstAccessRequest firstAccessRequest);

}
