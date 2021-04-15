package br.com.tokio.forgotPassword.client;

import br.com.tokio.config.FromUrlEncodedClientConfiguration;
import br.com.tokio.forgotPassword.request.ForgotPasswordRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(url = "${client.url.api-forgot-password}",
    name = "forgotPasswordClient",
    configuration = FromUrlEncodedClientConfiguration.class)
public interface ForgotPasswordClient {

    String BASE_URL_FIRST_ACCESS = "/first-access";

    @PutMapping(BASE_URL_FIRST_ACCESS + "/forgot-password")
    void forgotPassword(@RequestBody @Valid ForgotPasswordRequest forgotPasswordRequest);

}
