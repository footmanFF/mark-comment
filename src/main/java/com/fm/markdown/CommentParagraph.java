package com.fm.markdown;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangli on 2017/8/21.
 */
@Data
public class CommentParagraph implements Markdown {

    private String description;

    public static CommentParagraph parse(String description) {
        if(StringUtils.isBlank(description)){
            throw new IllegalArgumentException("注释段落解析失败: description不得为空");
        }
        CommentParagraph commentParagraph = new CommentParagraph();
        commentParagraph.setDescription(description);
        return commentParagraph;
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
