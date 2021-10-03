package br.com.zup.controller

import br.com.zup.KeyManagerGRPCServiceGrpc
import br.com.zup.controller.dto.NovaChavePixRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/v1/clientes/{clientId}")
class RegistraChavePixController(private val registraChavePixClient: KeyManagerGRPCServiceGrpc.KeyManagerGRPCServiceBlockingStub){

    @Post("/pix")
    fun criaChave(clientId: String, @Valid @Body request: NovaChavePixRequest): HttpResponse<Any>{
        val grpcResponse = registraChavePixClient.registraChavePix(request.toModel(clientId))

        return HttpResponse.created(location(clientId, grpcResponse.pixKey))
    }

    private fun location(clientId: String, pixKey: String) = HttpResponse.uri("/api/v1/clientes/$clientId/pix/${pixKey}")
}