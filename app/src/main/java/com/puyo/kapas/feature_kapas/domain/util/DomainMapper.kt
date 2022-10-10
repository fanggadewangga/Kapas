package com.puyo.kapas.feature_kapas.domain.util

interface DomainMapper <T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel

    fun mapFromDomainModel(model: DomainModel): T

}