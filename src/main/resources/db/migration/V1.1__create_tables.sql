CREATE TABLE IF NOT EXISTS locations
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    number    INT          NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    city      VARCHAR(255) NOT NULL,
    country   VARCHAR(255) NOT NULL,
    street    VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS holidays
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    duration    INT          NOT NULL,
    free_slots  INT          NOT NULL,
    price       VARCHAR(255) NOT NULL,
    title       VARCHAR(255) NOT NULL,
    start_date  DATE         NOT NULL,
    location_id BIGINT,
    FOREIGN KEY (location_id) REFERENCES locations (id)
);

CREATE TABLE IF NOT EXISTS reservations
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    contact_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20)  NOT NULL,
    holiday_id   BIGINT,
    FOREIGN KEY (holiday_id) REFERENCES holidays (id)
);

