package br.com.zup.controller

import br.com.zup.KeyManagerRemoveGRPCServiceGrpc
import br.com.zup.RemoveChavePixRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete

@Controller("/api/v1/clientes/{clientId}")
class RemoveChavePixController(private val removeChavePixClient: KeyManagerRemoveGRPCServiceGrpc.KeyManagerRemoveGRPCServiceBlockingStub){

    @Delete("/pix/{pixKey}")
    fun delete(clientId: String?, pixKey: String?): HttpResponse<Any>{
        removeChavePixClient.remove(RemoveChavePixRequest.newBuilder()
            .setClientId(clientId)
            .setPixKey(pixKey)
            .build())

        return HttpResponse.ok()
    }
}