INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (1, 'No', 'CLIENT');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (2, 'Yes', 'CLIENT');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (3, 'No', 'CLIENT');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (4, 'No', 'CLIENT');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (10, 'No', 'DRIVER');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (11, 'No', 'DRIVER');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (12, 'No', 'DRIVER');
INSERT INTO `user_detail` (`user_id`, `banned`, `role`)
VALUES (13, 'No', 'DRIVER');



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
VALUES (10, 4, 13, 12, '2019-05-03', 'COMPLETED', 4);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (11, 4, 13, 12, '2019-05-04', 'CANCELLED_BY_DRIVER', 4);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (12, 4, 13, 12, '2019-05-04', 'CANCELLED_BY_CLIENT', 3);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (13, 4, 13, 12, '2019-05-04', 'CANCELLED_BY_DRIVER', 2);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (14, 4, 13, 12, '2019-05-05', 'CANCELLED_BY_CLIENT', 2);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (15, 4, 13, 12, '2019-05-05', 'CANCELLED_BY_DRIVER', 2);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (16, 4, 13, 12, '2019-05-06', 'CANCELLED_BY_CLIENT', 4);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (17, 4, 13, 12, '2019-05-06', 'COMPLETED', 3);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (18, 4, 13, 12, '2019-05-06', 'CANCELLED_BY_CLIENT', 1);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (19, 4, 13, 12, '2019-05-07', 'COMPLETED', 3);
INSERT INTO `trip_detail` (`id`, `client_id`, `driver_id`, `region_id`, `request_at`, `status`, `user_id`)
VALUES (20, 4, 13, 12, '2019-05-07', 'CANCELLED_BY_DRIVER', 2);

