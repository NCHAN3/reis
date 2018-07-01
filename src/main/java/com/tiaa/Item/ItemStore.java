package com.tiaa.Item;

import java.util.*;

/**
 * Created by navchand0 on 6/30/2018.
 */
public class ItemStore{

    private int noOfBolts;
    private int noOfMachines;
    private int totalItems;
    private Item[] items;

    public ItemStore(int noOfBolts, int noOfMachines){
        this.noOfBolts = noOfBolts;
        this.noOfMachines = noOfMachines;
        this.totalItems = noOfBolts + noOfMachines;
        CreateItems();
    }

    private void CreateItems(){
        items = new Item[totalItems];
        List<Item> itemsList = new ArrayList<>();

        for(int i =0; i < noOfBolts; i++){
            itemsList.add(new Item(ItemType.BOLT, i));
        }

        for(int i =0 ; i < noOfMachines; i++){
            itemsList.add(new Item(ItemType.MACHINE, i));
        }

        Collections.shuffle(itemsList);

        for(int i=0; i < totalItems; i++){
            items[i]=itemsList.get(i);
        }
    }

    public Item[] getItems(){
        return items;
    }
}
