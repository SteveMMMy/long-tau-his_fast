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
   batch_number         char(16) not null comment '生产批号',
   pdc_number           int not null comment '生产商编号',
   primary key (batch_number)
);

alter table his_batch_numbers comment '生产批号表';

/*==============================================================*/
/* Table: his_departements                                      */
/*==============================================================*/
create table his_departements
(
   dept_id              int not null auto_increment comment '部门编号',
   dept_parent_id       varchar(16) not null comment '上级部门编号',
   dept_ancestors       varchar(32) not null comment '所有上级部门',
   dept_name            varchar(32) not null comment '部门名称',
   dept_order           int not null comment '顺序号',
   primary key (dept_id)
);

alter table his_departements comment '部门表';

/*==============================================================*/
/* Table: his_doctor_regInfo                                    */
/*==============================================================*/
create table his_doctor_regInfo
(
   doc_reg_id           int not null auto_increment comment '接诊记录编号',
   worker_id            int not null comment '人员编号',
   doc_reg_time         date not null comment '时间',
   doc_reg_morNum       int not null comment '上午时段号数',
   doc_reg_aftNum       int not null comment '下午时段号数',
   doc_reg_eveNum       int not null comment '晚上时段号数',
   doc_reg_morSum       int not null comment '上午完成号数',
   doc_reg_aftSum       int not null comment '下午完成号数',
   doc_reg_eveSum       int not null comment '晚上完成号数',
   primary key (doc_reg_id)
);

alter table his_doctor_regInfo comment '医生接诊记录表';

/*==============================================================*/
/* Table: his_drug_catalogue                                    */
/*==============================================================*/
create table his_drug_catalogue
(
   cat_id               int not null auto_increment comment '药品编号',
   cat_name             varchar(128) not null comment '通用名或商品名',
   cat_specs            varchar(64) not null comment '规格',
   cat_dosage_form      smallint not null comment '剂型',
   cat_unit             smallint not null comment '单位',
   cat_unit_price       int not null comment '销售单价',
   primary key (cat_id)
);

alter table his_drug_catalogue comment '药品目录表';

/*==============================================================*/
/* Table: his_inventory                                         */
/*==============================================================*/
create table his_inventory
(
   inv_id               int not null auto_increment comment '库存编号',
   batch_number         char(16) not null comment '生产批号',
   cat_id               int not null comment '药品编号',
   inv_number           bigint not null comment '库存数量',
   inv_unit_price       int not null comment '销售单价',
   inv_prod_date        datetime not null comment '生产日期',
   inv_valid_to         datetime not null comment '有效期至',
   primary key (inv_id)
);

alter table his_inventory comment '库存信息表';

/*==============================================================*/
/* Table: his_orders_schedules                                  */
/*==============================================================*/
create table his_orders_schedules
(
   order_sch_id         int not null auto_increment comment '明细号',
   pur_id               int not null comment '采购单号',
   batch_number         char(16) not null comment '生产批号',
   cat_id               int not null comment '药品编号',
   order_sch_number     bigint not null comment '采购数量',
   primary key (order_sch_id)
);

alter table his_orders_schedules comment '采购订单明细表';

/*==============================================================*/
/* Table: his_patients                                          */
/*==============================================================*/
create table his_patients
(
   patient_number       int not null auto_increment comment '患者编号',
   patient_name         varchar(16) not null comment '姓名',
   patient_sex          smallint not null comment '性别',
   patient_birthDate    date not null comment '出生日期',
   patient_age          smallint not null comment '年龄',
   patient_id           varchar(20) not null comment '身份证号',
   patient_medCardNum   varchar(20) comment '医保卡号',
   patient_phoneNum     varchar(16) not null comment '手机号',
   primary key (patient_number)
);

alter table his_patients comment '患者信息表';

/*==============================================================*/
/* Table: his_posts                                             */
/*==============================================================*/
create table his_posts
(
   post_id              int not null auto_increment comment '岗位编号',
   post_name            varchar(32) not null comment '岗位名称',
   primary key (post_id)
);

alter table his_posts comment '岗位表';

/*==============================================================*/
/* Table: his_prescriptions                                     */
/*==============================================================*/
create table his_prescriptions
(
   prsc_id              int not null auto_increment comment '处方号',
   worker_id            int not null comment '人员编号',
   reg_id               int not null comment '记录编号',
   prsc_type            smallint not null comment '处方类型',
   prsc_cost            int not null comment '费用总计',
   prsc_status          smallint not null comment '处方状态',
   prsc_comments        text comment '备注',
   primary key (prsc_id)
);

alter table his_prescriptions comment '处方表';

/*==============================================================*/
/* Table: his_prescriptions_schedules                           */
/*==============================================================*/
create table his_prescriptions_schedules
(
   prsc_sch_id          int not null auto_increment comment '明细号',
   prsc_id              int not null comment '处方号',
   cat_id               int comment '药品编号',
   prsc_sch_quantity    bigint not null comment '数量',
   prsc_sch_usage       smallint comment '用法',
   prsc_sch_freq        smallint comment '频次',
   prsc_sch_isSelfPrepared bool not null comment '是否自备',
   primary key (prsc_sch_id)
);

alter table his_prescriptions_schedules comment '处方明细表';

/*==============================================================*/
/* Table: his_procurement_plans                                 */
/*==============================================================*/
create table his_procurement_plans
(
   prcp_id              int not null auto_increment comment '单号',
   worker_id            int not null comment '人员编号',
   prcp_date            date not null comment '制单日期',
   primary key (prcp_id)
);

alter table his_procurement_plans comment '采购计划单表';

/*==============================================================*/
/* Table: his_procurement_schedules                             */
/*==============================================================*/
create table his_procurement_schedules
(
   psch_id              int not null auto_increment comment '明细号',
   prcp_id              int not null comment '单号',
   cat_id               int not null comment '药品编号',
   psch_price           bigint not null comment '参考单价',
   psch_number          bigint not null comment '采购数量',
   psch_pur_date        date comment '预计采购日期',
   psch_arv_date        date comment '最迟到货日期',
   primary key (psch_id)
);

alter table his_procurement_schedules comment '采购计划明细表';

/*==============================================================*/
/* Table: his_producers                                         */
/*==============================================================*/
create table his_producers
(
   pdc_number           int not null auto_increment comment '生产商编号',
   pdc_name             varchar(32) not null comment '生产商名称',
   primary key (pdc_number)
);

alter table his_producers comment '生产商表';

/*==============================================================*/
/* Table: his_purchaseOrders                                    */
/*==============================================================*/
create table his_purchaseOrders
(
   pur_id               int not null auto_increment comment '采购单号',
   spl_number           int not null comment '供应商编号',
   worker_id            int not null comment '人员编号',
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
   reg_id               int not null auto_increment comment '记录编号',
   patient_number       int not null comment '患者编号',
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
   spl_number           int not null auto_increment comment '供应商编号',
   spl_name             varchar(32) not null comment '供应商名称',
   spl_addr             varchar(512) comment '供应商地址',
   spl_contact          varchar(16) not null comment '联系方式',
   spl_legal_person     varchar(32) not null comment '法人代表',
   spl_permit_id        char(16) not null comment '许可证编号',
   spl_certification    char(16) not null comment '质量认证情况',
   spl_business_license_id char(20) not null comment '营业执照编号',
   primary key (spl_number)
);

alter table his_suppliers comment '供应商表';

/*==============================================================*/
/* Table: his_sysroles                                          */
/*==============================================================*/
create table his_sysroles
(
   role_id              int not null auto_increment comment '角色编号',
   role_name            varchar(32) not null comment '角色名',
   primary key (role_id)
);

alter table his_sysroles comment '系统角色表';

/*==============================================================*/
/* Table: his_workers                                           */
/*==============================================================*/
create table his_workers
(
   worker_id            int not null auto_increment comment '人员编号',
   role_id              int not null comment '角色编号',
   post_id              int not null comment '岗位编号',
   dept_id              int not null comment '部门编号',
   doc_reg_id           int comment '接诊记录编号',
   worker_name          varchar(32) not null comment '姓名',
   woker_sex            smallint not null comment '性别',
   primary key (worker_id)
);

alter table his_workers comment '工作人员信息表';

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

