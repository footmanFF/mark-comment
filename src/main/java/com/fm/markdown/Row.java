package com.fm.markdown;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangli on 2017/8/22.
 */
@Data
public class Row implements Markdown{

    private List<String> values;

    public Row() {
        this.values = new ArrayList<>();
    }

    @Override
    public String text() {
        return null;
    }

}
