package demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/6  21:44
 */
public class CardDemo {
    public static final String[] suits={"♥","♠" ,"♣","♦"};

    //买牌
    public List<Card> buyCard(){
        List<Card> ret=new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            for (int j = 0; j < 4; j++) {
                String rank=i+"";
                String suit=suits[j];
                ret.add(new Card(suit,rank));
            }
        }
            for (int j = 0; j < 4; j++) {
                String rank="J";
                String suit=suits[j];
                ret.add(new Card(suit,rank));
            }
        for (int j = 0; j < 4; j++) {
            String rank="Q";
            String suit=suits[j];
            ret.add(new Card(suit,rank));
        }
        for (int j = 0; j < 4; j++) {
            String rank="K";
            String suit=suits[j];
            ret.add(new Card(suit,rank));
        }
        return ret;
    }
    //洗牌
    public void shuffle(List<Card> c){
        Random random=new Random();
        for (int i = c.size()-1; i > 0 ; i--) {
            int index=random.nextInt(i);
            swap(c,i,index);
        }

    }
    public void swap(List<Card> c,int i,int j){
        Card tmp=c.get(i);
        c.set(i,c.get(j));
        c.set(j,tmp);
    }
    //拿牌
    public List<List<Card>> play(List<Card> c){
        List<List<Card>> ret=new ArrayList<>();
        List<Card> p1=new ArrayList<>();
        List<Card> p2=new ArrayList<>();
        List<Card> p3=new ArrayList<>();

        ret.add(p1);
        ret.add(p2);
        ret.add(p3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card tmp=c.remove(0);

                ret.get(j).add(tmp);
            }
        }

        return ret;
    }

}
















