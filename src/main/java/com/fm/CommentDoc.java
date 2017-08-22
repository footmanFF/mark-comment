package com.fm;

import com.fm.markdown.Markdown;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangli on 2017/8/22.
 */
@Data
public class CommentDoc {

    private List<Markdown> elements;

    public CommentDoc() {
        this.elements = new ArrayList<>();
    }

    // TODO
    public String toMarkdown(){
        return "";
    }

}
