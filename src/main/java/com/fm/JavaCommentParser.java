package com.fm;

import com.fm.markdown.Markdown;
import com.fm.markdown.TagType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author zhangli on 2017/8/22.
 */
public class JavaCommentParser {

    public static final Predicate<String> STRING_NOT_EMPTY = s -> !s.isEmpty();
    private static String BLOCK_TAG_PREFIX = "@";
    private static Pattern BLOCK_PATTERN = Pattern.compile("^" + BLOCK_TAG_PREFIX, Pattern.MULTILINE);

    private static Pattern p = Pattern.compile("\n\n");

    public static List<Markdown> parse(String content){
        List<String> cleanLines = cleanLines(content);
        String comment = cleanLines.stream().collect(Collectors.joining("\n"));
        List<String> blockList = p
                .splitAsStream(comment)
                .filter(STRING_NOT_EMPTY)
                .collect(Collectors.toList());

        List<Markdown> markdownList = new ArrayList<>();
        blockList.forEach((block) -> markdownList.add(parseBlock(block)));
        return markdownList;
    }

    public static Markdown parseBlock(String block){
        block = block.trim().substring(1);
        String tagName = nextWord(block);
        String rest = block.substring(tagName.length()).trim();
        TagType tagType = TagType.getByTagName(tagName);



        return null;
    }



    public static String nextWord(String string) {
        int index = 0;
        while (index < string.length() && !Character.isWhitespace(string.charAt(index))) {
            index++;
        }
        return string.substring(0, index);
    }

    // Visible for testing
    private static int startsWithAsterisk(String line) {
        if (line.startsWith("*")) {
            return 0;
        } else if ((line.startsWith(" ") || line.startsWith("\t")) && line.length() > 1) {
            int res = startsWithAsterisk(line.substring(1));
            if (res == -1) {
                return -1;
            } else {
                return 1 + res;
            }
        } else {
            return -1;
        }
    }

    private static List<String> cleanLines(String content) {
        String[] lines = content.split("\n");
        List<String> cleanedLines = Arrays.stream(lines).map(l -> {
            int asteriskIndex = startsWithAsterisk(l);
            if (asteriskIndex == -1) {
                return l;
            } else {
                // if a line starts with space followed by an asterisk drop to the asterisk
                // if there is a space immediately after the asterisk drop it also
                if (l.length() > (asteriskIndex + 1)) {

                    char c = l.charAt(asteriskIndex + 1);
                    if (c == ' ' || c == '\t') {
                        return l.substring(asteriskIndex + 2);
                    }
                }
                return l.substring(asteriskIndex + 1);
            }
        }).collect(Collectors.toList());
        // lines containing only whitespace are normalized to empty lines
        cleanedLines = cleanedLines.stream().map(l -> l.trim().isEmpty() ? "" : l).collect(Collectors.toList());
        // if the first starts with a space, remove it
        if (!cleanedLines.get(0).isEmpty() && (cleanedLines.get(0).charAt(0) == ' ' || cleanedLines.get(0).charAt(0) == '\t')) {
            cleanedLines.set(0, cleanedLines.get(0).substring(1));
        }
        // drop empty lines at the beginning and at the end
        while (cleanedLines.size() > 0 && cleanedLines.get(0).trim().isEmpty()) {
            cleanedLines = cleanedLines.subList(1, cleanedLines.size());
        }
        while (cleanedLines.size() > 0 && cleanedLines.get(cleanedLines.size() - 1).trim().isEmpty()) {
            cleanedLines = cleanedLines.subList(0, cleanedLines.size() - 1);
        }
        return cleanedLines;
    }

}
