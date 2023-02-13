package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

@DisplayName("Тестирование: Todos")
public class TodosTests {
    private final Todos todos = new Todos();

    private TreeSet<String> result = new TreeSet<>();

    @Test
    @DisplayName("Тестирование метода добавления задачи")
    void addTask() {
        todos.addTask("Пробежка");
        todos.addTask("Сон");
        todos.addTask("Акробатика");
        todos.addTask("Учеба");
        todos.addTask("Танцы");
        todos.addTask("Рисование");
        todos.addTask("Лыжи");
        todos.addTask("Бег");
        result.add("Акробатика");
        result.add("Лыжи");
        result.add("Пробежка");
        result.add("Рисование");
        result.add("Сон");
        result.add("Танцы");
        result.add("Учеба");
        Assertions.assertEquals(result.toString(), todos.toString());
    }

    @Test
    @DisplayName("Тестирование метода удаления задачи")
    void removeTask() {
        todos.addTask("Пробежка");
        todos.addTask("Сон");
        todos.addTask("Акробатика");
        todos.addTask("Учеба");
        todos.removeTask("Сон");
        result.add("Акробатика");
        result.add("Пробежка");
        result.add("Учеба");
        Assertions.assertEquals(result.toString(), todos.toString());
    }

    @Test
    @DisplayName("Тестирование метода вывода всех задач")
    void getAllTasks() {
        todos.addTask("Пробежка");
        todos.addTask("Акробатика");
        todos.addTask("Учеба");
        String message = "Акробатика Пробежка Учеба ";
        Assertions.assertEquals(message, todos.getAllTasks());
    }
}
