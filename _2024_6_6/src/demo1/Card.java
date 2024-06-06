package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/6  21:43
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
//                ", si=" + rank +
//                '}';
        return suit+rank;
    }
}
