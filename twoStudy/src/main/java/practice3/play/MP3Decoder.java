package practice3.play;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/30  9:15
 */
public class MP3Decoder implements Decoder{
    @Override
    public boolean canDecode(String path) {
        if(path.endsWith(".mp3")||path.endsWith(".MP3")){
            return true;
        }
        return false;
    }

    @Override
    public String decode(String path) {
        return "解码mp3："+path;
    }
}
