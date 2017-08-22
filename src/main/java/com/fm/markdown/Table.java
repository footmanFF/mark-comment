package com.fm.markdown;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangli on 2017/8/22.
 */
@Data
public class Table implements Markdown{

    private List<String> columns;

    public Table() {
        this.columns = new ArrayList<>();
    }

    @Override
    public String text() {
        return null;
    }

}
