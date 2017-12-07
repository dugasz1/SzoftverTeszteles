INSERT INTO `category` (`id`, `name`) VALUES(NULL, "Category1");

INSERT INTO `ingredient` (`id`, `name`, `energy`, `fat`, `carbohydrate`, `protein`, `salt`, `unit`) VALUES
  (NULL, "so", 10, 10, 10, 10, 10, "gramm");

INSERT INTO `recipe` (`id`, `name` , `category_id`) VALUES(NULL, "Test1",1);
INSERT INTO `recipe` (`id`, `name` , `category_id`) VALUES(NULL, "Test2",1);
INSERT INTO `recipe` (`id`, `name` , `category_id`) VALUES(NULL, "Test3",1);
INSERT INTO `recipe` (`id`, `name` , `category_id`) VALUES(NULL, "Test4",1);

INSERT INTO `recipe_ingredient` (`id`, `recipe_id`, `ingredient_id`, `quantity`) VALUES
  (NULL, 1, 1, 10);

INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 1, 2000.0);
INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 2, 2500.0);
INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 3, 2455.0);
INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 4, 1234.0);

