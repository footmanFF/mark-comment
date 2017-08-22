package com.fm.markdown;

import lombok.Data;

/**
 * @author zhangli on 2017/8/22.
 */
@Data
public class Refrence implements Markdown {

    private String content;

    @Override
    public String text() {
        return null;
    }

}
