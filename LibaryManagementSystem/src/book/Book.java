package book;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  21:52
 */
public class Book {
    private String name;
    private String author;
    private double price;
    private String type;
    private Boolean status;

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
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", auther='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }
}
