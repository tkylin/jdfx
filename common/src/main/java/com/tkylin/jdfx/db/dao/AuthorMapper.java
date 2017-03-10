package com.tkylin.jdfx.db.dao;

import com.tkylin.jdfx.db.model.Author;
import com.tkylin.jdfx.db.model.AuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    long countByExample(AuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    int deleteByExample(AuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    int deleteByPrimaryKey(String author_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    int insert(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    int insertSelective(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    List<Author> selectByExample(AuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    Author selectByPrimaryKey(String author_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    int updateByPrimaryKeySelective(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table author
     *
     * @mbg.generated Sat Mar 11 00:07:13 CST 2017
     */
    int updateByPrimaryKey(Author record);
}