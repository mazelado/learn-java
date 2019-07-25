import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    private static void printShoppingCart(ArrayList<MenuItem> shopping_cart) {
        double subtotal = 0.00;
        double tax_rate = 0.075;
        double scale = Math.pow(10, 2);
        String divider = "                 ---------";

        System.out.println("Your shopping cart:");
        for (MenuItem item : shopping_cart) {
            System.out.printf("  %15s $%6.2f\n", item.getDescription(), item.getPrice());
            subtotal += item.getPrice();
        }
        double tax = Math.round(subtotal * tax_rate * scale) / scale;
        double total = subtotal + tax;
        System.out.println(divider);
        System.out.printf("  Subtotal:       $%6.2f\n", subtotal);
        System.out.printf("  Tax:            $%6.2f\n", tax);
        System.out.println(divider);
        System.out.printf("  Total:          $%6.2f\n", total);
        System.out.println(divider);
    }

    private static void printMenu(ArrayList<MenuItem> choices) {
        System.out.println("Available pizzas:");
        for (MenuItem choice : choices) {
            System.out.printf("  %15s $%6.2f\n", choice.getDescription(), choice.getPrice());
        }
    }

    private static MenuItem getSelection(ArrayList<MenuItem> choices) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which pizza would you like to add: ");
        String user_input = scanner.nextLine();

        for (MenuItem choice : choices) {
            if (user_input.equalsIgnoreCase(choice.getDescription())) {
                return choice;
            }
        }

        MenuItem emptyItem = new MenuItem("", 0.0);
        return emptyItem;
    }

    public static void main(String[] args) {
        ArrayList<MenuItem> shopping_cart = new ArrayList<>();
        ArrayList<MenuItem> choices = new ArrayList<>();

        choices.add(new MenuItem("Cheese", 15.99));
        choices.add(new MenuItem("Pepperoni", 19.99));
        choices.add(new MenuItem("Deluxe", 23.99));
        choices.add(new MenuItem("Done", 0.00));

        while (true) {
            printShoppingCart(shopping_cart);
            printMenu(choices);

            MenuItem selection = getSelection(choices);
            if (selection.getDescription() == "") {
                System.out.println("Sorry, we're out of that one.");
                continue;
            } else if (selection.getDescription() == "Done") {
                printShoppingCart(shopping_cart);
                break;
            } else {
                shopping_cart.add(selection);
                continue;
            }
        }
    }
}

class MenuItem {
    private String description;
    private double price;

    MenuItem(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }
}