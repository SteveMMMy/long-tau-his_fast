/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2024/4/12 11:19:12                           */
/*==============================================================*/


drop table if exists his_batch_numbers;

drop table if exists his_departements;

drop table if exists his_doctor_regInfo;

drop table if exists his_drug_catalogue;

drop table if exists his_inventory;

drop table if exists his_orders_schedules;

drop table if exists his_patients;

drop table if exists his_posts;

drop table if exists his_prescriptions;

drop table if exists his_prescriptions_schedules;

drop table if exists his_procurement_plans;

drop table if exists his_procurement_schedules;

drop table if exists his_producers;

drop table if exists his_purchaseOrders;

drop table if exists his_registers;

drop table if exists his_suppliers;

drop table if exists his_sysroles;

drop table if exists his_workers;

/*==============================================================*/
/* Table: his_batch_numbers                                     */
/*==============================================================*/
create table his_batch_numbers
(
   batch_number         char(16) not null comment '��������',
   pdc_number           int not null comment '�����̱��',
   primary key (batch_number)
);

alter table his_batch_numbers comment '�������ű�';

/*==============================================================*/
/* Table: his_departements                                      */
/*==============================================================*/
create table his_departements
(
   dept_id              int not null auto_increment comment '���ű��',
   dept_parent_id       varchar(16) not null comment '�ϼ����ű��',
   dept_ancestors       varchar(32) not null comment '�����ϼ�����',
   dept_name            varchar(32) not null comment '��������',
   dept_order           int not null comment '˳���',
   primary key (dept_id)
);

alter table his_departements comment '���ű�';

/*==============================================================*/
/* Table: his_doctor_regInfo                                    */
/*==============================================================*/
create table his_doctor_regInfo
(
   doc_reg_id           int not null auto_increment comment '�����¼���',
   worker_id            int not null comment '��Ա���',
   doc_reg_time         date not null comment 'ʱ��',
   doc_reg_morNum       int not null comment '����ʱ�κ���',
   doc_reg_aftNum       int not null comment '����ʱ�κ���',
   doc_reg_eveNum       int not null comment '����ʱ�κ���',
   doc_reg_morSum       int not null comment '������ɺ���',
   doc_reg_aftSum       int not null comment '������ɺ���',
   doc_reg_eveSum       int not null comment '������ɺ���',
   primary key (doc_reg_id)
);

alter table his_doctor_regInfo comment 'ҽ�������¼��';

/*==============================================================*/
/* Table: his_drug_catalogue                                    */
/*==============================================================*/
create table his_drug_catalogue
(
   cat_id               int not null auto_increment comment 'ҩƷ���',
   cat_name             varchar(128) not null comment 'ͨ��������Ʒ��',
   cat_specs            varchar(64) not null comment '���',
   cat_dosage_form      smallint not null comment '����',
   cat_unit             smallint not null comment '��λ',
   cat_unit_price       int not null comment '���۵���',
   primary key (cat_id)
);

alter table his_drug_catalogue comment 'ҩƷĿ¼��';

/*==============================================================*/
/* Table: his_inventory                                         */
/*==============================================================*/
create table his_inventory
(
   inv_id               int not null auto_increment comment '�����',
   batch_number         char(16) not null comment '��������',
   cat_id               int not null comment 'ҩƷ���',
   inv_number           bigint not null comment '�������',
   inv_unit_price       int not null comment '���۵���',
   inv_prod_date        datetime not null comment '��������',
   inv_valid_to         datetime not null comment '��Ч����',
   primary key (inv_id)
);

alter table his_inventory comment '�����Ϣ��';

/*==============================================================*/
/* Table: his_orders_schedules                                  */
/*==============================================================*/
create table his_orders_schedules
(
   order_sch_id         int not null auto_increment comment '��ϸ��',
   pur_id               int not null comment '�ɹ�����',
   batch_number         char(16) not null comment '��������',
   cat_id               int not null comment 'ҩƷ���',
   order_sch_number     bigint not null comment '�ɹ�����',
   primary key (order_sch_id)
);

alter table his_orders_schedules comment '�ɹ�������ϸ��';

/*==============================================================*/
/* Table: his_patients                                          */
/*==============================================================*/
create table his_patients
(
   patient_number       int not null auto_increment comment '���߱��',
   patient_name         varchar(16) not null comment '����',
   patient_sex          smallint not null comment '�Ա�',
   patient_birthDate    date not null comment '��������',
   patient_age          smallint not null comment '����',
   patient_id           varchar(20) not null comment '���֤��',
   patient_medCardNum   varchar(20) comment 'ҽ������',
   patient_phoneNum     varchar(16) not null comment '�ֻ���',
   primary key (patient_number)
);

alter table his_patients comment '������Ϣ��';

/*==============================================================*/
/* Table: his_posts                                             */
/*==============================================================*/
create table his_posts
(
   post_id              int not null auto_increment comment '��λ���',
   post_name            varchar(32) not null comment '��λ����',
   primary key (post_id)
);

alter table his_posts comment '��λ��';

/*==============================================================*/
/* Table: his_prescriptions                                     */
/*==============================================================*/
create table his_prescriptions
(
   prsc_id              int not null auto_increment comment '������',
   worker_id            int not null comment '��Ա���',
   reg_id               int not null comment '��¼���',
   prsc_type            smallint not null comment '��������',
   prsc_cost            int not null comment '�����ܼ�',
   prsc_status          smallint not null comment '����״̬',
   prsc_comments        text comment '��ע',
   primary key (prsc_id)
);

alter table his_prescriptions comment '������';

/*==============================================================*/
/* Table: his_prescriptions_schedules                           */
/*==============================================================*/
create table his_prescriptions_schedules
(
   prsc_sch_id          int not null auto_increment comment '��ϸ��',
   prsc_id              int not null comment '������',
   cat_id               int comment 'ҩƷ���',
   prsc_sch_quantity    bigint not null comment '����',
   prsc_sch_usage       smallint comment '�÷�',
   prsc_sch_freq        smallint comment 'Ƶ��',
   prsc_sch_isSelfPrepared bool not null comment '�Ƿ��Ա�',
   primary key (prsc_sch_id)
);

alter table his_prescriptions_schedules comment '������ϸ��';

/*==============================================================*/
/* Table: his_procurement_plans                                 */
/*==============================================================*/
create table his_procurement_plans
(
   prcp_id              int not null auto_increment comment '����',
   worker_id            int not null comment '��Ա���',
   prcp_date            date not null comment '�Ƶ�����',
   primary key (prcp_id)
);

alter table his_procurement_plans comment '�ɹ��ƻ�����';

/*==============================================================*/
/* Table: his_procurement_schedules                             */
/*==============================================================*/
create table his_procurement_schedules
(
   psch_id              int not null auto_increment comment '��ϸ��',
   prcp_id              int not null comment '����',
   cat_id               int not null comment 'ҩƷ���',
   psch_price           bigint not null comment '�ο�����',
   psch_number          bigint not null comment '�ɹ�����',
   psch_pur_date        date comment 'Ԥ�Ʋɹ�����',
   psch_arv_date        date comment '��ٵ�������',
   primary key (psch_id)
);

alter table his_procurement_schedules comment '�ɹ��ƻ���ϸ��';

/*==============================================================*/
/* Table: his_producers                                         */
/*==============================================================*/
create table his_producers
(
   pdc_number           int not null auto_increment comment '�����̱��',
   pdc_name             varchar(32) not null comment '����������',
   primary key (pdc_number)
);

alter table his_producers comment '�����̱�';

/*==============================================================*/
/* Table: his_purchaseOrders                                    */
/*==============================================================*/
create table his_purchaseOrders
(
   pur_id               int not null auto_increment comment '�ɹ�����',
   spl_number           int not null comment '��Ӧ�̱��',
   worker_id            int not null comment '��Ա���',
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
   reg_id               int not null auto_increment comment '��¼���',
   patient_number       int not null comment '���߱��',
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
   spl_number           int not null auto_increment comment '��Ӧ�̱��',
   spl_name             varchar(32) not null comment '��Ӧ������',
   spl_addr             varchar(512) comment '��Ӧ�̵�ַ',
   spl_contact          varchar(16) not null comment '��ϵ��ʽ',
   spl_legal_person     varchar(32) not null comment '���˴���',
   spl_permit_id        char(16) not null comment '���֤���',
   spl_certification    char(16) not null comment '������֤���',
   spl_business_license_id char(20) not null comment 'Ӫҵִ�ձ��',
   primary key (spl_number)
);

alter table his_suppliers comment '��Ӧ�̱�';

/*==============================================================*/
/* Table: his_sysroles                                          */
/*==============================================================*/
create table his_sysroles
(
   role_id              int not null auto_increment comment '��ɫ���',
   role_name            varchar(32) not null comment '��ɫ��',
   primary key (role_id)
);

alter table his_sysroles comment 'ϵͳ��ɫ��';

/*==============================================================*/
/* Table: his_workers                                           */
/*==============================================================*/
create table his_workers
(
   worker_id            int not null auto_increment comment '��Ա���',
   role_id              int not null comment '��ɫ���',
   post_id              int not null comment '��λ���',
   dept_id              int not null comment '���ű��',
   doc_reg_id           int comment '�����¼���',
   worker_name          varchar(32) not null comment '����',
   woker_sex            smallint not null comment '�Ա�',
   primary key (worker_id)
);

alter table his_workers comment '������Ա��Ϣ��';

alter table his_batch_numbers add constraint FK_Relationship_15 foreign key (pdc_number)
      references his_producers (pdc_number) on delete restrict on update restrict;

alter table his_doctor_regInfo add constraint FK_Relationship_27 foreign key (worker_id)
      references his_workers (worker_id) on delete restrict on update restrict;

alter table his_inventory add constraint FK_Relationship_16 foreign key (batch_number)
      references his_batch_numbers (batch_number) on delete restrict on update restrict;

alter table his_inventory add constraint FK_Relationship_26 foreign key (cat_id)
      references his_drug_catalogue (cat_id) on delete restrict on update restrict;

alter table his_orders_schedules add constraint FK_Relationship_11 foreign key (pur_id)
      references his_purchaseOrders (pur_id) on delete restrict on update restrict;

alter table his_orders_schedules add constraint FK_Relationship_17 foreign key (batch_number)
      references his_batch_numbers (batch_number) on delete restrict on update restrict;

alter table his_orders_schedules add constraint FK_Relationship_19 foreign key (cat_id)
      references his_drug_catalogue (cat_id) on delete restrict on update restrict;

alter table his_prescriptions add constraint FK_Relationship_18 foreign key (reg_id)
      references his_registers (reg_id) on delete restrict on update restrict;

alter table his_prescriptions add constraint FK_Relationship_8 foreign key (worker_id)
      references his_workers (worker_id) on delete restrict on update restrict;

alter table his_prescriptions_schedules add constraint FK_Relationship_21 foreign key (cat_id)
      references his_drug_catalogue (cat_id) on delete restrict on update restrict;

alter table his_prescriptions_schedules add constraint FK_Relationship_3 foreign key (prsc_id)
      references his_prescriptions (prsc_id) on delete restrict on update restrict;

alter table his_procurement_plans add constraint FK_Relationship_23 foreign key (worker_id)
      references his_workers (worker_id) on delete restrict on update restrict;

alter table his_procurement_schedules add constraint FK_Relationship_24 foreign key (prcp_id)
      references his_procurement_plans (prcp_id) on delete restrict on update restrict;

alter table his_procurement_schedules add constraint FK_Relationship_25 foreign key (cat_id)
      references his_drug_catalogue (cat_id) on delete restrict on update restrict;

alter table his_purchaseOrders add constraint FK_Relationship_13 foreign key (spl_number)
      references his_suppliers (spl_number) on delete restrict on update restrict;

alter table his_purchaseOrders add constraint FK_Relationship_22 foreign key (worker_id)
      references his_workers (worker_id) on delete restrict on update restrict;

alter table his_registers add constraint FK_Relationship_20 foreign key (patient_number)
      references his_patients (patient_number) on delete restrict on update restrict;

alter table his_workers add constraint FK_Relationship_28 foreign key (doc_reg_id)
      references his_doctor_regInfo (doc_reg_id) on delete restrict on update restrict;

alter table his_workers add constraint FK_Relationship_5 foreign key (role_id)
      references his_sysroles (role_id) on delete restrict on update restrict;

alter table his_workers add constraint FK_Relationship_6 foreign key (post_id)
      references his_posts (post_id) on delete restrict on update restrict;

alter table his_workers add constraint FK_Relationship_7 foreign key (dept_id)
      references his_departements (dept_id) on delete restrict on update restrict;

