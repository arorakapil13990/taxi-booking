INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (1, 'No', 'CLIENT');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (2, 'Yes', 'CLIENT');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (3, 'No', 'CLIENT');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (4, 'No', 'CLIENT');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (10, 'No', 'driver');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (11, 'No', 'driver');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (12, 'No', 'driver');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (13, 'No', 'driver');



INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (1, 1, 10, 1, '2019-05-01', 'COMPLETED', 1);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (2, 2, 11, 1, '2019-05-01', 'CANCELLED_BY_DRIVER', 2);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (3, 3, 12, 6, '2019-05-01', 'COMPLETED', 3);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (4, 4, 13, 6, '2019-05-01', 'CANCELLED_BY_CLIENT', 4);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (5, 1, 10, 1, '2019-05-02', 'COMPLETED', 1);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (6, 2, 11, 6, '2019-05-02', 'COMPLETED', 2);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (7, 3, 12, 6, '2019-05-02', 'COMPLETED', 3);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (8, 2, 12, 12, '2019-05-03', 'COMPLETED', 2);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (9, 3, 10, 12, '2019-05-03', 'COMPLETED', 3);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (10, 4, 13, 12, '2019-05-03', 'CANCELLED_BY_DRIVER', 4);
