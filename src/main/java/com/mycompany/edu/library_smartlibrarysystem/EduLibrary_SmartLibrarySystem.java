/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.edu.library_smartlibrarysystem;

/**
 *
 * @author kobus
 */
import java.util.*;
public class EduLibrary_SmartLibrarySystem {

    public static void main(String[] args) {
        //===================| Creating mock data for all the classes
        //=====| Categories and covers
        Cover paperback = new Cover("Paperback");
        Cover hardback = new Cover("HardBack");
        
        Category fiction = new Category("Fiction");
        Category nonFiction = new Category("Non Fiction");
        

        
        
        //=====| Author and books
        List<Author> authorList = new ArrayList<>();
        
        authorList.add(new Author("Steven", "Covey"));
        authorList.getLast().addBook("7 Habits of highly effective people", paperback, nonFiction, 391, 230.00d, 5);
        
        authorList.add(new Author("Serah", "Maas"));
        authorList.getLast().addBook("Throne of glass", paperback, fiction, 400, 188.00d, 3);
        
        
        //=====| Initializing objects and variables
        // Objects
        Scanner input = new Scanner(System.in);
        
        Author currentAuthor;
        
        
        // userInput variables
        String strInput = "";
        int intInput = 0;
        
        String firstName;
        String lastName;
        
        String bookTitle;
        int bookCoverOption;
        int bookCategoryOption;
        int bookPages;
        double bookValue;
        int bookQty;
        Cover bookCover;
        Category bookCategory;
        
        
        
        // Collections framework
        List<Member> allMembers;
        List<Book> allBooks;
        
        
        
        //===================| Main loop
        boolean runProgram = true;
        
       // Possible user actions:
       // - Borrow book
       // - Return book
       // - Change book value
       // - Manage member dept
       // - Add book to system
       
       System.out.println("Welcome to version 1 Edu Librarys Smart Library System!\n");
       
              
        while (runProgram == true){
            System.out.println("What do you want to do? Enter the number of the action you want to complete. E.g > 1");
            System.out.println("""
                               1. Add Author
                               2. Add book
                               3. View available books
                               4. Register member
                               5. Borrow book
                               6. Return book
                               7. View all members
                               """);
            intInput = input.nextInt();
            input.nextLine();
            
            

            switch (intInput){
                case 1 -> {
                    // Getting author -first and -last name from user
                    System.out.println("===| Creating an Author |===");
                    System.out.println("Enter the first name of the new author: ");
                    firstName = input.nextLine();
                    System.out.println("Enter the last name of the new author");
                    lastName = input.nextLine();
                    
                    // Creating author object
                    authorList.add(new Author(firstName, lastName));
                }
                case 2 -> {
                    System.out.println("===| Adding a book to the system |===");
                    
                    // Get author firstName and lastName from user
                    System.out.println("Enter author first name of new book: ");
                    firstName = input.nextLine();
                    System.out.println("Enter author last name of new book: ");
                    lastName = input.nextLine();
                    
                    // Lookup author with firstName and lastName and save to currentAuthor
                    currentAuthor = Author.lookup(firstName, lastName);
                    
                    // If author is not found; break after a message
                    if (currentAuthor == null){
                        System.out.println("\nAuthor not found; please try again");
                        break;
                    }
                    
                    // Get book details from user
                    authorList.getLast().addBook("Throne of glass", paperback, fiction, 400, 188.00d, 3);
                    System.out.println("Enter the book title: ");
                    bookTitle = input.nextLine();
                    
                    System.out.println("Is the book a hardback or paperback?\n1. Hardback\n2. Paperback");
                    bookCoverOption = input.nextInt();
                    input.nextLine();
                    
                    System.out.println("It the book fiction or non fiction?\n1. Fiction\n2. Non-Fiction");
                    bookCategoryOption = input.nextInt();
                    input.nextLine();
                    
                    System.out.println("How many pages are in the book?");
                    bookPages = input.nextInt();
                    input.nextLine();
                    
                    System.out.println("How much is the book worth?");
                    bookValue = input.nextDouble();
                    input.nextLine();
                    
                    System.out.println("How many of this books do you have?");
                    bookQty = input.nextInt();
                    input.nextLine();
                    
                    // SafetyNet for bookCover and bookCategory 
                    // NOTE: This is not best practice at all - with more time, a propor method would have been used to ensure both bookCover
                    // and bookCategory has a value
                    bookCover = hardback;
                    bookCategory = fiction;
                    
                    // Create book with user details for currentAuthor
                    
                    switch (bookCoverOption){
                        case 1: 
                            bookCover = hardback;
                            break;
                        case 2: bookCover = paperback;
                         
                        break;
                    }
                    switch (bookCategoryOption){
                        case 1: 
                            bookCategory = fiction;
                            break;
                        case 2: 
                            bookCategory = nonFiction;
                            break;
                    }
                    try{
                        currentAuthor.addBook(lastName, bookCover, bookCategory, bookPages, bookValue, bookQty);
                    } catch (Exception e){
                        System.err.println("System error: " + e);
                    }
                    System.out.println("Book succesfully created!");
                }
                        case 3 -> {
                            allBooks = Book.getBooks();
                            System.out.println("\nHere are all the books in the system:");
                            for (Book book : allBooks){
                                System.out.println("Book title: " + book.getName() + "\nCurrently available: " + book.getAvailability() + "\n\n");
                            }
                }
                        case 4 -> {
                }
                        case 5 -> {
                }
                        case 6 -> {
                }
                        case 7 -> {
                            // Get all members list
                            allMembers = Member.listMembers();

                            // Display list to terminal
                            for (Member member : allMembers){
                                System.out.println();
                            }
                            System.out.println("");
                }
                    }
            //=====| Add author |=====
            //=====| Add book  |=====
            //=====| View available books |=====
            //=====| Register member |=====
            //=====| Borrow book |=====
            //=====| Return book |=====
            //=====| View all members |=====
            
        }
        
        
    }
}
