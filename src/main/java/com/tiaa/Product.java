package com.tiaa;

/**
 * Created by navchand0 on 7/1/2018.
 */
public class Product {
    private boolean isBolt1Exist;
    private boolean isBolt2Exist;
    private boolean isMachineExist;

    Product(int productId){
    }

    void setBolt1Exist() {
        isBolt1Exist = true;
    }

    void setBolt2Exist() {
        isBolt2Exist = true;
    }

    void setMachineExist() {
        isMachineExist = true;
    }

    public boolean isAllItemsAvailable(){
        return isBolt1Exist && isBolt2Exist && isMachineExist;
    }
}
