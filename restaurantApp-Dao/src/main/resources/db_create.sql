CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_order` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`order_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`date` DATETIME NOT NULL,
	`complited` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order_menu` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`order_id` INT NOT NULL,
	`menu_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `menu` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`recipe_id` INT NOT NULL,
	`price` DECIMAL NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `recipe` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL UNIQUE,
	`category_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `ingredient` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	`energy` FLOAT NOT NULL,
	`fat` FLOAT NOT NULL,
	`carbohydrate` FLOAT NOT NULL,
	`protein` FLOAT NOT NULL,
	`salt` FLOAT NOT NULL,
	`unit` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `recipe_ingredient` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`recipe_id` INT NOT NULL,
	`ingredient_id` INT NOT NULL,
	`quantity` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `warehouse` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`ingredient_id` INT NOT NULL,
	`user_id` INT NOT NULL,
	`registered` DATETIME NOT NULL,
	`warrant` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `user_order` ADD CONSTRAINT `user_order_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

ALTER TABLE `user_order` ADD CONSTRAINT `user_order_fk1` FOREIGN KEY (`order_id`) REFERENCES `order`(`id`);

ALTER TABLE `order_menu` ADD CONSTRAINT `order_menu_fk0` FOREIGN KEY (`order_id`) REFERENCES `order`(`id`);

ALTER TABLE `order_menu` ADD CONSTRAINT `order_menu_fk1` FOREIGN KEY (`menu_id`) REFERENCES `menu`(`id`);

ALTER TABLE `menu` ADD CONSTRAINT `menu_fk0` FOREIGN KEY (`recipe_id`) REFERENCES `recipe`(`id`);

ALTER TABLE `recipe` ADD CONSTRAINT `recipe_fk0` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);

ALTER TABLE `recipe_ingredient` ADD CONSTRAINT `recipe_ingredient_fk0` FOREIGN KEY (`recipe_id`) REFERENCES `recipe`(`id`);

ALTER TABLE `recipe_ingredient` ADD CONSTRAINT `recipe_ingredient_fk1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient`(`id`);

ALTER TABLE `warehouse` ADD CONSTRAINT `warehouse_fk0` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient`(`id`);

ALTER TABLE `warehouse` ADD CONSTRAINT `warehouse_fk1` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

