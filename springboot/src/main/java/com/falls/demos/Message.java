package com.falls.demos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/6  10:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String from;
    private String to;
    private String message;

}
