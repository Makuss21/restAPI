create table POST (
    id bigint auto_increment primary key,
    title varchar(400) not null,
    content varchar(2000) null,
    created TIMESTAMP
);

create table COMMENT(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id BIGINT NOT NULL,
    content VARCHAR(2000) NULL,
    created TIMESTAMP
);

ALTER TABLE COMMENT
    ADD CONSTRAINT comment_post_id
    FOREIGN KEY (post_id) REFERENCES POST(id)