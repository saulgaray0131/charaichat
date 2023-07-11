CREATE TABLE `chats` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `aiuser_id` INT,
  `last_chat` TEXT,
  `user_id` INT
);

CREATE TABLE `chat_lines` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `chat_id` INT,
  `user_id` INT,
  `text` TEXT,
  `created_at` TIMESTAMP
);

CREATE TABLE `aiusers` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(36),
  `url` VARCHAR(128),
  `system_dsc` TEXT,
  `description` TEXT
);

CREATE TABLE `users` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(128),
  `username` VARCHAR(36),
  `uuid` VARCHAR(36)
);

ALTER TABLE `chats` ADD FOREIGN KEY (`aiuser_id`) REFERENCES `aiusers` (`id`);

ALTER TABLE `chat_lines` ADD FOREIGN KEY (`chat_id`) REFERENCES `chats` (`id`);

ALTER TABLE `chat_lines` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `chats` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
