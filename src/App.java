import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Object[][] toDo = new Object[10][3];

        while(true){
            System.out.println("Please enter a command");
            System.out.println("Type 'help' to read documentation...");

            String command = sc.nextLine();
            
            //create
            if(command.equals("create")){
                System.out.println("in the create branch...");

                System.out.print("Enter the item description:");
                String description = sc.nextLine();

                System.out.println("Enter the due date:");
                System.out.print("Year:");
                int year = sc.nextInt();
                System.out.print("Month:");
                int month = sc.nextInt();
                System.out.print("Date:");
                int date = sc.nextInt();

                Calendar dueDate = new GregorianCalendar(year,month,date);

                System.out.println("Enter the id number");
                int id = sc.nextInt();

                Object[] object = {description, dueDate, "pending"};
                toDo[id] = object;

                System.out.println("The item has been entered");

            }

            //list
            if(command.equals("list")){
                System.out.println("in the list branch...");

                for(int i = 0; i < toDo.length; i++){
                    if(toDo[i][0] != null){
                        System.out.println("description: " + toDo[i][0]);
                        System.out.println("status: " + toDo[i][2]);
                        // Calendar calendar = (Calendar)toDo[i][1];
                        Calendar calendar = (Calendar)toDo[i][1];
                        // System.out.println(calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR));
                        System.out.println(calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR));
                    }
                }
            }

            //read
            if(command.equals("read")){
                System.out.println("in the read branch...");

                System.out.println("Enter the item number:");
                int id = sc.nextInt();

                System.out.println("description: " + toDo[id][0]);
                System.out.println("status: " + toDo[id][2]);

                Calendar calendar = (Calendar)toDo[id][1];
                System.out.println(calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR));
            }

            //update
            if(command.equals("update")){
                System.out.println("in the update branch...");

                System.out.println("Enter the number:");
                int id = Integer.parseInt(sc.nextLine());

                System.out.println("description: " + toDo[id][0]);
                System.out.println("status: " + toDo[id][2]);
                Calendar calendar = (Calendar)toDo[id][1];
                System.out.println(calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR));

                System.out.print("Enter an item description:");
                String description = sc.nextLine();

                System.out.print("Enter the status:");
                String status = sc.nextLine();

                System.out.println("Enter a due date:");
                System.out.print("year:");
                int year = sc.nextInt();
                System.out.print("month:");
                int month = sc.nextInt();
                System.out.println("date:");
                int date = sc.nextInt();
                Calendar dueDate = new GregorianCalendar(year,month,date);

                Object[] object = {description,dueDate,status};
                toDo[id] = object;

                System.out.println("The item has been updated");
            }

            //delete
            if(command.equals("delete")){
                System.out.println("in the delete branch...");

                System.out.println("Enter the item number:");
                int id = Integer.parseInt(sc.nextLine());

                System.out.println("description: " + toDo[id][0]);
                System.out.println("status: " + toDo[id][2]);
                Calendar calendar = (Calendar)toDo[id][1];
                System.out.println(calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR));

                System.out.println("delete it ? yes or no:");
                String delete = sc.nextLine();

                if(delete.equals("yes")){
                    toDo[id][0]=null;
                    toDo[id][1]=null;
                    toDo[id][2]=null;
                    System.out.println("The item has been deleted");
                }else{
                    System.out.println("The item was not deleted");
                }
            }

            //size
            if(command.equals("size")){
                System.out.println("in the size branch...");

                System.out.println("WARNING: Data will be lost!");
                System.out.println("Still want to resize? yes or no?");
                String delete = sc.nextLine();

                if(delete.equals("yes")){
                    System.out.println("what is the new size of the list?:");
                    int size = Integer.parseInt(sc.nextLine());
                    toDo = new Object[size][3];
                    System.out.println("The list has been resized");
                }else{
                    System.out.println("The list was not resized");
                }
            }

            //restart
            if(command.equals("restart")){
                System.out.println("in the restart branch...");

                System.out.println("WARNING: Data will be lost!");
                System.out.println("Still want to restart? yes or no?");
                String delete = sc.nextLine();

                if(delete.equals("yes")){
                    toDo = new Object[10][3];
                    System.out.println("The app has been restarted");
                }else{
                    System.out.println("The app was not restarted");
                }
            }

            //exit
            if(command.equals("exit")){
                System.out.println("the app has exited...");
                break;
            }

            //help
            if(command.equals("help")){
                System.out.println("in the help branch...");
                System.out.println("Below is a description of the possible commands");

                System.out.println("create - create a new to do list");
                System.out.println("list - list all of the to do items");
                System.out.println("read - read a to do list item by item number");
                System.out.println("update - update a to do list item by item number");
                System.out.println("delete - delete a to do list item by item number");
                System.out.println("size - resize the to do list");
                System.out.println("restart - restart the application (all data lost)");
                System.out.println("exit - exit the application");
                System.out.println("help - get helpful information about the commands");
            }
        }
    }
}
