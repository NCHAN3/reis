package com.tiaa;

import com.tiaa.Item.ItemStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by navchand0 on 7/1/2018.
 */
public class Dispatcher {

    private int workers;
    private int noOfMachines;
    private int noOfBolts;
    private long sleepTime;

    public Dispatcher(int noOfBolts, int noOfMachines, long sleepTime){
        this.workers = 3;
        this.noOfBolts = noOfBolts;
        this.noOfMachines = noOfMachines;
        this.sleepTime = sleepTime;
    }

    public int processWorkers() throws ExecutionException, InterruptedException {

        int totalProduct = 0;

        // wrap items with index which will help in assigning these items to worker
        ItemStore store = new ItemStore(noOfBolts, noOfMachines);


        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Future<Queue<Product>>> futures = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for(int i=0; i< workers; i++){

            futures.add(service.submit(new Worker(store.getItems(), i, sleepTime)));

        }

        for(Future<Queue<Product>> future : futures){
            Queue<Product> finishedProduct = future.get();
            totalProduct = totalProduct + finishedProduct.size();
        }

        System.out.println("Total products = " + totalProduct);
        System.out.println("Total time taken = " + (System.currentTimeMillis() - startTime) + "ms");

        return totalProduct;
    }

}
