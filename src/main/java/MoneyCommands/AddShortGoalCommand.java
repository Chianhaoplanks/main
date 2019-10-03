package MoneyCommands;

import controlpanel.*;
import Money.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This command adds a short-term goal to the Short-Term Goals List
 */
public class AddShortGoalCommand extends MoneyCommand {

    private String inputString;
    private SimpleDateFormat simpleDateFormat;

    /**
     * Constructor of the command which initialises the add short-term goal command
     * with the goal data within the user input
     * @param cmd add command inputted from user
     */
    public AddShortGoalCommand(String cmd){
        inputString = cmd;
        simpleDateFormat  = new SimpleDateFormat("d/M/yyyy");
    }

    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * This method executes the add short-term goal command. Takes input from user
     * and adds a short-term goal to the Short-Term Goals List
     * @param account Account object containing all financial info of user saved on the programme
     * @param ui Handles interaction with the user
     * @param storage Saves and loads data into/from the local disk
     * @throws ParseException If invalid date is parsed
     * @throws DukeException When the command is invalid
     */
    @Override
    public void execute(Account account, Ui ui, Storage storage) throws ParseException, DukeException {

                String desc = inputString.split("/amt ")[0].replaceFirst("goal-short ", "");
                float price = Float.parseFloat(inputString.split("/amt ")[1].split("/by ")[0]);
               // Date byDate = simpleDateFormat.parse(inputString.split("/by ")[1].split("/priority ")[0]);
                Date byDate = Parser.shortcutTime(inputString.split("/by ")[1].split("/priority ")[0]);
                String priorityLevel = inputString.split("/priority ")[1];
                String category = "GS";
                //System.out.println(priorityLevel);
                Goal g = new Goal(price, desc, category,byDate, priorityLevel);
                account.getShortTermGoals().add(g);

//        System.out.println(" Got it. I've added this task: \n");
//        System.out.println("     " + account.getShortTermGoals().get(account.getShortTermGoals().size()-1).toString() + "\n");
//        System.out.println(" Now you have " + account.getShortTermGoals().size() + " Goals in the list.");
//        System.out.println("Current Goal Savings: $" + account.getGoalSavings());
        ////storage.writeTheFile(account.getShortTermGoals());

        ui.appendToOutput(" Got it. I've added this task: \n");
        ui.appendToOutput("     " + account.getShortTermGoals().get(account.getShortTermGoals().size()-1).toString() + "\n");
        ui.appendToOutput(" Now you have " + account.getShortTermGoals().size() + " Goals in the list.\n");
        ui.appendToOutput("Current Goal Savings: $" + account.getGoalSavings() + "\n");
    }
}