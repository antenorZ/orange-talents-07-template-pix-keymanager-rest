package br.com.zup.controller

import br.com.zup.KeyManagerListaServiceGrpc
import br.com.zup.ListaChavePixRequest
import br.com.zup.ListaChavePixResponse
import br.com.zup.controller.dto.ChavePixResponse
import br.com.zup.controller.dto.DetalhaChavePixResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/api/v1/clientes/{clientId}")
class ListaChavesPixController(val listaChavePixClient: KeyManagerListaServiceGrpc.KeyManagerListaServiceBlockingStub){

    @Get("/pix/")
    fun listaChaves(clientId: String?): HttpResponse<Any>{
        val listaChaveResponse = listaChavePixClient.lista(ListaChavePixRequest.newBuilder()
            .setClientId(clientId).build())

        val chaves = listaChaveResponse.chavesList.map { ChavePixResponse(it) }

        return HttpResponse.ok(chaves)
    }
}