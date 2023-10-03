package com.workintech.Challenge;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Java Collections", "Write List Interface",
                        "Ann", Priority.LOW, Status.IN_QUEUE);
        Task task2 = new Task("Java Collections", "Write Set Interface",
                        "Ann", Priority.MED, Status.ASSIGNED);
        Task task3 = new Task("Java Collections", "Write Map Interface",
                        "Bob", Priority.HIGH, Status.IN_QUEUE);
        Task task4 = new Task("Java Collections", "Write Queue Interface",
                        "Carol", Priority.LOW, Status.ASSIGNED);
        Task task5 = new Task("Java Collections", "Write Stack Interface",
                        "Carol", Priority.MED, Status.IN_QUEUE);
        Task task6 = new Task("Java Collections", "What is Abstract Class",
                        "Dogancan", Priority.MED, Status.IN_QUEUE);
        Task task7 = new Task("Java Collections", "Write Set Interface",
                        "Carol", Priority.MED, Status.ASSIGNED);


        Set<Task> totalTasks = new HashSet<>();
        totalTasks.add(task1);
        totalTasks.add(task2);
        totalTasks.add(task3);
        totalTasks.add(task4);
        totalTasks.add(task5);
        totalTasks.add(task6);
        totalTasks.add(task7);

        Set<Task> annsTask = new LinkedHashSet<>();
        annsTask.add(task1);
        annsTask.add(task2);
        Set<Task> bobsTask = new LinkedHashSet<>();
        bobsTask.add(task3);

        Set<Task> carolsTask = new LinkedHashSet<>();
        carolsTask.add(task4);
        carolsTask.add(task5);
        carolsTask.add(task7);

        Set<Task> unassignedTasks = new LinkedHashSet<>();
        unassignedTasks.add(task6);

        TaskData taskData = new TaskData(annsTask, bobsTask, carolsTask, unassignedTasks);

        System.out.println("******************");
        System.out.println("ALL TASKS");
        System.out.println(taskData.getTasks("ALL"));

        System.out.println("*****************");
        System.out.println("ANN'S TASKS");
        System.out.println(taskData.getTasks("ANN"));

        System.out.println("*****************");
        System.out.println("BOB'S TASKS");
        System.out.println(taskData.getTasks("BOB"));

        System.out.println("*****************");
        System.out.println("CAROL'S TASKS");
        System.out.println(taskData.getTasks("CAROL"));

        System.out.println("*****************************");
        System.out.println(taskData.getDifferences(totalTasks, taskData.getTasks("ALL")));

        System.out.println("*****************************");
        System.out.println("ANN+CAROL :" + taskData.getIntersection(annsTask, carolsTask));
        System.out.println("BOB+CAROL :" + taskData.getIntersection(bobsTask, carolsTask));
        System.out.println("ANN+BOB :" + taskData.getIntersection(annsTask, bobsTask));

    }
}