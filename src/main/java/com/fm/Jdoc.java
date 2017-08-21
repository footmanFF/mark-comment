package com.fm;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.javadoc.Javadoc;
import com.github.javaparser.javadoc.JavadocBlockTag;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @H1 标题1
 * @{anchor xxx} 锚点，可以跳转到一个当前页面的某个地方
 * <p>
 * The iterators returned by all of this class's "collection view methods
 * are __fail-fast__: if the map is structurally modified at any time after
 * the iterator is created, in any way except through the iterator's own
 * ø__remove__ method, the iterator will throw a
 * {@link ConcurrentModificationException}.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the
 * future.
 * <p>
 * Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw <ConcurrentModificationException> on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness: __the fail-fast behavior of iterators
 * should be used only to detect bugs.__
 * <p>
 * <Sql>
 * select * from sys_field_manage where col_code='car_evaluate@pawn';
 * </Sql>
 * <p>
 * <Java>
 * public class Jdoc {
 * private String source;
 * private List<Comment> comments;
 * private List<FieldDoc> fieldDocs;
 * }
 * <Java/>
 * @table |xx     |xxxxxx  |xx
 * @row |aaxxx  |aa      |aa
 * @row |aa     |aa      |aa
 * @refrence Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw __ConcurrentModificationException__ on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness: __the fail-fast behavior of iterators
 * should be used only to detect bugs.__
 * @list - 第一级的列表
 * - 第二级的列表
 * 列表下的内容
 * - 第一级的列表
 * - 第二级的列表
 * - 第三级的列表
 * - 第一级的列表
 */
public class Jdoc {

    private String source;
    private List<Comment> comments;
    private List<FieldDoc> fieldDocs;

    /**
     * 鹏元卡交易数据近 6 个月数据用户最新绑定的信用卡取自 clmg.user_creditcard_infosql如下：
     * <code>
     * select
     * uname, bank_no
     * from
     * user_creditcard_info
     * where
     * uid=num and  bind_status=1 order by id desc limit 1
     * </code>
     * <p>
     * <pre> {@code
     * class DirectExecutor implements Executor {
     *   public void execute(Runnable r) {
     *     r.run();
     *   }
     * }}</pre>
     * <p>
     * 等燕清加了绑定时间后修改成根据绑定时间排序鹏元卡交易数据近 6 个月数据用户最新绑定的信用卡
     * 取自等燕清加了绑定时间后修改成根据绑定时间排序
     */
    public Jdoc(String source) {
        this.source = source;
        comments = new ArrayList<>();
        fieldDocs = new ArrayList<>();
    }

    public static Jdoc build(String source) {
        return new Jdoc(source);
    }

    public static void addType(Type[] type) {

    }

    public List<FieldDoc> parse() {
        parseComments();
        parseDocs();
        return fieldDocs;
    }

    private List<FieldDoc> parseDocs() {
        List<FieldDoc> docs = new ArrayList<>(4);
        comments.forEach(comment -> {
            if (!(comment instanceof JavadocComment)) {
                return;
            }
            JavadocComment javadocComment = (JavadocComment) comment;
            Javadoc javadoc = javadocComment.parse();

            FieldDoc doc = new FieldDoc();
            if (javadoc.getDescription() != null) {
                String text = javadoc.getDescription()
                                     .toText();
                parseDesc(doc, text);
            }

            List<JavadocBlockTag> blockTags = javadoc.getBlockTags();
            if (blockTags == null || blockTags.isEmpty()) {
                return;
            }

            blockTags.forEach(blockTag -> {
                BaseInfo baseInfo = new BaseInfo();
                baseInfo.setName(blockTag.getTagName());
                baseInfo.setValue(blockTag.toText());
                doc.getBaseInfoList()
                   .add(baseInfo);
            });

        });
        return docs;
    }

    private void parseDesc(FieldDoc doc, String text) {
        if (StringUtils.isBlank(text)) {
            return;
        }
        String[] contentList = text.split("\n\n");

    }

    private void parseComments() {
        CompilationUnit compilationUnit;
        try {
            compilationUnit = JavaParser.parse(source);
        } catch (Exception e) {
            throw new ParseException("Java代码解析失败", e);
        }

        List<MethodDeclaration> methods = compilationUnit.getChildNodesByType(MethodDeclaration.class);
        List<Comment> comments = new ArrayList<>(4);

        Optional<Comment> classComment = compilationUnit.getComment();
        if (classComment.isPresent()) {
            comments.add(classComment.get());
        }

        methods.forEach(method -> {
            Optional<Comment> comment = method.getComment();
            if (comment.isPresent()) {
                comments.add(comment.get());
            }
        });

        this.comments = comments;
    }

    public static void main(String[] args) {
        System.out.println(CharSequence.class.isAssignableFrom(String.class));
    }

}
