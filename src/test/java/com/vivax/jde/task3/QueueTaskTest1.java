package com.vivax.jde.task3;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueueTaskTest1 {

    @Test
    public void timeNeed() throws Exception {
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(2);
        arrayList3.add(3);
        arrayList3.add(10);
        assertEquals(12, new QueueTask(arrayList3,2).timeNeed());
    }
}