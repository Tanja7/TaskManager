package ru.netology.javacore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class TodoCommand {

    private final String type;
    private final String task;

    public TodoCommand(@JsonProperty("type") String type, @JsonProperty("task") String task) {
        this.type = type;
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    public static String scannerType() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип операции: ADD - добавить; REMOVE - удалить; RESTORE - отмена последнего действия");
        String typeScan = scanner.nextLine().toLowerCase();
        String taskScan;
        if (!"restore".equals(typeScan)) {
            System.out.println("Введите название задачи");
        taskScan = scanner.nextLine();
        } else {
            taskScan = null;
        }
        TodoCommand todoCommand = new TodoCommand(typeScan, taskScan);
        return todoCommand.toJson(todoCommand);
    }


        public String toJson (TodoCommand todoCommand) throws IOException {

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(todoCommand);
        }
    public static TodoCommand fromJson(String json) {
        //   код для преобразования JSON в Java
        ObjectMapper mapper = new ObjectMapper();
        TodoCommand todoCommand;
        try {
            todoCommand = mapper.readValue(json, TodoCommand.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return todoCommand;
    }
    }
