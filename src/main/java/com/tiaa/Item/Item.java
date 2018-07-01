package com.tiaa.Item;

/**
 * Created by navchand0 on 6/30/2018.
 * Wraper class for bolt or machines. it also stores index which will decide which worker will pick this item.
 * It will remove chnaces item will be picked by wrong thread
 */

public class Item {


    private ItemType type;
    private int index;

    Item(ItemType type, int index){
        this.type = type;
        this.index = index;
    }

    public ItemType getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

}

