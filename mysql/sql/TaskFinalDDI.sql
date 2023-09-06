use shop

drop table if exists ONLINE_ORDER_LIST; 
drop table if exists ONLINE_ORDER; 
drop table if exists ONLINE_PRODUCT; 
drop table if exists ONLINE_CATEGORY; 
drop table if exists ONLINE_STAFF; 
drop table if exists ONLINE_MEMBER; 

create table ONLINE_MEMBER( 
  MEMBER_NO integer primary key
  , PASSWORD varchar (8) NOT NULL
  , NAME varchar (20) NOT NULL
  , AGE integer NOT NULL
  , SEX char (1) NOT NULL
  , ZIP varchar (8) NOT NULL
  , ADDRESS varchar (50) NOT NULL
  , TEL varchar (20) NOT NULL
  , REGISTER_DATE date NOT NULL
  , DELETE_FLG char (1) default '0' NOT NULL
  , LAST_UPD_DATE timestamp
) ENGINE = InnoDB DEFAULT CHARSET = utf8; 

create table ONLINE_STAFF( 
  STAFF_NO integer primary key
  , PASSWORD varchar (8) NOT NULL
  , NAME varchar (20) NOT NULL
  , AGE integer NOT NULL
  , SEX char (1) NOT NULL
  , REGISTER_DATE date NOT NULL
  , LAST_UPD_DATE timestamp
) ENGINE = InnoDB DEFAULT CHARSET = utf8; 

create table ONLINE_CATEGORY( 
  CTGR_ID integer primary key
  , NAME varchar (50) NOT NULL
  , LAST_UPD_DATE timestamp
) ENGINE = InnoDB DEFAULT CHARSET = utf8; 

create table ONLINE_PRODUCT( 
  PRODUCT_CODE varchar (14) primary key
  , CATEGORY_ID integer NOT NULL
  , PRODUCT_NAME varchar (50) NOT NULL
  , MAKER varchar (20) NOT NULL
  , STOCK_COUNT integer NOT NULL
  , REGISTER_DATE date NOT NULL
  , UNIT_PRICE BIGINT NOT NULL
  , PICTURE_NAME varchar (100)
  , MEMO varchar (255)
  , DELETE_FLG char (1) default '0' NOT NULL
  , LAST_UPD_DATE timestamp
  , foreign key (CATEGORY_ID) references ONLINE_CATEGORY(CTGR_ID)
) ENGINE = InnoDB DEFAULT CHARSET = utf8; 

create table ONLINE_ORDER( 
  ORDER_NO integer NOT NULL primary key AUTO_INCREMENT
  , MEMBER_NO integer NOT NULL
  , TOTAL_MONEY BIGINT NOT NULL
  , TOTAL_TAX BIGINT NOT NULL
  , ORDER_DATE date NOT NULL
  , COLLECT_NO varchar (16) NOT NULL UNIQUE KEY
  , LAST_UPD_DATE timestamp NOT NULL
  , foreign key (MEMBER_NO) references ONLINE_MEMBER(MEMBER_NO)
) ENGINE = InnoDB DEFAULT CHARSET = utf8; 

create table ONLINE_ORDER_LIST( 
  LIST_NO integer NOT NULL primary key AUTO_INCREMENT
  , COLLECT_NO varchar (16) NOT NULL
  , PRODUCT_CODE varchar (14) NOT NULL
  , ORDER_COUNT integer NOT NULL
  , ORDER_PRICE bigint NOT NULL
  , foreign key (PRODUCT_CODE) references ONLINE_PRODUCT(PRODUCT_CODE)
) ENGINE = InnoDB DEFAULT CHARSET = utf8; 


insert into ONLINE_CATEGORY (CTGR_ID, NAME, LAST_UPD_DATE) value (1, 'トップス', Now());
insert into ONLINE_CATEGORY (CTGR_ID, NAME, LAST_UPD_DATE) value (2, 'パンツ', Now());
insert into ONLINE_CATEGORY (CTGR_ID, NAME, LAST_UPD_DATE) value (3, 'アウター', Now());
insert into ONLINE_CATEGORY (CTGR_ID, NAME, LAST_UPD_DATE) value (4, 'スポーツユーティリティウェア', Now());
insert into ONLINE_CATEGORY (CTGR_ID, NAME, LAST_UPD_DATE) value (5, 'インナー・下着', Now());
insert into ONLINE_CATEGORY (CTGR_ID, NAME, LAST_UPD_DATE) value (6, 'ルーム・ホーム', Now());
insert into ONLINE_CATEGORY (CTGR_ID, NAME, LAST_UPD_DATE) value (7, 'グッズ', Now());
insert into ONLINE_CATEGORY (CTGR_ID, NAME, LAST_UPD_DATE) value (8, '花', Now());