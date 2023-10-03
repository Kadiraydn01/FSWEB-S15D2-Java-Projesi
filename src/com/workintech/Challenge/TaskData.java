package com.workintech.Challenge;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> nooneTask;

    public TaskData(Set<Task> annsTask, Set<Task> bobsTask, Set<Task> carolsTask, Set<Task> unassignedTasks) {
        this.annsTasks = new HashSet<>();
        this.bobsTasks = new HashSet<>();
        this.carolsTasks = new HashSet<>();
        this.nooneTask = new HashSet<>();
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getNooneTask() {
        return nooneTask;
    }

    public Set<Task> getTasks(String assignee){
        switch (assignee.toLowerCase()){
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(bobsTasks,annsTasks,carolsTasks);
            default:
                try {
                    throw new IllegalAccessException("Invalid Assignee");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }


        }
    }
    public Set<Task> getAllTasks(){
        Set<Task> allTasks = new HashSet<>();
        allTasks.addAll(annsTasks);
        allTasks.addAll(bobsTasks);
        allTasks.addAll(carolsTasks);
        return allTasks;
    }
    public void addTask (Task task){
        switch (task.getAssignee()){
            case "ann":
                annsTasks.add(task);
                break;
            case "bob":
                bobsTasks.add(task);
                break;
            case "carol":
                carolsTasks.add(task);
                break;
            case "all":
                List<Set<Task>> tasklist = new ArrayList<>();
                tasklist.add(annsTasks);
                tasklist.add(bobsTasks);
                tasklist.add(carolsTasks);
                break;
            default:
                new HashSet<>();
        }
    }
    public Set<Task> getUnion(Set<Task>... sets){
    Set<Task> union = new LinkedHashSet<>();
    for(Set<Task> set : sets){
        union.addAll(set);
    }
    return union;
    }
    public Set<Task> getIntersection(Set<Task> set1 , Set<Task> set2){
        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }
    public Set<Task> getDifferences(Set<Task> set1 , Set<Task> set2){
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }
}

