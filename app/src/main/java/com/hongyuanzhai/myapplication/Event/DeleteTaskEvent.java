package com.hongyuanzhai.myapplication.Event;

import com.hongyuanzhai.myapplication.Bean.CollBookBean;

/**
 * Created by newbiechen on 17-5-27.
 */

public class DeleteTaskEvent {
    public CollBookBean collBook;

    public DeleteTaskEvent(CollBookBean collBook){
        this.collBook = collBook;
    }
}
