INSERT INTO `category` (`id`, `name`) VALUES(NULL, "Category1");

INSERT INTO `recipe` (`id`, `name` , `category_id`) VALUES(NULL, "Test1",1);
INSERT INTO `recipe` (`id`, `name` , `category_id`) VALUES(NULL, "Test2",1);
INSERT INTO `recipe` (`id`, `name` , `category_id`) VALUES(NULL, "Test3",1);
INSERT INTO `recipe` (`id`, `name` , `category_id`) VALUES(NULL, "Test4",1);

INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 1, 2000.0);
INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 2, 2500.0);
INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 3, 2455.0);
INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 4, 1234.0);
INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 5, 1254.0);
INSERT INTO `menu` (`id`, `recipe_id`, `price`) VALUES(NULL, 6, 1548.0);

