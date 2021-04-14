package br.com.tokio.firstAccess.client;

import br.com.tokio.config.FromUrlEncodedClientConfiguration;
import br.com.tokio.firstAccess.request.CreateVCodeRequest;
import br.com.tokio.firstAccess.request.FirstAccessRequest;
import br.com.tokio.firstAccess.request.ValidateAccessRequest;
import br.com.tokio.firstAccess.response.ValidateAccessResponse;
import br.com.tokio.firstAccess.response.ValidateVCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(url = "${client.url.api-first-access}",
        name = "api-first-access",
        configuration = FromUrlEncodedClientConfiguration.class)
public interface FirstAccessClient {

    String BASE_URL_FIRST_ACCESS = "/first-access";

    @PostMapping(BASE_URL_FIRST_ACCESS + "/validate-access")
    ValidateAccessResponse validateAccess(@RequestBody @Valid ValidateAccessRequest validateAccessRequest);

    @PostMapping("/{code}/validation")
    void createVCode(@PathVariable("code") String code, @RequestBody @Valid CreateVCodeRequest createVCodeRequest);

    @GetMapping("/{code}/validation")
    ValidateVCodeResponse validateVCode(@PathVariable("code") String code);

    @PostMapping(BASE_URL_FIRST_ACCESS)
    void firstAccess(@RequestBody @Valid FirstAccessRequest firstAccessRequest);

}

