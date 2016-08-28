package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class Formatter {
	public Scanner in;
	public PrintStream out;

	public Formatter() {
	}

	public void showWelcomeMessage(TextUi textUi, String version, String storageFilePath) {
	    String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
	    textUi.formatter.showToUser(
	            textUi, TextUi.DIVIDER,
	            TextUi.DIVIDER,
	            MESSAGE_WELCOME,
	            version,
	            MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
	            storageFileInfo,
	            TextUi.DIVIDER);
	}

	public void showGoodbyeMessage(TextUi textUi) {
	    textUi.formatter.showToUser(textUi, MESSAGE_GOODBYE, TextUi.DIVIDER, TextUi.DIVIDER);
	}

	public void showInitFailedMessage(TextUi textUi) {
	    textUi.formatter.showToUser(textUi, MESSAGE_INIT_FAILED, TextUi.DIVIDER, TextUi.DIVIDER);
	}

	/** Shows message(s) to the user 
	 * @param textUi TODO
	 * @param message TODO*/
	public void showToUser(TextUi textUi, String... message) {
	    for (String m : message) {
	        out.println(TextUi.LINE_PREFIX + m.replace("\n", TextUi.LS + TextUi.LINE_PREFIX));
	    }
	}

	/**
	 * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
	 * command execution segments.
	 * @param textUi TODO
	 * @param result TODO
	 */
	public void showResultToUser(TextUi textUi, CommandResult result) {
	    final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
	    if(resultPersons.isPresent()) {
	        textUi.formatter.showPersonListView(textUi, resultPersons.get());
	    }
	    showToUser(textUi, result.feedbackToUser, TextUi.DIVIDER);
	}

	/**
	 * Shows a list of persons to the user, formatted as an indexed list.
	 * Private contact details are hidden.
	 * @param textUi TODO
	 * @param persons TODO
	 */
	void showPersonListView(TextUi textUi, List<? extends ReadOnlyPerson> persons) {
	    final List<String> formattedPersons = new ArrayList<>();
	    for (ReadOnlyPerson person : persons) {
	        formattedPersons.add(person.getAsTextHidePrivate());
	    }
	    textUi.formatter.showToUserAsIndexedList(textUi, formattedPersons);
	}

	/** Shows a list of strings to the user, formatted as an indexed list. 
	 * @param textUi TODO
	 * @param list TODO*/
	void showToUserAsIndexedList(TextUi textUi, List<String> list) {
	    showToUser(textUi, Formatter.getIndexedListForViewing(list));
	}

	/**
	 * Formats a string as a viewable indexed list item.
	 *
	 * @param visibleIndex visible index for this listing
	 */
	static String getIndexedListItem(int visibleIndex, String listItem) {
	    return String.format(TextUi.MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
	}

	/** Formats a list of strings as a viewable indexed list. */
	static String getIndexedListForViewing(List<String> listItems) {
	    final StringBuilder formatted = new StringBuilder();
	    int displayIndex = 0 + TextUi.DISPLAYED_INDEX_OFFSET;
	    for (String listItem : listItems) {
	        formatted.append(Formatter.getIndexedListItem(displayIndex, listItem)).append("\n");
	        displayIndex++;
	    }
	    return formatted.toString();
	}
}