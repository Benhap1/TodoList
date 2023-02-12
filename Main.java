package practice;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println("Enter command (LIST, ADD, EDIT, DELETE, EXIT):");
            String command = sc.nextLine();

            if (command.equals("EXIT")) {
                break;
            } else if (command.equals("LIST")) {
                System.out.println("Todo List:");
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println(i + ". " + todoList.getTodos().get(i)); //СДЕЛАЛ ПРА
                }
            } else if (command.equals("ADD")) {
                System.out.println("Enter todo:");
                String todo = sc.nextLine();
                System.out.println("Enter index (optional):");
                String indexStr = sc.nextLine();
                if (indexStr.isEmpty()) {
                    todoList.add(todo);
                } else {
                    try {
                        int index = Integer.parseInt(indexStr);
                        todoList.add(index, todo);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid index. Todo not added.");
                    }
                }
            } else if (command.equals("EDIT")) {
                System.out.println("Enter index:");
                String indexStr = sc.nextLine();
                try {
                    int index = Integer.parseInt(indexStr);
                    System.out.println("Enter new todo:");
                    String todo = sc.nextLine();
                    todoList.edit(index, todo);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index. Todo not edited.");
                }
            } else if (command.equals("DELETE")) {
                System.out.println("Enter index:");
                String indexStr = sc.nextLine();
                try {
                    int index = Integer.parseInt(indexStr);
                    todoList.delete(index);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index. Todo not deleted.");
                }
            } else { System.out.println("Invalid command. Try again.");
            }
        }
        sc.close();
    }
}
