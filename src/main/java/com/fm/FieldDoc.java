package com.fm;

import com.fm.markdown.Markdown;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangli on 2017/8/20.
 */
@Data
public class FieldDoc {

    private List<Markdown> descriptionList;

    private List<BaseInfo> baseInfoList;

    public FieldDoc() {
        this.baseInfoList = new ArrayList<>();
        this.descriptionList = new ArrayList<>();
    }
}