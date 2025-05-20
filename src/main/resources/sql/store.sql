-- SQL INSERT statements for store data with real names and business types, but simulated other fields
-- Modified to restrict owner_id to values 1-4 and change certification to file paths

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (1, '김형민세무회계사무소', '신뢰할 수 있는 세무 상담과 회계 서비스를 제공합니다.', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/1/thumbnail.jpg', '서울특별시 마포구 서교동 123-45', '홍대입구역 3번 출구에서 도보 5분', '09:00', '18:00', '02-123-4567', '공인회계사', '123-45-67890', '2018-03-15 09:00:00', '/files/certifications/store_1_cert.pdf', 'APPROVED', 1, 1);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (2, '파마트엘지약국', '건강을 위한 전문적인 약사 상담과 처방을 제공합니다.', 27, 'https://cheerup-bucket.s3.amazonaws.com/store/2/thumbnail.jpg', '서울특별시 마포구 서교동 234-56', '홍대입구역 2번 출구에서 도보 3분', '09:00', '22:00', '02-234-5678', '약국', '234-56-78901', '2015-07-22 09:00:00', '/files/certifications/store_2_cert.pdf', 'APPROVED', 2, 2);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (3, '에스지디자인', '맞춤형 디자인 서비스로 간판, 명함, 홍보물을 제작해 드립니다.', 8, 'https://cheerup-bucket.s3.amazonaws.com/store/3/thumbnail.jpg', '서울특별시 마포구 서교동 345-67', '홍대입구역 1번 출구에서 도보 7분', '10:00', '19:00', '02-345-6789', '명함/간판/광고물 제작', '345-67-89012', '2019-11-05 10:00:00', '/files/certifications/store_3_cert.pdf', 'APPROVED', 3, 3);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (4, 'GS공인중개사사무소', '신뢰할 수 있는 부동산 중개와 매물 정보를 제공합니다.', 32, 'https://cheerup-bucket.s3.amazonaws.com/store/4/thumbnail.jpg', '서울특별시 마포구 서교동 456-78', '합정역 5번 출구에서 도보 10분', '09:00', '21:00', '02-456-7890', '부동산 중개/대리업', '456-78-90123', '2017-05-20 09:00:00', '/files/certifications/store_4_cert.pdf', 'APPROVED', 4, 4);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (5, '인더월드', '맞춤형 여행 패키지와 항공권 예약 서비스를 제공합니다.', 41, 'https://cheerup-bucket.s3.amazonaws.com/store/5/thumbnail.jpg', '서울특별시 마포구 서교동 567-89', '홍대입구역 4번 출구에서 도보 6분', '10:00', '19:00', '02-567-8901', '여행사', '567-89-01234', '2016-09-15 10:00:00', '/files/certifications/store_5_cert.pdf', 'APPROVED', 1, 5);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (6, '카페모노블럭', '여유로운 분위기에서 직접 로스팅한 커피를 즐길 수 있는 공간입니다.', 87, 'https://cheerup-bucket.s3.amazonaws.com/store/6/thumbnail.jpg', '서울특별시 마포구 서교동 678-90', '홍대입구역 9번 출구에서 도보 4분', '10:00', '23:00', '02-678-9012', '카페', '678-90-12345', '2020-02-28 10:00:00', '/files/certifications/store_6_cert.pdf', 'APPROVED', 2, 6);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (7, '오유', '아름다운 손끝을 위한 프리미엄 네일아트 서비스를 제공합니다.', 64, 'https://cheerup-bucket.s3.amazonaws.com/store/7/thumbnail.jpg', '서울특별시 마포구 서교동 789-01', '홍대입구역 8번 출구에서 도보 3분', '11:00', '21:00', '02-789-0123', '네일숍', '789-01-23456', '2021-04-10 11:00:00', '/files/certifications/store_7_cert.pdf', 'APPROVED', 3, 8);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (8, '앨버트투어', '전세계 맞춤형 패키지 여행과 특별한 경험을 선사합니다.', 29, 'https://cheerup-bucket.s3.amazonaws.com/store/8/thumbnail.jpg', '서울특별시 마포구 서교동 890-12', '홍대입구역 2번 출구에서 도보 7분', '09:30', '18:30', '02-890-1234', '여행사', '890-12-34567', '2018-08-15 09:30:00', '/files/certifications/store_8_cert.pdf', 'APPROVED', 4, 9);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (9, '더블하모니', '아늑한 분위기에서 즐기는 스페셜티 커피와 수제 디저트가 있는 공간입니다.', 103, 'https://cheerup-bucket.s3.amazonaws.com/store/9/thumbnail.jpg', '서울특별시 마포구 서교동 901-23', '합정역 3번 출구에서 도보 8분', '08:00', '22:00', '02-901-2345', '카페', '901-23-45678', '2019-05-17 08:00:00', '/files/certifications/store_9_cert.pdf', 'APPROVED', 1, 10);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (10, '인사갤러리', '국내외 유명 작가의 작품을 감상하고 구매할 수 있는 갤러리입니다.', 47, 'https://cheerup-bucket.s3.amazonaws.com/store/10/thumbnail.jpg', '서울특별시 마포구 서교동 012-34', '합정역 6번 출구에서 도보 12분', '11:00', '20:00', '02-012-3456', '예술품 소매업', '012-34-56789', '2017-11-30 11:00:00', '/files/certifications/store_10_cert.pdf', 'APPROVED', 2, 11);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (11, '오-스케이프', '공간의 가치를 높이는 맞춤형 인테리어 디자인 서비스를 제공합니다.', 24, 'https://cheerup-bucket.s3.amazonaws.com/store/11/thumbnail.jpg', '서울특별시 마포구 서교동 112-33', '홍대입구역 5번 출구에서 도보 9분', '10:00', '19:00', '02-112-3345', '인테리어 디자인업', '112-33-45678', '2020-07-15 10:00:00', '/files/certifications/store_11_cert.pdf', 'APPROVED', 3, 12);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (12, '밍키행운파워연구소', '브랜드 아이덴티티와 시각 디자인 솔루션을 제공하는 디자인 스튜디오입니다.', 18, 'https://cheerup-bucket.s3.amazonaws.com/store/12/thumbnail.jpg', '서울특별시 마포구 서교동 212-44', '홍대입구역 9번 출구에서 도보 5분', '10:00', '19:00', '02-212-4456', '시각 디자인업', '212-44-56789', '2021-03-22 10:00:00', '/files/certifications/store_12_cert.pdf', 'APPROVED', 4, 13);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (13, '한국바이오초크', '친환경 문구와 회화용품을 판매하는 전문점입니다.', 33, 'https://cheerup-bucket.s3.amazonaws.com/store/13/thumbnail.jpg', '서울특별시 마포구 서교동 312-55', '홍대입구역 6번 출구에서 도보 8분', '09:30', '19:30', '02-312-5567', '문구/회화용품 소매업', '312-55-67890', '2019-09-05 09:30:00', '/files/certifications/store_13_cert.pdf', 'APPROVED', 1, 14);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (14, '쉐시몽', '프랑스 전통 요리와 현대적인 감각이 어우러진 경양식 레스토랑입니다.', 92, 'https://cheerup-bucket.s3.amazonaws.com/store/14/thumbnail.jpg', '서울특별시 마포구 서교동 412-66', '합정역 7번 출구에서 도보 6분', '11:30', '22:00', '02-412-6678', '경양식', '412-66-78901', '2018-06-12 11:30:00', '/files/certifications/store_14_cert.pdf', 'APPROVED', 2, 15);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (15, '사계진미', '엄선된 국내산 돼지고기로 정성껏 만드는 구이와 찜 요리 전문점입니다.', 117, 'https://cheerup-bucket.s3.amazonaws.com/store/15/thumbnail.jpg', '서울특별시 마포구 서교동 512-77', '홍대입구역 1번 출구에서 도보 10분', '11:00', '23:00', '02-512-7789', '돼지고기 구이/찜', '512-77-89012', '2017-04-20 11:00:00', '/files/certifications/store_15_cert.pdf', 'APPROVED', 3, 16);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (16, '바이하루', '트렌디한 헤어스타일과 헤어케어를 위한 프리미엄 미용실입니다.', 68, 'https://cheerup-bucket.s3.amazonaws.com/store/16/thumbnail.jpg', '서울특별시 마포구 서교동 612-88', '합정역 4번 출구에서 도보 8분', '10:00', '20:00', '02-612-8890', '미용실', '612-88-90123', '2020-05-15 10:00:00', '/files/certifications/store_16_cert.pdf', 'APPROVED', 4, 17);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (17, '번역공동체잇다', '전문적인 번역과 통역 서비스를 제공하는 언어 전문 업체입니다.', 21, 'https://cheerup-bucket.s3.amazonaws.com/store/17/thumbnail.jpg', '서울특별시 마포구 서교동 712-99', '홍대입구역 7번 출구에서 도보 6분', '09:00', '18:00', '02-712-9901', '번역/통역 서비스업', '712-99-01234', '2019-02-28 09:00:00', '/files/certifications/store_17_cert.pdf', 'APPROVED', 1, 18);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (18, '와이즈뮤직', '개인 맞춤 레슨과 다양한 음악 프로그램을 제공하는 음악학원입니다.', 44, 'https://cheerup-bucket.s3.amazonaws.com/store/18/thumbnail.jpg', '서울특별시 마포구 서교동 813-00', '홍대입구역 3번 출구에서 도보 7분', '13:00', '22:00', '02-813-0012', '음악학원', '813-00-12345', '2018-10-10 13:00:00', '/files/certifications/store_18_cert.pdf', 'APPROVED', 2, 19);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (19, '홍대닭갈비', '특제 양념과 신선한 재료로 만드는 정통 닭갈비 전문점입니다.', 156, 'https://cheerup-bucket.s3.amazonaws.com/store/19/thumbnail.jpg', '서울특별시 마포구 서교동 913-11', '홍대입구역 2번 출구에서 도보 4분', '16:00', '02:00', '02-913-1123', '닭/오리고기 구이/찜', '913-11-23456', '2016-11-23 16:00:00', '/files/certifications/store_19_cert.pdf', 'APPROVED', 3, 20);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (20, '홍어한마리', '신선한 해산물과 정통 홍어 요리를 맛볼 수 있는 횟집입니다.', 89, 'https://cheerup-bucket.s3.amazonaws.com/store/20/thumbnail.jpg', '서울특별시 마포구 서교동 013-22', '합정역 1번 출구에서 도보 10분', '11:30', '22:30', '02-013-2234', '횟집', '013-22-34567', '2017-08-05 11:30:00', '/files/certifications/store_20_cert.pdf', 'APPROVED', 4, 21);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (21, '스타코칭주', '경영자와 리더를 위한 전문적인 코칭 및 컨설팅 서비스를 제공합니다.', 37, 'https://cheerup-bucket.s3.amazonaws.com/store/21/thumbnail.jpg', '서울특별시 마포구 서교동 114-33', '홍대입구역 8번 출구에서 도보 12분', '09:00', '18:00', '02-114-3345', '경영 컨설팅업', '114-33-45678', '2019-06-17 09:00:00', '/files/certifications/store_21_cert.pdf', 'APPROVED', 1, 22);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (22, '크루아', '다양한 레크리에이션 및 교육 프로그램을 제공하는 레저 교육 기관입니다.', 53, 'https://cheerup-bucket.s3.amazonaws.com/store/22/thumbnail.jpg', '서울특별시 마포구 서교동 214-44', '홍대입구역 9번 출구에서 도보 13분', '10:00', '20:00', '02-214-4456', '레크리에이션 교육기관', '214-44-56789', '2020-03-10 10:00:00', '/files/certifications/store_22_cert.pdf', 'APPROVED', 2, 23);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (23, '닭대장', '30년 전통의 비법 양념으로 만드는 맛있는 닭요리 전문점입니다.', 128, 'https://cheerup-bucket.s3.amazonaws.com/store/23/thumbnail.jpg', '서울특별시 마포구 서교동 314-55', '홍대입구역 6번 출구에서 도보 12분', '16:00', '01:00', '02-314-5567', '닭/오리고기 구이/찜', '314-55-67890', '2015-12-25 16:00:00', '/files/certifications/store_23_cert.pdf', 'APPROVED', 3, 24);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (24, '위니즈리서치주', '시장 조사와 여론 분석을 통한 전문적인 데이터 서비스를 제공합니다.', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/24/thumbnail.jpg', '서울특별시 마포구 서교동 414-66', '합정역 2번 출구에서 도보 9분', '09:00', '18:00', '02-414-6678', '시장 조사 및 여론 조사업', '414-66-78901', '2018-02-15 09:00:00', '/files/certifications/store_24_cert.pdf', 'APPROVED', 4, 25);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (25, '에이씨휴먼넷', '맞춤형 인력 공급 및 인사관리 솔루션을 제공하는 전문 기업입니다.', 22, 'https://cheerup-bucket.s3.amazonaws.com/store/25/thumbnail.jpg', '서울특별시 마포구 서교동 514-77', '홍대입구역 5번 출구에서 도보 14분', '09:00', '18:00', '02-514-7789', '상용 인력 공급 및 인사관리 서비스업', '514-77-89012', '2019-05-07 09:00:00', '/files/certifications/store_25_cert.pdf', 'APPROVED', 1, 26);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (26, '돼지저금통', '엄선된 국내산 돼지고기로 건강하고 맛있는 구이와 찜 요리를 제공합니다.', 143, 'https://cheerup-bucket.s3.amazonaws.com/store/26/thumbnail.jpg', '서울특별시 마포구 서교동 614-88', '홍대입구역 4번 출구에서 도보 5분', '16:00', '01:00', '02-614-8890', '돼지고기 구이/찜', '614-88-90123', '2017-07-17 16:00:00', '/files/certifications/store_26_cert.pdf', 'APPROVED', 2, 27);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (27, '메종드웨이브.1', '도심 속 휴식을 위한 모던하고 편안한 펜션입니다.', 72, 'https://cheerup-bucket.s3.amazonaws.com/store/27/thumbnail.jpg', '서울특별시 마포구 서교동 714-99', '홍대입구역 9번 출구에서 도보 7분', '15:00', '11:00', '02-714-9901', '펜션', '714-99-01234', '2019-08-08 15:00:00', '/files/certifications/store_27_cert.pdf', 'APPROVED', 3, 28);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (28, '유니티레코드바', '음악과 함께 즐기는 특별한 안주와 칵테일이 있는 요리 주점입니다.', 110, 'https://cheerup-bucket.s3.amazonaws.com/store/28/thumbnail.jpg', '서울특별시 마포구 서교동 815-00', '합정역 3번 출구에서 도보 11분', '18:00', '03:00', '02-815-0012', '요리 주점', '815-00-12345', '2018-09-19 18:00:00', '/files/certifications/store_28_cert.pdf', 'APPROVED', 4, 29);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (29, '육오공', '독특한 분위기와 특별한 안주가 있는 요리 주점입니다.', 95, 'https://cheerup-bucket.s3.amazonaws.com/store/29/thumbnail.jpg', '서울특별시 마포구 서교동 915-11', '홍대입구역 1번 출구에서 도보 9분', '17:00', '02:00', '02-915-1123', '요리 주점', '915-11-23456', '2016-10-05 17:00:00', '/files/certifications/store_29_cert.pdf', 'APPROVED', 1, 30);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (30, '레몬디자인', '공간의 가치를 높이는 창의적인 인테리어 디자인 서비스를 제공합니다.', 31, 'https://cheerup-bucket.s3.amazonaws.com/store/30/thumbnail.jpg', '서울특별시 마포구 서교동 015-22', '합정역 4번 출구에서 도보 7분', '10:00', '19:00', '02-015-2234', '인테리어 디자인업', '015-22-34567', '2020-01-15 10:00:00', '/files/certifications/store_30_cert.pdf', 'APPROVED', 2, 31);

-- SQL INSERT statements for store data
INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (31, '라이브곰친구', '신선한 재료로 만든 맛있는 감자탕과 해장국을 즐길 수 있는 맛집입니다.', 12, 'https://cheerup-bucket.s3.amazonaws.com/store/1/thumbnail.jpg', '서울특별시 종로구 관철동 123-45', '종로3가역 5번 출구에서 도보 3분', '11:00', '23:00', '02-123-4567', '요리 주점', '123-45-67890', '2018-05-12 11:00:00', '/files/certifications/store_1_cert.pdf', 'APPROVED', 1, 101);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (32, '참맛감자탕', '20년 전통의 감자탕 전문점으로 깊은 맛을 자랑합니다.', 25, 'https://cheerup-bucket.s3.amazonaws.com/store/2/thumbnail.jpg', '서울특별시 마포구 서교동 234-56', '홍대입구역 3번 출구에서 도보 5분', '10:00', '22:00', '02-234-5678', '국/탕/찌개류', '234-56-78901', '2015-03-22 10:00:00', '/files/certifications/store_2_cert.pdf', 'APPROVED', 2, 102);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (33, '뭉치바위', '정성이 담긴 한식 백반으로 매일 다른 메뉴를 제공합니다.', 18, 'https://cheerup-bucket.s3.amazonaws.com/store/3/thumbnail.jpg', '서울특별시 강남구 역삼동 345-67', '강남역 2번 출구에서 도보 10분', '08:00', '20:00', '02-345-6789', '백반/한정식', '345-67-89012', '2017-11-15 08:00:00', '/files/certifications/store_3_cert.pdf', 'APPROVED', 3, 103);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (34, '백장미댄스', '전문 강사진이 지도하는 다양한 댄스 프로그램을 운영합니다.', 7, 'https://cheerup-bucket.s3.amazonaws.com/store/4/thumbnail.jpg', '서울특별시 서초구 서초동 456-78', '서초역 4번 출구에서 도보 5분', '09:00', '21:00', '02-456-7890', '레크리에이션 교육기관', '456-78-90123', '2019-07-01 09:00:00', '/files/certifications/store_4_cert.pdf', 'APPROVED', 4, 104);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (35, '라면땡기는날', '다양한 라면과 분식을 맛볼 수 있는 분식점입니다.', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/5/thumbnail.jpg', '서울특별시 동작구 사당동 567-89', '사당역 1번 출구에서 도보 2분', '10:30', '21:30', '02-567-8901', '김밥/만두/분식', '567-89-01234', '2020-02-15 10:30:00', '/files/certifications/store_5_cert.pdf', 'APPROVED', 1, 105);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (36, '시티벨로', '전문 자전거 판매 및 수리 서비스를 제공합니다.', 6, 'https://cheerup-bucket.s3.amazonaws.com/store/6/thumbnail.jpg', '서울특별시 강동구 천호동 678-90', '천호역 5번 출구에서 도보 8분', '09:00', '18:00', '02-678-9012', '자전거 소매업', '678-90-12345', '2018-04-10 09:00:00', '/files/certifications/store_6_cert.pdf', 'APPROVED', 2, 106);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (37, '트윈빌세탁소', '친환경 세제를 사용한 깨끗한 세탁 서비스를 제공합니다.', 9, 'https://cheerup-bucket.s3.amazonaws.com/store/7/thumbnail.jpg', '서울특별시 노원구 상계동 789-01', '노원역 3번 출구에서 도보 4분', '08:00', '19:00', '02-789-0123', '세탁소', '789-01-23456', '2016-09-22 08:00:00', '/files/certifications/store_7_cert.pdf', 'APPROVED', 3, 107);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (38, '청소하는고양이', '친환경 청소 용품으로 건물 내외부를 깨끗하게 관리해 드립니다.', 11, 'https://cheerup-bucket.s3.amazonaws.com/store/8/thumbnail.jpg', '서울특별시 관악구 신림동 890-12', '신림역 2번 출구에서 도보 6분', '09:00', '18:00', '02-890-1234', '건축물 일반 청소업', '890-12-34567', '2019-03-15 09:00:00', '/files/certifications/store_8_cert.pdf', 'APPROVED', 4, 108);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (39, '목포낙지', '신선한 해산물로 만든 맛있는 낙지요리를 맛볼 수 있습니다.', 22, 'https://cheerup-bucket.s3.amazonaws.com/store/9/thumbnail.jpg', '서울특별시 송파구 잠실동 901-23', '잠실역 7번 출구에서 도보 5분', '11:30', '22:00', '02-901-2345', '해산물 구이/찜', '901-23-45678', '2017-05-05 11:30:00', '/files/certifications/store_9_cert.pdf', 'APPROVED', 1, 109);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (40, '오.헤어', '최신 트렌드를 반영한 헤어 스타일링을 제공합니다.', 17, 'https://cheerup-bucket.s3.amazonaws.com/store/10/thumbnail.jpg', '서울특별시 중구 명동 012-34', '명동역 4번 출구에서 도보 3분', '10:00', '20:00', '02-012-3456', '미용실', '012-34-56789', '2018-12-01 10:00:00', '/files/certifications/store_10_cert.pdf', 'APPROVED', 2, 110);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (41, '한미문구', '다양한 문구 및 사무용품을 판매하는 문구점입니다.', 5, 'https://cheerup-bucket.s3.amazonaws.com/store/11/thumbnail.jpg', '서울특별시 광진구 구의동 123-45', '구의역 1번 출구에서 도보 2분', '09:00', '19:00', '02-123-4567', '문구/회화용품 소매업', '123-45-67890', '2020-01-15 09:00:00', '/files/certifications/store_11_cert.pdf', 'APPROVED', 3, 111);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (42, '이다헤어샵', '개인 맞춤형 헤어 디자인을 제공하는 미용실입니다.', 13, 'https://cheerup-bucket.s3.amazonaws.com/store/12/thumbnail.jpg', '서울특별시 성북구 길음동 234-56', '길음역 3번 출구에서 도보 5분', '10:00', '20:00', '02-234-5678', '미용실', '234-56-78901', '2019-08-20 10:00:00', '/files/certifications/store_12_cert.pdf', 'APPROVED', 4, 112);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (43, '두울웨딩', '맞춤형 웨딩 서비스를 제공하는 예식장입니다.', 19, 'https://cheerup-bucket.s3.amazonaws.com/store/13/thumbnail.jpg', '서울특별시 서초구 반포동 345-67', '고속터미널역 5번 출구에서 도보 10분', '10:00', '19:00', '02-345-6789', '예식장업', '345-67-89012', '2017-06-15 10:00:00', '/files/certifications/store_13_cert.pdf', 'APPROVED', 1, 113);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (44, '혜화사', '고급 의류 전문 세탁 서비스를 제공합니다.', 8, 'https://cheerup-bucket.s3.amazonaws.com/store/14/thumbnail.jpg', '서울특별시 종로구 혜화동 456-78', '혜화역 2번 출구에서 도보 3분', '08:30', '19:30', '02-456-7890', '세탁소', '456-78-90123', '2018-10-10 08:30:00', '/files/certifications/store_14_cert.pdf', 'APPROVED', 2, 114);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (45, '정안빌', '조용하고 쾌적한 환경에서 공부할 수 있는 스터디 카페입니다.', 14, 'https://cheerup-bucket.s3.amazonaws.com/store/15/thumbnail.jpg', '서울특별시 동작구 상도동 567-89', '상도역 1번 출구에서 도보 5분', '08:00', '23:00', '02-567-8901', '독서실/스터디 카페', '567-89-01234', '2019-09-01 08:00:00', '/files/certifications/store_15_cert.pdf', 'APPROVED', 3, 115);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (46, '９번지해장국', '30년 전통의 뼈해장국 전문점입니다.', 26, 'https://cheerup-bucket.s3.amazonaws.com/store/16/thumbnail.jpg', '서울특별시 중구 신당동 678-90', '신당역 4번 출구에서 도보 3분', '06:00', '16:00', '02-678-9012', '국/탕/찌개류', '678-90-12345', '2010-05-05 06:00:00', '/files/certifications/store_16_cert.pdf', 'APPROVED', 4, 116);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (47, '미술관', '정성스럽게 준비한 한식 메뉴를 제공하는 백반 전문점입니다.', 16, 'https://cheerup-bucket.s3.amazonaws.com/store/17/thumbnail.jpg', '서울특별시 용산구 이태원동 789-01', '이태원역 3번 출구에서 도보 7분', '11:00', '21:00', '02-789-0123', '백반/한정식', '789-01-23456', '2018-03-01 11:00:00', '/files/certifications/store_17_cert.pdf', 'APPROVED', 1, 117);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (48, '동인디자인포토', '고품질 인쇄 및 디자인 서비스를 제공합니다.', 7, 'https://cheerup-bucket.s3.amazonaws.com/store/18/thumbnail.jpg', '서울특별시 강남구 논현동 890-12', '신논현역 6번 출구에서 도보 4분', '09:00', '18:00', '02-890-1234', '명함/간판/광고물 제작', '890-12-34567', '2019-04-15 09:00:00', '/files/certifications/store_18_cert.pdf', 'APPROVED', 2, 118);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (49, '덤','아늑한 분위기에서 맛있는 커피와 디저트를 즐길 수 있는 카페입니다.',18, 'https://cheerup-bucket.s3.amazonaws.com/store/19/thumbnail.jpg', '서울특별시 마포구 합정동 901-23', '합정역 5번 출구에서 도보 6분', '10:00', '22:00', '02-901-2345', '카페', '901-23-45678', '2020-03-15 10:00:00', '/files/certifications/store_19_cert.pdf', 'APPROVED', 3, 119);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (50, '피드미', '다양한 반려동물 용품을 판매하는 전문점입니다.', 12, 'https://cheerup-bucket.s3.amazonaws.com/store/20/thumbnail.jpg', '서울특별시 강서구 등촌동 012-34', '등촌역 2번 출구에서 도보 5분', '10:00', '19:00', '02-012-3456', '애완동물/애완용품 소매업', '012-34-56789', '2019-11-01 10:00:00', '/files/certifications/store_20_cert.pdf', 'APPROVED', 4, 120);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (51, '코지필라테스', '전문 강사진이 지도하는 필라테스 수업을 제공합니다.', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/21/thumbnail.jpg', '서울특별시 송파구 문정동 123-45', '문정역 3번 출구에서 도보 3분', '09:00', '21:00', '02-123-4567', '요가/필라테스 학원', '123-45-67890', '2019-02-15 09:00:00', '/files/certifications/store_21_cert.pdf', 'APPROVED', 1, 121);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (52, '7페이지사진관', '다양한 콘셉트의 사진 촬영 서비스를 제공합니다.', 9, 'https://cheerup-bucket.s3.amazonaws.com/store/22/thumbnail.jpg', '서울특별시 마포구 망원동 234-56', '망원역 1번 출구에서 도보 5분', '10:00', '19:00', '02-234-5678', '사진촬영업', '234-56-78901', '2018-07-07 10:00:00', '/files/certifications/store_22_cert.pdf', 'APPROVED', 2, 122);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (53, '르규옹', '프랑스 정통 요리를 맛볼 수 있는 레스토랑입니다.', 21, 'https://cheerup-bucket.s3.amazonaws.com/store/23/thumbnail.jpg', '서울특별시 서초구 잠원동 345-67', '고속터미널역 4번 출구에서 도보 8분', '11:30', '22:00', '02-345-6789', '경양식', '345-67-89012', '2017-12-10 11:30:00', '/files/certifications/store_23_cert.pdf', 'APPROVED', 3, 123);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (54, '아날로그하우스', '분위기 좋은 공간에서 다양한 안주와 술을 즐길 수 있는 주점입니다.', 17, 'https://cheerup-bucket.s3.amazonaws.com/store/24/thumbnail.jpg', '서울특별시 성동구 성수동 456-78', '성수역 2번 출구에서 도보 7분', '17:00', '02:00', '02-456-7890', '요리 주점', '456-78-90123', '2018-09-15 17:00:00', '/files/certifications/store_24_cert.pdf', 'APPROVED', 4, 124);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (55, '케이바', '다양한 칵테일과 안주를 즐길 수 있는 바입니다.', 14, 'https://cheerup-bucket.s3.amazonaws.com/store/25/thumbnail.jpg', '서울특별시 강남구 신사동 567-89', '신사역 8번 출구에서 도보 5분', '18:00', '03:00', '02-567-8901', '요리 주점', '567-89-01234', '2019-05-20 18:00:00', '/files/certifications/store_25_cert.pdf', 'APPROVED', 1, 125);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (56, '테누', '직접 로스팅한 원두로 만든 커피를 제공하는 카페입니다.', 20, 'https://cheerup-bucket.s3.amazonaws.com/store/26/thumbnail.jpg', '서울특별시 용산구 한남동 678-90', '한남역 3번 출구에서 도보 6분', '08:00', '21:00', '02-678-9012', '카페', '678-90-12345', '2018-06-01 08:00:00', '/files/certifications/store_26_cert.pdf', 'APPROVED', 2, 126);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (57, '아르봉봉', '수제 디저트와 맛있는 커피를 즐길 수 있는 카페입니다.', 16, 'https://cheerup-bucket.s3.amazonaws.com/store/27/thumbnail.jpg', '서울특별시 강북구 수유동 789-01', '수유역 4번 출구에서 도보 4분', '09:00', '22:00', '02-789-0123', '카페', '789-01-23456', '2019-08-15 09:00:00', '/files/certifications/store_27_cert.pdf', 'APPROVED', 3, 127);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (58, '인디라벨', '개성 있는 디자인의 의류를 판매하는 편집샵입니다.', 11, 'https://cheerup-bucket.s3.amazonaws.com/store/28/thumbnail.jpg', '서울특별시 마포구 서교동 890-12', '홍대입구역 9번 출구에서 도보 5분', '12:00', '21:00', '02-890-1234', '기타 의류 소매업', '890-12-34567', '2020-04-01 12:00:00', '/files/certifications/store_28_cert.pdf', 'APPROVED', 4, 128);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (59, '표정', '건강한 재료로 만든 양식을 즐길 수 있는 레스토랑입니다.', 19, 'https://cheerup-bucket.s3.amazonaws.com/store/29/thumbnail.jpg', '서울특별시 송파구 잠실동 901-23', '잠실역 2번 출구에서 도보 10분', '11:00', '22:00', '02-901-2345', '경양식', '901-23-45678', '2017-11-11 11:00:00', '/files/certifications/store_29_cert.pdf', 'APPROVED', 1, 129);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (60, '동서여행사주', '국내외 맞춤형 여행 패키지를 제공하는 여행사입니다.', 8, 'https://cheerup-bucket.s3.amazonaws.com/store/30/thumbnail.jpg', '서울특별시 강남구 삼성동 012-34', '삼성역 5번 출구에서 도보 3분', '09:00', '18:00', '02-012-3456', '여행사', '012-34-56789', '2016-04-10 09:00:00', '/files/certifications/store_30_cert.pdf', 'APPROVED', 2, 130);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (61, '인테리어살림', '독특한 디자인의 소품과 기념품을 판매하는 상점입니다.', 7, 'https://cheerup-bucket.s3.amazonaws.com/store/31/thumbnail.jpg', '서울특별시 마포구 연남동 123-45', '홍대입구역 3번 출구에서 도보 8분', '11:00', '20:00', '02-123-4567', '기념품점', '123-45-67890', '2019-10-15 11:00:00', '/files/certifications/store_31_cert.pdf', 'APPROVED', 3, 131);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (62, '비엔더블유스튜디오', '전문적인 사진 촬영 및 영상 제작 서비스를 제공합니다.', 13, 'https://cheerup-bucket.s3.amazonaws.com/store/32/thumbnail.jpg', '서울특별시 강남구 청담동 234-56', '청담역 2번 출구에서 도보 5분', '10:00', '19:00', '02-234-5678', '사진촬영업', '234-56-78901', '2018-08-01 10:00:00', '/files/certifications/store_32_cert.pdf', 'APPROVED', 4, 132);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (63, '새들러하우스', '편안한 분위기에서 특별한 커피를 즐길 수 있는 카페입니다.', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/33/thumbnail.jpg', '서울특별시 용산구 이태원동 345-67', '이태원역 1번 출구에서 도보 7분', '10:00', '22:00', '02-345-6789', '카페', '345-67-89012', '2018-08-01 10:00:00', '/files/certifications/store_33_cert.pdf', 'APPROVED', 1, 133);

-- 신사동 업체들
INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (64, '에이블', '편안한 분위기에서 즐기는 프리미엄 커피와 디저트', 12, 'https://cheerup-bucket.s3.amazonaws.com/store/64/thumbnail.jpg', '서울특별시 강남구 신사동 123-45', '신사역 8번 출구에서 도보 5분', '10:00', '22:00', '02-123-4567', '카페', '123-45-67890', '2020-05-15 09:00:00', '/files/certifications/store_64_cert.pdf', 'APPROVED', 2, 134);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (65, '윌비에프씨', '특별한 블렌딩 원두로 만든 스페셜티 커피를 제공합니다', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/65/thumbnail.jpg', '서울특별시 강남구 신사동 234-56', '신사역 3번 출구에서 도보 6분', '08:30', '21:00', '02-234-5678', '카페', '234-56-78901', '2021-03-22 10:00:00', '/files/certifications/store_65_cert.pdf', 'APPROVED', 1, 135);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (66, '시선에스피주', '고품질 디자인으로 명함, 간판, 광고물을 제작해드리는 디자인 전문업체입니다', 7, 'https://cheerup-bucket.s3.amazonaws.com/store/66/thumbnail.jpg', '서울특별시 강남구 신사동 345-67', '신사역 5번 출구에서 도보 8분', '09:00', '18:00', '02-345-6789', '명함/간판/광고물 제작', '345-67-89012', '2018-09-10 09:00:00', '/files/certifications/store_66_cert.pdf', 'APPROVED', 3, 136);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (67, '미우', '국내산 돼지고기만 사용하는 정통 한국식 돼지고기 전문점', 22, 'https://cheerup-bucket.s3.amazonaws.com/store/67/thumbnail.jpg', '서울특별시 강남구 신사동 456-78', '신사역 2번 출구에서 도보 10분', '11:30', '22:30', '02-456-7890', '돼지고기 구이/찜', '456-78-90123', '2019-07-15 11:00:00', '/files/certifications/store_67_cert.pdf', 'APPROVED', 4, 137);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (68, '에밀리아뜰리에', '계절별 신선한 꽃과 다양한 플라워 디자인을 제공하는 프리미엄 플라워샵', 14, 'https://cheerup-bucket.s3.amazonaws.com/store/68/thumbnail.jpg', '서울특별시 강남구 신사동 567-89', '신사역 4번 출구에서 도보 4분', '10:00', '20:00', '02-567-8901', '꽃집', '567-89-01234', '2020-12-01 10:00:00', '/files/certifications/store_68_cert.pdf', 'APPROVED', 2, 138);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (69, '채셔브로우', '맞춤형 스킨케어 서비스와 최신 피부 관리 트렌드를 반영한 프리미엄 피부 관리실', 18, 'https://cheerup-bucket.s3.amazonaws.com/store/69/thumbnail.jpg', '서울특별시 강남구 신사동 678-90', '신사역 1번 출구에서 도보 12분', '11:00', '21:00', '02-678-9012', '피부 관리실', '678-90-12345', '2021-02-10 11:00:00', '/files/certifications/store_69_cert.pdf', 'APPROVED', 1, 139);

-- 을지로동 업체들
INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (70, '을지왕', '30년 전통의 정통 한식 안주와 막걸리를 즐길 수 있는 요리 주점', 25, 'https://cheerup-bucket.s3.amazonaws.com/store/70/thumbnail.jpg', '서울특별시 중구 을지로동 789-01', '을지로3가역 1번 출구에서 도보 3분', '17:00', '02:00', '02-789-0123', '요리 주점', '789-01-23456', '1992-05-20 17:00:00', '/files/certifications/store_70_cert.pdf', 'APPROVED', 3, 140);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (71, '코만도레저스포츠', '다양한 아웃도어 및 레저 의류를 판매하는 전문점', 9, 'https://cheerup-bucket.s3.amazonaws.com/store/71/thumbnail.jpg', '서울특별시 중구 을지로동 890-12', '을지로4가역 2번 출구에서 도보 5분', '10:30', '20:30', '02-890-1234', '기타 의류 소매업', '890-12-34567', '2015-08-15 10:00:00', '/files/certifications/store_71_cert.pdf', 'APPROVED', 4, 141);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (72, '희스토리두번째', '현대적인 감각으로 재해석한 전통 안주와 주류를 즐길 수 있는 요리 주점', 16, 'https://cheerup-bucket.s3.amazonaws.com/store/72/thumbnail.jpg', '서울특별시 중구 을지로동 901-23', '을지로3가역 4번 출구에서 도보 6분', '18:00', '01:00', '02-901-2345', '요리 주점', '901-23-45678', '2019-11-11 18:00:00', '/files/certifications/store_72_cert.pdf', 'APPROVED', 2, 142);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (73, '청수복국', '40년 전통의 깊은 맛을 자랑하는 한식 전문점으로 정성이 담긴 백반과 한정식을 제공합니다', 30, 'https://cheerup-bucket.s3.amazonaws.com/store/73/thumbnail.jpg', '서울특별시 중구 을지로동 012-34', '을지로4가역 1번 출구에서 도보 2분', '06:00', '20:00', '02-012-3456', '백반/한정식', '012-34-56789', '1983-03-05 06:00:00', '/files/certifications/store_73_cert.pdf', 'APPROVED', 1, 143);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (74, '문경식당', '건강한 재료로 만든 정성 가득한 한식을 즐길 수 있는 백반 전문점', 24, 'https://cheerup-bucket.s3.amazonaws.com/store/74/thumbnail.jpg', '서울특별시 중구 을지로동 123-45', '을지로3가역 2번 출구에서 도보 4분', '07:00', '21:00', '02-123-4567', '백반/한정식', '123-45-67890', '1995-09-10 07:00:00', '/files/certifications/store_74_cert.pdf', 'APPROVED', 3, 144);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (75, '골목식당', '오랜 전통을 자랑하는 정성스러운 가정식 한정식을 맛볼 수 있는 곳', 22, 'https://cheerup-bucket.s3.amazonaws.com/store/75/thumbnail.jpg', '서울특별시 중구 을지로동 234-56', '을지로3가역 3번 출구에서 도보 5분', '11:00', '22:00', '02-234-5678', '백반/한정식', '234-56-78901', '2000-05-15 11:00:00', '/files/certifications/store_75_cert.pdf', 'APPROVED', 4, 145);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (76, '티파니당구장', '쾌적한 환경에서 즐길 수 있는 프리미엄 당구장', 10, 'https://cheerup-bucket.s3.amazonaws.com/store/76/thumbnail.jpg', '서울특별시 중구 을지로동 345-67', '을지로4가역 3번 출구에서 도보 7분', '12:00', '03:00', '02-345-6789', '당구장', '345-67-89012', '2017-07-20 12:00:00', '/files/certifications/store_76_cert.pdf', 'APPROVED', 2, 146);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (77, '하시시박', '트렌디한 여성 의류와 액세서리를 판매하는 셀렉트샵', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/77/thumbnail.jpg', '서울특별시 중구 을지로동 456-78', '을지로3가역 5번 출구에서 도보 4분', '11:00', '21:00', '02-456-7890', '여성 의류 소매업', '456-78-90123', '2019-03-08 11:00:00', '/files/certifications/store_77_cert.pdf', 'APPROVED', 1, 147);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (78, 'GY시스템', '10년 이상의 경력을 가진 전문가들의 신속하고 정확한 컴퓨터 수리 서비스', 18, 'https://cheerup-bucket.s3.amazonaws.com/store/78/thumbnail.jpg', '서울특별시 중구 을지로동 567-89', '을지로4가역 4번 출구에서 도보 3분', '09:00', '19:00', '02-567-8901', '컴퓨터/노트북/프린터 수리업', '567-89-01234', '2012-11-15 09:00:00', '/files/certifications/store_78_cert.pdf', 'APPROVED', 3, 148);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (79, '유네사진관', '중요한 순간을 아름답게 담아내는 프로페셔널 사진 스튜디오', 13, 'https://cheerup-bucket.s3.amazonaws.com/store/79/thumbnail.jpg', '서울특별시 중구 을지로동 678-90', '을지로3가역 6번 출구에서 도보 5분', '10:00', '19:00', '02-678-9012', '사진촬영업', '678-90-12345', '2016-04-20 10:00:00', '/files/certifications/store_79_cert.pdf', 'APPROVED', 4, 149);

-- 한남동 업체들
INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (80, '원인어밀리언', '독특한 분위기에서 즐기는 스페셜티 커피와 디저트', 20, 'https://cheerup-bucket.s3.amazonaws.com/store/80/thumbnail.jpg', '서울특별시 용산구 한남동 789-01', '한남역 1번 출구에서 도보 10분', '08:00', '22:00', '02-789-0123', '카페', '789-01-23456', '2020-01-15 08:00:00', '/files/certifications/store_80_cert.pdf', 'APPROVED', 2, 150);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (81, '레에스티우', '유러피안 스타일의 모던한 경양식을 즐길 수 있는 레스토랑', 25, 'https://cheerup-bucket.s3.amazonaws.com/store/81/thumbnail.jpg', '서울특별시 용산구 한남동 890-12', '한남역 2번 출구에서 도보 7분', '11:30', '22:00', '02-890-1234', '경양식', '890-12-34567', '2018-06-10 11:30:00', '/files/certifications/store_81_cert.pdf', 'APPROVED', 1, 151);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (82, '아크바인', '유니크한 디자인의 수제 액세서리와 잡화를 판매하는 셀렉트샵', 12, 'https://cheerup-bucket.s3.amazonaws.com/store/82/thumbnail.jpg', '서울특별시 용산구 한남동 901-23', '한남역 3번 출구에서 도보 8분', '11:00', '20:00', '02-901-2345', '액세서리/잡화 소매업', '901-23-45678', '2019-09-05 11:00:00', '/files/certifications/store_82_cert.pdf', 'APPROVED', 3, 152);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (83, '스튜디오다홍', '자연광을 활용한 감성적인 인물 사진과 프로필 촬영 전문 스튜디오', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/83/thumbnail.jpg', '서울특별시 용산구 한남동 012-34', '한남역 1번 출구에서 도보 12분', '10:00', '19:00', '02-012-3456', '사진촬영업', '012-34-56789', '2020-03-15 10:00:00', '/files/certifications/store_83_cert.pdf', 'APPROVED', 4, 153);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (84, '블루클럽', '트렌디한 스타일링과 정성스러운 서비스를 제공하는 프리미엄 미용실', 18, 'https://cheerup-bucket.s3.amazonaws.com/store/84/thumbnail.jpg', '서울특별시 용산구 한남동 123-45', '한남역 2번 출구에서 도보 5분', '10:00', '20:00', '02-123-4567', '미용실', '123-45-67890', '2017-11-20 10:00:00', '/files/certifications/store_84_cert.pdf', 'APPROVED', 2, 154);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (85, '센츄리한남공인중개사사무소', '한남동 부동산 전문가로 맞춤형 부동산 상담과 중개 서비스를 제공합니다', 10, 'https://cheerup-bucket.s3.amazonaws.com/store/85/thumbnail.jpg', '서울특별시 용산구 한남동 234-56', '한남역 3번 출구에서 도보 6분', '09:00', '18:00', '02-234-5678', '부동산 중개/대리업', '234-56-78901', '2015-05-10 09:00:00', '/files/certifications/store_85_cert.pdf', 'APPROVED', 1, 155);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (86, '쿠', '아늑한 분위기에서 즐기는 프리미엄 원두와 홈메이드 디저트', 22, 'https://cheerup-bucket.s3.amazonaws.com/store/86/thumbnail.jpg', '서울특별시 용산구 한남동 345-67', '한남역 1번 출구에서 도보 9분', '09:00', '21:00', '02-345-6789', '카페', '345-67-89012', '2019-07-15 09:00:00', '/files/certifications/store_86_cert.pdf', 'APPROVED', 3, 156);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (87, '레이나공방', '창의적인 공예 수업과 원데이 클래스를 제공하는 전문 공방', 14, 'https://cheerup-bucket.s3.amazonaws.com/store/87/thumbnail.jpg', '서울특별시 용산구 한남동 456-78', '한남역 2번 출구에서 도보 11분', '11:00', '20:00', '02-456-7890', '그 외 기타 교육기관', '456-78-90123', '2021-01-10 11:00:00', '/files/certifications/store_87_cert.pdf', 'APPROVED', 4, 157);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (88, '브리에', '유럽의 감성을 담은 세련된 여성 의류와 액세서리를 판매하는 부티크', 16, 'https://cheerup-bucket.s3.amazonaws.com/store/88/thumbnail.jpg', '서울특별시 용산구 한남동 567-89', '한남역 3번 출구에서 도보 8분', '11:00', '20:30', '02-567-8901', '여성 의류 소매업', '567-89-01234', '2018-08-20 11:00:00', '/files/certifications/store_88_cert.pdf', 'APPROVED', 2, 158);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (89, '아라비즈', '최신 의료기기와 건강용품을 판매하는 전문점', 8, 'https://cheerup-bucket.s3.amazonaws.com/store/89/thumbnail.jpg', '서울특별시 용산구 한남동 678-90', '한남역 1번 출구에서 도보 15분', '10:00', '19:00', '02-678-9012', '의료기기 소매업', '678-90-12345', '2017-03-05 10:00:00', '/files/certifications/store_89_cert.pdf', 'APPROVED', 1, 159);

-- 성수1가2동 업체들
INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (90, '누아흐', '로스팅부터 추출까지 모든 과정에 정성을 담은 스페셜티 커피 전문점', 19, 'https://cheerup-bucket.s3.amazonaws.com/store/90/thumbnail.jpg', '서울특별시 성동구 성수1가2동 789-01', '성수역 3번 출구에서 도보 7분', '08:30', '21:30', '02-789-0123', '카페', '789-01-23456', '2020-08-15 08:30:00', '/files/certifications/store_90_cert.pdf', 'APPROVED', 3, 160);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (91, '에이치디디', '정통 중국 요리사가 만드는 본격 중식 요리를 맛볼 수 있는 중국집', 24, 'https://cheerup-bucket.s3.amazonaws.com/store/91/thumbnail.jpg', '서울특별시 성동구 성수1가2동 890-12', '성수역 2번 출구에서 도보 8분', '11:00', '21:30', '02-890-1234', '중국집', '890-12-34567', '2018-11-10 11:00:00', '/files/certifications/store_91_cert.pdf', 'APPROVED', 4, 161);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (92, '푸르너스케이크', '최고급 재료로 만든 케이크 클래스를 제공하는 베이킹 스튜디오', 15, 'https://cheerup-bucket.s3.amazonaws.com/store/92/thumbnail.jpg', '서울특별시 성동구 성수1가2동 901-23', '성수역 1번 출구에서 도보 10분', '10:00', '19:00', '02-901-2345', '그 외 기타 교육기관', '901-23-45678', '2019-05-05 10:00:00', '/files/certifications/store_92_cert.pdf', 'APPROVED', 2, 162);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (93, '오드비', '유럽의 감성을 담은 모던 유러피안 다이닝 레스토랑', 26, 'https://cheerup-bucket.s3.amazonaws.com/store/93/thumbnail.jpg', '서울특별시 성동구 성수1가2동 012-34', '성수역 4번 출구에서 도보 6분', '11:30', '22:00', '02-012-3456', '경양식', '012-34-56789', '2020-02-20 11:30:00', '/files/certifications/store_93_cert.pdf', 'APPROVED', 1, 163);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (94, '셀렌바이옴', '자연주의 화장품과 친환경 뷰티 제품을 판매하는 코스메틱 스토어', 17, 'https://cheerup-bucket.s3.amazonaws.com/store/94/thumbnail.jpg', '서울특별시 성동구 성수1가2동 123-45', '성수역 2번 출구에서 도보 5분', '11:00', '20:00', '02-123-4567', '화장품 소매업', '123-45-67890', '2021-04-15 11:00:00', '/files/certifications/store_94_cert.pdf', 'APPROVED', 3, 164);


INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (95, '온리맨', '남성 전용 헤어 케어와 스타일링을 제공하는 프리미엄 바버샵', 20, 'https://cheerup-bucket.s3.amazonaws.com/store/95/thumbnail.jpg', '서울특별시 성동구 성수1가2동 234-56', '성수역 3번 출구에서 도보 4분', '10:00', '20:00', '02-234-5678', '미용실', '234-56-78901', '2019-03-10 10:00:00', '/files/certifications/store_95_cert.pdf', 'APPROVED', 4, 165);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (96, '샐러드넘버6', '신선한 로컬 재료로 만든 건강한 샐러드와 경양식을 제공하는 레스토랑', 21, 'https://cheerup-bucket.s3.amazonaws.com/store/96/thumbnail.jpg', '서울특별시 성동구 성수1가2동 345-67', '성수역 2번 출구에서 도보 7분', '11:00', '21:00', '02-345-6789', '경양식', '345-67-89012', '2020-06-15 11:00:00', '/files/certifications/store_96_cert.pdf', 'APPROVED', 2, 166);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (97, '쁘띠그랑', '프랑스 정통 기법으로 만든 다양한 빵과 도넛을 판매하는 프리미엄 베이커리', 23, 'https://cheerup-bucket.s3.amazonaws.com/store/97/thumbnail.jpg', '서울특별시 성동구 성수1가2동 456-78', '성수역 1번 출구에서 도보 9분', '07:30', '20:00', '02-456-7890', '빵/도넛', '456-78-90123', '2019-12-05 07:30:00', '/files/certifications/store_97_cert.pdf', 'APPROVED', 1, 167);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (98, '고미하우스', '엄선된 천연 원료로 만든 건강보조식품과 영양제를 판매하는 전문점', 11, 'https://cheerup-bucket.s3.amazonaws.com/store/98/thumbnail.jpg', '서울특별시 성동구 성수1가2동 567-89', '성수역 4번 출구에서 도보 12분', '10:00', '19:00', '02-567-8901', '건강보조식품 소매업', '567-89-01234', '2018-07-20 10:00:00', '/files/certifications/store_98_cert.pdf', 'APPROVED', 3, 168);

INSERT INTO store (id, name, description, cheer_count, thumbnail, address, directions, opening_time, closing_time, phone_number, business_type, business_number, opening_date, certification, status, owner_id, location_id)
VALUES (99, '에이티104', '모던한 분위기에서 즐기는 크래프트 맥주와 창의적인 안주를 제공하는 요리 주점', 18, 'https://cheerup-bucket.s3.amazonaws.com/store/99/thumbnail.jpg', '서울특별시 성동구 성수1가2동 678-90', '성수역 3번 출구에서 도보 5분', '17:00', '01:00', '02-678-9012', '요리 주점', '678-90-12345', '2021-05-10 17:00:00', '/files/certifications/store_99_cert.pdf', 'APPROVED', 3, 169);
