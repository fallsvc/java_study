package com.falls.demos.mapper;

import com.falls.demos.model.MessageInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/16  11:17
 */
@Mapper
public interface MessageMapper {
    /**
     * 查询所有留言
     */
    @Select("select * from message_info where delete_flag=0")
    List<MessageInfo> queryAll();
    /**
     * 发表留言
     * @return
     */
    @Insert("insert into message_info (`from`,`to`,message) values(#{from},#{to},#{message});")
    Integer insertMessage(MessageInfo messageInfo);
}
