package practice3.play;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/30  9:16
 */
public class WAVDecoder implements Decoder{
    @Override
    public boolean canDecode(String path) {
        if(path.endsWith(".wav")||path.endsWith(".WAV")){
            return true;
        }
        return false;
    }

    @Override
    public String decode(String path) {
        return "解码wav："+path;
    }
}
