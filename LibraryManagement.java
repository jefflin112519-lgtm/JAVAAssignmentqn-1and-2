/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library.management;

/**
 *
 * @author MARKKLIN JEYA SINGH
 */

import java.util.ArrayList;
import java.util.Scanner;
import library.management.Book;


public class LibraryManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(101, "Java Programming"));
        books.add(new Book(102, "Python Programming"));
        books.add(new Book(103, "Data Structures"));

        System.out.println("Library Books:");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.print("\nEnter Book ID to search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Book Found: " + b.name);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found");
        }

        System.out.print("\nEnter Book ID to remove: ");
        int removeId = sc.nextInt();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id == removeId) {
                books.remove(i);
                System.out.println("Book removed successfully");
                found = true;
                break;
            }
        }

        System.out.println("\nBooks after removal:");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}

   