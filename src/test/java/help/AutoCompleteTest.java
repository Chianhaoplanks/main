package help;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AutoCompleteTest {
    private final String[] list = {
            "init [existing savings] [Avg Monthly Expenditure]",
            "add income [desc] /amt [amount in dollars] /on [d/mm/yyyy]",
            "spent [desc] /amt [amount in dollars] /cat [category] /on [d/mm/yyyy]",
            "delete income [index]",
            "delete expenditure [index]",
            "list all income",
            "list all expenditure",
            "list month income",
            "list month expenditure",
            "check income [month] [year]",
            "check expenditure [month] [year]",
            "goal [desc] /amt [cost] /by [d/M/yyyy] /priority [priority level]",
            "delete goal [index]",
            "list goals",
            "done goal [index]",
            "commit goal [index 1, index 2,...]",
            "add instalment [desc] /amt [cost] /within [number of months] months /from [d/M/yyyy] /percentage [annual interest rate]",
            "delete instalment [index]",
            "list all instalments",
            "lent [other party] /amt [cost] /on [date]",
            "borrowed [other party] /amt [cost] /on [date]",
            "delete loan [index]",
            "list all loans",
            "list incoming loans",
            "list outgoing loans",
            "paid [amount] /to [other party]",
            "received [amount] /from [other party]",
            "split [desc] /amt [amount in dollars] /on [d/m/yyyy] /parties [other party] and [other party] and ...",
            "settle [index] [index/name of party]",
            "bank-account [desc] /amt [initial amount of money] /at [initial date] /rate [interest rate]",
            "delete bank-account [index of the tracker]",
            "check-balance [desc] /at [the future date]",
            "deposit [amount] [desc] /at [date]",
            "withdraw[amount] [desc] /at [date]",
            "list bank trackers",
            "graph monthly report",
            "graph monthly report histogram",
            "graph monthly report line_graph",
            "graph monthly report pie_chart",
            "graph income trend",
            "graph income trend histogram",
            "graph income trend line_graph",
            "graph income trend pie_chart",
            "graph expenditure trend",
            "graph expenditure trend histogram",
            "graph expenditure trend line_graph",
            "graph expenditure trend pie_chart",
            "graph financial status /until [date]",
            "undo",
            "bye"
    };
    private List<String> commandList = Arrays.asList(list);

    public AutoCompleteTest() {
        Collections.sort(commandList);
    }

    @Test
    public void testGetAutoComplete() {
        AutoComplete autoComplete = new AutoComplete();
        assertEquals(commandList, autoComplete.getCommandList());
    }
}