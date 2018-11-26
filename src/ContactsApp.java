import util.Input;

import java.util.*;

public class ContactsApp {

    private static Input input = new Input(new Scanner(System.in));
//    private Map<String, Integer> contacts = new HashMap<>();

    private List<Contact> contacts = new ArrayList<>();

    public static void menu(){
        String output = "1. view\n"
                + "2. add \n"
                + "3. search\n"
                + "4. delete\n"
                + "5. exit";
        System.out.println(output);
    }

    public static void init(){
        menu();

        action(input.getInt(1, 5, "Enter an option"));

    }

    public static boolean action(int choice){
        boolean continueRunning = true;
        switch(choice){
            case 1:
                view();
                break;
            case 2:
                add();
                break;
            case 3:
                search(input.getString("Enter contact name"));
                break;
            case 4:
                delete(input.getString("Enter contact name to delete"));
                break;
            case 5:
                if(!input.yesNo("Continue running?")){
                    continueRunning = false;
                }
                break;
        }
        return continueRunning;
    }

    public static void view() {

    }

    public static void add() {

    }

    public static void search(String keyName) {

    }

    public static void delete(String keyName) {

    }

    public static void main(String[] args) {


        init();
    }
}
