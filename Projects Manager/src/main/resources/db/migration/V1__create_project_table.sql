CREATE TABLE project
(
    project_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255),
    project_description VARCHAR(255),
    project_start_date DATE,
    project_end_date DATE
);
