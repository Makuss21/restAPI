create table Client (
    id bigint auto_increment primary key,
    First_Name varchar(400) not null,
    Last_Name varchar(2000) null,
    created TIMESTAMP
);

create table Orders(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    client_id BIGINT NOT NULL,
    content VARCHAR(2000) NULL,
    created TIMESTAMP
);

ALTER TABLE Orders
    ADD CONSTRAINT Orders_Client_id
    FOREIGN KEY (client_id) REFERENCES Client(id)