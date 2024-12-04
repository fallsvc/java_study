package practice3.play;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/30  9:16
 */
public class Player {
    private Decoder[] decoders={new MP3Decoder(),new WAVDecoder()};
    public void play(String path){
        for (Decoder d : decoders) {
            if(d.canDecode(path)){
                d.decode(path);
                break;
            }
        }
    }
}
