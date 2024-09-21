package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/9  21:06
 */
public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
//        return "Card{" +
//                "suit='" + suit + '\'' +
//                ", rank='" + rank + '\'' +
//                '}';
        return rank+suit;
    }
}
