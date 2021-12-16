CREATE TABLE `User` (
                        `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `username` VARCHAR(255) NOT NULL,
                        `email` VARCHAR(255) NOT NULL UNIQUE,
                        `password` VARCHAR(255) NOT NULL,
                        `balance` FLOAT NOT NULL,

);

CREATE TABLE `Cart` (
                        `id` INT NOT NULL,
                        `user_id` INT NOT NULL,
                        `totalAmount` FLOAT NOT NULL,
                        `paymentTypeId` INT NOT NULL
);

CREATE TABLE `Shop` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(255) NOT NULL,
                        `price` FLOAT NOT NULL,
                        `description` VARCHAR(255) NOT NULL,
                        PRIMARY KEY (`id`)
);

CREATE TABLE `CartItems` (
                             `id` INT NOT NULL AUTO_INCREMENT,
                             `shop_id` INT NOT NULL,
                             `cart_id` INT NOT NULL,
                             PRIMARY KEY (`id`)
);

CREATE TABLE `PaymenType` (
                              `id` INT NOT NULL AUTO_INCREMENT,
                              `type` VARCHAR(255) NOT NULL,
                              PRIMARY KEY (`id`)
);

CREATE TABLE `orders` (
                          `id` INT NOT NULL AUTO_INCREMENT,
                          `cart_id` BINARY NOT NULL,
                          `paymentAmount` FLOAT NOT NULL,
                          `paymentDate` DATE NOT NULL,
                          PRIMARY KEY (`id`)
);

ALTER TABLE `Cart` ADD CONSTRAINT `Cart_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);

ALTER TABLE `CartItems` ADD CONSTRAINT `CartItems_fk0` FOREIGN KEY (`shop_id`) REFERENCES `Shop`(`id`);

ALTER TABLE `CartItems` ADD CONSTRAINT `CartItems_fk1` FOREIGN KEY (`cart_id`) REFERENCES `Cart`(`id`);

ALTER TABLE `PaymenType` ADD CONSTRAINT `PaymenType_fk0` FOREIGN KEY (`id`) REFERENCES `Cart`(`paymentTypeId`);

ALTER TABLE `PaymenType` ADD CONSTRAINT `PaymenType_fk1` FOREIGN KEY (`type`) REFERENCES ``(``);







