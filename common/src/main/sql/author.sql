CREATE TABLE `author` (
  `author_id` varchar(100) NOT NULL COMMENT 'id主键',
  `author_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `author_pic` varchar(300) DEFAULT NULL COMMENT '头像',
  `author_sign` varchar(600) DEFAULT NULL COMMENT '签名',
  `author_synopsis` varchar(100) DEFAULT NULL COMMENT '宣言',
  `author_url` varchar(200) DEFAULT NULL,
  `author_level` int(11) DEFAULT NULL COMMENT '等级',
  `author_article_num` int(11) DEFAULT NULL COMMENT '文章数',
  `goods_nums` int(11) DEFAULT NULL COMMENT '单品数',
  `list_nums` int(11) DEFAULT NULL COMMENT '清单数',
  `follow_nums` int(11) DEFAULT NULL COMMENT '粉丝数',
  `has_followed` int(11) DEFAULT NULL,
  `signature` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
)