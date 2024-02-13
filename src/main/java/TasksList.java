public class TasksList {
    private int numberOfTasks = 0;
    private final Task[] tasks = new Task[100];

    public void listTasks() {
        if (isTasksListEmpty()) {
            return;
        }
        printTasksList();
    }

    public void addTask(Task newTask) {
        tasks[numberOfTasks] = newTask;
        numberOfTasks++;
        System.out.println("\tYou have added: " + newTask.getTaskName());
        System.out.println("\tYou have a total of " + numberOfTasks + " completed and uncompleted tasks.");
        System.out.println("\t-------------------------------------------------------------------");
    }

    public void printTasksList() {
        boolean isAllTasksDone = true;
        System.out.println("\tHere's your current list of tasks:");

        for (int i = 0; i < numberOfTasks; i++) {
            Task currentTask = tasks[i];
            if (!currentTask.isTaskDone()) {
                isAllTasksDone = false;
            }
            System.out.println("\t" + (i + 1) + "." + currentTask);
        }
        System.out.println("\tNow you have " + numberOfTasks + " tasks in your list.");

        if (isAllTasksDone) {
            System.out.println("\tExcellent! You have completed all your tasks!");
        }
        System.out.println("\t-------------------------------------------------------------------");
    }
    public boolean isTasksListEmpty() {
        if (numberOfTasks == 0) {
            System.out.println("\tThere are no tasks in your list! Please add some tasks.");
            System.out.println("\t-------------------------------------------------------------------");
            return true;
        }
        return false;
    }
    public void mark(String[] arguments, boolean isDone) {
        if (isTasksListEmpty()) {
            return;
        }

        int taskNumber = Integer.parseInt(arguments[1]) - 1;
        Task taskToEdit = tasks[taskNumber];

        if (isAlreadyMarked(isDone, taskToEdit) || isAlreadyUnmarked(isDone, taskToEdit)) {
            return;
        }

        changeTaskStatus(isDone, taskToEdit, taskNumber);
    }
    private void changeTaskStatus(boolean isDone, Task taskToEdit, int taskNumber) {
        taskToEdit.setTaskDone(isDone);
        if (isDone) {
            System.out.println("\tWell done, you are one step closer to finishing your tasks!");
            System.out.println("\tI've marked this task done for you:");
        } else {
            System.out.println("\tNo worries, let's do our best!");
            System.out.println("\tI've unmarked this task done for you:");
        }
        System.out.println("\t\t" + (taskNumber + 1) + ". " + taskToEdit);
        System.out.println("\t-------------------------------------------------------------------");
    }

    private boolean isAlreadyUnmarked(boolean isDone, Task taskToEdit) {
        if (!taskToEdit.isTaskDone() && !isDone) {
            System.out.println("\tTask is already unmarked!");
            System.out.println("\t-------------------------------------------------------------------");
            return true;
        }
        return false;
    }

    private boolean isAlreadyMarked(boolean isDone, Task taskToEdit) {
        if (taskToEdit.isTaskDone() && isDone) {
            System.out.println("\tTask is already marked done!");
            System.out.println("\t-------------------------------------------------------------------");
            return true;
        }
        return false;
    }
    public int getNumberOfTasks() {
        return numberOfTasks;
    }
}
