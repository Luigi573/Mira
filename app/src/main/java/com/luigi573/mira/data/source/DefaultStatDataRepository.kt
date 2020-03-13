package com.luigi573.mira.data.source

import com.luigi573.mira.data.Result
import com.luigi573.mira.data.Stat
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.IllegalArgumentException

class DefaultStatDataRepository constructor(
        private val remoteDataSource : StatDataSource,
        private val ioDispatcher : CoroutineDispatcher = Dispatchers.IO
) : StatDataRepository {
    override suspend fun getStat(): Result<Stat> = withContext(ioDispatcher) {
        val stat = remoteDataSource.getStat()
        when (stat) {
            is Result.Success -> return@withContext stat
            is Result.Error -> return@withContext stat
            else -> throw IllegalArgumentException()
        }

    }

}