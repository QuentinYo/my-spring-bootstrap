create database `my_demo`;

use `my_demo`;

create table `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL DEFAULT '0' COMMENT "年龄",
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `create_time` bigint(20) NOT NULL DEFAULT '0' COMMENT "创建时间",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;