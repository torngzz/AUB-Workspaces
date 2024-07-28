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