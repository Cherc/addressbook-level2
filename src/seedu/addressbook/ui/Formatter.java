package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.io.PrintStream;
import java.util.Scanner;

public class Formatter {
	public Scanner in;
	public PrintStream out;

	public Formatter() {
	}

	public void showWelcomeMessage(TextUi textUi, String version, String storageFilePath) {
	    String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
	    textUi.showToUser(
	            TextUi.DIVIDER,
	            TextUi.DIVIDER,
	            MESSAGE_WELCOME,
	            version,
	            MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
	            storageFileInfo,
	            TextUi.DIVIDER);
	}

	public void showGoodbyeMessage(TextUi textUi) {
	    textUi.showToUser(MESSAGE_GOODBYE, TextUi.DIVIDER, TextUi.DIVIDER);
	}

	public void showInitFailedMessage(TextUi textUi) {
	    textUi.showToUser(MESSAGE_INIT_FAILED, TextUi.DIVIDER, TextUi.DIVIDER);
	}
}