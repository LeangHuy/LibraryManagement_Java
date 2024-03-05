
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // ANSI escape code color
        String red = "\u001B[31m";
        String white = "\u001B[0m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";
        Scanner sc = new Scanner(System.in);
        String name, address,message,option;
        String bookName,authorName,yearActive,publishYear;
        int index = 8;
        boolean conditionCheck = true;
        java.util.Date date = new java.util.Date();


        System.out.println("========== SET UP LIBRARY ==========");

        do{
            System.out.print("=> Enter Library's Name :");
            name = sc.nextLine();
            message = Pattern.matches("[\\w\\s]+", name)?"":red + "Please input Library's name and without special characters" + white;
            if(!message.isEmpty()){
                System.out.println(message);
            }
        }while (!message.isEmpty());

        do{
            System.out.print("=> Enter Library's Address :");
            address = sc.nextLine();
            message = Pattern.matches("[\\w\\s]+", address)?"":red + "Please input Library's address and without special characters" + white;
            if(!message.isEmpty()){
                System.out.println(message);
            }
        }while (!message.isEmpty());
        System.out.println(green+'"'+name.toUpperCase()+'"'+white+" Library is already created in "+blue+'"'+address.toUpperCase()+'"'+white+" successfully on "+date);
        Book[] books = new Book[100];
        books[0] = new Book(1,"A Cambodian Prison Portrait","1998",new Author("Vann Nath","1946-2011"));
        books[1] = new Book(2,"The Candidate","2000",new Author("Bhattacharya","1980-Present"));
        books[2] = new Book(3,"Leadership","2005",new Author("R.D.Pradhan","1990-2020"));
        books[3] = new Book(4,"ModiNomics","2004",new Author("Vijay Darda","1800-1858"));
        books[4] = new Book(5,"Got Of War","1998",new Author("kratos","1985-Present"));
        books[5] = new Book(6,"Hillary Clintos's","2008",new Author("Hillary Clintos","1880-1940"));
        books[6] = new Book(7,"Atomic Habit","2008",new Author("Antony Del","1950-2015"));
        books[7] = new Book(8,"Spider man","2021",new Author("Jon Watts","1985-Present"));
        do {
            System.out.println("\n\n===================== " +green+name.toUpperCase()+white+blue+" ,"+address.toUpperCase()+white+ " =====================");
            System.out.println("1- Add Book");
            System.out.println("2- Show All Books");
            System.out.println("3- Show Available Books");
            System.out.println("4- Borrow Book");
            System.out.println("5- Return Book");
            System.out.println("6- Remove Book");
            System.out.println("7- Search Book");
            System.out.println("8- Exit");
            System.out.println("-----------------------------------------------------");
            do {
                System.out.print(blue+"\n=> Choose option(1-8) : "+white);
                option = sc.nextLine();

                switch (option){
                    case "1":
                        do {
                            System.out.println("================= add book info =================".toUpperCase());
                            System.out.println("=> Book ID : "+(index+1));
                            System.out.print("=> Enter Book's Name : ");
                            bookName = sc.nextLine();
                            System.out.print("=> Enter Book Author Name : ");
                            authorName = sc.nextLine();
                            do{
                                System.out.print("=> Enter Author Year Active : ");
                                yearActive = sc.nextLine();
                                message = Pattern.matches("[^a-z]+", yearActive)?"":red + "Year active can't input with text text. Ex.2000-2024" + white;
                                if(!message.isEmpty()){
                                    System.out.println(message);
                                }
                            }while (!message.isEmpty());

                            do{
                                System.out.print("=> Enter Published Year : ");
                                publishYear = sc.nextLine();
                                message = Pattern.matches("\\d+", publishYear)?"":red + "Publish year can't input with text. Ex.2000  " + white;
                                if(!message.isEmpty()){
                                    System.out.println(message);
                                }
                            }while (!message.isEmpty());

                            books[index] = new Book((index+1),bookName,publishYear,new Author(authorName,yearActive));
                            System.out.println("Book is added successfully😍🎉");
                            index++;
                            System.out.print("Do you want to add more book?(y/n): ");
                            String addMore = sc.nextLine().toLowerCase();
                            if (!addMore.equals("y")){
                                break;
                            }
                        }while (true);
                        conditionCheck = false;
                        break;
                    case "2":
                        CellStyle headerStyle = new CellStyle(CellStyle.HorizontalAlign.center);
                        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
                        table.setColumnWidth(0, 20, 30);
                        table.setColumnWidth(1, 20, 30);
                        table.setColumnWidth(2, 20, 30);
                        table.setColumnWidth(3, 20, 30);
                        table.setColumnWidth(4, 20, 30);
                        table.addCell(blue + "all books info".toUpperCase() + white, headerStyle, 5);
                        table.addCell(blue + "Id".toUpperCase() + white, headerStyle);
                        table.addCell(blue + "title".toUpperCase() + white, headerStyle);
                        table.addCell(blue + "author".toUpperCase() + white, headerStyle);
                        table.addCell(blue + "publish date".toUpperCase() + white, headerStyle);
                        table.addCell(blue + "status".toUpperCase() + white, headerStyle);
                        for (int i = 0;i <index;i++){
                            table(books, headerStyle, table, i);
                        }
                        System.out.println(table.render());
                        System.out.println("Press "+blue+'"'+"Enter"+'"'+white+" to continue...");
                        sc.nextLine();
                        conditionCheck = false;
                        break;
                    case "3":
                        CellStyle headerStyle1 = new CellStyle(CellStyle.HorizontalAlign.center);
                        Table table1 = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
                        table1.setColumnWidth(0, 20, 30);
                        table1.setColumnWidth(1, 20, 30);
                        table1.setColumnWidth(2, 20, 30);
                        table1.setColumnWidth(3, 20, 30);
                        table1.setColumnWidth(4, 20, 30);
                        table1.addCell(blue + "available books info".toUpperCase() + white, headerStyle1, 5);
                        table1.addCell(blue + "Id".toUpperCase() + white, headerStyle1);
                        table1.addCell(blue + "title".toUpperCase() + white, headerStyle1);
                        table1.addCell(blue + "author".toUpperCase() + white, headerStyle1);
                        table1.addCell(blue + "publish date".toUpperCase() + white, headerStyle1);
                        table1.addCell(blue + "status".toUpperCase() + white, headerStyle1);
                        for (int i = 0;i <index;i++){
                            if (books[i].getStatus()){
                                table(books, headerStyle1, table1, i);
                            }
                        }
                        System.out.println(table1.render());
                        conditionCheck = false;
                        break;
                    case "4":
                        System.out.println(blue+"================= borrow book info =================".toUpperCase()+white);
                        System.out.print("=> Enter Book's ID to Borrow : ");
                        String idBorrow = sc.nextLine();

                        int bookIndex = Integer.parseInt(idBorrow)-1;
                        if (bookIndex < 0 || bookIndex >= index ) {
                            System.out.println(red+"Invalid Book's ID. We have only "+index+" books"+" Please try again"+white);
                            break;
                        }
                        CellStyle headerStyle2 = new CellStyle(CellStyle.HorizontalAlign.center);
                        Book borrowBook = books[bookIndex];
                        Table table2 = getTable(blue, white);
                        if (borrowBook.getStatus()){
                            borrowBook.setStatus(false);
                            table2.addCell(String.valueOf(borrowBook.getID()), headerStyle2);
                            table2.addCell((blue+borrowBook.getTitle()+white), headerStyle2);
                            table2.addCell((borrowBook.getAuthor().getAuthorName()+'('+borrowBook.getAuthor().getYearActive()+')'), headerStyle2);
                            table2.addCell((borrowBook.getPublishYear()), headerStyle2);
                            System.out.println(table2.render());
                            System.out.println(blue+borrowBook.getTitle()+white + green+" book is borrowed successfully...🎉🎉"+white);
                        }else {
                            System.out.println(red+"Book's ID " + borrowBook.getID() + " is already borrowed or remove please check again."+white);
                        }
                        conditionCheck = false;
                        break;
                    case "5":
                        System.out.println(blue+"================= borrow book info =================".toUpperCase()+white);
                        System.out.print("=> Enter Book's ID to Return : ");
                        String idReturn = sc.nextLine();
                        int bookIndexReturn = Integer.parseInt(idReturn)-1;
                        CellStyle headerStyle3 = new CellStyle(CellStyle.HorizontalAlign.center);
                        Table table3 = getTable(blue, white);
                        Book returnBook = books[bookIndexReturn];
                        if (returnBook.getTitle().equalsIgnoreCase("remove")) {
                        System.out.println("no return");
                        }
                        if (returnBook.getStatus()){
                                System.out.println(blue+books[bookIndexReturn].getTitle()+white + green+" book is Available"+white);
                            }else {
                                books[bookIndexReturn].setStatus(true);
                                table3.addCell(String.valueOf(books[bookIndexReturn].getID()), headerStyle3);
                                table3.addCell((blue+returnBook.getTitle()+white), headerStyle3);
                                table3.addCell((returnBook.getAuthor().getAuthorName()+'('+returnBook.getAuthor().getYearActive()+')'), headerStyle3);
                                table3.addCell((returnBook.getPublishYear()), headerStyle3);
                                System.out.println(table3.render());
                                System.out.println(blue+returnBook.getTitle()+white + green+" book is return successfully...🎉🎉"+white);
                            }
                            conditionCheck = false;
                        break;

                    case "6":
                        System.out.println(blue + "================= Remove Book =================" + white);
                        System.out.print("=> Enter Book's ID to Remove book : ");
                        String idRemove = sc.nextLine();
                        int indexRemove = Integer.parseInt(idRemove) - 1;
                        CellStyle headerStyle4= new CellStyle(CellStyle.HorizontalAlign.center);
                        Table table4 = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
                        table4.setColumnWidth(0, 20, 30);
                        table4.setColumnWidth(1, 20, 30);
                        table4.setColumnWidth(2, 20, 30);
                        table4.setColumnWidth(3, 20, 30);
                        table4.setColumnWidth(4, 20, 30);
                        table4.addCell(blue + "books info".toUpperCase() + white, headerStyle4, 5);
                        table4.addCell(blue + "Id".toUpperCase() + white, headerStyle4);
                        table4.addCell(blue + "title".toUpperCase() + white, headerStyle4);
                        table4.addCell(blue + "author".toUpperCase() + white, headerStyle4);
                        table4.addCell(blue + "publish date".toUpperCase() + white, headerStyle4);
                        table4.addCell(blue + "status".toUpperCase() + white, headerStyle4);
                        if (indexRemove >= index) {
                            System.out.println(red+"Invalid Book's ID. We have only "+index+" books"+" Please try again"+white);
                        } else {
                            Book removedBook = books[indexRemove];
                            if (!removedBook.getStatus()) {
                                System.out.println(red + "This book has already been borrow or removed. Please check and try again" + white);
                            }else{
                                table4.addCell(String.valueOf(books[indexRemove].getID()), headerStyle4);
                                table4.addCell((blue+removedBook.getTitle()+white), headerStyle4);
                                table4.addCell((removedBook.getAuthor().getAuthorName()+'('+removedBook.getAuthor().getYearActive()+')'), headerStyle4);
                                table4.addCell((removedBook.getPublishYear()), headerStyle4);
                                table4.addCell(((removedBook.getStatus()) ? green+"available".toUpperCase()+white : red+"unavailable".toUpperCase()+white), headerStyle4);
                                System.out.println(table4.render());
                                System.out.println(red+"Are you sure that you want to remove this book?"+white);
                                System.out.println(red+"This Book will permanently remove from library!!!"+white);

                                System.out.print("\nPress" +red+" 1 "+white+"to continue and"+green+" 0"+white+" to cancel :" );
                                int answerRemove = sc.nextInt();
                                sc.nextLine();
                                if (answerRemove == 1){
                                    books[indexRemove] = new Book(indexRemove+1,red+"Remove".toUpperCase(),red+"Remove".toUpperCase(),new Author(red+"Remove".toUpperCase()+white,red+"Remove".toUpperCase()+white));
                                    books[indexRemove].setStatus(false);
                                    System.out.println("Book removed successfully.");
                                }

                            }
                        }
                        conditionCheck = false;
                        break;
                    case "7":
                        System.out.println(blue + "================= Search Books =================" + white);
                        do {
                            System.out.print("=> Enter book titles to search : ");
                            String searchText = sc.nextLine().toLowerCase();
                            boolean found = false;
                            CellStyle headerStyle5= new CellStyle(CellStyle.HorizontalAlign.center);
                            Table table5 = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
                            table5.setColumnWidth(0, 20, 30);
                            table5.setColumnWidth(1, 20, 30);
                            table5.setColumnWidth(2, 20, 30);
                            table5.setColumnWidth(3, 20, 30);
                            table5.setColumnWidth(4, 20, 30);
                            table5.addCell(blue + "books info".toUpperCase() + white, headerStyle5, 5);
                            table5.addCell(blue + "Id".toUpperCase() + white, headerStyle5);
                            table5.addCell(blue + "title".toUpperCase() + white, headerStyle5);
                            table5.addCell(blue + "author".toUpperCase() + white, headerStyle5);
                            table5.addCell(blue + "publish date".toUpperCase() + white, headerStyle5);
                            table5.addCell(blue + "status".toUpperCase() + white, headerStyle5);
                            for (int i = 0; i < index; i++) {
                                String title = books[i].getTitle().toLowerCase();
                                if (title.contains(searchText)) {
                                    if (!found) {
                                        System.out.println(blue+"Search Book Result... :"+white);
                                        found = true;
                                    }
                                    table(books, headerStyle5, table5, i);
                                }
                            }
                            System.out.println(table5.render());
                            if (!found) {
                                System.out.println("Books not found‼️");
                            }
                            System.out.print("Press 1 to search Book again and 0 to cancel : ");
                            int searchAgain = sc.nextInt();
                            sc.nextLine();
                            if (searchAgain != 1){
                                break;
                            }

                        }while (true);
                        conditionCheck = false;
                        break;
                    case "8":
                        System.out.println("(^-^) Good Bye! (^-^)👋👋");
                    return;

                    default:
                        System.out.println(red+"Invalid Option.Please try again!!"+white);
                }
            }while (conditionCheck);

        }while (true);

    }

    private static Table getTable(String blue, String white) {
        CellStyle headerStyle2 = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table2 = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table2.setColumnWidth(0, 20, 30);
        table2.setColumnWidth(1, 20, 30);
        table2.setColumnWidth(2, 20, 30);
        table2.setColumnWidth(3, 20, 30);
        table2.addCell(blue + "all books info".toUpperCase() + white, headerStyle2, 4);
        table2.addCell(blue + "Id".toUpperCase() + white, headerStyle2);
        table2.addCell(blue + "title".toUpperCase() + white, headerStyle2);
        table2.addCell(blue + "author".toUpperCase() + white, headerStyle2);
        table2.addCell(blue + "publish date".toUpperCase() + white, headerStyle2);
        return table2;
    }


    private static void table(Book[] books, CellStyle headerStyle1, Table table1, int i) {
        // ANSI escape code color
        String red = "\u001B[31m";
        String white = "\u001B[0m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";
        table1.addCell(String.valueOf(books[i].getID()), headerStyle1);
        table1.addCell((blue+books[i].getTitle()+white), headerStyle1);
        table1.addCell((books[i].getAuthor().getAuthorName()+" ("+books[i].getAuthor().getYearActive()+")"), headerStyle1);
        table1.addCell(String.valueOf(books[i].getPublishYear()), headerStyle1);
        table1.addCell(((books[i].getStatus()) ? green+"available".toUpperCase()+white : red+"unavailable".toUpperCase()+white), headerStyle1);
    }
}