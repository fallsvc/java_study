package book;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  21:58
 */
public class BookList {
    private Book[] books=new Book[100];//存放图书最大100本
    private int bookSize;//已经存放的图书

    public BookList() {
        //初始化放入三本图书
       books[0]=new Book("西游记","吴承恩",20,"小说");
       books[1]=new Book("三国演义","罗贯中",30,"小说");
       books[2]=new Book("红楼梦","曹雪芹",40,"小说");
       bookSize=3;
    }

    //访问私有成员变量提供接口
    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getBookSize() {
        return bookSize;
    }

    public void setBookSize(int bookSize) {
        this.bookSize = bookSize;
    }

    //getBook和setBook方法来直接获得书和放书
    public Book getBook(int pos) {
        return books[pos];
    }
    public void setBook(int pos,Book book) {
        this.books[pos] = book;
    }

}
