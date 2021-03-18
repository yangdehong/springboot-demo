package com.ydh.redsheep.springbatch.step;

import org.springframework.batch.item.ItemReader;

public class Reader implements ItemReader<String> {

    private String[] messages = { "javainuse.com",
            "Welcome to Spring Batch Example",
            "We use H2 Database for this example" };

    private int count = 0;

    @Override
    public String read() {
        if (count < messages.length) {
            return messages[count++];
        }
        return null;
    }

}
