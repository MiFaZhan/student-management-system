USE mydatabase;

-- 删除表
DROP TABLE IF EXISTS score;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS exam_record;
DROP TABLE IF EXISTS subject;

-- 创建科目表
CREATE TABLE IF NOT EXISTS `subject` (
    `subject_id` INTEGER NOT NULL AUTO_INCREMENT,
    `subject_name` VARCHAR(50) NOT NULL,
    `deleted` INTEGER NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`subject_id`),
    UNIQUE KEY `uk_subject_name` (`subject_name`)
) COMMENT='科目表';

-- 创建学生表
CREATE TABLE IF NOT EXISTS `student` (
    `student_id` INTEGER NOT NULL AUTO_INCREMENT,
    `student_number` VARCHAR(50) NOT NULL COMMENT '学号',
    `student_name` VARCHAR(50) NOT NULL COMMENT '学生姓名',
    `gender` ENUM('男', '女') NOT NULL COMMENT '性别',
    `phone` VARCHAR(20) NOT NULL COMMENT '联系方式',
    `id_card` CHAR(18) NOT NULL COMMENT '身份证号',
    `grade` VARCHAR(20) NOT NULL COMMENT '年级',
    `class_name` VARCHAR(20) NOT NULL COMMENT '班级',
    `hometown` VARCHAR(100) COMMENT '籍贯',
    `address` VARCHAR(200) COMMENT '住址',
    `deleted` INTEGER NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`student_id`),
    UNIQUE KEY `uk_student_number` (`student_number`),
    UNIQUE KEY `uk_id_card` (`id_card`),
    INDEX `idx_students_class` (`class_name`),
    INDEX `idx_students_grade` (`grade`),
    INDEX `idx_students_number` (`student_number`)
) COMMENT='学生表';

-- 创建考试记录表
CREATE TABLE IF NOT EXISTS `exam_record` (
    `exam_id` INTEGER NOT NULL AUTO_INCREMENT,
    `subject_id` INTEGER NOT NULL COMMENT '科目id',
    `exam_name` VARCHAR(100) NOT NULL COMMENT '考试名称',
    `teacher_name` VARCHAR(50) NOT NULL COMMENT '出题教师',
    `exam_start_time` DATETIME COMMENT '考试开始时间',
    `exam_end_time` DATETIME COMMENT '考试结束时间',
    `deleted` INTEGER NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`exam_id`),
    INDEX `idx_exam_records_subject` (`subject_id`)
) COMMENT='考试记录表';

-- 创建成绩表
CREATE TABLE IF NOT EXISTS `score` (
    `score_id` INTEGER NOT NULL AUTO_INCREMENT,
    `student_number` VARCHAR(50) NOT NULL COMMENT '学号',
    `exam_id` INTEGER NOT NULL COMMENT '考试id',
    `score` DECIMAL(5,2) NOT NULL COMMENT '成绩',
    `deleted` INTEGER NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`score_id`),
    UNIQUE KEY `uk_student_exam` (`student_number`, `exam_id`) COMMENT '防止重复成绩',
    INDEX `idx_scores_student` (`student_number`),
    INDEX `idx_scores_exam` (`exam_id`)
) COMMENT='成绩表';





-- USE mydatabase;
-- 
-- -- 按依赖关系顺序删除表
-- DROP TABLE IF EXISTS score;
-- DROP TABLE IF EXISTS student;
-- DROP TABLE IF EXISTS exam_record;
-- DROP TABLE IF EXISTS subject;
-- 
-- -- 创建科目表（无外键依赖）
-- CREATE TABLE IF NOT EXISTS `subject` (
--     `subject_id` INTEGER NOT NULL AUTO_INCREMENT,
--     `subject_name` VARCHAR(50) NOT NULL,
--     `deleted` INTEGER NOT NULL DEFAULT 0 COMMENT '逻辑删除',
--     PRIMARY KEY (`subject_id`),
--     UNIQUE KEY `uk_subject_name` (`subject_name`)
-- ) COMMENT='科目表';
-- 
-- -- 创建学生表（无外键依赖）
-- CREATE TABLE IF NOT EXISTS `student` (
--     `student_id` INTEGER NOT NULL AUTO_INCREMENT,
--     `student_number` VARCHAR(50) NOT NULL COMMENT '学号',
--     `student_name` VARCHAR(50) NOT NULL COMMENT '学生姓名',
--     `gender` ENUM('男', '女') NOT NULL COMMENT '性别',
--     `phone` VARCHAR(20) NOT NULL COMMENT '联系方式',
--     `id_card` CHAR(18) NOT NULL COMMENT '身份证号',
--     `grade` VARCHAR(20) NOT NULL COMMENT '年级',
--     `class_name` VARCHAR(20) NOT NULL COMMENT '班级',
--     `hometown` VARCHAR(100) COMMENT '籍贯',
--     `address` VARCHAR(200) COMMENT '住址',
--     `deleted` INTEGER NOT NULL DEFAULT 0 COMMENT '逻辑删除',
--     PRIMARY KEY (`student_id`),
--     UNIQUE KEY `uk_student_number` (`student_number`),
--     UNIQUE KEY `uk_id_card` (`id_card`),
--     INDEX `idx_students_class` (`class_name`),
--     INDEX `idx_students_grade` (`grade`),
--     INDEX `idx_students_number` (`student_number`)
-- ) COMMENT='学生表';
-- 
-- -- 创建考试记录表（依赖科目表）
-- CREATE TABLE IF NOT EXISTS `exam_record` (
--     `exam_id` INTEGER NOT NULL AUTO_INCREMENT,
--     `subject_id` INTEGER NOT NULL COMMENT '科目id',
--     `exam_name` VARCHAR(100) NOT NULL COMMENT '考试名称',
--     `teacher_name` VARCHAR(50) NOT NULL COMMENT '出题教师',
--     `exam_start_time` DATETIME COMMENT '考试开始时间',
--     `exam_end_time` DATETIME COMMENT '考试结束时间',
--     `deleted` INTEGER NOT NULL DEFAULT 0 COMMENT '逻辑删除',
--     PRIMARY KEY (`exam_id`),
-- --     FOREIGN KEY (`subject_id`) REFERENCES `subject`(`subject_id`)
-- --         ON UPDATE NO ACTION ON DELETE NO ACTION,
--     INDEX `idx_exam_records_subject` (`subject_id`)
-- ) COMMENT='考试记录表';
-- 
-- -- 创建成绩表（依赖学生表和考试记录表）
-- CREATE TABLE IF NOT EXISTS `score` (
--     `score_id` INTEGER NOT NULL AUTO_INCREMENT,
--     `student_number` VARCHAR(50) NOT NULL COMMENT '学号',
--     `exam_id` INTEGER NOT NULL COMMENT '考试id',
--     `score` DECIMAL(5,2) NOT NULL COMMENT '成绩',
--     `deleted` INTEGER NOT NULL DEFAULT 0 COMMENT '逻辑删除',
--     PRIMARY KEY (`score_id`),
-- --     FOREIGN KEY (`student_number`) REFERENCES `student`(`student_number`)
-- --         ON UPDATE NO ACTION ON DELETE NO ACTION,
-- --     FOREIGN KEY (`exam_id`) REFERENCES `exam_record`(`exam_id`)
-- --         ON UPDATE NO ACTION ON DELETE NO ACTION,
--     UNIQUE KEY `uk_student_exam` (`student_number`, `exam_id`) COMMENT '防止重复成绩',
--     INDEX `idx_scores_student` (`student_number`),
--     INDEX `idx_scores_exam` (`exam_id`)
-- ) COMMENT='成绩表';