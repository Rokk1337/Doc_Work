package com.company;
import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        File file = new File("Book.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String data = "";
        try
        {
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine())
            {
                data += scanner.nextLine();
            }



            Scanner consoleScanner = new Scanner(System.in);
            String consoleInput = "";
            while (consoleInput.compareTo("EXIT") != 0)
            {
                consoleInput = consoleScanner.nextLine();
                if (consoleInput.compareTo("EXIT") != 0)
                {
                    if (data.indexOf(consoleInput) != -1)
                    {
                        throw new Exception("This phone number already exists");
                    }
                    else
                    {
                        data += consoleInput;
                        data += '\n';
                    }
                }
            }

            printWriter.print(data);
            printWriter.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            printWriter.print(data);
            printWriter.close();
        }
    }
}