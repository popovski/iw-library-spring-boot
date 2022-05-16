/* CRETE database iw_library */
CREATE DATABASE `iw_library` DEFAULT CHARACTER SET utf8;

USE `iw_library`;

/* CRETE TABLE BOOK */

CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `created_on` timestamp DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `modified_on` timestamp DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

/* CRETE TABLE AUTHOR */

CREATE TABLE `author` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `created_on` timestamp DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `modified_on` timestamp DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=1;


CREATE TABLE iw_library.author_book_mapping (
	author_id BIGINT NOT NULL,
	book_id BIGINT NOT NULL,
	CONSTRAINT author_book_mapping_FK FOREIGN KEY (author_id) REFERENCES iw_library.author(id),
	CONSTRAINT author_book_mapping_FK_1 FOREIGN KEY (book_id) REFERENCES iw_library.book(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8_general_ci;