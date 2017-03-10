CREATE TABLE `article` (
  `id` bigint(20) NOT NULL,
  `author_id` varchar(100) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `index_image` varchar(300) DEFAULT NULL,
  `imghost` varchar(100) DEFAULT NULL,
  `like_num` int(11) DEFAULT NULL,
  `pageView` int(11) DEFAULT NULL,
  `pin` varchar(100) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `type_name` varchar(100) DEFAULT NULL,
  `union_id` varchar(100) DEFAULT NULL,
  `video_flag` int(11) DEFAULT NULL,
  `summary` varchar(300) DEFAULT NULL,
  `comment_num` int(11) DEFAULT NULL,
  `banner` varchar(100) DEFAULT NULL,
  `description` text,
  `tags` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)