package com.vivax.jde.task3;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueueTaskTest {

    @Test
    public void timeNeed() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        arrayList1.add(5);
        arrayList1.add(3);
        arrayList1.add(4);
        assertEquals(12, new QueueTask(arrayList1,1).timeNeed());

    }
}