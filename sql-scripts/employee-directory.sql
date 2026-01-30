-- =====================================================
-- Database: employee_directory (enhanced)
-- =====================================================

CREATE DATABASE IF NOT EXISTS `employee_directory`
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

USE `employee_directory`;

-- =====================================================
-- Table: employee
-- =====================================================

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `first_name` VARCHAR(50) NOT NULL COMMENT 'Employee first name',
  `last_name` VARCHAR(50) NOT NULL COMMENT 'Employee last name',
  `email` VARCHAR(100) NOT NULL COMMENT 'Unique employee email',
  `department` VARCHAR(50) DEFAULT NULL COMMENT 'Department name',
  `status` ENUM('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE' COMMENT 'Employment status',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Record creation time',
  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
                ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_employee_email` (`email`),
  KEY `idx_employee_last_name` (`last_name`),
  KEY `idx_employee_department` (`department`)
) ENGINE=InnoDB
  AUTO_INCREMENT=1
  COMMENT='Employee master table';

-- =====================================================
-- Sample data
-- =====================================================

INSERT INTO `employee`
  (`first_name`, `last_name`, `email`, `department`, `status`)
VALUES
  ('Leslie','Andrews','leslie@luv2code.com','Engineering','ACTIVE'),
  ('Emma','Baumgarten','emma@luv2code.com','HR','ACTIVE'),
  ('Avani','Gupta','avani@luv2code.com','Finance','ACTIVE'),
  ('Yuri','Petrov','yuri@luv2code.com','Engineering','ACTIVE'),
  ('Juan','Vega','juan@luv2code.com','Sales','ACTIVE');
