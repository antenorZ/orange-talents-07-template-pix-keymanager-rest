package br.com.zup.controller

import br.com.zup.CarregaChavePixRequest
import br.com.zup.KeyManagerCarregaGRPCServiceGrpc
import br.com.zup.KeyManagerListaServiceGrpc
import br.com.zup.controller.dto.DetalhaChavePixResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/api/v1/clientes/{clientId}")
class CarregaDetalhesChavePixController(val carregaChavePixClient: KeyManagerCarregaGRPCServiceGrpc.KeyManagerCarregaGRPCServiceBlockingStub)
{
    @Get("/pix/{pixId}")
    fun carrega(clientId: String?, pixId: String?): HttpResponse<Any>{
        val chaveResponse = carregaChavePixClient.carrega(CarregaChavePixRequest.newBuilder()
            .setPixId(CarregaChavePixRequest.FiltroPorPixId.newBuilder().
            setClientId(clientId).
            setPixId(pixId).build()).
            build())

        return HttpResponse.ok(DetalhaChavePixResponse(chaveResponse))
    }
}