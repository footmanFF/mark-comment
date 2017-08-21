package com.fm;

import net.steppschuh.markdowngenerator.table.Table;
/**
 * @author zhangli on 2017/8/13.
 */
public class MarkdownTest {

    public static void main(String[] args) {
        Table.Builder builder = new Table.Builder()
                .withAlignments(Table.ALIGN_LEFT, Table.ALIGN_LEFT)
                .addRow("a1", "b1")
                .addRow("a2", "b2")
                .addRow("a3", "b3")
                .addRow("a4", "b4")
                .addRow("a5", "b5");
        
        System.out.println(builder.build());
    }

}