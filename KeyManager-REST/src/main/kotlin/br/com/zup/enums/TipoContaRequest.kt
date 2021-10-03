package br.com.zup.enums

import br.com.zup.TipoConta

enum class TipoContaRequest(val atributoGrpc: TipoConta){
    CONTA_CORRENTE(TipoConta.CONTA_CORRENTE),

    CONTA_POUPANCA(TipoConta.CONTA_POUPANCA)
}