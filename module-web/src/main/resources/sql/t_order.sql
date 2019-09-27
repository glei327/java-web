CREATE TABLE `open`.`t_order`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `created` datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单表';