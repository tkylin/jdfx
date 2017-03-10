package com.tkylin.jdfx.db.model;

import java.util.Date;

public class Author {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.author_id
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private String authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.author_name
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private String authorName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.author_pic
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private String authorPic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.author_sign
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private String authorSign;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.author_synopsis
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private String authorSynopsis;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.author_url
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private String authorUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.author_level
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Integer authorLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.author_article_num
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Integer authorArticleNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.goods_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Integer goodsNums;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.list_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Integer listNums;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.follow_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Integer followNums;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.has_followed
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Integer hasFollowed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.signature
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private String signature;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.create_time
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.update_time
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.status
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.author_id
     *
     * @return the value of author.author_id
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.author_id
     *
     * @param authorId the value for author.author_id
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.author_name
     *
     * @return the value of author.author_name
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.author_name
     *
     * @param authorName the value for author.author_name
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.author_pic
     *
     * @return the value of author.author_pic
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public String getAuthorPic() {
        return authorPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.author_pic
     *
     * @param authorPic the value for author.author_pic
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setAuthorPic(String authorPic) {
        this.authorPic = authorPic == null ? null : authorPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.author_sign
     *
     * @return the value of author.author_sign
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public String getAuthorSign() {
        return authorSign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.author_sign
     *
     * @param authorSign the value for author.author_sign
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setAuthorSign(String authorSign) {
        this.authorSign = authorSign == null ? null : authorSign.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.author_synopsis
     *
     * @return the value of author.author_synopsis
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public String getAuthorSynopsis() {
        return authorSynopsis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.author_synopsis
     *
     * @param authorSynopsis the value for author.author_synopsis
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setAuthorSynopsis(String authorSynopsis) {
        this.authorSynopsis = authorSynopsis == null ? null : authorSynopsis.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.author_url
     *
     * @return the value of author.author_url
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public String getAuthorUrl() {
        return authorUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.author_url
     *
     * @param authorUrl the value for author.author_url
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl == null ? null : authorUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.author_level
     *
     * @return the value of author.author_level
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Integer getAuthorLevel() {
        return authorLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.author_level
     *
     * @param authorLevel the value for author.author_level
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setAuthorLevel(Integer authorLevel) {
        this.authorLevel = authorLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.author_article_num
     *
     * @return the value of author.author_article_num
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Integer getAuthorArticleNum() {
        return authorArticleNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.author_article_num
     *
     * @param authorArticleNum the value for author.author_article_num
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setAuthorArticleNum(Integer authorArticleNum) {
        this.authorArticleNum = authorArticleNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.goods_nums
     *
     * @return the value of author.goods_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Integer getGoodsNums() {
        return goodsNums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.goods_nums
     *
     * @param goodsNums the value for author.goods_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setGoodsNums(Integer goodsNums) {
        this.goodsNums = goodsNums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.list_nums
     *
     * @return the value of author.list_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Integer getListNums() {
        return listNums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.list_nums
     *
     * @param listNums the value for author.list_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setListNums(Integer listNums) {
        this.listNums = listNums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.follow_nums
     *
     * @return the value of author.follow_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Integer getFollowNums() {
        return followNums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.follow_nums
     *
     * @param followNums the value for author.follow_nums
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setFollowNums(Integer followNums) {
        this.followNums = followNums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.has_followed
     *
     * @return the value of author.has_followed
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Integer getHasFollowed() {
        return hasFollowed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.has_followed
     *
     * @param hasFollowed the value for author.has_followed
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setHasFollowed(Integer hasFollowed) {
        this.hasFollowed = hasFollowed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.signature
     *
     * @return the value of author.signature
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public String getSignature() {
        return signature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.signature
     *
     * @param signature the value for author.signature
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.create_time
     *
     * @return the value of author.create_time
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.create_time
     *
     * @param createTime the value for author.create_time
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.update_time
     *
     * @return the value of author.update_time
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.update_time
     *
     * @param updateTime the value for author.update_time
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.status
     *
     * @return the value of author.status
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.status
     *
     * @param status the value for author.status
     *
     * @mbg.generated Sat Mar 11 01:21:03 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}