import java.time.LocalDate;

public class EventCommand extends Command {

    private LocalDate from;

    private LocalDate to;

    private String description;

    public EventCommand(String description, LocalDate from, LocalDate to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException{
        Task temp = new Event(description, from, to);
        taskList.addTask(temp);
        ui.printAddTaskMessage(temp, taskList);
        storage.save(taskList);
    }
}
