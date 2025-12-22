package opgave4_command.exercise1;

import java.util.ArrayList;
import java.util.List;
//
// This is the invoker
//
public class RemoteControl {
    List<Command> onCommands = new ArrayList<Command>();
    List<Command> offCommands = new ArrayList<Command>();

    public RemoteControl() {
        onCommands = new ArrayList<Command>();
        offCommands = new ArrayList<Command>();
    }

    public void setCommand(Command onCommand, Command offCommand) {
        onCommands.add(onCommand);
        offCommands.add(offCommand);
        System.out.println("Command added in slot "+ (onCommands.size()-1));
    }

    public void onButtonWasPushed(int slot) {
        onCommands.get(slot).execute();

    }

    public void offButtonWasPushed(int slot) {
        offCommands.get(slot).execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.size(); i++) {
            stringBuff.append("[slot " + i + "] " + onCommands.get(i).getClass().getName()
                    + "    " + offCommands.get(i).getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}