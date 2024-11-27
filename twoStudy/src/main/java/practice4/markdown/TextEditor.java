package practice4.markdown;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
public class TextEditor extends Application{
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    
    VBox global = new VBox();
    
    MenuBar mb = new MenuBar();
    Menu menu = new Menu("文件");
    MenuItem newItem = new MenuItem("新建");
    MenuItem openItem = new MenuItem("打开");
    MenuItem saveItem = new MenuItem("保存");
    MenuItem saveAsItem = new MenuItem("另存为..");
    menu.getItems().addAll(newItem, openItem, saveItem, saveAsItem);
    mb.getMenus().add(menu);
    
    FileTextArea textArea = new FileTextArea();
    textArea.setFont(Font.font("Arial", 22));  // 设置字体
    VBox textLayout = new VBox();
    textLayout.setPadding(new Insets(5.0));
    textLayout.getChildren().add(textArea);
    global.getChildren().addAll(mb, textLayout);
    
    // 剩余空间填充
    VBox.setVgrow(textArea, Priority.ALWAYS);
    VBox.setVgrow(textLayout, Priority.ALWAYS);
    
    // 新建
    newItem.setOnAction(e -> {
      FileChooser chooser = new FileChooser();
      chooser.getExtensionFilters().add(new ExtensionFilter("文本文件", ".txt", ".md"));
      File selected = chooser.showSaveDialog(primaryStage);
      if(selected != null) {
        textArea.clear(); // 清理
        textArea.saveAs(selected.getPath());
      }
    });
    
    // 打开
    openItem.setOnAction(e -> {
      FileChooser file = new FileChooser();
      File selected = file.showOpenDialog(primaryStage);
      if(selected != null) {
        textArea.load(selected.toPath().toString());
      }
    });
    // 保存
    saveItem.setOnAction(e -> {
      textArea.save();
    });
    // 另存为
    saveAsItem.setOnAction(e -> {
      FileChooser chooser = new FileChooser();
      chooser.getExtensionFilters().add(new ExtensionFilter("文本文件", ".txt", ".md"));
      File selected = chooser.showSaveDialog(primaryStage);
      if(selected != null) {
        textArea.saveAs(selected.getPath());
      }
    });
    
    Scene scene = new Scene(global, 500, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("文本编辑器");
    primaryStage.show();
  }
}