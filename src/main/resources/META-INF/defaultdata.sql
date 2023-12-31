INSERT INTO USERS (USER_ID, USER_EMAIL, USER_ACTIVE, USER_GROUP, USER_PASSWORD, USER_USERNAME) VALUES (151, 'asan@example.com', TRUE, 'USER', 'PBKDF2WithHmacSHA256:2048:r/zM/2MTJMOBxD2DIA06fw7/CulHGX1QCAE3Z3TnMjo=:FU/Qg7/+DIOcyE0WXNh/KKyyIdFeXybuPOxWl9PJu0w=', 'asan');
INSERT INTO USER_PROFILES (ID, USER_USERNAME, THEME, DESIGNATION, EMAIL, FIRST_NAME, LAST_NAME, PHONE, SUMMARY) VALUES (151, 'asan', 1, 'Software Developer', 'asan@example.com', 'Asan', 'Asanov', '+123456789', 'Diligent software engineer with 5+ years of experience in commercial application and software development. Eager to join Cyclone Inc. to build innovative and cutting-edge business solutions for the impressive suite of clients within its global reach.');
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (151, 'C++', 151);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (152, 'Java', 151);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (153, 'Docker', 151);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (154, 'Kubernetes', 151);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (155, 'AWS', 151);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (156, 'Python', 151);
INSERT INTO JOBS(ID, COMPANY, CURRENT_JOB, DESIGNATION, END_DATE, START_DATE, USER_PROFILE_ID) VALUES (151, 'Jetbrains', FALSE, 'Junior Software Developer', '2022-03-15', '2023-07-16', 151);
INSERT INTO JOBS(ID, COMPANY, CURRENT_JOB, DESIGNATION, END_DATE, START_DATE, USER_PROFILE_ID) VALUES (152, 'Google', TRUE, 'Middle Software Developer', '2024-06-15', '2025-10-20', 151);
INSERT INTO JOB_RESPONSIBILITIES (JOB_ID, RESPONSIBILITIES) VALUES (151, 'Execute full software development life cycle (SDLC)');
INSERT INTO JOB_RESPONSIBILITIES (JOB_ID, RESPONSIBILITIES) VALUES (151, 'Write well-designed, testable code');
INSERT INTO JOB_RESPONSIBILITIES (JOB_ID, RESPONSIBILITIES) VALUES (152, 'Produce specifications and determine operational feasibility');
INSERT INTO JOB_RESPONSIBILITIES (JOB_ID, RESPONSIBILITIES) VALUES (152, 'Integrate software components into a fully functional software system');
INSERT INTO EDUCATIONS (ID, COLLEGE, MAJOR, QUALIFICATION, USER_PROFILE_ID) VALUES (151, 'Kyrgyz-Turkish Manas University', 'Mathematics', 'Bachelor`s', 151);
INSERT INTO EDUCATIONS (ID, COLLEGE, MAJOR, QUALIFICATION, USER_PROFILE_ID) VALUES (152, 'ITMO', 'Applied Mathematics', 'Master`s', 151);
INSERT INTO EDUCATIONS (ID, COLLEGE, MAJOR, QUALIFICATION, USER_PROFILE_ID) VALUES (153, 'Stanford University', 'Artificial Intelligence', 'PhD', 151);

INSERT INTO USERS (USER_ID, USER_EMAIL, USER_ACTIVE, USER_GROUP, USER_PASSWORD, USER_USERNAME) VALUES (152, 'uson@example.com', TRUE, 'USER', 'PBKDF2WithHmacSHA256:2048:r/zM/2MTJMOBxD2DIA06fw7/CulHGX1QCAE3Z3TnMjo=:FU/Qg7/+DIOcyE0WXNh/KKyyIdFeXybuPOxWl9PJu0w=', 'uson');
INSERT INTO USER_PROFILES (ID, USER_USERNAME, THEME, DESIGNATION, EMAIL, FIRST_NAME, LAST_NAME, PHONE, SUMMARY) VALUES (152, 'uson', 2, 'Software Engineer', 'uson@example.com', 'Uson', 'Usonov', '+987654321', 'Detail-oriented computer engineer with 5+ years of expertise working with embedded systems, artificial intelligence, machine learning, and automation technologies. Increased multiply-accumulate performance on proprietary DSP algorithms by 5% through system and chip analysis revamp. ');
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (157, 'Bash Shell', 152);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (158, 'C#', 152);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (159, 'Rust', 152);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (160, 'MySQL', 152);
INSERT INTO SKILLS (ID, SKILL, USER_PROFILE_ID) VALUES (161, 'MongoDB', 152);
INSERT INTO JOBS(ID, COMPANY, CURRENT_JOB, DESIGNATION, END_DATE, START_DATE, USER_PROFILE_ID) VALUES (153, 'Microsoft', FALSE, 'Junior Software Engineer', '2013-01-15', '2017-09-16', 152);
INSERT INTO JOBS(ID, COMPANY, CURRENT_JOB, DESIGNATION, END_DATE, START_DATE, USER_PROFILE_ID) VALUES (154, 'Apple', TRUE, 'Middle Software Engineer', '2017-10-15', '2020-12-20', 152);
INSERT INTO JOB_RESPONSIBILITIES (JOB_ID, RESPONSIBILITIES) VALUES (153, 'Develop software verification plans and quality assurance procedures');
INSERT INTO JOB_RESPONSIBILITIES (JOB_ID, RESPONSIBILITIES) VALUES (153, 'Document and maintain software functionality');
INSERT INTO JOB_RESPONSIBILITIES (JOB_ID, RESPONSIBILITIES) VALUES (154, 'Troubleshoot, debug and upgrade existing systems');
INSERT INTO JOB_RESPONSIBILITIES (JOB_ID, RESPONSIBILITIES) VALUES (154, 'Deploy programs and evaluate user feedback');
INSERT INTO EDUCATIONS (ID, COLLEGE, MAJOR, QUALIFICATION, USER_PROFILE_ID) VALUES (154, 'Moscow State University', 'Software Engineering', 'Bachelor`s', 152);
INSERT INTO EDUCATIONS (ID, COLLEGE, MAJOR, QUALIFICATION, USER_PROFILE_ID) VALUES (155, 'MIT', 'Computer Engineering', 'Master`s', 152);