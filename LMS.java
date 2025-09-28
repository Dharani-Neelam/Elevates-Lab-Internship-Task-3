import java.util.ArrayList;
import java.util.List;

class Book{
  private int id;
  private String title;
  private String author;
  private boolean issue;
  public Book(int id,String title,String author){
    this.id=id;
    this.title=title;
    this.author=author;
    this.issue=false;
  }
  public int getId(){
    return id;
  }
  public String getTitle(){
    return title;

  }
  public String getAuthor(){
    return author;
  }
  public boolean getIssue(){
    return issue;
  }
  // public void setId(int id){
  //   this.id=id;
  // }
  // public void setTitle(String title){
  //   this.title=title;
  // }
  // public void setAuthor(String author){
  //   this.author=author;
  // }
  // public void setIssue(boolean issue){
  //   this.issue=issue;
  // }
  public void issueBook(){
    issue=true;
  }
  public void returnBook(){
    issue=false;
  }


  @Override
  public String toString(){
    return "[id "+id+", title "+title+" ,by "+author+ (issue? "(issued)":"(available)");
  }
}

class User{
  private int userId;
  private String name;
  public User(int userId,String name){
    this.userId=userId;
    this.name=name;
  }
  public int getUserId(){
    return userId;
  }
  public String getName(){
    return name;
  }
  @Override
  public String toString(){
    return "UserId "+userId+" ,UserName "+ name;
  }
}
class Library{
  private List<Book> books;
  public Library(){
    books=new ArrayList<>();
  } 
  public void addBook(Book book){
    books.add(book);
  }
  public void showBooks(){
    for(Book b:books){
      System.out.println(b);
    }
  }
  public void issueBook(int bookId,User user){
    for(Book b:books){
      if(b.getId()==bookId){
        if(!b.getIssue()){
          b.issueBook();
          System.out.println("Book issued succussfull to user "+user.getName());
        }
        else{
          System.out.println("Book is already issued");
        }
        return;
      }
    }
    System.out.println("Book not found");
  }

  public void returnBook(int bookId,User user){
    for (Book b:books){
      if(b.getId()==bookId){
        if (b.getIssue()) {
          b.returnBook();
          System.out.println("Book returned succussfully by user "+user.getName());
        }
        else{
          System.out.println("Book was not issued");
        }
        return;
      }
    }
    System.out.println("Book not found");
  }
}

public class LMS {
  public static void main(String[] args) {
    Library lib=new Library();

    lib.addBook(new Book(1,"Java Programming","James Gosling"));
    lib.addBook(new Book(2,"Python","Eric Matthes"));
    User u1=new User(101, "Asda");
    User u2=new User(102, "Eva");

    System.out.println("Available Books:");
    lib.showBooks();
    lib.issueBook(1, u1);
    lib.issueBook(2, u2);

    lib.returnBook(1, u1);

    System.out.println("\nBooks after transactions:");
    lib.showBooks();
  }
}
