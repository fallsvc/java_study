package demo2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WAVPlayer {
  private Clip audioClip; // 音频控制对象

  // 播放wav文件
  public void play(File wav) {
    // 创建一个新线程来播放音频，避免阻塞主线程
    new Thread(() -> {
      try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(wav);) { // 获取音频文件
        // 如果已经有音频在播放，先停止并释放资源
        if (audioClip != null && audioClip.isRunning()) {
          audioClip.stop();
          audioClip.close();
        }
        // 打开并开始播放音频
        audioClip = AudioSystem.getClip();
        audioClip.open(audioStream);
        audioClip.start(); // 非阻塞方式
        System.out.printf("准备播放:%s\n", wav.getName());
        try {
          Thread.sleep(1000); // 应对资源加载延时
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        // 等待音频播放完毕
        audioClip.drain(); 
        audioClip.close();
      } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
        System.out.println("播放错误");
      }
    }).start();  // 启动新线程
  }
  public void stop() {
    if (audioClip != null && audioClip.isRunning()) {
      audioClip.stop();
      audioClip.close();
    }
  }
  public static void main(String[] args) {
    WAVPlayer player = new WAVPlayer(); // 实例化播放器
    try(Scanner input = new Scanner(System.in)){
      System.out.print("文件目录：");
      String dir = input.nextLine().trim(); // 读入输入的目录
      File file = new File(dir);
      List<File> wavs = new ArrayList<File>();
      for(File f : file.listFiles()) {
        if(f.getName().toLowerCase().contains(".wav")) {
          wavs.add(f);
        }
      }
      System.out.println("歌曲目录:");
      for(int i = 0; i < wavs.size(); i++) {
        System.out.printf("%d.%s\n", i + 1, wavs.get(i).getName());
      }
      while(true) {
        String number = input.nextLine().trim(); // 读取曲目序号
        int index = -1;
        try {
          index = Integer.parseInt(number) - 1;
        }catch(NumberFormatException ex) {
          System.out.println("歌曲序号格式错误"); // 序号格式错误
        }
        if(index < 0 || index >= wavs.size()) continue; // 索引超出范围
        File target = wavs.get(index);
        player.play(target);
      }
    }
  }
}