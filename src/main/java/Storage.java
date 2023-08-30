import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private String path;

    public Storage(String path) {
        this.path = path;
    }


    public void save(TaskList taskList) throws DukeException{
        try {
            FileWriter fw = new FileWriter(path);
            for (int i = 0; i < taskList.size(); i++) {
                fw.write(taskList.getTask(i).saveString() + '\n');
            }
            fw.close();
        } catch (IOException e) {
            throw new DukeException(e.getMessage());
        }
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> taskList = new ArrayList<>();
        File f = new File(path);
        Scanner sc;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new DukeException(e.getMessage());
        }
        while (sc.hasNext()) {
            String input = sc.nextLine();
            Task temp = Parser.parseSaveFile(input);
            taskList.add(temp);
        }
        sc.close();
        return taskList;
    }
}
