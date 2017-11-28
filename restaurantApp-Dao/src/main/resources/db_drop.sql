ALTER TABLE `user_order` DROP FOREIGN KEY `user_order_fk0`;

ALTER TABLE `user_order` DROP FOREIGN KEY `user_order_fk1`;

ALTER TABLE `order_menu` DROP FOREIGN KEY `order_menu_fk0`;

ALTER TABLE `order_menu` DROP FOREIGN KEY `order_menu_fk1`;

ALTER TABLE `menu` DROP FOREIGN KEY `menu_fk0`;

ALTER TABLE `recipe` DROP FOREIGN KEY `recipe_fk0`;

ALTER TABLE `recipe_ingredient` DROP FOREIGN KEY `recipe_ingredient_fk0`;

ALTER TABLE `recipe_ingredient` DROP FOREIGN KEY `recipe_ingredient_fk1`;

ALTER TABLE `warehouse` DROP FOREIGN KEY `warehouse_fk0`;

ALTER TABLE `warehouse` DROP FOREIGN KEY `warehouse_fk1`;

DROP TABLE IF EXISTS `user`;

DROP TABLE IF EXISTS `user_order`;

DROP TABLE IF EXISTS `order`;

DROP TABLE IF EXISTS `order_menu`;

DROP TABLE IF EXISTS `menu`;

DROP TABLE IF EXISTS `recipe`;

DROP TABLE IF EXISTS `ingredient`;

DROP TABLE IF EXISTS `recipe_ingredient`;

DROP TABLE IF EXISTS `category`;

DROP TABLE IF EXISTS `warehouse`;

