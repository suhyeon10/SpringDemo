insert into company(id,
                    company_name,
                    company_region,
                    contract_start_date,
                    business_man)
values
    (1, '맘스터치', '강남', parsedatetime('20211001','yyyyMMdd'), '김맘스'),
    (2, '롯데리아', '서초',  parsedatetime('20211101','yyyyMMdd'), '박롯데'),
    (3, '베스킨라빈스', '역삼', parsedatetime('20211105','yyyyMMdd'), '베스킨'),
    (4, '본죽', '삼성', parsedatetime('20211103','yyyyMMdd'), '최본죽');

insert into collect_history(id,
                            company_id,
                            collect_amount,
                            collect_tub_count,
                            image_count,
                            collect_etc,
                            real_collect_time)
values
    (1, 1, 450, 4, 3, '새벽 수거 해야함', {ts '2021-11-03 01:15:13'}),
    (2, 2, 110, 1, 1, '없음',{ts '2021-11-03 13:25:36'}),
    (3, 3, 362, 3, 2, '하루 2번 수거',{ts '2021-11-03 12:25:14'}),
    (4, 4, 651, 6, 1, '매일 수거',{ts '2021-11-04 01:10:13'});

insert into collect_image(id,
                            file_name,
                            file_type,
                            collect_history_id,
                            create_date,
                            modified_date)
values
    (1, '맘스터치_01', 'jpg', 1, '2021-11-03 01:15:13', '2021-11-03 01:15:13'),
    (2, '맘스터치_02', 'jpg', 1, '2021-11-03 01:15:14', '2021-11-03 01:15:14'),
    (3, '맘스터치_03', 'jpg', 1, '2021-11-03 01:15:15', '2021-11-03 01:15:15'),
    (4, '롯데리아_01', 'png', 2, '2021-11-03 13:25:36', '2021-11-03 13:25:36'),
    (5, '베스킨라빈스_01', 'jpeg', 3, '2021-11-03 12:25:14', '2021-11-03 12:25:14'),
    (6, '베스킨라빈스_02', 'jpeg', 4, '2021-11-03 12:25:20', '2021-11-03 12:25:20'),
    (7, '본죽_01', 'jpg', 4, '2021-11-04 01:10:13', '2021-11-04 01:10:13');

