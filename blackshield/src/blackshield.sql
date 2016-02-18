-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.7-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 blackshield 的数据库结构
CREATE DATABASE IF NOT EXISTS `blackshield` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `blackshield`;


-- 导出  表 blackshield.course 结构
CREATE TABLE IF NOT EXISTS `course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `managerId` int(11) DEFAULT NULL,
  `ctId` int(11) DEFAULT NULL,
  `courseImg` varchar(200) DEFAULT NULL,
  `courseName` varchar(100) DEFAULT NULL,
  `courseDesc` text,
  `publishTime` datetime DEFAULT NULL,
  `studyCount` int(11) DEFAULT '0',
  `path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.course 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`courseId`, `managerId`, `ctId`, `courseImg`, `courseName`, `courseDesc`, `publishTime`, `studyCount`, `path`) VALUES
	(1, 1, 1, '/resource/vidio/a20781f7-64cc-48c9-bacf-e15bedb26769.jpg', 'HTML5测试视频', '测试视频', '2015-12-14 09:08:33', 0, '/resource/vidio/d21d21a7-5b9a-4782-a818-4d34f426ca56.doc'),
	(2, 1, 1, '/resource/vidio/260b0f3e-ea8f-4f9d-897a-812ccb9622f9.jpg', 'HTML入门', '这是一个测试视频', '2015-12-21 20:37:04', 0, '/resource/vidio/896a804e-2cb0-48a7-a199-6cd498ee60af.mp4'),
	(3, 1, 1, '/resource/vidio/1d8f1234-3c83-477b-b464-54a77a3b45fb.bmp', 'testvidio', 'testvidiodesc', '2015-12-22 14:18:55', 0, '/resource/vidio/9d040d9d-fa29-4a0f-816f-59a237511625.mp4'),
	(4, 1, 1, '/resource/vidio/5933fac6-f602-4b61-a23c-b55def386a83.bmp', 'testvidio1', 'tuofang', '2015-12-22 14:31:05', 0, '/resource/vidio/9f60277b-0217-4470-9391-902d71d2eadf.mp4'),
	(5, 1, 2, '/resource/vidio/fc2fa443-5ead-4146-816c-a7a5df25f23a.bmp', 'Java环境配置', '这节视频介绍了WINDOWS系统下JDK的安装和配置', '2015-12-22 15:28:38', 0, '/resource/vidio/08e7d60b-a5ac-47a0-8957-0a7ecd6764b5.mp4');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


-- 导出  表 blackshield.courseneed 结构
CREATE TABLE IF NOT EXISTS `courseneed` (
  `cnId` int(11) NOT NULL AUTO_INCREMENT,
  `cnUsername` varchar(200) NOT NULL,
  `cnEmail` varchar(100) NOT NULL,
  `cnDesc` text,
  `needTime` datetime DEFAULT NULL,
  `qtTime` datetime DEFAULT NULL,
  `cnDeal` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`cnId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.courseneed 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `courseneed` DISABLE KEYS */;
/*!40000 ALTER TABLE `courseneed` ENABLE KEYS */;


-- 导出  表 blackshield.coursetype 结构
CREATE TABLE IF NOT EXISTS `coursetype` (
  `ctId` int(11) NOT NULL AUTO_INCREMENT,
  `ctName` varchar(200) NOT NULL,
  PRIMARY KEY (`ctId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.coursetype 的数据：~18 rows (大约)
/*!40000 ALTER TABLE `coursetype` DISABLE KEYS */;
INSERT INTO `coursetype` (`ctId`, `ctName`) VALUES
	(1, 'HTML5课程'),
	(2, 'Java课程'),
	(3, 'MySQL课程'),
	(4, 'JDBC课程'),
	(5, 'JSP课程'),
	(6, 'JavaScript课程'),
	(7, 'Java进阶课程'),
	(8, 'Servlet课程'),
	(9, 'Ajax课程'),
	(10, 'JQuery课程'),
	(11, 'Struts2课程'),
	(12, 'Spring课程'),
	(13, 'Hibernate课程'),
	(14, 'Oracle课程'),
	(15, 'Maven课程'),
	(16, 'SVN课程'),
	(17, 'Gradle课程'),
	(18, '项目视频');
/*!40000 ALTER TABLE `coursetype` ENABLE KEYS */;


-- 导出  表 blackshield.doc 结构
CREATE TABLE IF NOT EXISTS `doc` (
  `docId` int(11) NOT NULL AUTO_INCREMENT,
  `managerId` int(11) DEFAULT NULL,
  `dtId` int(11) DEFAULT NULL,
  `dname` varchar(200) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `ddesc` text,
  `path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`docId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.doc 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `doc` DISABLE KEYS */;
INSERT INTO `doc` (`docId`, `managerId`, `dtId`, `dname`, `publishTime`, `ddesc`, `path`) VALUES
	(1, 1, 1, '这是一个测试文件', '2015-12-11 15:47:28', '测试文件', '/resource/doc/54015d4e-ef70-4c7a-b69e-a3a98e68f126.dll'),
	(2, 1, 1, '测试问津', '2015-12-11 15:48:49', '测试文件', '/resource/doc/978fc6dc-02ab-4d80-a4b9-c9e528255ce3.xml'),
	(3, 1, 2, 'jdk_api_6.0', '2015-12-11 16:04:56', '这是一个Java的开发接口文档', '/resource/doc/ebd82cd7-69a4-4f92-8ca9-c47185580e23.chm'),
	(4, 1, 2, 'Java in Action', '2015-12-12 10:29:58', '测试文件', '/resource/doc/77087be1-a532-4652-866f-aab1990dc925.chm'),
	(5, 1, 2, 'test', '2015-12-12 10:30:49', 'adfasfasfdad', '/resource/doc/67532650-06a5-4d97-a4c2-1956a111e067.chm'),
	(6, 1, 2, 'Java编程入门', '2015-12-12 15:02:18', '文件描述描述', '/resource/doc/7c858b74-879e-404c-8a2c-c9d72f99f443.chm'),
	(7, 1, 1, 'JDK_API', '2015-12-12 17:38:27', '这是一个JDK API文档', '/resource/doc/9ba6fb5e-c925-487a-9663-8f873d438b04.chm'),
	(8, 1, 1, 'eclipse for javaee', '2015-12-12 19:11:38', '这是一个java web开发IDE', '/resource/doc/8b7fa776-9dad-4d35-9d8d-ff55c23782ea.doc');
/*!40000 ALTER TABLE `doc` ENABLE KEYS */;


-- 导出  表 blackshield.doctype 结构
CREATE TABLE IF NOT EXISTS `doctype` (
  `dtId` int(11) NOT NULL AUTO_INCREMENT,
  `dtName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`dtId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.doctype 的数据：~16 rows (大约)
/*!40000 ALTER TABLE `doctype` DISABLE KEYS */;
INSERT INTO `doctype` (`dtId`, `dtName`) VALUES
	(1, 'Java Web'),
	(2, 'Java SE'),
	(3, 'JavaScript'),
	(4, 'JSP'),
	(5, 'HTML'),
	(6, 'Ajax'),
	(7, 'DWR'),
	(8, 'Servlet'),
	(9, 'Struts2'),
	(10, 'Sprint'),
	(11, 'Hibernate'),
	(12, 'Mybatis'),
	(13, 'Shiro'),
	(14, 'Maven'),
	(15, 'Ant'),
	(16, 'SVN');
/*!40000 ALTER TABLE `doctype` ENABLE KEYS */;


-- 导出  表 blackshield.manager 结构
CREATE TABLE IF NOT EXISTS `manager` (
  `managerId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `realName` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `headerImg` varchar(200) DEFAULT 'headerimg/default.png',
  `email` varchar(50) DEFAULT NULL,
  `registTime` datetime DEFAULT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.manager 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`managerId`, `username`, `password`, `realName`, `phone`, `headerImg`, `email`, `registTime`) VALUES
	(1, 'admin', 'admin', '伟哥', '169686868', 'headerimg/default.png', '3848348@qq.com', NULL),
	(2, 'manager', '123123', '隔壁老王', '13800000000', 'headerimg/default.png', '189764988@qq.com', '2015-12-14 00:00:00');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;


-- 导出  表 blackshield.member 结构
CREATE TABLE IF NOT EXISTS `member` (
  `memberId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `realName` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `headerImg` varchar(200) DEFAULT 'headerimg/default.png',
  `email` varchar(50) DEFAULT NULL,
  `registTime` datetime DEFAULT NULL,
  `islock` int(11) DEFAULT NULL,
  PRIMARY KEY (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.member 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`memberId`, `username`, `password`, `realName`, `phone`, `headerImg`, `email`, `registTime`, `islock`) VALUES
	(11, 'admin', 'admin', '牟文斌', '16868686868', 'headerimg/default.png', 'laomu@163.com', '2015-12-17 00:00:00', 0);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;


-- 导出  表 blackshield.questions 结构
CREATE TABLE IF NOT EXISTS `questions` (
  `qtId` int(11) NOT NULL AUTO_INCREMENT,
  `qtUsername` varchar(200) NOT NULL,
  `quEmail` varchar(100) NOT NULL,
  `qtDesc` text,
  `qtDeal` tinyint(1) DEFAULT NULL,
  `qttime` datetime DEFAULT NULL,
  PRIMARY KEY (`qtId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.questions 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` (`qtId`, `qtUsername`, `quEmail`, `qtDesc`, `qtDeal`, `qttime`) VALUES
	(1, '如贺', 'ruhe@163.com', '提交意见', 1, '2015-12-24 00:00:00');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;


-- 导出  表 blackshield.tools 结构
CREATE TABLE IF NOT EXISTS `tools` (
  `toolsId` int(11) NOT NULL AUTO_INCREMENT,
  `managerId` int(11) DEFAULT NULL,
  `ttId` int(11) DEFAULT NULL,
  `tname` varchar(200) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `tdesc` text,
  `toolsimg` varchar(200) DEFAULT NULL,
  `path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`toolsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.tools 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `tools` DISABLE KEYS */;
INSERT INTO `tools` (`toolsId`, `managerId`, `ttId`, `tname`, `publishTime`, `tdesc`, `toolsimg`, `path`) VALUES
	(1, 1, 1, 'eclipse', '2015-12-12 19:29:48', '这是一个java开发工具', '/resource/tools/cdb22f1a-b098-4890-81e0-72007482233a.jpg', '05db3e5b-286d-4419-96f5-8e273a421709.doc'),
	(2, 1, 1, '测试视频', '2015-12-13 21:11:05', '测试类型', '/resource/tools/fd142f92-a356-47e0-9a3a-6fbbf59056f2.jpg', 'c656d2b8-22bd-40eb-ad45-7954de4949a2.doc'),
	(3, 1, 1, '测试视频视频', '2015-12-13 21:12:05', '这个是测试视频', '/resource/vidio/1ceb071f-c170-4b59-850d-5cb7057e9a83.jpg', '5a569853-42de-4131-909a-588b710c721c.doc'),
	(4, 1, 1, '测试软件', '2015-12-21 15:36:17', '这个是测试软件数据', '/resource/tools/bc976e56-a62a-4c2b-8c69-63b62d1b1804.jpg', '67e6fbaf-2338-4a17-943a-9388aede0162.doc'),
	(5, 1, 1, '再次测试视频', '2015-12-21 15:42:07', 'asfdasdaf', '/resource/tools/e2830d31-65be-454c-b0f7-7612bdcbc283.jpg', '/resource/tools/e0783fd7-a6d5-4d80-8535-3ef016c65811.doc');
/*!40000 ALTER TABLE `tools` ENABLE KEYS */;


-- 导出  表 blackshield.toolstype 结构
CREATE TABLE IF NOT EXISTS `toolstype` (
  `ttId` int(11) NOT NULL AUTO_INCREMENT,
  `ttname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ttId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 正在导出表  blackshield.toolstype 的数据：~18 rows (大约)
/*!40000 ALTER TABLE `toolstype` DISABLE KEYS */;
INSERT INTO `toolstype` (`ttId`, `ttname`) VALUES
	(1, 'Java开发工具'),
	(2, 'C#开发工具'),
	(3, 'python开发工具'),
	(4, 'Unity 3D开发工具'),
	(5, 'C开发工具'),
	(6, 'C++开发工具'),
	(7, 'Ruby开发工具'),
	(8, 'office办公软件'),
	(9, 'PDF阅读软件'),
	(10, '压缩解压软件'),
	(11, '系统杀毒软件'),
	(12, '安全清理软件'),
	(13, '下载软件'),
	(14, '聊天软件'),
	(15, '播放器软件'),
	(16, '图像处理软件'),
	(17, '动画处理软件'),
	(18, '翻译软件');
/*!40000 ALTER TABLE `toolstype` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
