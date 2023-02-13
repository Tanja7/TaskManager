package ru.netology.javacore;

import java.util.*;

public class Todos {
    private final Set<String> tasks = new TreeSet<>(); // сет для хранения задач
    private final Deque<TodoCommand> list = new LinkedList<>(); // очередь операций

    //Объект класса содержит в себе набор задач, добавленных в систему.
    public Todos() {

    }

    // добавить задачу в список
    public void addTask(String task) {
        int maxTasks = 7;
        if (tasks.size() < maxTasks) {
            tasks.add(task);
        } else {
            System.out.println("Задача \"" + task + "\" не добавлена. Превышен максимальный размер списка!");
        }
    }

    // удалить задачу из списка
    public void removeTask(String task) {
        tasks.remove(task);
    }

    // метод возвращает все задачи через пробел в отсортированном лексикографическом (словарном) порядке.
    public String getAllTasks() {
        Iterator<String> itr = tasks.iterator();
        StringBuilder str = new StringBuilder();
        while (itr.hasNext()) {
            str.append(itr.next()).append(" ");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return tasks.toString();
    }

    public void currentStatus(String message) {
        TodoCommand todoCommand = TodoCommand.fromJson(message);
        switch (todoCommand.getType()) {
            case "add":
                list.addLast(todoCommand);
                addTask(todoCommand.getTask());
                break;
            case "remove":
                list.addLast(todoCommand);
                removeTask(todoCommand.getTask());
                break;
            case "restore":
                if ("add".equals(list.getLast().getType())) {
                    removeTask(list.getLast().getTask());
                } else {
                    addTask(list.getLast().getTask());
                }
                list.removeLast();
                break;
            default:
                System.out.println("Введен некорректный тип операции!!!");
                break;
        }
    }
}
