package com.fm.markdown;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangli on 2017/8/22.
 */
public enum TagType {

    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    TABLE,
    ROW,
    REFRENCE,
    LIST,
    UNKONOW;

    public static TagType getByTagName(String tagName){
        if(StringUtils.isBlank(tagName)){
            return UNKONOW;
        }
        for(TagType tagType : values()){
            if(tagName.equalsIgnoreCase(tagType.name())){
                return tagType;
            }
        }
        return UNKONOW;
    }

}
