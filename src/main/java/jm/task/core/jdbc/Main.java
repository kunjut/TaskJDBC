package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        // Создание таблицы User(ов)
        userService.createUsersTable();

        // Добавление 4 User(ов) в таблицу с данными на свой выбор.
        userService.saveUser("Jack", "Smith", (byte) 20);
        userService.saveUser("Artur", "Wood", (byte) 10);
        userService.saveUser("Bill", "Bach", (byte) 15);
        userService.saveUser("Bob", "Allen", (byte) 7);

        // Получение всех User из базы и вывод в консоль
        List<User> list = userService.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }

        // Очистка таблицы User(ов)
        userService.cleanUsersTable();

        // Удаление таблицы
        userService.dropUsersTable();

//        System.out.println((connection.isClosed()) ? "true" : "false");
    }
}
