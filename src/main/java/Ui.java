import java.util.Scanner;

/**
 * Helper User interface class to print results and command prompts to the command line interface that users of CheeseBot
 * interacts with.
 */
public class Ui {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DIVIDER = "\t-------------------------------------------------------------------";

    public void printDivider() {
        System.out.println(DIVIDER);
    }
    public void printGreeting() {
        printDivider();
        String greeting = "\tHello! I'm CheeseBot\n" + "\tWhat can I do for you?";
        System.out.println(greeting);
        printDivider();
    }

    public void printFarewell() {
        String farewell = "\tBye. Hope to see you again soon!";
        System.out.println(farewell);
        printDivider();
    }

    /**
     * Prints the list of commands available to the user. Invoked when the "help" command is supplied by the user.
     */
    public void printCommandList() {
        System.out.println("\tAvailable commands: list, mark, unmark, todo, deadline, event, help, bye\n");
        System.out.println("\tCommand 'list' usage: list\n" +
                "\tFunction: Lists all recorded tasks.\n");

        System.out.println("\tCommand 'mark' usage: mark <task number>\n" +
                "\tFunction: Marks <task number> as completed.\n");

        System.out.println("\tCommand 'unmark' usage: unmark <task number>\n" +
                "\tFunction: Marks <task number> as not completed.\n");

        System.out.println("\tCommand 'todo' usage: todo <task name>\n" +
                "\tFunction: Adds a to do task with no deadline.\n");

        System.out.println("\tCommand 'deadline' usage: deadline <task name> /by <deadline>\n" +
                "\tFunction: Adds a to do task with a deadline.\n");

        System.out.println("\tCommand 'event' usage: event <event name> /from <start time> /to <end time>\n" +
                "\tFunction: Adds an event with the start and end timings.\n");

        System.out.println("\tCommand 'help' usage: help\n" +
                "\tFunction: Lists the available command, along with its usage and functionality.\n");

        System.out.println("\tCommand 'bye' usage: bye\n" +
                "\tFunction: Ends session with CheeseBot.");
    }

    /**
     * Prints an input prompt to ask user to type into the command line interface. Then waits for user to type a
     * command, then return that input line.
     *
     * @return The string input by the user.
     */
    public String printInputPrompt() {
        String inputPrompt = "\tPlease input your desired action or type 'help' for a list of commands: ";
        System.out.println(inputPrompt);
        return SCANNER.nextLine().strip();

    }
}
