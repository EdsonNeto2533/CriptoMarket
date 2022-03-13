package com.mctable.criptomarket.commons.utils.implementations

import kotlinx.coroutines.flow.Flow

/**
 * @param P is a parameter that you will or will not use
 * @param R is the return type
 */
interface IUseCase <P , R> {
    suspend fun execute(param: P?): Flow<R>?
}