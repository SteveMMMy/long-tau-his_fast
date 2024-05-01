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
   doc_reg_id           bigint not null auto_increment comment '接诊记录编号',
   user_id              bigint not null comment '用户ID',
   doc_reg_time         date not null comment '时间',
   doc_reg_mor_num      int comment '上午时段号数',
   doc_reg_aft_num      int comment '下午时段号数',
   doc_reg_eve_num      int comment '晚上时段号数',
   doc_reg_mor_sum      int comment '上午完成号数',
   doc_reg_aft_sum      int comment '下午完成号数',
   doc_reg_eve_sum      int comment '晚上完成号数',
   primary key (doc_reg_id)
);

alter table his_doctor_regInfo comment '医生接诊记录表';

/*==============================================================*/
/* Table: his_drug_catalogue                                    */
/*==============================================================*/
create table his_drug_catalogue
(
   cat_id               bigint not null auto_increment comment '药品ID',
   cat_approval_number  varchar(64) comment '批准文号',
   cat_drug_num         char(14) comment '药品编号',
   cat_name             varchar(128) comment '通用名或商品名',
   cat_English_name     varchar(128) comment '英文名称',
   cat_producer         varchar(128) comment '生产单位',
   cat_specs            varchar(128) comment '规格',
   cat_dosage_form      smallint comment '剂型',
   cat_package          varchar(256) comment '包装',
   cat_unit             smallint comment '单位',
   cat_unit_price       int comment '销售单价',
   primary key (cat_id)
);

alter table his_drug_catalogue comment '药品目录表';

/*==============================================================*/
/* Table: his_inventory                                         */
/*==============================================================*/
create table his_inventory
(
   inv_id               bigint not null auto_increment comment '库存编号',
   cat_id               bigint not null comment '药品ID',
   inv_batch_number     varchar(32) not null comment '生产批号',
   inv_number           bigint comment '库存数量',
   inv_unit_price       int comment '销售单价',
   inv_prod_date        datetime comment '生产日期',
   inv_valid_to         datetime comment '有效期至',
   primary key (inv_id)
);

alter table his_inventory comment '库存信息表';

/*==============================================================*/
/* Table: his_orders_schedules                                  */
/*==============================================================*/
create table his_orders_schedules
(
   order_sch_id         bigint not null auto_increment comment '明细号',
   pur_id               bigint not null comment '采购单ID',
   cat_id               bigint not null comment '药品ID',
   order_sch_number     bigint not null comment '采购数量',
   primary key (order_sch_id)
);

alter table his_orders_schedules comment '采购订单明细表';

/*==============================================================*/
/* Table: his_patients                                          */
/*==============================================================*/
create table his_patients
(
   patient_id           bigint not null auto_increment comment '患者编号',
   user_id              bigint comment '用户ID',
   patient_name         varchar(16) not null comment '姓名',
   patient_sex          smallint comment '性别',
   patient_birth_date   date comment '出生日期',
   patient_age          smallint comment '年龄',
   patient_id_card_num  varchar(20) comment '身份证号',
   patient_med_card_num varchar(20) comment '医保卡号',
   patient_phone_num    varchar(16) comment '手机号',
   primary key (patient_id)
);

alter table his_patients comment '患者信息表';

/*==============================================================*/
/* Table: his_prescriptions                                     */
/*==============================================================*/
create table his_prescriptions
(
   prsc_id              bigint not null auto_increment comment '处方ID',
   reg_id               bigint not null comment '记录编号',
   prsc_doc_num         char(20) comment '处方单据号',
   prsc_type            smallint comment '处方类型',
   prsc_cost            int comment '费用总计',
   prsc_status          smallint comment '处方状态',
   prsc_comments        text comment '备注',
   primary key (prsc_id)
);

alter table his_prescriptions comment '处方表';

/*==============================================================*/
/* Table: his_prescriptions_schedules                           */
/*==============================================================*/
create table his_prescriptions_schedules
(
   prsc_sch_id          bigint not null auto_increment comment '明细号',
   prsc_id              bigint not null comment '处方ID',
   cat_id               bigint comment '药品ID',
   prsc_sch_quantity    bigint not null comment '数量',
   prsc_sch_usage       smallint comment '用法',
   prsc_sch_freq        smallint comment '频次',
   prsc_sch_is_self_prepared bool not null comment '是否自备',
   primary key (prsc_sch_id)
);

alter table his_prescriptions_schedules comment '处方明细表';

/*==============================================================*/
/* Table: his_procurement_plans                                 */
/*==============================================================*/
create table his_procurement_plans
(
   prcp_id              bigint not null auto_increment comment '采购计划表ID',
   user_id              bigint not null comment '用户ID',
   pur_id               bigint comment '采购单ID',
   prcp_doc_num         char(20) comment '采购计划单据号',
   prcp_date            date not null comment '制单日期',
   primary key (prcp_id)
);

alter table his_procurement_plans comment '采购计划单表';

/*==============================================================*/
/* Table: his_procurement_schedules                             */
/*==============================================================*/
create table his_procurement_schedules
(
   psch_id              bigint not null auto_increment comment '明细号',
   prcp_id              bigint not null comment '采购计划表ID',
   cat_id               bigint not null comment '药品ID',
   psch_price           bigint not null comment '参考单价',
   psch_number          bigint not null comment '采购数量',
   psch_pur_date        date comment '预计采购日期',
   psch_arv_date        date comment '最迟到货日期',
   primary key (psch_id)
);

alter table his_procurement_schedules comment '采购计划明细表';

/*==============================================================*/
/* Table: his_purchaseOrders                                    */
/*==============================================================*/
create table his_purchaseOrders
(
   pur_id               bigint not null auto_increment comment '采购单ID',
   spl_id               bigint not null comment '供应商编号',
   user_id              bigint not null comment '用户ID',
   pur_doc_num          char(20) comment '采购单据号',
   pur_date             date not null comment '订单日期',
   pur_arr_date         date comment '计划到货日期',
   pur_pay_date         date comment '预计付款日期',
   primary key (pur_id)
);

alter table his_purchaseOrders comment '采购订单表';

/*==============================================================*/
/* Table: his_registers                                         */
/*==============================================================*/
create table his_registers
(
   reg_id               bigint not null auto_increment comment '记录编号',
   user_id              bigint not null comment '医生ID',
   patient_id           bigint not null comment '患者编号',
   reg_time             datetime not null comment '挂号日期',
   reg_period           smallint not null comment '挂号时段',
   reg_status           smallint not null comment '挂号状态',
   primary key (reg_id)
);

alter table his_registers comment '挂号记录表';

/*==============================================================*/
/* Table: his_suppliers                                         */
/*==============================================================*/
create table his_suppliers
(
   spl_id               bigint not null auto_increment comment '供应商编号',
   spl_name             varchar(32) not null comment '供应商名称',
   spl_addr             varchar(512) comment '供应商地址',
   spl_contact          varchar(16) comment '联系方式',
   spl_legal_person     varchar(32) comment '法人代表',
   spl_permit_id        char(16) comment '许可证编号',
   spl_certification    char(16) comment '质量认证情况',
   spl_business_license_id char(20) comment '营业执照编号',
   primary key (spl_id)
);

alter table his_suppliers comment '供应商表';

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

