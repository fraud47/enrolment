-- liquibase formatted sql

-- changeset sheltons:1713189787441-1
CREATE TABLE address
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    surbub       VARCHAR(255),
    street       VARCHAR(255),
    country_id   VARCHAR(255),
    CONSTRAINT pk_address PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-2
CREATE TABLE attendance
(
    id                 VARCHAR(255) NOT NULL,
    date_created       TIMESTAMP WITH TIME ZONE,
    last_updated       TIMESTAMP WITH TIME ZONE,
    student_id         VARCHAR(255),
    teacher_id         VARCHAR(255),
    student_attendance VARCHAR(255),
    teacher_attendance VARCHAR(255),
    date               TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_attendance PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-3
CREATE TABLE contact
(
    id              VARCHAR(255) NOT NULL,
    date_created    TIMESTAMP WITH TIME ZONE,
    last_updated    TIMESTAMP WITH TIME ZONE,
    phone_number_id VARCHAR(255),
    CONSTRAINT pk_contact PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-4
CREATE TABLE country
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    name         VARCHAR(255),
    code         VARCHAR(255),
    CONSTRAINT pk_country PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-5
CREATE TABLE device_tokens
(
    id            VARCHAR(255) NOT NULL,
    device_tokens TEXT
);

-- changeset sheltons:1713189787441-6
CREATE TABLE district
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    name         VARCHAR(255),
    CONSTRAINT pk_district PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-7
CREATE TABLE emergency_contact
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    detail_id    VARCHAR(255),
    relationship VARCHAR(255) NOT NULL,
    user_id      VARCHAR(255),
    CONSTRAINT pk_emergency_contact PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-8
CREATE TABLE enrollment
(
    id             VARCHAR(255) NOT NULL,
    date_created   TIMESTAMP WITH TIME ZONE,
    last_updated   TIMESTAMP WITH TIME ZONE,
    student_id     VARCHAR(255),
    admission_date TIMESTAMP WITHOUT TIME ZONE,
    level          VARCHAR(255),
    CONSTRAINT pk_enrollment PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-9
CREATE TABLE grade
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    name         VARCHAR(255),
    CONSTRAINT pk_grade PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-10
CREATE TABLE institute
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(255),
    province_id  VARCHAR(255),
    CONSTRAINT pk_institute PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-11
CREATE TABLE media
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    name         VARCHAR(255),
    path         VARCHAR(255),
    content_type VARCHAR(255),
    CONSTRAINT pk_media PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-12
CREATE TABLE phone_number
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    number       VARCHAR(255),
    CONSTRAINT pk_phone_number PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-13
CREATE TABLE province
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    name         VARCHAR(255),
    CONSTRAINT pk_province PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-14
CREATE TABLE qualification
(
    id                    VARCHAR(255) NOT NULL,
    date_created          TIMESTAMP WITH TIME ZONE,
    last_updated          TIMESTAMP WITH TIME ZONE,
    user_id               VARCHAR(255),
    instudte_id           VARCHAR(255),
    qualification_type_id VARCHAR(255),
    CONSTRAINT pk_qualification PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-15
CREATE TABLE qualification_media
(
    documents_id     VARCHAR(255) NOT NULL,
    qualification_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_qualification_media PRIMARY KEY (documents_id, qualification_id)
);

-- changeset sheltons:1713189787441-16
CREATE TABLE qualification_type
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(255),
    CONSTRAINT pk_qualification_type PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-17
CREATE TABLE role
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    type         VARCHAR(255),
    CONSTRAINT pk_role PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-18
CREATE TABLE school
(
    id                 VARCHAR(255) NOT NULL,
    date_created       TIMESTAMP WITH TIME ZONE,
    last_updated       TIMESTAMP WITH TIME ZONE,
    name               VARCHAR(255) NOT NULL,
    province_id        VARCHAR(255),
    address_id         VARCHAR(255),
    average_enrollment BIGINT,
    CONSTRAINT pk_school PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-19
CREATE TABLE school_contacts
(
    school_id   VARCHAR(255) NOT NULL,
    contacts_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_school_contacts PRIMARY KEY (school_id, contacts_id)
);

-- changeset sheltons:1713189787441-20
CREATE TABLE semester
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    type_id      VARCHAR(255),
    name         VARCHAR(255) NOT NULL,
    year         SMALLINT     NOT NULL,
    start        TIMESTAMP WITHOUT TIME ZONE,
    "end"        TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_semester PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-21
CREATE TABLE semester_type
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    count        BIGINT,
    school_id    VARCHAR(255),
    CONSTRAINT pk_semester_type PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-22
CREATE TABLE student
(
    id                        VARCHAR(255) NOT NULL,
    date_created              TIMESTAMP WITH TIME ZONE,
    last_updated              TIMESTAMP WITH TIME ZONE,
    registration_registration VARCHAR(255) NOT NULL,
    user_id                   VARCHAR(255),
    grade_id                  VARCHAR(255),
    CONSTRAINT pk_student PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-23
CREATE TABLE student_subject
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    student_id   VARCHAR(255),
    subject_id   VARCHAR(255),
    CONSTRAINT pk_student_subject PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-24
CREATE TABLE subject
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    code         VARCHAR(255),
    name         VARCHAR(255),
    description  VARCHAR(255),
    year         date,
    CONSTRAINT pk_subject PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-25
CREATE TABLE subject_grades
(
    subject_id VARCHAR(255) NOT NULL,
    grades_id  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_subject_grades PRIMARY KEY (subject_id, grades_id)
);

-- changeset sheltons:1713189787441-26
CREATE TABLE subject_teachers
(
    subject_id  VARCHAR(255) NOT NULL,
    teachers_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_subject_teachers PRIMARY KEY (subject_id, teachers_id)
);

-- changeset sheltons:1713189787441-27
CREATE TABLE teacher
(
    id                  VARCHAR(255) NOT NULL,
    date_created        TIMESTAMP WITH TIME ZONE,
    last_updated        TIMESTAMP WITH TIME ZONE,
    user_id             VARCHAR(255),
    registration_number VARCHAR(255),
    CONSTRAINT pk_teacher PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-28
CREATE TABLE teacher_subject
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    teacher_id   VARCHAR(255),
    subject_id   VARCHAR(255),
    CONSTRAINT pk_teacher_subject PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-29
CREATE TABLE token_refresh
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    user_id      VARCHAR(255),
    token        UUID         NOT NULL,
    expiry_date  TIMESTAMP WITH TIME ZONE,
    is_valid     BOOLEAN,
    CONSTRAINT pk_token_refresh PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-30
CREATE TABLE user_detail
(
    id            VARCHAR(255)                NOT NULL,
    date_created  TIMESTAMP WITH TIME ZONE,
    last_updated  TIMESTAMP WITH TIME ZONE,
    first_name    VARCHAR(255),
    middle_names  TEXT,
    last_name     VARCHAR(255),
    email         VARCHAR(255),
    gender        VARCHAR(255)                NOT NULL,
    date_of_birth TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_user_detail PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-31
CREATE TABLE user_detail_phone_numbers
(
    user_detail_id   VARCHAR(255) NOT NULL,
    phone_numbers_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user_detail_phone_numbers PRIMARY KEY (user_detail_id, phone_numbers_id)
);

-- changeset sheltons:1713189787441-32
CREATE TABLE users
(
    id           VARCHAR(255) NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE,
    last_updated TIMESTAMP WITH TIME ZONE,
    username     VARCHAR(255),
    password     VARCHAR(255),
    country      VARCHAR(255),
    status       VARCHAR(255),
    detail_id    VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

-- changeset sheltons:1713189787441-33
CREATE TABLE users_roles
(
    users_id  VARCHAR(255) NOT NULL,
    roles_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users_roles PRIMARY KEY (users_id, roles_id)
);

-- changeset sheltons:1713189787441-34
ALTER TABLE contact
    ADD CONSTRAINT uc_contact_phone_number UNIQUE (phone_number_id);

-- changeset sheltons:1713189787441-35
ALTER TABLE country
    ADD CONSTRAINT uc_country_code UNIQUE (code);

-- changeset sheltons:1713189787441-36
ALTER TABLE country
    ADD CONSTRAINT uc_country_name UNIQUE (name);

-- changeset sheltons:1713189787441-37
ALTER TABLE district
    ADD CONSTRAINT uc_district_name UNIQUE (name);

-- changeset sheltons:1713189787441-38
ALTER TABLE emergency_contact
    ADD CONSTRAINT uc_emergency_contact_detail UNIQUE (detail_id);

-- changeset sheltons:1713189787441-39
ALTER TABLE enrollment
    ADD CONSTRAINT uc_enrollment_level UNIQUE (level);

-- changeset sheltons:1713189787441-40
ALTER TABLE enrollment
    ADD CONSTRAINT uc_enrollment_student UNIQUE (student_id);

-- changeset sheltons:1713189787441-41
ALTER TABLE grade
    ADD CONSTRAINT uc_grade_name UNIQUE (name);

-- changeset sheltons:1713189787441-42
ALTER TABLE institute
    ADD CONSTRAINT uc_institute_name UNIQUE (name);

-- changeset sheltons:1713189787441-43
ALTER TABLE media
    ADD CONSTRAINT uc_media_name UNIQUE (name);

-- changeset sheltons:1713189787441-44
ALTER TABLE phone_number
    ADD CONSTRAINT uc_phone_number_number UNIQUE (number);

-- changeset sheltons:1713189787441-45
ALTER TABLE province
    ADD CONSTRAINT uc_province_name UNIQUE (name);

-- changeset sheltons:1713189787441-46
ALTER TABLE qualification_media
    ADD CONSTRAINT uc_qualification_media_documents UNIQUE (documents_id);

-- changeset sheltons:1713189787441-47
ALTER TABLE qualification
    ADD CONSTRAINT uc_qualification_qualification_type UNIQUE (qualification_type_id);

-- changeset sheltons:1713189787441-48
ALTER TABLE qualification_type
    ADD CONSTRAINT uc_qualification_type_name UNIQUE (name);

-- changeset sheltons:1713189787441-49
ALTER TABLE qualification
    ADD CONSTRAINT uc_qualification_user UNIQUE (user_id);

-- changeset sheltons:1713189787441-50
ALTER TABLE school
    ADD CONSTRAINT uc_school_address UNIQUE (address_id);

-- changeset sheltons:1713189787441-51
ALTER TABLE school_contacts
    ADD CONSTRAINT uc_school_contacts_contacts UNIQUE (contacts_id);

-- changeset sheltons:1713189787441-52
ALTER TABLE school
    ADD CONSTRAINT uc_school_name UNIQUE (name);

-- changeset sheltons:1713189787441-53
ALTER TABLE school
    ADD CONSTRAINT uc_school_province UNIQUE (province_id);

-- changeset sheltons:1713189787441-54
ALTER TABLE semester
    ADD CONSTRAINT uc_semester_name UNIQUE (name);

-- changeset sheltons:1713189787441-55
ALTER TABLE semester
    ADD CONSTRAINT uc_semester_type UNIQUE (type_id);

-- changeset sheltons:1713189787441-56
ALTER TABLE semester_type
    ADD CONSTRAINT uc_semester_type_school UNIQUE (school_id);

-- changeset sheltons:1713189787441-57
ALTER TABLE student
    ADD CONSTRAINT uc_student_registration_registration UNIQUE (registration_registration);

-- changeset sheltons:1713189787441-58
ALTER TABLE student
    ADD CONSTRAINT uc_student_user UNIQUE (user_id);

-- changeset sheltons:1713189787441-59
ALTER TABLE subject
    ADD CONSTRAINT uc_subject_code UNIQUE (code);

-- changeset sheltons:1713189787441-60
ALTER TABLE subject_grades
    ADD CONSTRAINT uc_subject_grades_grades UNIQUE (grades_id);

-- changeset sheltons:1713189787441-61
ALTER TABLE subject
    ADD CONSTRAINT uc_subject_name UNIQUE (name);

-- changeset sheltons:1713189787441-62
ALTER TABLE subject_teachers
    ADD CONSTRAINT uc_subject_teachers_teachers UNIQUE (teachers_id);

-- changeset sheltons:1713189787441-63
ALTER TABLE teacher
    ADD CONSTRAINT uc_teacher_user UNIQUE (user_id);

-- changeset sheltons:1713189787441-64
ALTER TABLE token_refresh
    ADD CONSTRAINT uc_token_refresh_token UNIQUE (token);

-- changeset sheltons:1713189787441-65
ALTER TABLE user_detail_phone_numbers
    ADD CONSTRAINT uc_user_detail_phone_numbers_phonenumbers UNIQUE (phone_numbers_id);

-- changeset sheltons:1713189787441-66
ALTER TABLE users
    ADD CONSTRAINT uc_users_detail UNIQUE (detail_id);

-- changeset sheltons:1713189787441-67
ALTER TABLE users_roles
    ADD CONSTRAINT uc_users_roles_roles UNIQUE (roles_id);

-- changeset sheltons:1713189787441-68
ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

-- changeset sheltons:1713189787441-69
ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_COUNTRY FOREIGN KEY (country_id) REFERENCES country (id);

-- changeset sheltons:1713189787441-70
ALTER TABLE attendance
    ADD CONSTRAINT FK_ATTENDANCE_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student_subject (id);

-- changeset sheltons:1713189787441-71
ALTER TABLE attendance
    ADD CONSTRAINT FK_ATTENDANCE_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher_subject (id);

-- changeset sheltons:1713189787441-72
ALTER TABLE contact
    ADD CONSTRAINT FK_CONTACT_ON_PHONE_NUMBER FOREIGN KEY (phone_number_id) REFERENCES phone_number (id);

-- changeset sheltons:1713189787441-73
ALTER TABLE emergency_contact
    ADD CONSTRAINT FK_EMERGENCY_CONTACT_ON_DETAIL FOREIGN KEY (detail_id) REFERENCES user_detail (id);

-- changeset sheltons:1713189787441-74
ALTER TABLE emergency_contact
    ADD CONSTRAINT FK_EMERGENCY_CONTACT_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset sheltons:1713189787441-75
ALTER TABLE enrollment
    ADD CONSTRAINT FK_ENROLLMENT_ON_LEVEL FOREIGN KEY (level) REFERENCES grade (id);

-- changeset sheltons:1713189787441-76
ALTER TABLE enrollment
    ADD CONSTRAINT FK_ENROLLMENT_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student (id);

-- changeset sheltons:1713189787441-77
ALTER TABLE institute
    ADD CONSTRAINT FK_INSTITUTE_ON_PROVINCE FOREIGN KEY (province_id) REFERENCES province (id);

-- changeset sheltons:1713189787441-78
ALTER TABLE qualification
    ADD CONSTRAINT FK_QUALIFICATION_ON_INSTUDTE FOREIGN KEY (instudte_id) REFERENCES institute (id);

-- changeset sheltons:1713189787441-79
ALTER TABLE qualification
    ADD CONSTRAINT FK_QUALIFICATION_ON_QUALIFICATION_TYPE FOREIGN KEY (qualification_type_id) REFERENCES qualification_type (id);

-- changeset sheltons:1713189787441-80
ALTER TABLE qualification
    ADD CONSTRAINT FK_QUALIFICATION_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset sheltons:1713189787441-81
ALTER TABLE school
    ADD CONSTRAINT FK_SCHOOL_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

-- changeset sheltons:1713189787441-82
ALTER TABLE school
    ADD CONSTRAINT FK_SCHOOL_ON_PROVINCE FOREIGN KEY (province_id) REFERENCES province (id);

-- changeset sheltons:1713189787441-83
ALTER TABLE semester
    ADD CONSTRAINT FK_SEMESTER_ON_TYPE FOREIGN KEY (type_id) REFERENCES semester_type (id);

-- changeset sheltons:1713189787441-84
ALTER TABLE semester_type
    ADD CONSTRAINT FK_SEMESTER_TYPE_ON_SCHOOL FOREIGN KEY (school_id) REFERENCES school (id);

-- changeset sheltons:1713189787441-85
ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_GRADE FOREIGN KEY (grade_id) REFERENCES grade (id);

-- changeset sheltons:1713189787441-86
ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset sheltons:1713189787441-87
ALTER TABLE student_subject
    ADD CONSTRAINT FK_STUDENT_SUBJECT_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student (id);

-- changeset sheltons:1713189787441-88
ALTER TABLE student_subject
    ADD CONSTRAINT FK_STUDENT_SUBJECT_ON_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject (id);

-- changeset sheltons:1713189787441-89
ALTER TABLE teacher
    ADD CONSTRAINT FK_TEACHER_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset sheltons:1713189787441-90
ALTER TABLE teacher_subject
    ADD CONSTRAINT FK_TEACHER_SUBJECT_ON_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject (id);

-- changeset sheltons:1713189787441-91
ALTER TABLE teacher_subject
    ADD CONSTRAINT FK_TEACHER_SUBJECT_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher (id);

-- changeset sheltons:1713189787441-92
ALTER TABLE token_refresh
    ADD CONSTRAINT FK_TOKEN_REFRESH_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset sheltons:1713189787441-93
ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_DETAIL FOREIGN KEY (detail_id) REFERENCES user_detail (id);

-- changeset sheltons:1713189787441-94
ALTER TABLE device_tokens
    ADD CONSTRAINT fk_device_tokens_on_user FOREIGN KEY (id) REFERENCES users (id);

-- changeset sheltons:1713189787441-95
ALTER TABLE qualification_media
    ADD CONSTRAINT fk_quamed_on_media FOREIGN KEY (documents_id) REFERENCES media (id);

-- changeset sheltons:1713189787441-96
ALTER TABLE qualification_media
    ADD CONSTRAINT fk_quamed_on_qualification FOREIGN KEY (qualification_id) REFERENCES qualification (id);

-- changeset sheltons:1713189787441-97
ALTER TABLE school_contacts
    ADD CONSTRAINT fk_schcon_on_contact FOREIGN KEY (contacts_id) REFERENCES contact (id);

-- changeset sheltons:1713189787441-98
ALTER TABLE school_contacts
    ADD CONSTRAINT fk_schcon_on_school FOREIGN KEY (school_id) REFERENCES school (id);

-- changeset sheltons:1713189787441-99
ALTER TABLE subject_grades
    ADD CONSTRAINT fk_subgra_on_grade FOREIGN KEY (grades_id) REFERENCES grade (id);

-- changeset sheltons:1713189787441-100
ALTER TABLE subject_grades
    ADD CONSTRAINT fk_subgra_on_subject FOREIGN KEY (subject_id) REFERENCES subject (id);

-- changeset sheltons:1713189787441-101
ALTER TABLE subject_teachers
    ADD CONSTRAINT fk_subtea_on_subject FOREIGN KEY (subject_id) REFERENCES subject (id);

-- changeset sheltons:1713189787441-102
ALTER TABLE subject_teachers
    ADD CONSTRAINT fk_subtea_on_teacher FOREIGN KEY (teachers_id) REFERENCES teacher (id);

-- changeset sheltons:1713189787441-103
ALTER TABLE user_detail_phone_numbers
    ADD CONSTRAINT fk_usedetphonum_on_phone_number FOREIGN KEY (phone_numbers_id) REFERENCES phone_number (id);

-- changeset sheltons:1713189787441-104
ALTER TABLE user_detail_phone_numbers
    ADD CONSTRAINT fk_usedetphonum_on_user_detail FOREIGN KEY (user_detail_id) REFERENCES user_detail (id);

-- changeset sheltons:1713189787441-105
ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (roles_id) REFERENCES role (id);

-- changeset sheltons:1713189787441-106
ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (users_id) REFERENCES users (id);

