package com.fm;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.javadoc.Javadoc;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * 一条文本注释
 *
 * @para abc
 * @author zhangli on 2017/8/13.
 */
public class JavaDocUtilTest {

    @Test
    public void m() throws Exception{
        // /Users/zhangli/Work/idea_workspace/jdoc/src/main/java/com/fm/DocletTest.java
        String path = "/Users/zhangli/Work/idea_workspace/jdoc/src/main/java/com/fm/Jdoc.java";
        File file = new File(path);
        FileInputStream in = new FileInputStream(file);
        CompilationUnit compilationUnit = JavaParser.parse(in);

        JavaParser.parse("");
        List<NodeList<?>> list = compilationUnit.getNodeLists();

        List<Comment> comments = compilationUnit.getAllContainedComments();
        Comment comment = comments.get(0);

        if(comment instanceof JavadocComment){
            JavadocComment javadocComment = (JavadocComment)comment;
            Javadoc javadoc = javadocComment.parse();
            System.out.println(javadoc.toText());
        }
        
    }

}
