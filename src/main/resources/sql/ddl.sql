/* CRETE TABLE BOOK */

CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `created_on` date DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `modified_on` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

