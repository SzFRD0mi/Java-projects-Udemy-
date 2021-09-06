import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone contacts = new MobilePhone();

    public static void main(String[] args)
    {
        boolean quit = false;

        printOptions();

        while (!quit)
        {
            System.out.print("Enter a number: ");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input)
            {
                case 0:
                    printOptions();
                    break;
                case 1:
                    contacts.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                default:
                    quit = true;
                    System.out.println("Quiting application.");
                    break;
            }

        }
    }

    public static void printOptions()
    {
        System.out.println("Menu: ");
        System.out.println("\t 0 - Print menu options.");
        System.out.println("\t 1 - Print list of contacts.");
        System.out.println("\t 2 - Add a new contact.");
        System.out.println("\t 3 - Update existing contact.");
        System.out.println("\t 4 - Remove contact.");
        System.out.println("\t 5 - Find contact.");
        System.out.println("\t 6 - Quit the application.");
    }

    public static void addContact()
    {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();;
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber);
        contacts.addContact(contact);
    }

    public static void updateContact()
    {
        System.out.print("Enter the name of the contact you would like to update:");
        String oldContactName = scanner.nextLine();
        System.out.print("Enter new contact name: ");
        String name = scanner.nextLine();;
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber);
        contacts.updateContact(oldContactName, contact);
    }

    public static void removeContact()
    {
        System.out.print("Enter the name of the contact you would like to delete:");
        contacts.removeContact(scanner.nextLine());
    }

    public static void findContact()
    {
        boolean found;
        System.out.print("Enter the name of the contact you would like to find: ");
        String contactName = scanner.nextLine();
        if(contacts.onFile(contactName))
        {
            System.out.println("Contact has been found.");
        }
        else
        {
            System.out.println("The provided contact is not set up.");
        }
    }
}
