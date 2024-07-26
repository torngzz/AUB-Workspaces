INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(1,'Laptop','Active', 'Tavan', NOW());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(2,'Desktop','Active', 'Tavan', NOW());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(3,'Vehicle','Active', 'Tavan', Now());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(4,'Tablet', 'Active', 'Tavan', Now());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(5,'Phone', 'Active', 'Tavan', Now());
INSERT INTO CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(6,'Accessory', 'Active', 'Tavan', Now());

INSERT INTO PRODUCT (
    PRODUCT_ID, CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    1,
    '1',
    'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
    'ASUS TUF Gaming A17',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://www.asus.com/media/Odin/Websites/global/ProductLine/20200824120842.jpg, https://m.media-amazon.com/images/I/81fZmxBbQgL._AC_SL1500_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);

-- Insert statement for product with ID 2
INSERT INTO PRODUCT (
    PRODUCT_ID, CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    2,
    '1',
    'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
    'ASUS TUF Gaming A17',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg,https://www.drukarki3d.seb-comp.pl/3876-large_default/dell-inspiron-g15-5510-i5.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);

-- Insert statement for product with ID 3
INSERT INTO PRODUCT (
    PRODUCT_ID, CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    3,
    '1',
    'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
    'ASUS TUF Gaming A17',
    1200,
    1500.90,
    NOW(),
    'Tavan',
    'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://ae04.alicdn.com/kf/Hb4127f960bbb4d0abf710eef848f1cf0l.jpg_640x640.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);

-- Insert statement for product with ID 4
INSERT INTO PRODUCT (
    PRODUCT_ID, CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    4,
    '1',
    'https://m.media-amazon.com/images/I/712fs524LSL._SX679_.jpg',
    'ASUS TUF Gaming A15',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6574/6574954_sd.jpg,https://www.hardwarezone.com.sg/thumbs/news/685777/t.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	5,
	'1',
	'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
	'ASUS TUF Gaming A17',
	800,
	900.90,
	now(),
	'Tavan',
	'https://www.drukarki3d.seb-comp.pl/3876-large_default/dell-inspiron-g15-5510-i5.jpg,https://image.ceneostatic.pl/data/products/148975977/i-laptop-dell-g15-gaming-5520-4063-15-6-i7-16gb-512gb-win11-55204.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY ) VALUES
						(6,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
						(7,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A17', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
						(8,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY ) VALUES
						(9,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');


INSERT INTO PRODUCT_MODEL (MODEL_ID ,MODEL_NAME ) VALUES (1, 'DELL');