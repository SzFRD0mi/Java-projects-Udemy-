import java.util.ArrayList;

public class MobilePhone
{
    private static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void printContacts()
    {
        System.out.println("You have " + contacts.size() + " contacts in your phone.");
        for (int i=0; i<contacts.size(); i++)
        {
            System.out.println((i+1) + ". " + contacts.get(i).getName() + ", " + contacts.get(i).getPhoneNumber());
        }
    }

    public void addContact(Contact contact)
    {
        contacts.add(contact);
    }

    public void updateContact(String oldContactName, Contact newContact)
    {
        boolean foundName = false;
        int i = 0;
        while (!foundName)
        {
            Contact currentContact = contacts.get(i);
            if(currentContact.getName().equals(oldContactName))
            {
                System.out.println(contacts.get(i).getName() + " has been updated.");
                updateContact(i, newContact);
                foundName = true;
            }
            i++;

            if(i == contacts.size())
            {
                break;
            }
        }

        if(!foundName)
        {
            System.out.println(oldContactName + " has not been added to contacts yet.");
        }
    }

    private void updateContact(int index, Contact newContact)
    {
        contacts.set(index, newContact);
        System.out.println("Update successful.");
    }

    public void removeContact(String contactName)
    {
        boolean foundName = false;
        int i = 0;
        while (!foundName)
        {
            if(contacts.get(i).getName().equals(contactName))
            {
                Contact contactToRemove = contacts.get(i);
                contacts.remove(contactToRemove);
                System.out.println(contactToRemove.getName() + " has been removed.");
                foundName = true;
            }
            i++;

            if(i == contacts.size())
            {
                break;
            }
        }

        if(!foundName)
        {
            System.out.println(contactName + "has not been added to contacts yet.");
        }
    }

    public boolean onFile(String contactName)
    {
        boolean foundName = false;
        int i = 0;

        while (!foundName)
        {
            String currentContactName = contacts.get(i).getName();
            if(currentContactName.equals(contactName))
            {
                foundName = true;
            }

            i++;
            if(i == contacts.size())
            {
                break;
            }
        }
        return foundName;
    }
}
