package br.com.tokio.controller;

import br.com.tokio.firstAccess.client.FirstAccessClient;
import br.com.tokio.firstAccess.request.CreateVCodeRequest;
import br.com.tokio.firstAccess.request.FirstAccessRequest;
import br.com.tokio.firstAccess.request.ValidateAccessRequest;
import br.com.tokio.firstAccess.response.ValidateAccessResponse;
import br.com.tokio.firstAccess.response.ValidateVCodeResponse;
import br.com.tokio.firstAccess.service.FirstAccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api(value = "Serviço responsável pelas chamadas First Access.", tags = {"First-Access"})
@RestController
@RequestMapping("/v1/first-access")
public class FirstAccessController {

    @Autowired
    private FirstAccessService firstAccessService;

    @PostMapping("/validate-access")
    @ApiOperation(value = "Valida um CPF ou CNPJ.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso ao validar o usuário."),
            @ApiResponse(code = 400, message = "Erro ao validar o usuário.")
    })
    public ValidateAccessResponse validateAccess(@RequestBody @Validated ValidateAccessRequest validateAccessRequest) {
        log.info("Iniciando validações.");
        return  this.firstAccessService.validateAccess(validateAccessRequest);
    }

    @PostMapping("/{code}/create-vcode")
    @ApiOperation(value = "Cria um código e envia no celular informado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso ao enviar o código."),
            @ApiResponse(code = 400, message = "Erro ao enviar o código.")
    })
    public void createVCode(@PathVariable("code") String code,
                     @RequestBody @Valid CreateVCodeRequest createVCodeRequest) {
        log.info("Iniciado createVCode");
        this.firstAccessService.createVCode(code, createVCodeRequest);
    }

    @GetMapping("/{code}/validate-vcode")
    @ApiOperation(value = "Validar o código enviado para o celular informado anteriormente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso ao validar o código."),
            @ApiResponse(code = 400, message = "Erro ao validar o código.")
    })
    public ValidateVCodeResponse validateVCode(@PathVariable("code") String code) {
        log.info("Iniciado validateVCode");
        return this.firstAccessService.validateVCode(code);
    }

    @PostMapping()
    @ApiOperation(value = "Primeiro acesso.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso ao acessar."),
            @ApiResponse(code = 400, message = "Erro ao acessar.")
    })
    public void firstAccess(@RequestBody @Valid FirstAccessRequest firstAccessRequest) {
        log.info("Iniciado firstAccess");
        this.firstAccessService.firstAccess(firstAccessRequest);
    }

}
