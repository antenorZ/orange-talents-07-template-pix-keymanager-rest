package br.com.zup.controller.dto

import br.com.zup.RegistraChavePixRequest
import br.com.zup.TipoChave
import br.com.zup.TipoConta
import br.com.zup.enums.TipoChaveRequest
import br.com.zup.enums.TipoContaRequest
import io.micronaut.core.annotation.Introspected


@Introspected
class NovaChavePixRequest(val tipoConta: TipoContaRequest, val tipoChave: TipoChaveRequest, val chave: String?){
    fun toModel(clientId: String): RegistraChavePixRequest{
        return RegistraChavePixRequest.newBuilder()
            .setClientId(clientId)
            .setTipoChave(tipoChave?.atributoGrpc ?: TipoChave.UNKNOWN_TIPO_CHAVE)
            .setTipoConta(tipoConta?.atributoGrpc ?: TipoConta.UNKNOWN_TIPO_CONTA)
            .setChave(chave ?: "")
            .build()
    }
}