INSERT INTO `ingredient` (`id`, `name`, `energy`, `fat`, `carbohydrate`, `protein`, `salt`, `unit`) VALUES
	(NULL, "bors", 10, 10, 5, 10, 5, "gramm");

INSERT INTO `category` (`id`, `name`) VALUES (NULL, "leves");

INSERT INTO `recipe` (`id`, `name`, `category_id`) VALUES (NULL, "husleves", 1);

INSERT INTO `recipe_ingredient` (`id`, `recipe_id`, `ingredient_id`, `quantity`) VALUES(NULL, 1, 1, 20);

INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES (NULL, 1, 3000);

INSERT INTO `order` (`id`, `date`, `complited`) VALUES (NULL, NOW(), FALSE);

INSERT INTO `order_menu` (`id`, `order_id`, `menu_id`) VALUES (NULL, 1, 1);

INSERT INTO `user` (`id`, `username`) VALUES (NULL, "tesztuser");

INSERT INTO `user_order` (`id`, `user_id`, `order_id`) VALUES (NULL, 1, 1);