/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2024/5/1 10:50:52                            */
/*==============================================================*/


drop table if exists his_doctor_regInfo;

drop table if exists his_drug_catalogue;

drop table if exists his_inventory;

drop table if exists his_orders_schedules;

drop table if exists his_patients;

drop table if exists his_prescriptions;

drop table if exists his_prescriptions_schedules;

drop table if exists his_procurement_plans;

drop table if exists his_procurement_schedules;

drop table if exists his_purchaseOrders;

drop table if exists his_registers;

drop table if exists his_suppliers;

/*==============================================================*/
/* Table: his_doctor_regInfo                                    */
/*==============================================================*/
create table his_doctor_regInfo
(
   doc_reg_id           bigint not null auto_increment comment '�����¼���',
   user_id              bigint not null comment '�û�ID',
   doc_reg_time         date not null comment 'ʱ��',
   doc_reg_mor_num      int comment '����ʱ�κ���',
   doc_reg_aft_num      int comment '����ʱ�κ���',
   doc_reg_eve_num      int comment '����ʱ�κ���',
   doc_reg_mor_sum      int comment '������ɺ���',
   doc_reg_aft_sum      int comment '������ɺ���',
   doc_reg_eve_sum      int comment '������ɺ���',
   primary key (doc_reg_id)
);

alter table his_doctor_regInfo comment 'ҽ�������¼��';

/*==============================================================*/
/* Table: his_drug_catalogue                                    */
/*==============================================================*/
create table his_drug_catalogue
(
   cat_id               bigint not null auto_increment comment 'ҩƷID',
   cat_approval_number  varchar(64) comment '��׼�ĺ�',
   cat_drug_num         char(14) comment 'ҩƷ���',
   cat_name             varchar(128) comment 'ͨ��������Ʒ��',
   cat_English_name     varchar(128) comment 'Ӣ������',
   cat_producer         varchar(128) comment '������λ',
   cat_specs            varchar(128) comment '���',
   cat_dosage_form      smallint comment '����',
   cat_package          varchar(256) comment '��װ',
   cat_unit             smallint comment '��λ',
   cat_unit_price       int comment '���۵���',
   primary key (cat_id)
);

alter table his_drug_catalogue comment 'ҩƷĿ¼��';

/*==============================================================*/
/* Table: his_inventory                                         */
/*==============================================================*/
create table his_inventory
(
   inv_id               bigint not null auto_increment comment '�����',
   cat_id               bigint not null comment 'ҩƷID',
   inv_batch_number     varchar(32) not null comment '��������',
   inv_number           bigint comment '�������',
   inv_unit_price       int comment '���۵���',
   inv_prod_date        datetime comment '��������',
   inv_valid_to         datetime comment '��Ч����',
   primary key (inv_id)
);

alter table his_inventory comment '�����Ϣ��';

/*==============================================================*/
/* Table: his_orders_schedules                                  */
/*==============================================================*/
create table his_orders_schedules
(
   order_sch_id         bigint not null auto_increment comment '��ϸ��',
   pur_id               bigint not null comment '�ɹ���ID',
   cat_id               bigint not null comment 'ҩƷID',
   order_sch_number     bigint not null comment '�ɹ�����',
   primary key (order_sch_id)
);

alter table his_orders_schedules comment '�ɹ�������ϸ��';

/*==============================================================*/
/* Table: his_patients                                          */
/*==============================================================*/
create table his_patients
(
   patient_id           bigint not null auto_increment comment '���߱��',
   user_id              bigint comment '�û�ID',
   patient_name         varchar(16) not null comment '����',
   patient_sex          smallint comment '�Ա�',
   patient_birth_date   date comment '��������',
   patient_age          smallint comment '����',
   patient_id_card_num  varchar(20) comment '���֤��',
   patient_med_card_num varchar(20) comment 'ҽ������',
   patient_phone_num    varchar(16) comment '�ֻ���',
   primary key (patient_id)
);

alter table his_patients comment '������Ϣ��';

/*==============================================================*/
/* Table: his_prescriptions                                     */
/*==============================================================*/
create table his_prescriptions
(
   prsc_id              bigint not null auto_increment comment '����ID',
   reg_id               bigint not null comment '��¼���',
   prsc_doc_num         char(20) comment '�������ݺ�',
   prsc_type            smallint comment '��������',
   prsc_cost            int comment '�����ܼ�',
   prsc_status          smallint comment '����״̬',
   prsc_comments        text comment '��ע',
   primary key (prsc_id)
);

alter table his_prescriptions comment '������';

/*==============================================================*/
/* Table: his_prescriptions_schedules                           */
/*==============================================================*/
create table his_prescriptions_schedules
(
   prsc_sch_id          bigint not null auto_increment comment '��ϸ��',
   prsc_id              bigint not null comment '����ID',
   cat_id               bigint comment 'ҩƷID',
   prsc_sch_quantity    bigint not null comment '����',
   prsc_sch_usage       smallint comment '�÷�',
   prsc_sch_freq        smallint comment 'Ƶ��',
   prsc_sch_is_self_prepared bool not null comment '�Ƿ��Ա�',
   primary key (prsc_sch_id)
);

alter table his_prescriptions_schedules comment '������ϸ��';

/*==============================================================*/
/* Table: his_procurement_plans                                 */
/*==============================================================*/
create table his_procurement_plans
(
   prcp_id              bigint not null auto_increment comment '�ɹ��ƻ���ID',
   user_id              bigint not null comment '�û�ID',
   pur_id               bigint comment '�ɹ���ID',
   prcp_doc_num         char(20) comment '�ɹ��ƻ����ݺ�',
   prcp_date            date not null comment '�Ƶ�����',
   primary key (prcp_id)
);

alter table his_procurement_plans comment '�ɹ��ƻ�����';

/*==============================================================*/
/* Table: his_procurement_schedules                             */
/*==============================================================*/
create table his_procurement_schedules
(
   psch_id              bigint not null auto_increment comment '��ϸ��',
   prcp_id              bigint not null comment '�ɹ��ƻ���ID',
   cat_id               bigint not null comment 'ҩƷID',
   psch_price           bigint not null comment '�ο�����',
   psch_number          bigint not null comment '�ɹ�����',
   psch_pur_date        date comment 'Ԥ�Ʋɹ�����',
   psch_arv_date        date comment '��ٵ�������',
   primary key (psch_id)
);

alter table his_procurement_schedules comment '�ɹ��ƻ���ϸ��';

/*==============================================================*/
/* Table: his_purchaseOrders                                    */
/*==============================================================*/
create table his_purchaseOrders
(
   pur_id               bigint not null auto_increment comment '�ɹ���ID',
   spl_id               bigint not null comment '��Ӧ�̱��',
   user_id              bigint not null comment '�û�ID',
   pur_doc_num          char(20) comment '�ɹ����ݺ�',
   pur_date             date not null comment '��������',
   pur_arr_date         date comment '�ƻ���������',
   pur_pay_date         date comment 'Ԥ�Ƹ�������',
   primary key (pur_id)
);

alter table his_purchaseOrders comment '�ɹ�������';

/*==============================================================*/
/* Table: his_registers                                         */
/*==============================================================*/
create table his_registers
(
   reg_id               bigint not null auto_increment comment '��¼���',
   user_id              bigint not null comment 'ҽ��ID',
   patient_id           bigint not null comment '���߱��',
   reg_time             datetime not null comment '�Һ�����',
   reg_period           smallint not null comment '�Һ�ʱ��',
   reg_status           smallint not null comment '�Һ�״̬',
   primary key (reg_id)
);

alter table his_registers comment '�Һż�¼��';

/*==============================================================*/
/* Table: his_suppliers                                         */
/*==============================================================*/
create table his_suppliers
(
   spl_id               bigint not null auto_increment comment '��Ӧ�̱��',
   spl_name             varchar(32) not null comment '��Ӧ������',
   spl_addr             varchar(512) comment '��Ӧ�̵�ַ',
   spl_contact          varchar(16) comment '��ϵ��ʽ',
   spl_legal_person     varchar(32) comment '���˴���',
   spl_permit_id        char(16) comment '���֤���',
   spl_certification    char(16) comment '������֤���',
   spl_business_license_id char(20) comment 'Ӫҵִ�ձ��',
   primary key (spl_id)
);

alter table his_suppliers comment '��Ӧ�̱�';

alter table his_inventory add constraint FK_Relationship_26 foreign key (cat_id)
      references his_drug_catalogue (cat_id) on delete restrict on update restrict;

alter table his_orders_schedules add constraint FK_Relationship_11 foreign key (pur_id)
      references his_purchaseOrders (pur_id) on delete restrict on update restrict;

alter table his_orders_schedules add constraint FK_Relationship_19 foreign key (cat_id)
      references his_drug_catalogue (cat_id) on delete restrict on update restrict;

alter table his_prescriptions add constraint FK_Relationship_18 foreign key (reg_id)
      references his_registers (reg_id) on delete restrict on update restrict;

alter table his_prescriptions_schedules add constraint FK_Relationship_21 foreign key (cat_id)
      references his_drug_catalogue (cat_id) on delete restrict on update restrict;

alter table his_prescriptions_schedules add constraint FK_Relationship_3 foreign key (prsc_id)
      references his_prescriptions (prsc_id) on delete restrict on update restrict;

alter table his_procurement_plans add constraint FK_Relationship_28 foreign key (pur_id)
      references his_purchaseOrders (pur_id) on delete restrict on update restrict;

alter table his_procurement_schedules add constraint FK_Relationship_24 foreign key (prcp_id)
      references his_procurement_plans (prcp_id) on delete restrict on update restrict;

alter table his_procurement_schedules add constraint FK_Relationship_25 foreign key (cat_id)
      references his_drug_catalogue (cat_id) on delete restrict on update restrict;

alter table his_purchaseOrders add constraint FK_Relationship_13 foreign key (spl_id)
      references his_suppliers (spl_id) on delete restrict on update restrict;

alter table his_registers add constraint FK_Relationship_20 foreign key (patient_id)
      references his_patients (patient_id) on delete restrict on update restrict;

