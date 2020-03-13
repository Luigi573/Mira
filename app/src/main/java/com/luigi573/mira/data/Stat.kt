package com.luigi573.mira.data

data class Stat(var confirmedCount: Int,
                var suspectedCount: Int,
                var curedCount: Int,
                var deadCount: Int,
                var modifyTime: Long,
                var imgUrl: String
)