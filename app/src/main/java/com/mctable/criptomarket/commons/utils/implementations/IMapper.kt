package com.mctable.criptomarket.commons.utils.implementations

interface IMapper<I, O> {
    fun transform(data: I) : O
}