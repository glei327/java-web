CREATE TABLE `sequence_value` (
  `name` varchar(100) NOT NULL COMMENT '名称',
  `id` bigint(20) NOT NULL COMMENT 'sequence值',
  PRIMARY KEY (`name`),
  UNIQUE KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sequence表'