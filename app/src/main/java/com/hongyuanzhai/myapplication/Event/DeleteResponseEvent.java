package com.hongyuanzhai.myapplication.Event;


import com.hongyuanzhai.myapplication.Bean.CollBookBean;

/**
 * Created by newbiechen on 17-5-27.
 */

public class DeleteResponseEvent {
    public boolean isDelete;
    public CollBookBean collBook;
    public DeleteResponseEvent(boolean isDelete, CollBookBean collBook){
        this.isDelete = isDelete;
        this.collBook = collBook;
    }
}
