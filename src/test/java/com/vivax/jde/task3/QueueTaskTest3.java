package com.vivax.jde.task3;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueueTaskTest3 {

    @Test
    public void timeNeed() throws Exception {
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(10);
        arrayList2.add(2);
        arrayList2.add(3);
        arrayList2.add(3);
        assertEquals(10, new QueueTask(arrayList2,2).timeNeed());
    }
}