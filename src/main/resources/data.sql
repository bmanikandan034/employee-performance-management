INSERT INTO departments (name, budget)
VALUES 
('IT', 1000000),
('HR', 500000),
('Finance', 750000);
INSERT INTO employees (name, email, date_of_joining, salary, manager_id, department_id)
VALUES
('Mani', 'mani@test.com', '2020-01-01', 80000, NULL, 1),
('Raj', 'raj@test.com', '2021-03-15', 90000, 1, 1),
('Rahul', 'rahul@test.com', '2019-07-10', 70000, 1, 2);
INSERT INTO projects (name, start_date, end_date, department_id)
VALUES
('Recruit CRM Platform', '2023-01-01', '2024-12-31', 1),
('HR Automation', '2022-06-01', '2023-12-31', 2);
INSERT INTO employee_projects (employee_id, project_id, assigned_date, role)
VALUES
(1, 1, '2023-01-05', 'Backend Developer'),
(2, 1, '2023-02-10', 'Full Stack Developer'),
(3, 2, '2022-06-15', 'HR Analyst');

INSERT INTO performance_reviews (employee_id, review_date, score, review_comments)
VALUES
(1, '2024-01-01', 4, 'Good performance'),
(1, '2023-01-01', 5, 'Excellent performance'),
(1, '2022-01-01', 3, 'Satisfactory'),
(2, '2024-01-01', 4, 'Consistent performer'),
(3, '2024-01-01', 3, 'Needs improvement');