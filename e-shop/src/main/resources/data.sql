INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(1,'Laptop','Active', 'Tavan', NOW());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(2,'Desktop','Active', 'Tavan', NOW());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(3,'Vehicle','Active', 'Tavan', Now());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(4,'Tablet', 'Active', 'Tavan', Now());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(5,'Phone', 'Active', 'Tavan', Now());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(6,'Accessory', 'Active', 'Tavan', Now());


INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , image_url, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY ) VALUES
					   (1,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A17', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , image_url, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY ) VALUES
					   (2,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A17', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , image_url, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
					   (3,'1','https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg', 'ASUS TUF Gaming A17', 1200, 1500.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID, image_url, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY )  VALUES
					   (4,'1','https://m.media-amazon.com/images/I/712fs524LSL._SX679_.jpg', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY ) VALUES
					   (5,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A17', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY ) VALUES
						(6,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
						(7,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A17', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
						(8,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY ) VALUES
						(9,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');


INSERT INTO PRODUCT_MODEL (MODEL_ID ,MODEL_NAME ) VALUES (1, 'DELL');