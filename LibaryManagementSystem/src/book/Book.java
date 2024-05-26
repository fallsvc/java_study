package book;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  21:52
 */
public class Book {
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
>>>>>>> Stashed changes
    private String name;
    private String author;
    private double price;
    private String type;
    private Boolean status;
<<<<<<< Updated upstream
=======
=======
    private String name;//书名
    private String author;//作者
    private double price;//价格
    private String type;//书的类型
    private boolean status;//默认false 书的状态
>>>>>>> Stashed changes
>>>>>>> Stashed changes

    public Book(String name, String author, double price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
<<<<<<< Updated upstream
    public String toString() {
=======
    public String toString() { //重写toString方法来打印书
>>>>>>> Stashed changes
        return "Book{" +
                "name='" + name + '\'' +
                ", auther='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }
}
