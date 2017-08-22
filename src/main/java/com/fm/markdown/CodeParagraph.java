package com.fm.markdown;

import com.fm.Language;
import com.fm.exception.CommentParseException;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangli on 2017/8/21.
 */
public class CodeParagraph implements Markdown {

    @Getter
    private String source;

    @Getter
    private Language language;

    public static CodeParagraph parse(String source) {
        if(StringUtils.isBlank(source)) {
            throw new IllegalArgumentException("代码段落解析失败: source不得为空");
        }

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

        CodeParagraph codeParagraph = new CodeParagraph();

        source = source.trim();
        for(Language language : Language.values()){
            String startTag = "<" + language.name() + ">";
            if(!source.startsWith(startTag)){
                continue;
            }
            String endTag = "<" + language.name() + "/>";
            source = source.replaceAll(endTag, "");
            codeParagraph.source = source;
            codeParagraph.language = language;
            break;
        }

        if(codeParagraph.getLanguage() == null){
            throw new CommentParseException("代码段落解析失败: " + source);
        }
        return codeParagraph;
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
