package com.fm.markdown;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangli on 2017/8/22.
 */
@Data
public class Head implements Markdown{

    private TagType tagType;
    private String content;

    public static Head parse(TagType tagType, String content){
        if(tagType == null){
            throw new IllegalArgumentException("Head解析失败: tagType不得为null");
        }
        if(StringUtils.isBlank(content)){
            throw new IllegalArgumentException("Head解析失败: content不得为空");
        }
        Head head = new Head();
        head.setTagType(tagType);
        head.setContent(content);
        return head;
    }

    @Override
    public String text() {
        return null;
    }

}
