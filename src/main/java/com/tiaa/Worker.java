package com.tiaa;

import com.tiaa.Item.Item;
import com.tiaa.Item.ItemType;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;

/**
 * Created by navchand0 on 6/30/2018.
 */
public class Worker implements Callable {

    private Item[] conveyorBelt;
    private int workerId;
    private long sleepTime;

    private Queue<Product> finishedProduct = new LinkedList<>();
    private Queue<Product> unFinishedProduct = new LinkedList<>();

    private Queue<Item> boltList = new LinkedList<>();


    Worker(Item[] conveyorBelt, int workerId, long sleepTime){
        this.conveyorBelt = conveyorBelt;
        this.workerId = workerId;
        this.sleepTime = sleepTime;
    }

    /*
    This method will be keep running and pick item from conveyor belt
     */
    private void pickUnfinishedGood(int index) throws InterruptedException {

        Item item = conveyorBelt[index];
        int itemIndex = item.getIndex();

        if(itemIndex%3 == workerId && item.getType() == ItemType.BOLT){

            boltList.add(item);
            createProduct();

        }else if (itemIndex%3 == workerId && item.getType() == ItemType.MACHINE){

            Product p = new Product();
            p.setMachineExist();
            unFinishedProduct.offer(p);
            createProduct();

        }

    }

    private void createProduct() throws InterruptedException {
        Product p = unFinishedProduct.peek();
        if(p!= null && boltList.size() >=2){
            p.setBolt1Exist();
            p.setBolt2Exist();
            p.setProductReady();
            boltList.remove();
            boltList.remove();
            Thread.sleep(sleepTime);
            finishedProduct.add(unFinishedProduct.remove());
        }
    }

    public Queue<Product> call() throws Exception {

        for(int i=0; i < conveyorBelt.length; i++){
            pickUnfinishedGood(i);
        }

        return finishedProduct;
    }
}
