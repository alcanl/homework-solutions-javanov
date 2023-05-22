package org.csystem.homework.solution.homework_13;

import java.util.Scanner;

import static org.csystem.util.string.StringUtil.countString;
import static org.csystem.util.string.StringUtil.reverse;

public class CommandLineApp {
    private static Scanner kb;
    final private static String ms_len = "length";
    final private static String ms_rev = "reverse";
    final private static String ms_upp = "upper";
    final private static String ms_low = "lower";
    private String m_input;

    public CommandLineApp()
    {
        this(new Scanner(System.in));
    }
    private CommandLineApp(Scanner keyboard)
    {
        kb = keyboard;
    }
    private void getInput()
    {
        System.out.print("CSD>");
        m_input = kb.nextLine().strip().toLowerCase();
    }
    private boolean isValidInput()
    {
        if (m_input.isEmpty())
            return false;

        if (!m_input.startsWith("len") && !m_input.startsWith("rev") && !m_input.startsWith("upp") && !m_input.startsWith("low")) {
            System.out.println("Invalid command, the command line must starts with one of these : (len, rev, upp, low, qui)");
            return false;
        }
        if (!m_input.endsWith("\"") || countString(m_input, "\"") != 2) {
            System.out.println("Invalid command value, the value must be given in double quotes");
            return false;
        }
        return true;
    }
    private void runCommand()
    {
        String [] temp = m_input.split("[\"]+");

        String command = temp[0].strip();
        String value = temp[1].strip();

        commandProcess(command, value);
    }
    private static void commandProcess(String command, String value) {

        if (ms_len.contains(command)) {
            System.out.println(value.length());
            return;
        }
        if (ms_rev.contains(command)) {
            System.out.println(reverse(value));
            return;
        }
        if (ms_upp.contains(command)) {
            System.out.println(value.toUpperCase());
            return;
        }
        if (ms_low.contains(command)) {
            System.out.println(value.toLowerCase());
            return;
        }

        System.out.println("Invalid command!");
    }
    public void run ()
    {
        for(;;) {
            getInput();

            if (m_input.equals("quit") || m_input.equals("qui"))
                break;

            if (isValidInput())
                runCommand();
        }
    }
}
