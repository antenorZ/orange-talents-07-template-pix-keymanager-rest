package br.com.zup.controller.dto

import br.com.zup.ListaChavePixResponse
import io.micronaut.core.annotation.Introspected

@Introspected
class ChavePixResponse(chavePix: ListaChavePixResponse.ChavePix){

    val id = chavePix.pixId
    val chave = chavePix.chave
    val tipo = chavePix.tipo
    val tipoConta = chavePix.tipoConta

}