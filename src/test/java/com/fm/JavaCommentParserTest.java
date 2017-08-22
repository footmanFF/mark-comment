package com.fm;

import org.junit.Test;

/**
 * @author zhangli on 2017/8/22.
 */
public class JavaCommentParserTest {

    @Test
    public void test(){
        String comment = " * @H1 标题1\n" +
                " *\n" +
                " * @{anchor xxx} 锚点，可以跳转到一个当前页面的某个地方\n" +
                " *\n" +
                " * The iterators returned by all of this class's \"collection view methods\n" +
                " * are __fail-fast__: if the map is structurally modified at any time after\n" +
                " * the iterator is created, in any way except through the iterator's own\n" +
                " * ø__remove__ method, the iterator will throw a\n" +
                " * {@link ConcurrentModificationException}.  Thus, in the face of concurrent\n" +
                " * modification, the iterator fails quickly and cleanly, rather than risking\n" +
                " * arbitrary, non-deterministic behavior at an undetermined time in the\n" +
                " * future.\n" +
                " *\n" +
                " * Note that the fail-fast behavior of an iterator cannot be guaranteed\n" +
                " * as it is, generally speaking, impossible to make any hard guarantees in the\n" +
                " * presence of unsynchronized concurrent modification.  Fail-fast iterators\n" +
                " * throw <ConcurrentModificationException> on a best-effort basis.\n" +
                " * Therefore, it would be wrong to write a program that depended on this\n" +
                " * exception for its correctness: __the fail-fast behavior of iterators\n" +
                " * should be used only to detect bugs.__\n" +
                " *\n" +
                " * <Sql>\n" +
                " *     select * from sys_field_manage where col_code='car_evaluate@pawn';\n" +
                " * </Sql>\n" +
                " *\n" +
                " * <Java>\n" +
                " *     public class Jdoc {\n" +
                " *         private String source;\n" +
                " *         private List<Comment> comments;\n" +
                " *         private List<FieldDoc> fieldDocs;\n" +
                " *     }\n" +
                " * <Java/>\n" +
                " *\n" +
                " * @table |xx     |xxxxxx  |xx\n" +
                " * @row   |aaxxx  |aa      |aa\n" +
                " * @row   |aa     |aa      |aa\n" +
                " *\n" +
                " * @refrence Note that the fail-fast behavior of an iterator cannot be guaranteed\n" +
                " *           as it is, generally speaking, impossible to make any hard guarantees in the\n" +
                " *           presence of unsynchronized concurrent modification.  Fail-fast iterators\n" +
                " *           throw __ConcurrentModificationException__ on a best-effort basis.\n" +
                " *           Therefore, it would be wrong to write a program that depended on this\n" +
                " *           exception for its correctness: __the fail-fast behavior of iterators\n" +
                " *           should be used only to detect bugs.__\n" +
                " *\n" +
                " * @list - 第一级的列表\n" +
                " *           - 第二级的列表\n" +
                " *             列表下的内容\n" +
                " *       - 第一级的列表\n" +
                " *           - 第二级的列表\n" +
                " *               - 第三级的列表\n" +
                " *       - 第一级的列表";

        JavaCommentParser.parse(comment);
    }

}
