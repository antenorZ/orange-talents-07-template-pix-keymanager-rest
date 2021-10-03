package br.com.zup.controller.dto

import br.com.zup.CarregaChavePixResponse
import br.com.zup.TipoConta
import io.micronaut.core.annotation.Introspected

@Introspected
class DetalhaChavePixResponse(chaveResponse: CarregaChavePixResponse){

    val pixId = chaveResponse.pixId
    val tipo = chaveResponse.chave.tipo
    val chave = chaveResponse.chave.chave

    val tipoConta = when(chaveResponse.chave.conta.tipo){
        TipoConta.CONTA_CORRENTE -> "CONTA_CORRENTE"
        TipoConta.CONTA_POUPANCA -> "CONTA_POUPANCA"
        else -> "TIPO INVALIDO"
    }

    val conta = mapOf(
        Pair("tipo", tipoConta),
            Pair("instituicao", chaveResponse.chave.conta.instituicao),
            Pair("cpfTitular", chaveResponse.chave.conta.cpfTitular),
            Pair("agencia", chaveResponse.chave.conta.agencia),
            Pair("numero", chaveResponse.chave.conta.numeroConta)
    )
}