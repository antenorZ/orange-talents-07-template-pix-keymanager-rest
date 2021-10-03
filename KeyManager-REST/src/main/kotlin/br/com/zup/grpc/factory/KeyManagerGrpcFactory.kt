package br.com.zup.grpc.factory

import br.com.zup.KeyManagerCarregaGRPCServiceGrpc
import br.com.zup.KeyManagerGRPCServiceGrpc
import br.com.zup.KeyManagerListaServiceGrpc
import br.com.zup.KeyManagerRemoveGRPCServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import jakarta.inject.Singleton

@Factory
class KeyManagerGrpcFactory(@GrpcChannel("keyManager") val channel: ManagedChannel){

    @Singleton
    fun registraChave() = KeyManagerGRPCServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun removeChave() = KeyManagerRemoveGRPCServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun carregaChave() = KeyManagerCarregaGRPCServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listaChaves() = KeyManagerListaServiceGrpc.newBlockingStub(channel)

}