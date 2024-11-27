package practice4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/20  8:48
 */
public class Student {
    private String id; // 学号
    private int scoreA; // 成绩A
    private int scoreB; // 成绩B
    private int scoreC; // 成绩C

    public static Student[] readFromFile(String path, int num) {
        // 待完成
        Path path1= Paths.get(path);
        Student[] students=new Student[num];
        try{
            List<String> list=Files.readAllLines(path1);
            for (int i = 0; i < list.size(); i++) {
                String[] items=list.get(i).split(",");
                int scoreA=Integer.parseInt(items[1]);
                int scoreB=Integer.parseInt(items[2]);
                int scoreC=Integer.parseInt(items[3]);
                students[i]=new Student(items[0],scoreA,scoreB,scoreC);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public int totalScore() {
        // 待完成
        return scoreA+scoreB+scoreC;
    }

    public static void sortByTotalScore(Student[] s) {
        // 待完成
        Comparator<Student> comparator=new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.totalScore()-o2.totalScore();
            }
        };
        Arrays.sort(s,comparator);
    }

    public Student(String id, int scoreA, int scoreB, int scoreC) {
        // 待完成
        this.id=id;
        this.scoreA=scoreA;
        this.scoreB=scoreB;
        this.scoreC=scoreC;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getScoreA() {
        return scoreA;
    }
    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }
    public int getScoreB() {
        return scoreB;
    }
    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }
    public int getScoreC() {
        return scoreC;
    }
    public void setScoreC(int scoreC) {
        this.scoreC = scoreC;
    }
    public String toString() {
        return id + "," + scoreA + "," + scoreB + "," + scoreC + "," + totalScore();
    }
}