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
        //=====| User
        // NOTE: Initiating a password like this is not safe at all. In a real-organizational viewpoint, the password would be encrypted
        // and go through other securiy measures. This is only for assesment purposes
        User librarian = new User("Dave", "Machintoch", "Machie", "dave@gmail.com", "Password12345!"); 
        
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
        
        //=====| Members
        List<Member> allMembers = new ArrayList<>();
        allMembers.add(new Member("Kobus", "van Schalkwyk", "kobus.vs.2006@gmail.com"));
        
        //=====| Initializing objects and variables
        // Objects
        Scanner input = new Scanner(System.in);
        
        Author currentAuthor;
        Member currentMember;
        Book currentBook;
        // userInput variables
        
        
        int intInput = 0;
        
        String firstName;
        String lastName;
        String email;
        
        String bookTitle;
        int bookCoverOption;
        int bookCategoryOption;
        int bookPages;
        double bookValue;
        int bookQty;
        Cover bookCover;
        Category bookCategory;
        
        
        
        // Collections framework
        List<Book> allBooks;
        
        
        //===================| Login
        boolean loginSuccessfull = false;
        String password;
        System.out.println("=====| Login |=====");
        while (!loginSuccessfull){
            System.out.println("Email: ");
            email = input.nextLine();
            
            System.out.println("Password: ");
            password = input.nextLine();
            
            if (email.equals(librarian.getEmail())){
                loginSuccessfull = librarian.verifyPassword(password);
            }  
            
            if (!loginSuccessfull){
                System.out.println("Incorrect email or password.\n");
            }
        }
        
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
                //=====| Add Author |=====
                case 1 -> {
                    // Getting author -first and -last name from user
                    System.out.println("===| Creating an Author |===");
                    System.out.println("Enter the first name of the new author: ");
                    firstName = input.nextLine();
                    System.out.println("Enter the last name of the new author");
                    lastName = input.nextLine();
                    
                    // Creating author object
                    authorList.add(new Author(firstName, lastName));
                    
                    System.out.println("============================================================");
                    
                }
                //=====| Add book |=====
                case 2 -> {
                    System.out.println("===| Adding a book to the system |===");
                    
                    // Get author firstName and lastName from user
                    System.out.println("Enter the first name of the books author: ");
                    firstName = input.nextLine();
                    
                    System.out.println("Enter the first name of the books author: ");
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
                        currentAuthor.addBook(bookTitle, bookCover, bookCategory, bookPages, bookValue, bookQty);
                    } catch (Exception e){
                        System.err.println("System error: " + e.getMessage());
                    }
                    System.out.println("Book succesfully created!");
                    System.out.println("============================================================");
                }
                
                case 3 -> { //=====| View available books |=====
                    System.out.println("\n===| Listing all books in the system |===");
                    allBooks = Book.getBooks();
                    for (Book book : allBooks){
                        System.out.println("Book title: " + book.getName() + "\nCurrently available: " + book.getAvailability() + "\n\n");
                    }
                    System.out.println("============================================================");
                }
                
                case 4 -> { //=====| Register member |=====
                    System.out.println("===| Creating a new member |===");
                    
                    // Get member first name, last name and email from user
                    System.out.println("Enter the new members first name: ");
                    firstName = input.nextLine();
                    
                    System.out.println("Enter the new members last name: ");
                    lastName = input.nextLine();
                    
                    System.out.println("Enter the new members email: ");
                    email = input.nextLine();
                    
                    // Create member object
                    try {
                        allMembers.add(new Member(firstName, lastName, email));
                    } catch (Exception e){
                        System.err.println("System exception: " + e.getMessage());
                    }
                    System.out.println("============================================================");

                }
                case 5 -> { //=====| Borrow book |=====
                    System.out.println("===| Borrowing book |===");
                    
                    // --->>> Get member object
                    // Get member email from user
                    System.out.println("Enter member email: ");
                    try {
                        email = input.nextLine();
                    } catch (NullPointerException e){
                        System.out.println("System exception: " + e.getMessage());
                        break;
                    }
                    
                    // Lookup member and save as currentMember
                    currentMember = Member.lookup(email);
                    
                    // --->>> Get book object
                    // Get book title and author name from user
                    System.out.println("\nEnter the title of the book to be borrowed: ");
                    bookTitle = input.nextLine();
                    
                    System.out.println("Enter the first name of the author of the book to be borrowed: ");
                    firstName = input.nextLine();
                    
                    System.out.println("Enter the last name of the author of the book to be borrowed: ");
                    lastName = input.nextLine();
                    
                    // Lookup book
                    currentBook = Book.lookup(bookTitle, firstName, lastName);
                    
                    
                    // --->>> Call the borrow method on the member, passing in the book as a parameter
                    try{
                        currentMember.borrowBook(currentBook);
                    } catch (Exception e) {
                        System.err.println("System error: " + e.getMessage());
                        break;
                    }
                    
                    System.out.println("Succsesfully borrowed book!\n");
                    System.out.println("============================================================");
                    
                }
                case 6 -> { //=====| Return book |=====
                    System.out.println("\n===| Return a book |===");
                    // --->>> Get member
                    // Get member email with user input
                    System.out.println("Enter the member email:");
                    email = input.nextLine();
                    
                    // Lookup member and save it as currentMember
                    System.out.println("Enter member email: ");
                    currentMember = Member.lookup(email);
                    
                    // --->>> GetBook 
                    // Get book title and author name with user input
                    System.out.println("Enter the book title: ");
                    bookTitle = input.nextLine();
                    
                    System.out.println("Enter the authors first name: ");
                    firstName = input.nextLine();
                    
                    System.out.println("Enter the authors last name: ");
                    lastName = input.nextLine();
                    
                    // Lookup book and save it as currentBook
                    currentBook = Book.lookup(bookTitle, firstName, lastName);
                    
                    // --->>> Return book
                    // Use call the return method on currentMember and pass currentBook as a parameter
                    currentMember.returnBook(currentBook);
                    System.out.println("============================================================");
                }
                case 7 -> { //=====| View all members |=====
                    // Get all members list
                    System.out.println("===| Listing all members |===");
                    allMembers = Member.listMembers();

                    // Display list to terminal
                    for (Member member : allMembers){
                        System.out.println(member);
                    }
                    System.out.println("");
                    System.out.println("============================================================");
                }
                case 8 -> { //=====| Exit Program |=====
                    runProgram = false;
                }
                    }

        }
        
        
    }
}
