

INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(1,'Laptop','Active', 'Tavan', NOW());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(2,'Desktop','Active', 'Tavan', NOW());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(3,'Tablet', 'Active', 'Tavan', Now());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(4,'Phone', 'Active', 'Tavan', Now());
INSERT INTO TBL_CATEGORY(ID , CATE_NAME  , DESCRIPTION, CREATED_BY, CREATED_DATE) VALUES(5,'Accessory', 'Active', 'Tavan', Now());

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
--             (6,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
-- INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
--             (7,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A17', 800, 900.90, now(), 'Tavan');
-- INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY )  VALUES
--             (8,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');
-- INSERT INTO PRODUCT (PRODUCT_ID , CATEGORY_ID , IMAGE_URL, PRO_NAME , ORIGINAL_PRICE , SALE_PRICE  , CREATED_DATE , CREATED_BY ) VALUES


--             (9,'1','https://www.asus.com/media/global/gallery/trfp1kp4xvoudgam_setting_xxx_0_90_end_2000.png', 'ASUS TUF Gaming A15', 800, 900.90, now(), 'Tavan');


INSERT INTO TBL_PRODUCTMODEL (MODEL_ID ,MODEL_NAME ) VALUES (1, 'DELL');
--------------------------------------------

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(1, 'Get 10% cashback . Expired', 'To celebrate the Renewal Opening Ceremony of AEON MALL Phnom Penh (AEON 1), ACLEDA Bank offers 10% cashback to customers for payments through ACLEDA QR on ACLEDA mobile in this AEON MALL Phnom Penh.', 'Valid from 03 to 05 November 2023.
Total cashback up to US$5.
Total payment from US$50 within these three days.
We reserve the rights to change the conditions or terminate this promotion without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/AEON1-Renewal.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(2, 'Lowest fee! Only US$3 Flat . Expired', 'For sending money worldwide within minutes via MoneyGram on ACLEDA mobile and over the counter nationwide.', 'Valid from now until October 31, 2023 or while stocks last.
Applicable for transaction up to US$2,000.
We reserve the rights to change, amend the conditions or terminate this promotion without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/moneygram-eng.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(3, 'Instant 30% OFF . Expired', 'Instant 30% off for payments through ACLEDA KHQR on ACLEDA mobile at Tealive Cambodia (both branches in St. 310, BKK and Steung Meanchey).', 'Valid from now until the end of August 2023.
Offer up to USD5 or KHR20,000 per transaction.
A customer gets 2 times discount per day.
We reserve the rights to change, amend the terms and conditions or terminate the promotion without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/tealive.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(4, 'Enjoy exclusive fares from Singapore Airlines . Expired', 'Enjoy exclusive fares from Singapore Airlines (SIA) and receive USD40 Chip Mong retail voucher.', 'Enjoy exclusive fares from Singapore Airlines (SIA) and receive USD40 Chip Mong retail voucher. Book early and enjoy a USD40 shopping voucher with every ticket purchased using Mastercard®*.   

Plan your trip with your family now and celebrate the upcoming holidays. 
Book with Mastercard and enjoy special fares to various destinations including: Singapore, Indonesia, Malaysia, Australia, as well as in Europe, and the Americas. ', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/SIA-khm.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(5, 'Get 30% cashback . Expired', 'Get 30% cashback for your payments through Visa cards on POS of ACLEDA Bank at Lucky Supermarket (all stores).', 'Offer from now until the end of May 2023 or while stocks last.
Get 30% cashback or up to $5 per transaction and up to $10 per month.
This cashback will be credited to customers accounts no later than June 20, 2023.
Terms & conditions apply.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/Visa-Lucky%20Supermarket.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(6, 'Special health checkup package . Expired', 'Special health checkup package for all cardholders of ACLEDA Visa cards at Bangkok Hospital (all 4 branches) in Thailand.', 'Bangkok Hospital

Chhong Vichchhika, [8/2/2024 10:39 AM]


Executive Male EST Checkup at THB 15,200 from regular price THB 39,930.
Executive Female EST Checkup at THB 20,900 from regular price THB 49,321.
Please make an appointment at least 7 days in advance at +66 310 3000 or email: info@bangkokhospital.com
Services are available at International Medical Services (IMS), 4th R Building, Bangkok Hospital (Soi Soonvijai, New Petchburi Road, Bangkok).
Bangkok Hospital Phuket

Health Checkup package for Male at THB 8,500 and for Female at THB 9,600.
Appointment in advance is required by contact to International Marketing Department at email: BPK-inter-MKT-Group@bgh.co.th
Map: https://goo.gl/maps/Kp94zpRuRcG9ktsw6
Bangkok Hospital Samui

Health Checkup for Male and Female at THB 3,900 from normal price THB 8,200.
Please make an appointment in advance. Contact to Marketing Department Tel. 077-429-500 ext. 3153.
Map: https://goo.gl/maps/N8QTTigVLYpKHzdf8
Bangkok Hospital Pattaya

VIP Male Checkup at THB 14,900 from regular price THB 19,235.
VIP Female Checkup at THB 18,900 from regular price THB 23,165.
For more information and appointment, contact to Health Promotion Center call 0 3825 9999.
Map: https://goo.gl/maps/3XWajjmpAGPwC69W6', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/Bangkok-Hospital.jpg', 0);


INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(7, 'Get 20% cashback . Expired', 'Payments through all ACLEDA Mastercard (including virtual card) on websites of coursera and udemy.', 'Get 20% cashback for your payments through all ACLEDA Mastercard (including virtual card) on websites of coursera and udemy.

Offer from 01 to 30 November 2023 or while stocks last.
Get 20% cashback or up to 10$ per month.
This cashback will be credited to your account no later than 20 December 2023.
We reserve the rights to change, amend the conditions or terminate this promotion without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/Mastercard-101.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(8, 'Get Siam gift card worth THB 1,000', 'Get Siam gift card worth THB 1,000 when you make payments through ACLEDA Visa cards from THB 100,000 for luxury brands at ICONSIAM in Thailand.', 'The offer is valid from now until August 31, 2024 or until stocks last. Multiple sales slip on the same card number and on the same day of purchase are eligible to redeem a Siam gift card. Please present your ACLEDA Visa card with your sales slip at Tourist Lounge to redeem a Siam gift card. The offers are available in limited amount, on a first come first served basis.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/iconsiam-visa.jpg', 0);

INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(9, 'Get 20% cashback . Expired', 'Payments through all ACLEDA Visa cards (including virtual card) on websites: LinkedIn Learning, edX, learnfly, and Earn and EXCEL.', 'Valid from now until September 30, 2024 or while stocks last. Terms & conditions apply. The offer is valid from now until August 14, 2024 or while stocks last. Discount up to KHR8,000 or USD2 per transaction. A customer gets 2 times discount per day. We reserve the rights to change the terms or terminate this program without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/Visa-1123.jpg', 0);



INSERT INTO ARTICLE (ID, TITLE, SHORT_DESCRIPTION, LONG_DESCRIPTION, CREATED_BY, CREATED_DATE, IMAGE_URL, VIEW_COUNT) VALUES 
(10, 'Get 20% cashback . Expired', 'Get 20% cashback for your payments through ACLEDA Bank JCB cards (including virtual card) on websites: coursera and udemy.', 'Valid from now until September 30, 2024 or while stocks last. Terms & conditions apply. The offer is valid from now until August 14, 2024 or while stocks last. Discount up to KHR8,000 or USD2 per transaction. A customer gets 2 times discount per day. We reserve the rights to change the terms or terminate this program without prior notice.', 'Admin', NOW(), 'https://www.acledabank.com.kh/kh/assets/promotion/JCB-Ecommerce.jpg', 0);