package practice4.markdown;

import javafx.scene.control.TextArea;
public class FileTextArea extends TextArea{
  private String path;
  // 加载文本
  public void load(String filePath) {
    this.path = filePath;
    this.setText(FileTool.read(filePath));
  }
  // 文本保存
  public void save() {
    FileTool.save(path, this.getText());
  }
  // 文本另存为
  public void saveAs(String newPath) {
    this.path = newPath;
    FileTool.save(newPath, this.getText());
  } 
}