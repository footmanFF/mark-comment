package com.fm;

import lombok.Getter;

/**
 * @author zhangli on 2017/8/21.
 */
public class CommentParagraph implements Markdown {

    @Getter
    private String description;

    public CommentParagraph(String description) {
        this.description = description;
    }

    @Override
    public String text() {
        // 处理成 markdown

        /**
         * **突出字体**
         * <http://www.google.com>
         */
        return null;
    }

}
