package com.luigi573.mira.data.source.remote

import com.luigi573.mira.data.Result.Success
import com.luigi573.mira.data.Stat
import com.luigi573.mira.data.source.StatDataSource

class FakeRemoteDataSource : StatDataSource {
    override suspend fun getStat() = Success(Stat(
            111,
            111,
            111,
            111,
            1,
            "https://img1.dxycdn.com/2020/0123/733/3392575782185696736-73.jpg"))
}