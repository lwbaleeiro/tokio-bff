package br.com.tokio.controller;

import br.com.tokio.forgotPassword.request.ForgotPasswordRequest;
import br.com.tokio.forgotPassword.service.ForgotPasswordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Api(value = "Serviço responsável pelas chamadas Forgot Password.", tags = {"Forgot-Password"})
@RestController
@RequestMapping("/v1/first-access")
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @PutMapping("/forgot-password")
    @ApiOperation(value = "Inicia com o processo de Forgot Password.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso ao enviar os dados."),
            @ApiResponse(code = 400, message = "Erro ao enviar os dados.")
    })
    public void forgotPassword(@RequestBody @Valid ForgotPasswordRequest forgotPasswordRequest) {
        log.info("Iniciado forgotPassword");
        this.forgotPasswordService.forgotPassword(forgotPasswordRequest);
    }

}
