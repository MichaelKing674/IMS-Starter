DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items` (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` INT(5) DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);
DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders` (
    `order_id` INT(5) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(5) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
);

DROP TABLE IF EXISTS `orderitems`;

CREATE TABLE IF NOT EXISTS `orderitems` (
    `orderitem_id` INT(5) NOT NULL AUTO_INCREMENT,
    `order_id` INT(5) DEFAULT NULL,
    `item_id` INT(5) DEFAULT NULL,
    `quantity` INT(5) DEFAULT NULL,
    PRIMARY KEY (`orderitem_id`)
);