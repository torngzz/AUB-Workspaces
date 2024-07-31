INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(1,'Laptop','Active', 'Tavan', NOW());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(2,'Desktop','Active', 'Tavan', NOW());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(3,'Vehicle','Active', 'Tavan', Now());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(4,'Tablet', 'Active', 'Tavan', Now());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(5,'Phone', 'Active', 'Tavan', Now());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(6,'Accessory', 'Active', 'Tavan', Now());

INSERT INTO TBL_PRODUCT (
     CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
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
INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '2',
    'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg',
    'MSI Gaming Laptop',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);

-- Insert statement for product with ID 3
INSERT INTO TBL_PRODUCT (CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '3',
    'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
    'MackBook Pro',
    1200,
    1500.90,
    NOW(),
    'Tavan',
    'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);

-- Insert statement for product with ID 4
INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '1',
    'https://m.media-amazon.com/images/I/712fs524LSL._SX679_.jpg',
    'ASUS TUF Gaming A15',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'2',
	'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg',
	'MSI Gaming Laptop',
	800,
	900.90,
	now(),
	'Tavan',
	'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
-- Insert statement for product with ID 3
INSERT INTO TBL_PRODUCT (
     CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '3',
    'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
    'MackBook Pro',
    1200,
    1500.90,
    NOW(),
    'Tavan',
    'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);

-- Insert statement for product with ID 4
INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'1',
	'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
	'ASUS TUF Gaming A17',
	800,
	900.90,
	now(),
	'Tavan',
	'https://www.asus.com/media/Odin/Websites/global/ProductLine/20200824120842.jpg, https://m.media-amazon.com/images/I/81fZmxBbQgL._AC_SL1500_.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'2',
	'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg',
	'MSI Gaming laptop',
	800,
	900.90,
	now(),
	'Tavan',
	'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'3',
	'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
	'MackBook Pro',
	1200,
	1500.90,
	now(),
	'Tavan',
	'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'1',
	'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
	'ASUS TUF Gaming A17',
	800,
	900.90,
	now(),
	'Tavan',
	'https://www.asus.com/media/Odin/Websites/global/ProductLine/20200824120842.jpg, https://m.media-amazon.com/images/I/81fZmxBbQgL._AC_SL1500_.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'2',
	'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg',
	'MSI Gaming Laptop',
	800,
	900.90,
	now(),
	'Tavan',
	'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'3',
	'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
	'MackBook Pro',
	1200,
	1500.90,
	now(),
	'Tavan',
	'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'1',
	'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
	'ASUS TUF Gaming A17',
	800,
	900.90,
	now(),
	'Tavan',
	'https://www.asus.com/media/Odin/Websites/global/ProductLine/20200824120842.jpg, https://m.media-amazon.com/images/I/81fZmxBbQgL._AC_SL1500_.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'2',
	'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg',
	'MSI Gaming Laptop',
	800,
	900.90,
	now(),
	'Tavan',
	'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'3',
	'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
	'MackBook Pro',
	1200,
	1500.90,
	now(),
	'Tavan',
	'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'1',
	'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
	'ASUS TUF Gaming A17',
	800,
	900.90,
	now(),
	'Tavan',
	'https://www.asus.com/media/Odin/Websites/global/ProductLine/20200824120842.jpg, https://m.media-amazon.com/images/I/81fZmxBbQgL._AC_SL1500_.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'2',
	'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg',
	'MSI Gaming Laptop',
	800,
	900.90,
	now(),
	'Tavan',
	'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'3',
	'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
	'MackBook Pro',
	1200,
	1500.90,
	now(),
	'Tavan',
	'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
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
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'2',
	'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg',
	'MSI Gaming Laptop',
	800,
	900.90,
	now(),
	'Tavan',
	'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'3',
	'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
	'MackBook Pro',
	1200,
	1500.90,
	now(),
	'Tavan',
	'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'1',
	'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
	'ASUS TUF Gaming A17',
	800,
	900.90,
	now(),
	'Tavan',
	'https://www.asus.com/media/Odin/Websites/global/ProductLine/20200824120842.jpg, https://m.media-amazon.com/images/I/81fZmxBbQgL._AC_SL1500_.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'2',
	'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg?v=1708044200',
	'MSI Gaming Laptop',
	800,
	900.90,
	now(),
	'Tavan',
	'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'3',
	'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
	'MackBook Pro',
	1200,
	1500.90,
	now(),
	'Tavan',
	'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'1',
	'https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png',
	'ASUS TUF Gaming A17',
	800,
	900.90,
	now(),
	'Tavan',
	'https://www.asus.com/media/Odin/Websites/global/ProductLine/20200824120842.jpg, https://m.media-amazon.com/images/I/81fZmxBbQgL._AC_SL1500_.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'2',
	'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/609802-Product-0-I-638128464799715885.jpg',
	'MSI Gaming Laptop',
	800,
	900.90,
	now(),
	'Tavan',
	'https://storage-asset.msi.com/event/2022/nb/RPL-Gaming/images/ge_m.png,https://5.imimg.com/data5/SELLER/Default/2024/3/405060859/CC/QG/UG/210833049/msi-17-raider-gaming-laptop-500x500.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT ( CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY , DETAIL_IMAGE_URL, DESCRIPTION)
VALUES(
	'3',
	'https://metaitech.com/wp-content/uploads/2020/07/mack-book.jpg',
	'MackBook Pro',
	1200,
	1500.90,
	now(),
	'Tavan',
	'https://m.media-amazon.com/images/I/6198-d8r20L._AC_UF894,1000_QL80_.jpg,https://static4.laurem.pl/pol_pl_APPLE-MACBOOK-PRO-A2251-i5-1038NG7-16GB-512GB-SSD-2560x1600-Space-Gray-2020r-18759_9.jpg',
	'It is a high-performance gaming laptop designed for gaming enthusiasts.'
	);
    INSERT INTO TBL_PRODUCT (
    CATEGORY_ID, IMAGE_URL, PRO_NAME, ORIGINAL_PRICE, SALE_PRICE, CREATED_DATE, CREATED_BY, DETAIL_IMAGE_URL, DESCRIPTION
) VALUES (
    '4',
    'https://m.media-amazon.com/images/I/81xAUzMHL9L._AC_UF894,1000_QL80_.jpg',
    'DELL NoteBook',
    800,
    900.90,
    NOW(),
    'Tavan',
    'https://sone.co.uk/cdn/shop/files/Dell-Inspiron-16-Plus-7620-Laptop-3K-Intel-i7-12th-Gen-16GB-Memory-512GB-RTX-3050-7_720x.jpg?,https://m.media-amazon.com/images/I/51-vDO4+qAL._AC_UF350,350_QL80_DpWeblab_.jpg',
    'It is a high-performance gaming laptop designed for gaming enthusiasts.'
);
-- INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID, IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE , CREATED_DATE , CREATED_BY ) VALUES
-- 						(6,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
-- INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
-- 						(7,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A17', 800, 900.90, now(), 'Tavan');
-- INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
-- 						(8,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
-- INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY ) VALUES
-- 						(9,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');


INSERT INTO TBL_PRODUCTMODEL (MODEL_ID ,MODEL_NAME ) VALUES (1, 'DELL');
--------------------------------------------

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(1, 'Get 30% off.', 'Exclusive offer for PassApp & ACLEDA Bank! Get 10% off when spending from THB3,000 on food only with ACLEDA Visa cards at DAI LOU Chinese Restaurant in Thailand.', 'The offer is valid from now until August 14, 2024 or while stocks last.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/PassApp-client.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(2, 'Free upgrade size of Starbucks', 'Special offer: Get $10 off your purchase.', 'The offer is valid from now until August 31, 2024 or while stocks last.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/visa-star-buck-1.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(3, 'Get 10% cashback', 'Get 10% cashback every month for your payments with ACLEDA JCB cards.', 'Valid from May to August 2024 or while stocks last.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/jcb-taobao-1.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(4, 'Get 30% off - Updated', 'Exclusive offer for PassApp & ACLEDA Bank! Get 30% off, booking PassApp rides and payment through ACLEDA mobile (ACLEDA Pay).', 'The offer is valid from now until August 14, 2024 or while stocks last. Discount up to KHR8,000 or USD2 per transaction. A customer gets 2 times discount per day. We reserve the rights to change the terms or terminate this program without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/PassApp-client.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(5, 'Free upgrade size of Starbucks - Updated', '77 Soi Phahon Yothin 5, Phayathai, Phaya Thai, Bangkok 10400, First time for dinner was quite nice. It was unexpectedly packed. Orders did not come out slow though. The Peking duck, the fish soup, etc, were just great in its Cantonese style. The michelin-starred scallop is a little off compared to other main dishes. Staff was very attentive and service minded Thailand Special offer: Get $10 off your purchase. Get up to KHR800,000 every month', 'The offer is valid from now until August 31, 2024 or while stocks last. The offer is applied on every Monday to Thursday at all Starbucks stores in Phnom Penh, Siem Reap, Preah Sihanouk, Battambang, and Kampot. Purchasing of Tall (small) size beverages will be upgraded to Grande (medium) size, while purchases Grande (medium) size will be upgraded to Venti (large) size respectively. The offer is applicable for handcrafted beverages, except bottle beverages. We reserve the right to change the conditions or terminate the promotion without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/visa-dailou.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(6, 'Get 10% cashback - Updated', 'Get 10% cashback every month for your payments with ACLEDA JCB cards (including virtual card) on Taobao.', 'Valid from May to August 2024 or while stocks last. Get 10% cashback or up to KHR40,000 or USD10 per month. Payment from KHR40,000 or USD10 and up per transaction. This cashback will be credited to your account no later than 20th next month. We reserve the rights to change the conditions or terminate this promotion without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/jcb-taobao-1.jpg', 0);


INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(7, 'Get up to KHR800,000 every month', 'Special offer: Get up to 30 extra minutes of massage. Get up to KHR800,000 every month for all ACLEDA Bank partners in Preah Sihanouk province.', 'Receive payment through ACLEDA KHQR on ACLEDA mobile from 100 buyers or more per month. Having most transactions: 1st - get KHR800,000, 2nd - get KHR600,000, 3rd - get KHR400,000, and other partners get KHR80,000 per month. Receive payment from KHR5,000 or USD1.25 per transaction. Offer is valid from June to August 2024. We reserve the rights to change the conditions or terminate the promotion without prior notice.', 'Admin', NOW(), 'https://www.mastertechkh.com/storage/images/11-Feb-2023-183331_63e7df7b50bbf.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(8, 'Get Siam gift card worth THB 1,000', 'Get Siam gift card worth THB 1,000 when you make payments through ACLEDA Visa cards from THB 100,000 for luxury brands at ICONSIAM in Thailand.', 'The offer is valid from now until August 31, 2024 or until stocks last. Multiple sales slip on the same card number and on the same day of purchase are eligible to redeem a Siam gift card. Please present your ACLEDA Visa card with your sales slip at Tourist Lounge to redeem a Siam gift card. The offers are available in limited amount, on a first come first served basis.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/iconsiam-visa.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(9, 'Offer 10% off', 'Special offer 10% off (food and beverage) every payment through ACLEDA Bank Visa cards (except virtual card) at Sovanphum Restaurant.', 'Valid from now until September 30, 2024 or while stocks last. Terms & conditions apply. The offer is valid from now until August 14, 2024 or while stocks last. Discount up to KHR8,000 or USD2 per transaction. A customer gets 2 times discount per day. We reserve the rights to change the terms or terminate this program without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/PassApp-client.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(10, 'Offer 10% off Liu @ Conrad China Hotel', 'Special offer 10% off (food and beverage) every payment through ACLEDA Bank Visa cards (except virtual card) at Sovanphum Restaurant.', 'Valid from now until September 30, 2024 or while stocks last. Terms & conditions apply. The offer is valid from now until August 14, 2024 or while stocks last. Discount up to KHR8,000 or USD2 per transaction. A customer gets 2 times discount per day. We reserve the rights to change the terms or terminate this program without prior notice.', 'Admin', NOW(), 'https://lh5.googleusercontent.com/p/AF1QipM8S4tSI_R5P0hRRBzq3lqS00iwdyjNuxGyq9VO=w234-h171-p-k-no', 0);

