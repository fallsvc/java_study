package com.fallsvc.book.adapter;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/24  11:09
 */
public class LogbackSlf4jAdapter implements Slf4jApi{
    private Logback logback;

    public LogbackSlf4jAdapter(Logback logback) {
        this.logback = logback;
    }

    @Override
    public void log(String msg) {
        logback.print(msg);
    }
}
