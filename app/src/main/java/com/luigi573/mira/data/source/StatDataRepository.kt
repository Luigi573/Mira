package com.luigi573.mira.data.source

import com.luigi573.mira.data.Result
import com.luigi573.mira.data.Stat

interface StatDataRepository {
    suspend fun getStat() : Result<Stat>

}