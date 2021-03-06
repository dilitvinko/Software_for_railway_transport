INSERT INTO `city` VALUES (1,'Moscow'),(2,'Minsk'),(3,'Bereza'),(4,'Brest'),(5,'Kiev'),(6,'Lvov'),(7,'Grodno');

INSERT INTO `type_carriage` VALUES (1,10,1, 'O'),(2,5,2,'P'),(3,1,2.2,'test');

INSERT INTO `train` VALUES (1,'A-123'),(2,'B-773'),(3,'V-321'),(4,'G-333'),(5,'D-111');

INSERT INTO `carriage` VALUES (1,11,1,1),(2,12,1,2),(3,22,2,2),(4,31,3,1),(5,32,3,1),(6,41,4,1),(7,42,4,1),(8,43,4,2),(9,51,5,1),(10,52,5,1);

INSERT INTO `schedule` (id, city_id, driving_order, time, train_id)  VALUES (1,1,1,'12:00:00',1),(2,2,2,'16:00:00',1),(3,3,3,'18:00:00',1),(4,4,4,'19:00:00',1),(5,6,1,'11:00:00',2),(6,5,2,'17:00:00',2),(7,4,3,'20:00:00',2),(8,2,4,'23:00:00',2),(9,1,1,'15:00:00',3),(10,3,2,'23:00:00',3),(11,1,1,'10:00:00',4),(12,2,2,'14:00:00',4),(13,4,3,'17:00:00',4),(14,5,1,'01:00:00',5),(15,4,2,'06:00:00',5),(16,3,3,'07:00:00',5),(17,2,4,'10:00:00',5),(18,1,5,'15:00:00',5);

INSERT INTO `ticket` (`id`, `number_seat`, `carriage_id`, `train_id`, `out_schedule_id`, `in_schedule_id`,  `date`,  `price`) VALUES (1,4,1,1,1,3,'2019-10-20',5),(2,3,1,1,2,4,'2019-10-20',4),(3,5,2,1,3,4,'2019-10-20',3),(4,5,3,2,6,8,'2019-10-20',7),(5,3,1,1,1,2,'2019-10-20',2),(6,1,1,1,2,4,'2019-10-20',34),(7,6,1,1,3,4,'2019-10-20',42),(8,4,1,1,1,4,'2019-10-20',12),(9,9,1,1,1,3,'2019-10-20',3),(11,10,1,1,1,3,'2019-10-21',12),(43,6,1,1,1,3,'2019-10-20',999);

INSERT INTO `person` (`id`, `experience`, `login`, `name`, `password`, `surname`) VALUES ('1', '1', 'admin', 'admin', 'admin', 'admin');
INSERT INTO `person` (`id`, `experience`, `login`, `name`, `password`, `surname`) VALUES ('2', '0', 'user', 'user', '123', 'user');
INSERT INTO `person_role` (`person_id`, `roles`) VALUES ('1', 'USER');
INSERT INTO `person_role` (`person_id`, `roles`) VALUES ('1', 'ADMIN');
INSERT INTO `person_role` (`person_id`, `roles`) VALUES ('2', 'USER');
