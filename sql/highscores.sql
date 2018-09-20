/*
	@AUTHOR Tim Hinz
	@VERSION 0.01
	@DATE 09/20/2018
*/
CREATE TABLE `rsps`.`hs_users` ( `username` VARCHAR(50) NOT NULL , `rights` INT(2) NOT NULL , `mode` INT(2) NOT NULL , `total_level` INT(50) NOT NULL , `overall_xp` INT(50) NOT NULL , `attack_xp` INT(50) NOT NULL , `defence_xp` INT(50) NOT NULL , `strength_xp` INT(50) NOT NULL , `constitution_xp` INT(50) NOT NULL , `ranged_xp` INT(50) NOT NULL , `prayer_xp` INT(50) NOT NULL , `magic_xp` INT(50) NOT NULL , `cooking_xp` INT(50) NOT NULL , `woodcutting_xp` INT(50) NOT NULL , `fletching_xp` INT(50) NOT NULL , `fishing_xp` INT(50) NOT NULL , `firemaking_xp` INT(50) NOT NULL , `crafting_xp` INT(50) NOT NULL , `smithing_xp` INT(50) NOT NULL , `mining_xp` INT(50) NOT NULL , `herblore_xp` INT(50) NOT NULL , `agility_xp` INT(50) NOT NULL , `thieving_xp` INT(50) NOT NULL , `slayer_xp` INT(50) NOT NULL , `farming_xp` INT(50) NOT NULL , `runecrafting_xp` INT(50) NOT NULL , `hunter_xp` INT(50) NOT NULL , `construction_xp` INT(50) NOT NULL , `summoning_xp` INT(50) NOT NULL , `dungeoneering_xp` INT(50) NOT NULL ) ENGINE = MyISAM;
CREATE TABLE `rsps`.`online`  ( `id` INT(255) NOT NULL , `currentlyonline` INT(255) NOT NULL ) ENGINE = MyISAM;