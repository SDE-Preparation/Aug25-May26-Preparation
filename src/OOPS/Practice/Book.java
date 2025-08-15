package OOPS.Practice;

class Calc{
    public void add(int a, int b){

        System.out.println(a+b);
    }


    public void add(double a, double b){
        System.out.println(a+b);
    }

    public void add(int a, int b, int c){
        System.out.println(a+b+c);
    }


}
public class Book {
    String title, author;
    float price;

    Book(String title1, String author1, float price1){
        this.title = title1;
        this.author = author1;
        this.price = price1;
    }

    public void displayDetails(){
        System.out.println("Title :" + title);
        System.out.println("Author :" + author);
        System.out.println("Price :" + price);
    }

    public static void main(String[] args) {
//        Book author1 = new Book("oops","karan", 500);
//        Book author2 = new Book("dsa","karan", 50330);
//        Book author3 = new Book("cs","karansdfds", 5020);
//
//        author1.displayDetails();
//        author2.displayDetails();
//        author3.displayDetails();

        Calc c = new Calc();
        c.add(1,4);
    }
}
