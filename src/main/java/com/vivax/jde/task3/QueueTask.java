package com.vivax.jde.task3;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QueueTask {
    private int timeNeeded = 0;
    private int kassi = 0;
    private ArrayList<Integer> costumers = new ArrayList<Integer>();

    public QueueTask(ArrayList<Integer> costumers, int kassi) {
        this.costumers = costumers;
        this.kassi = kassi;
    }

    public int timeNeed() throws InterruptedException {
        boolean flagNeed = true;
        ExecutorService executorService = Executors.newFixedThreadPool(kassi);
        while (!(costumers.isEmpty())) {
            if ((costumers.size() == 1) & (costumers.get(0) == 0)) {
                costumers.remove(0);
                return timeNeeded;
            }
            executorService.execute(new StepQueue());
        }
        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.HOURS);
        return timeNeeded;
    }

    public class StepQueue implements Runnable {

        public void run() {
            if (costumers.size() != 0) {
                if ((costumers.size() == 1) & (costumers.get(0) == 0)) {
                    timeNeeded--;
                    costumers.remove(0);
                }
                timeNeeded++;
                System.out.println("time:   " + timeNeeded);
                int kassCash = kassi;
                for (int i = 0; i < kassCash; i++) {
                    if (kassi > costumers.size()) {
                        kassi--;
                    }
                    int numCash = costumers.get(i);
                    costumers.set(i, costumers.get(i) - 1);
                    if (numCash == 0) {
                        costumers.remove(i);
                        i--;
                    }
                }
            }
        }
    }
}
