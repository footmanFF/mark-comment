package com.fm;

import lombok.Getter;

/**
 * @author zhangli on 2017/8/21.
 */
public class CodeParagraph implements Markdown {

    @Getter
    private String source;

    @Getter
    private Language language;

    public CodeParagraph(String source) {
        this.source = source;

        // 解析出语言类型
        /**
         * <sql>
         *     select
         *         id, name
         *     from
         *         user_info
         *     where
         *         create_time >= '2017-01-01'
         * </sql>
         */
    }

    @Override
    public String text() {
        /**
         * ```Java
         * public CodeParagraph(String source) {
         *     this.source = source;
         * }
         * ```
         */
        return null;
    }

}
