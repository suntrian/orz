# for mysql
# create database and tables here

DROP DATABASE IF EXISTS `orz`;
CREATE DATABASE IF NOT EXISTS `orz`;
USE `orz`;

## ORIGINAL Setting
# SET SQL_MODE = "ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION";
SET SQL_MODE = "ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION";

############################################################################################################
#* general component
##############################################################################################################

CREATE TABLE IF NOT EXISTS `options`(
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE COMMENT '选项ID',
  `key` VARCHAR(32) NOT NULL COMMENT '选项类别:“表名.字段名”',
  `name` VARCHAR(32) NOT NULL COMMENT '选项名',
  `upper` INT DEFAULT NULL COMMENT '上级选项',
  `order` TINYINT(2) COMMENT '显示顺序',
  `comment` VARCHAR(255) COMMENT '备注'
) ENGINE = InnoDB CHARSET = utf8;
ALTER TABLE `options` ADD CONSTRAINT `fk_options_options_upper` FOREIGN KEY (`upper`) REFERENCES `options`(`id`)
ON DELETE CASCADE ON UPDATE CASCADE ;
INSERT INTO `options` VALUES (NULL ,"","",NULL ,NULL ,"use for all types");


CREATE TABLE IF NOT EXISTS `operation_record`(
  `id` INT AUTO_INCREMENT NOT NULL UNIQUE COMMENT '关联用户表id',
  `type` TINYINT(3) NOT NULL DEFAULT 0 COMMENT '动作类别：0-无，1-登录，2-登出，3-修改资料……',
  `action` VARCHAR(255),
  `optime` TIMESTAMP DEFAULT current_timestamp
) ENGINE=archive DEFAULT CHARSET =  utf8;

CREATE TABLE IF NOT EXISTS `messages`(
  `id` INT AUTO_INCREMENT NOT NULL UNIQUE COMMENT '消息ID',
  `from` INT COMMENT '发送者',
  `to` INT COMMENT '接收者',
  `content` TEXT,
  `sendtime` TIMESTAMP DEFAULT current_timestamp,
  `recvtime` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = archive CHARSET = utf8 COMMENT '消息';

###############################################################################################################
#*  user component
################################################################################################################

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE COMMENT '用户ID',
  `username` VARCHAR(32) UNIQUE NOT NULL,
  `realname` VARCHAR(32),
  `password` VARCHAR(32) NOT NULL,
  `type` INT COMMENT '用户类型:0-无，1-普通，99-管理员',
  `status` INT COMMENT '用户状态：0-离线，1-在线，2-隐身，99-离职',
  `position` INT DEFAULT 0 COMMENT '岗位',
  `department` INT DEFAULT 0 COMMENT '部门'
) ENGINE=InnoDB DEFAULT CHAR SET = utf8;
ALTER TABLE `users` ADD CONSTRAINT `fk_users_options_type` FOREIGN KEY (`type`) REFERENCES `options`(`id`)
  ON UPDATE CASCADE ON DELETE SET NULL ;
ALTER TABLE `users` ADD CONSTRAINT `fk_users_options_status` FOREIGN KEY (`status`) REFERENCES `options`(`id`)
  ON UPDATE CASCADE ON DELETE SET NULL ;


CREATE TABLE IF NOT EXISTS `users_profile`(
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE COMMENT '关联用户表id',
  `code` VARCHAR(32) COMMENT '人员编号',
  `gender` TINYINT(1) COMMENT '性别:0-无，1-女，2-男',
  `photo` VARCHAR(255) COMMENT '照片地址',
  `birthday` DATE,
  `telphone` VARCHAR(14),
  `email` VARCHAR(64),
  `address` VARCHAR(255),
  `jointime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '入职时间',
  `leavetime` TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL COMMENT '离职时间',
  `comment` VARCHAR(255) COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET = utf8;
ALTER TABLE `users_profile` ADD CONSTRAINT `fk_profile_user_id` FOREIGN KEY (`id`) REFERENCES `users`(`id`)
  ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE IF NOT EXISTS `user_extra`(
  `user` INT NOT NULL COMMENT '用户ID',
  `key` VARCHAR(32) NOT NULL COMMENT 'KEY',
  `value` VARCHAR(255) COMMENT 'VALUE',
  PRIMARY KEY (`user`,`key`)
) ENGINE = InnoDB CHARSET = utf8 COMMENT '用户扩展信息';
ALTER TABLE `user_extra` ADD CONSTRAINT `fk_userextra_users_user` FOREIGN KEY (`user`) REFERENCES `users`(`id`);


CREATE TABLE IF NOT EXISTS `departments`(
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE COMMENT '部门ID',
  `type` INT NOT NULL DEFAULT 0 COMMENT '部门类型：0-无，1-公司，2-部门，3-小组',
  `name` VARCHAR(32) NOT NULL,
  `comment` VARCHAR(255),
  `upper` INT DEFAULT 0 COMMENT '上级部门'
) ENGINE = InnoDB CHARSET = utf8;
ALTER TABLE `departments` ADD CONSTRAINT `fk_departments_departments_upper` FOREIGN KEY (`upper`) REFERENCES `departments`(`id`);
ALTER TABLE `departments` ADD CONSTRAINT `fk_departments_options_type` FOREIGN KEY (`type`) REFERENCES `options`(`id`);
ALTER TABLE `users` ADD CONSTRAINT `fk_users_departments_department` FOREIGN KEY (`department`) REFERENCES `departments`(`id`);


CREATE TABLE IF NOT EXISTS positions(
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE COMMENT '岗位ID',
  `name` VARCHAR(32) NOT NULL ,
  `comment` VARCHAR(255),
  `department` INT,
  `level` INT DEFAULT 0 COMMENT '级别：0-无，1-领导，2-副领导，3-不知道'
) ENGINE = innoDB CHARSET = utf8;
ALTER TABLE positions ADD CONSTRAINT `fk_positions_departments_department` FOREIGN KEY (`department`) REFERENCES `departments`(`id`)
  ON UPDATE CASCADE ON DELETE SET NULL ;
ALTER TABLE `users` ADD CONSTRAINT `fk_users_positions_position` FOREIGN KEY (`position`) REFERENCES positions(`id`);
ALTER TABLE positions ADD CONSTRAINT `fk_postions_options_level` FOREIGN KEY (`level`) REFERENCES `options`(`id`);

##############################################################################################################
#*  project component
#################################################################################################################

CREATE TABLE IF NOT EXISTS `projects`(
  `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE ,
  `name` VARCHAR(32) NOT NULL UNIQUE COMMENT '项目名称',
  `upper` INT DEFAULT NULL COMMENT '父项目',
  `type` INT COMMENT '项目类型',
  `status` INT COMMENT '项目状态',
  `level` INT COMMENT '项目级别',
  `code` VARCHAR(64) COMMENT '项目代号',
  `comment` VARCHAR(255) COMMENT '项目简介',
  `creator` INT COMMENT '创建者',
  `createtime` TIMESTAMP DEFAULT current_timestamp COMMENT '创建时间',
  `starttime` TIMESTAMP COMMENT '项目启动时间',
  `endtime` TIMESTAMP COMMENT '项目结项时间',
  `manager` INT COMMENT '项目经理',
  `department` INT COMMENT '所属部门'
) ENGINE = InnoDB CHARSET = utf8;
ALTER TABLE `projects` ADD CONSTRAINT `fk_projects_projects_upper` FOREIGN KEY (`upper`) REFERENCES `projects`(`id`);
ALTER TABLE `projects` ADD CONSTRAINT `fk_projects_options_type` FOREIGN KEY (`type`) REFERENCES `options`(`id`);
ALTER TABLE `projects` ADD CONSTRAINT `fk_projects_options_status` FOREIGN KEY (`status`) REFERENCES `options`(`id`);
ALTER TABLE `projects` ADD CONSTRAINT `fk_projects_options_level` FOREIGN KEY (`level`) REFERENCES `options`(`id`);
ALTER TABLE `projects` ADD CONSTRAINT `fk_projects_users_creator` FOREIGN KEY (`creator`) REFERENCES `users`(`id`);
ALTER TABLE `projects` ADD CONSTRAINT `fk_projects_users_manager` FOREIGN KEY (`manager`) REFERENCES `users`(`id`);
ALTER TABLE `projects` ADD CONSTRAINT `fk_projects_departments_department` FOREIGN KEY (`department`) REFERENCES `departments`(`id`);

