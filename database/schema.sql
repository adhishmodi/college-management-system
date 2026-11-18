CREATE DATABASE IF NOT EXISTS college_management CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE college_management;
CREATE TABLE IF NOT EXISTS users (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, full_name VARCHAR(120) NOT NULL, email VARCHAR(160) NOT NULL UNIQUE,
 password_hash VARCHAR(255) NOT NULL, role ENUM('ADMIN','STUDENT') NOT NULL DEFAULT 'STUDENT',
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS students (
 id BIGINT PRIMARY KEY AUTO_INCREMENT, enrollment_no VARCHAR(30) NOT NULL UNIQUE,
 full_name VARCHAR(120) NOT NULL, email VARCHAR(160) NOT NULL UNIQUE, phone VARCHAR(20),
 department VARCHAR(100) NOT NULL, semester TINYINT UNSIGNED NOT NULL,
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
-- Demo passwords use PBKDF2-HMAC-SHA256 with 120,000 iterations.
INSERT INTO users(full_name,email,password_hash,role) VALUES
('System Administrator','admin@example.com','fzqcLWseT4BafC2eG28wSA==:XaoW4Y11moN8SjdHyJZdeKzVMVxvXSG44O3rKHnWIe4=','ADMIN'),
('Demo Student','student@example.com','ChssPU5fYHGCk6S1xtfo+Q==:mIT4KOgnthEjnvMX1qJZHoPyrqo95Br+Nxb4iFlrYEU=','STUDENT')
ON DUPLICATE KEY UPDATE email=VALUES(email);
INSERT INTO students(enrollment_no,full_name,email,phone,department,semester) VALUES
('CMS-2026-001','Demo Student','student@example.com','9876543210','Computer Engineering',5)
ON DUPLICATE KEY UPDATE enrollment_no=VALUES(enrollment_no);