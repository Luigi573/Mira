package com.luigi573.mira.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeUtilsTest {

    @Test
    public void timeStamp2String() {
        System.out.println(TimeUtils.timeStamp2String(1580223314000L
                , "yyyy.MM.dd HH:mm"));
    }
}