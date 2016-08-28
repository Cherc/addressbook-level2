package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import seedu.addressbook.common.Utils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class TextUi {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    static final String LS = System.lineSeparator();

    static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    public Formatter formatter = new Formatter();

	public TextUi(){
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.formatter.in = new Scanner(in);
        this.formatter.out = out;
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        formatter.out.print(LINE_PREFIX + "Enter command: ");
        String fullInputLine = formatter.in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = formatter.in.nextLine();
        }

        formatter.showToUser(this, "[Command entered:" + fullInputLine + "]");
        return fullInputLine;
    }

}
