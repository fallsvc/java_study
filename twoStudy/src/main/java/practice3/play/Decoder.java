package practice3.play;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/30  9:15
 */
public interface Decoder {
    boolean canDecode(String path);
    String decode(String path);
}
