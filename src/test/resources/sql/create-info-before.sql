delete from bank_acc_entrep;
delete from bank_acc_org;
delete from bank_acc_pers;
delete from diskvlic;
delete from faktupnal;
delete from ndfl3;
delete from ndipsr;
delete from vipip;
delete from vipul;
delete from zadorg;
delete from zpvipegr;
delete from zvipul;

insert into bank_acc_entrep(id, inn, create_date, bank_acc_entrep_info) values
('11111111-1111-1111-1111-111111111111', '123456', '11-11-2020', '{
    "банкСчетИП": null,
    "treatmentCode": null
}');
insert into bank_acc_org(id, inn, create_date, bank_acc_org_info) values
('11111111-1111-1111-1111-111111111111', '1234567', '11-11-2020', '{
    "treatmentCode": null,
    "банкСчетОрг": null
}');
insert into bank_acc_pers(id, inn, create_date, bank_acc_pers_info) values
('11111111-1111-1111-1111-111111111111', '12345678', '11-11-2020', '{
    "treatmentCode": null,
    "банкСчетФЛ": null
}');
insert into diskvlic(id, inn, create_date, diskvlic_info) values
('11111111-1111-1111-1111-111111111111', '123456789', '11-11-2020', '{
    "кодОбр": "1",
    "идЗапрос": "1",
    "свДисквФЛ": null}');
insert into faktupnal(id, inn, create_date, faktupnal_info) values
('11111111-1111-1111-1111-111111111111', '1234567890', '11-11-2020', '{
    "idRequest": null,
    "treatmentCode": null,
    "dataAmountPaidTaxes": null
}');
insert into ndfl3(id, inn, create_date, ndfl3_info) values
('11111111-1111-1111-1111-111111111111', '12345678901', '11-11-2020', '{
    "ndfl3Info": null,
    "requestId": null,
    "requestProcessingCode": null
}');
insert into ndipsr(id, inn, create_date, ndipsr_info) values
('11111111-1111-1111-1111-111111111111', '123456789012', '11-11-2020', '{
    "requestId": null,
    "ndipsrInfo": null
}');
insert into vipip(id, inn, create_date, vipip_info) values
('11111111-1111-1111-1111-111111111111', '1234567890123', '11-11-2020', '{
    "СвИП": null,
    "ИдДок": null,
    "КодОбр": null,
    "AttachmentsBlock": null
}');
insert into vipul(id, inn, create_date, vipul_info) values
('11111111-1111-1111-1111-111111111111', '12345678901234', '11-11-2020', '{
    "СвЮЛ": null,
    "ИдДок": null,
    "КодОбр": null,
    "AttachmentsBlock": null
}');
insert into zadorg(id, inn, create_date, zadorg_info) values
('11111111-1111-1111-1111-111111111111', '123456789012345', '11-11-2020', '{
    "идЗапрос": null,
    "кодОбраб": null,
    "свЗадолж": null
}');
insert into zpvipegr(id, inn, create_date, zpvipegr_info) values
('11111111-1111-1111-1111-111111111111', '1234567890123456', '11-11-2020', '{
    "ВидДок": null,
    "КодОбр": null,
    "КодОтк": null,
    "ИдЗаявл": null,
    "Вложения": null,
    "ИдЗапрос": null
}');
insert into zvipul(id, inn, create_date, zvipul_info) values
('11111111-1111-1111-1111-111111111111', '12345678901234567', '11-11-2020', '{
    "СвЮЛ": null,
    "ИдДок": null,
    "КодОбр": null}');