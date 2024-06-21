<p align="center">
	<img alt="logo" src="src/main/resources/static/favicon.ico">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">LongTau</h1>
<h4 align="center">基于若依开发的社区卫生服务中心信息系统</h4>

## 源程序清单

```
LongTau_HIS_fast
|   .gitignore
|   LICENSE
|   pom.xml
|   README.md
|   ry.bat
|   ry.sh
|   
+---.github
|       FUNDING.yml
|       
+---bin
|       clean.bat
|       package.bat
|       run-tomcat.bat
|       
+---sql
|   |   his_sql.sql
|   |   quartz.sql
|   |   ruoyi.html
|   |   ruoyi.pdm
|   |   ry_20240112.sql
|   |   
|   \---bak
|           longtauhis_0603.bak.sql
|           
\---src
    \---main
        +---java（Java代码）
        |   \---com
        |       \---ruoyi
        |           |   RuoYiApplication.java
        |           |   RuoYiServletInitializer.java
        |           |   
        |           +---common
        |           |   +---constant
        |           |   |       CommonMap.java
        |           |   |       Constants.java
        |           |   |       GenConstants.java
        |           |   |       PermissionConstants.java
        |           |   |       ScheduleConstants.java
        |           |   |       ShiroConstants.java
        |           |   |       UserConstants.java
        |           |   |       
        |           |   +---exception
        |           |   |   |   DemoModeException.java
        |           |   |   |   GlobalException.java
        |           |   |   |   ServiceException.java
        |           |   |   |   UtilException.java
        |           |   |   |   
        |           |   |   +---base
        |           |   |   |       BaseException.java
        |           |   |   |       
        |           |   |   +---file
        |           |   |   |       FileException.java
        |           |   |   |       FileNameLengthLimitExceededException.java
        |           |   |   |       FileSizeLimitExceededException.java
        |           |   |   |       FileUploadException.java
        |           |   |   |       InvalidExtensionException.java
        |           |   |   |       
        |           |   |   +---job
        |           |   |   |       TaskException.java
        |           |   |   |       
        |           |   |   \---user
        |           |   |           BlackListException.java
        |           |   |           CaptchaException.java
        |           |   |           RoleBlockedException.java
        |           |   |           UserBlockedException.java
        |           |   |           UserDeleteException.java
        |           |   |           UserException.java
        |           |   |           UserNotExistsException.java
        |           |   |           UserPasswordNotMatchException.java
        |           |   |           UserPasswordRetryLimitCountException.java
        |           |   |           UserPasswordRetryLimitExceedException.java
        |           |   |           
        |           |   +---utils
        |           |   |   |   AddressUtils.java
        |           |   |   |   Arith.java
        |           |   |   |   CacheUtils.java
        |           |   |   |   CookieUtils.java
        |           |   |   |   DateUtils.java
        |           |   |   |   DesensitizedUtil.java
        |           |   |   |   ExceptionUtil.java
        |           |   |   |   IpUtils.java
        |           |   |   |   LogUtils.java
        |           |   |   |   MapDataUtil.java
        |           |   |   |   Md5Utils.java
        |           |   |   |   MessageUtils.java
        |           |   |   |   PageUtils.java
        |           |   |   |   ServletUtils.java
        |           |   |   |   StringUtils.java
        |           |   |   |   Threads.java
        |           |   |   |   TreeUtils.java
        |           |   |   |   
        |           |   |   +---bean
        |           |   |   |       BeanUtils.java
        |           |   |   |       BeanValidators.java
        |           |   |   |       
        |           |   |   +---file
        |           |   |   |       FileTypeUtils.java
        |           |   |   |       FileUploadUtils.java
        |           |   |   |       FileUtils.java
        |           |   |   |       ImageUtils.java
        |           |   |   |       MimeTypeUtils.java
        |           |   |   |       
        |           |   |   +---html
        |           |   |   |       EscapeUtil.java
        |           |   |   |       HTMLFilter.java
        |           |   |   |       
        |           |   |   +---http
        |           |   |   |       HttpUtils.java
        |           |   |   |       
        |           |   |   +---poi
        |           |   |   |       ExcelHandlerAdapter.java
        |           |   |   |       ExcelUtil.java
        |           |   |   |       
        |           |   |   +---reflect
        |           |   |   |       ReflectUtils.java
        |           |   |   |       
        |           |   |   +---security
        |           |   |   |       AuthorizationUtils.java
        |           |   |   |       CipherUtils.java
        |           |   |   |       PermissionUtils.java
        |           |   |   |       ShiroUtils.java
        |           |   |   |       
        |           |   |   +---spring
        |           |   |   |       SpringUtils.java
        |           |   |   |       
        |           |   |   +---sql
        |           |   |   |       SqlUtil.java
        |           |   |   |       
        |           |   |   +---text
        |           |   |   |       CharsetKit.java
        |           |   |   |       Convert.java
        |           |   |   |       StrFormatter.java
        |           |   |   |       
        |           |   |   \---uuid
        |           |   |           IdUtils.java
        |           |   |           Seq.java
        |           |   |           UUID.java
        |           |   |           
        |           |   \---xss
        |           |           Xss.java
        |           |           XssFilter.java
        |           |           XssHttpServletRequestWrapper.java
        |           |           XssValidator.java
        |           |           
        |           +---framework
        |           |   +---aspectj
        |           |   |   |   DataScopeAspect.java
        |           |   |   |   DataSourceAspect.java
        |           |   |   |   LogAspect.java
        |           |   |   |   PermissionsAspect.java
        |           |   |   |   
        |           |   |   \---lang
        |           |   |       +---annotation
        |           |   |       |       DataScope.java
        |           |   |       |       DataSource.java
        |           |   |       |       Excel.java
        |           |   |       |       Excels.java
        |           |   |       |       Log.java
        |           |   |       |       Sensitive.java
        |           |   |       |       
        |           |   |       \---enums
        |           |   |               BusinessStatus.java
        |           |   |               BusinessType.java
        |           |   |               DataSourceType.java
        |           |   |               DesensitizedType.java
        |           |   |               OperatorType.java
        |           |   |               
        |           |   +---config
        |           |   |   |   ApplicationConfig.java
        |           |   |   |   CaptchaConfig.java
        |           |   |   |   DruidConfig.java
        |           |   |   |   FilterConfig.java
        |           |   |   |   GenConfig.java
        |           |   |   |   I18nConfig.java
        |           |   |   |   KaptchaTextCreator.java
        |           |   |   |   MyBatisConfig.java
        |           |   |   |   ResourcesConfig.java
        |           |   |   |   RuoYiConfig.java
        |           |   |   |   ScheduleConfig.java
        |           |   |   |   SensitiveJsonSerializer.java
        |           |   |   |   ServerConfig.java
        |           |   |   |   ShiroConfig.java
        |           |   |   |   SwaggerConfig.java
        |           |   |   |   ThreadPoolConfig.java
        |           |   |   |   
        |           |   |   \---properties
        |           |   |           DruidProperties.java
        |           |   |           
        |           |   +---context
        |           |   |       PermissionContextHolder.java
        |           |   |       
        |           |   +---datasource
        |           |   |       DynamicDataSource.java
        |           |   |       DynamicDataSourceContextHolder.java
        |           |   |       
        |           |   +---interceptor
        |           |   |   |   RepeatSubmitInterceptor.java
        |           |   |   |   
        |           |   |   +---annotation
        |           |   |   |       RepeatSubmit.java
        |           |   |   |       
        |           |   |   \---impl
        |           |   |           SameUrlDataInterceptor.java
        |           |   |           
        |           |   +---manager
        |           |   |   |   AsyncManager.java
        |           |   |   |   ShutdownManager.java
        |           |   |   |   
        |           |   |   \---factory
        |           |   |           AsyncFactory.java
        |           |   |           
        |           |   +---shiro
        |           |   |   +---realm
        |           |   |   |       UserRealm.java
        |           |   |   |       
        |           |   |   +---service
        |           |   |   |       LoginService.java
        |           |   |   |       PasswordService.java
        |           |   |   |       RegisterService.java
        |           |   |   |       
        |           |   |   +---session
        |           |   |   |       OnlineSessionDAO.java
        |           |   |   |       OnlineSessionFactory.java
        |           |   |   |       
        |           |   |   \---web
        |           |   |       |   CustomShiroFilterFactoryBean.java
        |           |   |       |   
        |           |   |       +---filter
        |           |   |       |   |   LogoutFilter.java
        |           |   |       |   |   
        |           |   |       |   +---captcha
        |           |   |       |   |       CaptchaValidateFilter.java
        |           |   |       |   |       
        |           |   |       |   +---kickout
        |           |   |       |   |       KickoutSessionFilter.java
        |           |   |       |   |       
        |           |   |       |   +---online
        |           |   |       |   |       OnlineSessionFilter.java
        |           |   |       |   |       
        |           |   |       |   \---sync
        |           |   |       |           SyncOnlineSessionFilter.java
        |           |   |       |           
        |           |   |       \---session
        |           |   |               OnlineWebSessionManager.java
        |           |   |               SpringSessionValidationScheduler.java
        |           |   |               
        |           |   +---task
        |           |   |       RyTask.java
        |           |   |       
        |           |   \---web
        |           |       +---controller
        |           |       |       BaseController.java
        |           |       |       
        |           |       +---domain
        |           |       |       AjaxResult.java
        |           |       |       BaseEntity.java
        |           |       |       CxSelect.java
        |           |       |       R.java
        |           |       |       TreeEntity.java
        |           |       |       Ztree.java
        |           |       |       
        |           |       +---exception
        |           |       |       GlobalExceptionHandler.java
        |           |       |       
        |           |       +---page
        |           |       |       PageDomain.java
        |           |       |       TableDataInfo.java
        |           |       |       TableSupport.java
        |           |       |       
        |           |       \---service
        |           |               CacheService.java
        |           |               ConfigService.java
        |           |               DictService.java
        |           |               PermissionService.java
        |           |               
        |           \---project
        |               +---common
        |               |       CommonController.java
        |               |       
        |               +---demo
        |               |   +---controller
        |               |   |       DemoDialogController.java
        |               |   |       DemoFormController.java
        |               |   |       DemoIconController.java
        |               |   |       DemoOperateController.java
        |               |   |       DemoReportController.java
        |               |   |       DemoTableController.java
        |               |   |       
        |               |   \---domain
        |               |           CustomerModel.java
        |               |           GoodsModel.java
        |               |           UserOperateModel.java
        |               |           
        |               +---his（LTHIS业务代码）
        |               |   +---catalogue
        |               |   |   +---controller
        |               |   |   |       HisDrugCatalogueController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisDrugCatalogue.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisDrugCatalogueMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisDrugCatalogueService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisDrugCatalogueServiceImpl.java
        |               |   |               
        |               |   +---diagnosis
        |               |   |   +---controller
        |               |   |   |       HisPatientsDiagController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisMedicalRecord.java
        |               |   |   |       HisPatientRecord.java
        |               |   |   |       HisPatientsDiag.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisPatientsDiagMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisPatientsDiagService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisPatientsDiagServiceImpl.java
        |               |   |               
        |               |   +---entry
        |               |   |   +---controller
        |               |   |   |       HisWarehousingEntryController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisEntrySchedules.java
        |               |   |   |       HisWarehousingEntry.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisWarehousingEntryMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisWarehousingEntryService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisWarehousingEntryServiceImpl.java
        |               |   |               
        |               |   +---inventory
        |               |   |   +---controller
        |               |   |   |       HisInventoryController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisInventory.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisInventoryMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisInventoryService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisInventoryServiceImpl.java
        |               |   |               
        |               |   +---plans
        |               |   |   +---controller
        |               |   |   |       HisProcurementPlansController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisProcurementPlans.java
        |               |   |   |       HisProcurementSchedules.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisProcurementPlansMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisProcurementPlansService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisProcurementPlansServiceImpl.java
        |               |   |               
        |               |   +---prescriptions
        |               |   |   +---controller
        |               |   |   |       HisPrescriptionsController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisPrescriptions.java
        |               |   |   |       HisPrescriptionsSchedules.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisPrescriptionsMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisPrescriptionsService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisPrescriptionsServiceImpl.java
        |               |   |               
        |               |   +---purchase
        |               |   |   +---controller
        |               |   |   |       HisPurchaseOrdersController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisOrdersSchedules.java
        |               |   |   |       HisPurchaseOrders.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisPurchaseOrdersMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisPurchaseOrdersService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisPurchaseOrdersServiceImpl.java
        |               |   |               
        |               |   +---registers
        |               |   |   +---controller
        |               |   |   |       HisRegistersController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisRegisters.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisRegistersMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisRegistersService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisRegistersServiceImpl.java
        |               |   |               
        |               |   +---registration
        |               |   |   +---controller
        |               |   |   |       HisPatientsController.java
        |               |   |   |       HisRegisController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       HisAppointment.java
        |               |   |   |       HisPatients.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       HisPatientsMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |       |   IHisPatientsService.java
        |               |   |       |   
        |               |   |       \---impl
        |               |   |               HisPatientsServiceImpl.java
        |               |   |               
        |               |   \---suppliers
        |               |       +---controller
        |               |       |       HisSuppliersController.java
        |               |       |       
        |               |       +---domain
        |               |       |       HisSuppliers.java
        |               |       |       
        |               |       +---mapper
        |               |       |       HisSuppliersMapper.java
        |               |       |       
        |               |       \---service
        |               |           |   IHisSuppliersService.java
        |               |           |   
        |               |           \---impl
        |               |                   HisSuppliersServiceImpl.java
        |               |                   
        |               +---monitor
        |               |   +---cache
        |               |   |       CacheController.java
        |               |   |       
        |               |   +---druid
        |               |   |       DruidController.java
        |               |   |       
        |               |   +---job
        |               |   |   +---controller
        |               |   |   |       JobController.java
        |               |   |   |       JobLogController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       Job.java
        |               |   |   |       JobLog.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       JobLogMapper.java
        |               |   |   |       JobMapper.java
        |               |   |   |       
        |               |   |   +---service
        |               |   |   |       IJobLogService.java
        |               |   |   |       IJobService.java
        |               |   |   |       JobLogServiceImpl.java
        |               |   |   |       JobServiceImpl.java
        |               |   |   |       
        |               |   |   \---util
        |               |   |           AbstractQuartzJob.java
        |               |   |           CronUtils.java
        |               |   |           JobInvokeUtil.java
        |               |   |           QuartzDisallowConcurrentExecution.java
        |               |   |           QuartzJobExecution.java
        |               |   |           ScheduleUtils.java
        |               |   |           
        |               |   +---logininfor
        |               |   |   +---controller
        |               |   |   |       LogininforController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       Logininfor.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       LogininforMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           ILogininforService.java
        |               |   |           LogininforServiceImpl.java
        |               |   |           
        |               |   +---online
        |               |   |   +---controller
        |               |   |   |       UserOnlineController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       OnlineSession.java
        |               |   |   |       UserOnline.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       UserOnlineMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           IUserOnlineService.java
        |               |   |           UserOnlineServiceImpl.java
        |               |   |           
        |               |   +---operlog
        |               |   |   +---controller
        |               |   |   |       OperlogController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       OperLog.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       OperLogMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           IOperLogService.java
        |               |   |           OperLogServiceImpl.java
        |               |   |           
        |               |   \---server
        |               |       +---controller
        |               |       |       ServerController.java
        |               |       |       
        |               |       \---domain
        |               |               Cpu.java
        |               |               Jvm.java
        |               |               Mem.java
        |               |               Server.java
        |               |               Sys.java
        |               |               SysFile.java
        |               |               
        |               +---system
        |               |   +---config
        |               |   |   +---controller
        |               |   |   |       ConfigController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       Config.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       ConfigMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           ConfigServiceImpl.java
        |               |   |           IConfigService.java
        |               |   |           
        |               |   +---dept
        |               |   |   +---controller
        |               |   |   |       DeptController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       Dept.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       DeptMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           DeptServiceImpl.java
        |               |   |           IDeptService.java
        |               |   |           
        |               |   +---dict
        |               |   |   +---controller
        |               |   |   |       DictDataController.java
        |               |   |   |       DictTypeController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       DictData.java
        |               |   |   |       DictType.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       DictDataMapper.java
        |               |   |   |       DictTypeMapper.java
        |               |   |   |       
        |               |   |   +---service
        |               |   |   |       DictDataServiceImpl.java
        |               |   |   |       DictTypeServiceImpl.java
        |               |   |   |       IDictDataService.java
        |               |   |   |       IDictTypeService.java
        |               |   |   |       
        |               |   |   \---utils
        |               |   |           DictUtils.java
        |               |   |           
        |               |   +---menu
        |               |   |   +---controller
        |               |   |   |       MenuController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       Menu.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       MenuMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           IMenuService.java
        |               |   |           MenuServiceImpl.java
        |               |   |           
        |               |   +---notice
        |               |   |   +---controller
        |               |   |   |       NoticeController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       Notice.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       NoticeMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           INoticeService.java
        |               |   |           NoticeServiceImpl.java
        |               |   |           
        |               |   +---post
        |               |   |   +---controller
        |               |   |   |       PostController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       Post.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       PostMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           IPostService.java
        |               |   |           PostServiceImpl.java
        |               |   |           
        |               |   +---role
        |               |   |   +---controller
        |               |   |   |       RoleController.java
        |               |   |   |       
        |               |   |   +---domain
        |               |   |   |       Role.java
        |               |   |   |       RoleDept.java
        |               |   |   |       RoleMenu.java
        |               |   |   |       
        |               |   |   +---mapper
        |               |   |   |       RoleDeptMapper.java
        |               |   |   |       RoleMapper.java
        |               |   |   |       RoleMenuMapper.java
        |               |   |   |       
        |               |   |   \---service
        |               |   |           IRoleService.java
        |               |   |           RoleServiceImpl.java
        |               |   |           
        |               |   \---user
        |               |       +---controller
        |               |       |       CaptchaController.java
        |               |       |       IndexController.java
        |               |       |       LoginController.java
        |               |       |       ProfileController.java
        |               |       |       RegisterController.java
        |               |       |       UserController.java
        |               |       |       
        |               |       +---domain
        |               |       |       User.java
        |               |       |       UserPost.java
        |               |       |       UserRole.java
        |               |       |       UserStatus.java
        |               |       |       
        |               |       +---mapper
        |               |       |       UserMapper.java
        |               |       |       UserPostMapper.java
        |               |       |       UserRoleMapper.java
        |               |       |       
        |               |       \---service
        |               |               IUserService.java
        |               |               UserServiceImpl.java
        |               |               
        |               +---test
        |               |   \---registration
        |               |       +---controller
        |               |       |       HisPatientsController.java
        |               |       |       HisRegisController.java
        |               |       |       
        |               |       +---domain
        |               |       |       HisAppointment.java
        |               |       |       HisPatients.java
        |               |       |       HisRegisters.java
        |               |       |       
        |               |       +---mapper
        |               |       |       HisPatientsMapper.java
        |               |       |       
        |               |       \---service
        |               |           |   IHisPatientsService.java
        |               |           |   
        |               |           \---impl
        |               |                   HisPatientsServiceImpl.java
        |               |                   
        |               \---tool
        |                   +---build
        |                   |       BuildController.java
        |                   |       
        |                   +---gen
        |                   |   +---controller
        |                   |   |       GenController.java
        |                   |   |       
        |                   |   +---domain
        |                   |   |       GenTable.java
        |                   |   |       GenTableColumn.java
        |                   |   |       
        |                   |   +---mapper
        |                   |   |       GenTableColumnMapper.java
        |                   |   |       GenTableMapper.java
        |                   |   |       
        |                   |   +---service
        |                   |   |       GenTableColumnServiceImpl.java
        |                   |   |       GenTableServiceImpl.java
        |                   |   |       IGenTableColumnService.java
        |                   |   |       IGenTableService.java
        |                   |   |       
        |                   |   \---util
        |                   |           GenUtils.java
        |                   |           VelocityInitializer.java
        |                   |           VelocityUtils.java
        |                   |           
        |                   \---swagger
        |                           SwaggerController.java
        |                           TestController.java
        |                           
        \---resources（资源文件）
            |   application-druid.yml
            |   application.yml
            |   banner.txt
            |   logback.xml
            |   
            +---ehcache
            |       ehcache-shiro.xml
            |       
            +---mybatis（MyBatis资源文件）
            |   |   mybatis-config.xml
            |   |   
            |   +---his（LTHIS Mapper文件）
            |   |       HisDrugCatalogueMapper.xml
            |   |       HisInventoryMapper.xml
            |   |       HisPatientsDiagMapper.xml
            |   |       HisPatientsMapper.xml
            |   |       HisPrescriptionsMapper.xml
            |   |       HisProcurementPlansMapper.xml
            |   |       HisPurchaseOrdersMapper.xml
            |   |       HisRegistersMapper.xml
            |   |       HisSuppliersMapper.xml
            |   |       HisWarehousingEntryMapper.xml
            |   |       
            |   +---monitor
            |   |       JobLogMapper.xml
            |   |       JobMapper.xml
            |   |       LogininforMapper.xml
            |   |       OnlineMapper.xml
            |   |       OperLogMapper.xml
            |   |       
            |   +---system
            |   |       ConfigMapper.xml
            |   |       DeptMapper.xml
            |   |       DictDataMapper.xml
            |   |       DictTypeMapper.xml
            |   |       MenuMapper.xml
            |   |       NoticeMapper.xml
            |   |       PostMapper.xml
            |   |       RoleDeptMapper.xml
            |   |       RoleMapper.xml
            |   |       RoleMenuMapper.xml
            |   |       UserMapper.xml
            |   |       UserPostMapper.xml
            |   |       UserRoleMapper.xml
            |   |       
            |   +---test
            |   |       HisPatientsMapper.xml
            |   |       
            |   \---tool
            |           GenTableColumnMapper.xml
            |           GenTableMapper.xml
            |           
            +---static
            |   |   favicon.ico
            |   |   ruoyi.png
            |   |   
            |   +---ajax
            |   |   \---libs
            |   |       +---beautifyhtml
            |   |       |       beautifyhtml.js
            |   |       |       
            |   |       +---blockUI
            |   |       |       jquery.blockUI.js
            |   |       |       
            |   |       +---bootstrap-fileinput
            |   |       |       fileinput.css
            |   |       |       fileinput.js
            |   |       |       fileinput.min.css
            |   |       |       fileinput.min.js
            |   |       |       loading-sm.gif
            |   |       |       loading.gif
            |   |       |       
            |   |       +---bootstrap-select
            |   |       |       bootstrap-select.css
            |   |       |       bootstrap-select.js
            |   |       |       bootstrap-select.min.css
            |   |       |       bootstrap-select.min.js
            |   |       |       
            |   |       +---bootstrap-table
            |   |       |   |   bootstrap-table.min.css
            |   |       |   |   bootstrap-table.min.js
            |   |       |   |   
            |   |       |   +---extensions
            |   |       |   |   +---auto-refresh
            |   |       |   |   |       bootstrap-table-auto-refresh.js
            |   |       |   |   |       
            |   |       |   |   +---columns
            |   |       |   |   |       bootstrap-table-fixed-columns.js
            |   |       |   |   |       
            |   |       |   |   +---custom-view
            |   |       |   |   |       bootstrap-table-custom-view.js
            |   |       |   |   |       
            |   |       |   |   +---editable
            |   |       |   |   |       bootstrap-editable.css
            |   |       |   |   |       bootstrap-editable.min.js
            |   |       |   |   |       bootstrap-table-editable.js
            |   |       |   |   |       clear.png
            |   |       |   |   |       loading.gif
            |   |       |   |   |       
            |   |       |   |   +---export
            |   |       |   |   |       bootstrap-table-export.js
            |   |       |   |   |       tableExport.min.js
            |   |       |   |   |       
            |   |       |   |   +---mobile
            |   |       |   |   |       bootstrap-table-mobile.js
            |   |       |   |   |       
            |   |       |   |   +---print
            |   |       |   |   |       bootstrap-table-print.js
            |   |       |   |   |       
            |   |       |   |   +---reorder-columns
            |   |       |   |   |       bootstrap-table-reorder-columns.js
            |   |       |   |   |       jquery.dragtable.js
            |   |       |   |   |       
            |   |       |   |   +---reorder-rows
            |   |       |   |   |       bootstrap-table-reorder-rows.js
            |   |       |   |   |       jquery.tablednd.js
            |   |       |   |   |       
            |   |       |   |   +---resizable
            |   |       |   |   |       bootstrap-table-resizable.js
            |   |       |   |   |       jquery.resizableColumns.min.js
            |   |       |   |   |       
            |   |       |   |   \---tree
            |   |       |   |           bootstrap-table-tree.js
            |   |       |   |           bootstrap-table-tree.min.js
            |   |       |   |           
            |   |       |   \---locale
            |   |       |           bootstrap-table-zh-CN.js
            |   |       |           bootstrap-table-zh-CN.min.js
            |   |       |           
            |   |       +---cropper
            |   |       |       cropper.css
            |   |       |       cropper.js
            |   |       |       cropper.min.css
            |   |       |       cropper.min.js
            |   |       |       
            |   |       +---cxselect
            |   |       |       jquery.cxselect.js
            |   |       |       jquery.cxselect.min.js
            |   |       |       
            |   |       +---datapicker
            |   |       |       bootstrap-datetimepicker.css
            |   |       |       bootstrap-datetimepicker.js
            |   |       |       bootstrap-datetimepicker.min.css
            |   |       |       bootstrap-datetimepicker.min.js
            |   |       |       
            |   |       +---duallistbox
            |   |       |       bootstrap-duallistbox.css
            |   |       |       bootstrap-duallistbox.js
            |   |       |       bootstrap-duallistbox.min.css
            |   |       |       bootstrap-duallistbox.min.js
            |   |       |       
            |   |       +---flot
            |   |       |       curvedLines.js
            |   |       |       jquery.flot.js
            |   |       |       jquery.flot.pie.js
            |   |       |       jquery.flot.resize.js
            |   |       |       jquery.flot.spline.js
            |   |       |       jquery.flot.symbol.js
            |   |       |       jquery.flot.tooltip.min.js
            |   |       |       
            |   |       +---fullscreen
            |   |       |       jquery.fullscreen.js
            |   |       |       
            |   |       +---highlight
            |   |       |       default.min.css
            |   |       |       highlight.min.js
            |   |       |       
            |   |       +---iCheck
            |   |       |       custom.css
            |   |       |       green-login.png
            |   |       |       green.png
            |   |       |       green@2x.png
            |   |       |       icheck.min.js
            |   |       |       
            |   |       +---jasny
            |   |       |       jasny-bootstrap.css
            |   |       |       jasny-bootstrap.js
            |   |       |       jasny-bootstrap.min.css
            |   |       |       jasny-bootstrap.min.js
            |   |       |       
            |   |       +---jquery-layout
            |   |       |       jquery.layout-latest.css
            |   |       |       jquery.layout-latest.js
            |   |       |       
            |   |       +---jquery-ztree
            |   |       |   \---3.5
            |   |       |       |   log v3.x.txt
            |   |       |       |   
            |   |       |       +---css
            |   |       |       |   +---default
            |   |       |       |   |   |   zTreeStyle.css
            |   |       |       |   |   |   
            |   |       |       |   |   \---img
            |   |       |       |   |       |   line_conn.gif
            |   |       |       |   |       |   loading.gif
            |   |       |       |   |       |   zTreeStandard.gif
            |   |       |       |   |       |   zTreeStandard.png
            |   |       |       |   |       |   
            |   |       |       |   |       \---diy
            |   |       |       |   |               1_close.png
            |   |       |       |   |               1_open.png
            |   |       |       |   |               2.png
            |   |       |       |   |               3.png
            |   |       |       |   |               4.png
            |   |       |       |   |               5.png
            |   |       |       |   |               6.png
            |   |       |       |   |               7.png
            |   |       |       |   |               8.png
            |   |       |       |   |               9.png
            |   |       |       |   |               
            |   |       |       |   +---metro
            |   |       |       |   |   |   zTreeStyle.css
            |   |       |       |   |   |   
            |   |       |       |   |   \---img
            |   |       |       |   |           line_conn.gif
            |   |       |       |   |           line_conn.png
            |   |       |       |   |           loading.gif
            |   |       |       |   |           metro.gif
            |   |       |       |   |           metro.png
            |   |       |       |   |           
            |   |       |       |   \---simple
            |   |       |       |       |   zTreeStyle.css
            |   |       |       |       |   
            |   |       |       |       \---img
            |   |       |       |               left_menu.gif
            |   |       |       |               left_menu.png
            |   |       |       |               line_conn.gif
            |   |       |       |               loading.gif
            |   |       |       |               zTreeStandard.gif
            |   |       |       |               zTreeStandard.png
            |   |       |       |               
            |   |       |       \---js
            |   |       |               jquery.ztree.all-3.5.js
            |   |       |               jquery.ztree.core-3.5.js
            |   |       |               jquery.ztree.excheck-3.5.js
            |   |       |               jquery.ztree.exedit-3.5.js
            |   |       |               jquery.ztree.exhide-3.5.js
            |   |       |               
            |   |       +---jsonview
            |   |       |       jquery.jsonview.css
            |   |       |       jquery.jsonview.js
            |   |       |       
            |   |       +---layer
            |   |       |   |   layer.min.js
            |   |       |   |   
            |   |       |   +---css
            |   |       |   |       layer.css
            |   |       |   |       
            |   |       |   \---theme
            |   |       |       \---moon
            |   |       |               default.png
            |   |       |               style.css
            |   |       |               
            |   |       +---layui
            |   |       |   |   layui.min.js
            |   |       |   |   
            |   |       |   +---css
            |   |       |   |   \---modules
            |   |       |   |           laydate.css
            |   |       |   |           
            |   |       |   \---modules
            |   |       |           laydate.js
            |   |       |           
            |   |       +---report
            |   |       |   +---echarts
            |   |       |   |       echarts-all.min.js
            |   |       |   |       
            |   |       |   +---peity
            |   |       |   |       jquery.peity.min.js
            |   |       |   |       
            |   |       |   \---sparkline
            |   |       |           jquery.sparkline.min.js
            |   |       |           
            |   |       +---select2
            |   |       |       select2-bootstrap.min.css
            |   |       |       select2.css
            |   |       |       select2.js
            |   |       |       select2.min.css
            |   |       |       select2.min.js
            |   |       |       
            |   |       +---smartwizard
            |   |       |       jquery.smartWizard.min.js
            |   |       |       smart_wizard_all.min.css
            |   |       |       
            |   |       +---suggest
            |   |       |       bootstrap-suggest.js
            |   |       |       bootstrap-suggest.min.js
            |   |       |       
            |   |       +---summernote
            |   |       |   |   summernote-zh-CN.js
            |   |       |   |   summernote.css
            |   |       |   |   summernote.js
            |   |       |   |   summernote.min.js
            |   |       |   |   
            |   |       |   \---font
            |   |       |           summernote.eot
            |   |       |           summernote.ttf
            |   |       |           summernote.woff
            |   |       |           summernote.woff2
            |   |       |           
            |   |       +---typeahead
            |   |       |       bootstrap-typeahead.js
            |   |       |       bootstrap-typeahead.min.js
            |   |       |       
            |   |       \---validate
            |   |               additional-methods.min.js
            |   |               jquery.validate.extend.js
            |   |               jquery.validate.min.js
            |   |               messages_zh.js
            |   |               
            |   +---css
            |   |       animate.min.css
            |   |       bootstrap.min.css
            |   |       font-awesome.min.css
            |   |       jquery.contextMenu.min.css
            |   |       login.css
            |   |       login.min.css
            |   |       skins.css
            |   |       style.css
            |   |       style.min.css
            |   |       zen-checkbox.css
            |   |       
            |   +---file
            |   |       rml.txt
            |   |       
            |   +---fonts
            |   |       fontawesome-webfont.eot
            |   |       fontawesome-webfont.svg
            |   |       fontawesome-webfont.ttf
            |   |       fontawesome-webfont.woff
            |   |       fontawesome-webfont.woff2
            |   |       FontAwesome.otf
            |   |       glyphicons-halflings-regular.eot
            |   |       glyphicons-halflings-regular.svg
            |   |       glyphicons-halflings-regular.ttf
            |   |       glyphicons-halflings-regular.woff
            |   |       glyphicons-halflings-regular.woff2
            |   |       iconfont.eot
            |   |       iconfont.svg
            |   |       iconfont.ttf
            |   |       iconfont.woff
            |   |       Simple-Line-Icons.woff2
            |   |       zenicon.woff
            |   |       
            |   +---his
            |   |   \---js
            |   |           custom-fun.js
            |   |           
            |   +---html
            |   |       ie.html
            |   |       
            |   +---i18n
            |   |       messages.properties
            |   |       
            |   +---img
            |   |       blue.png
            |   |       loading-upload.gif
            |   |       loading.gif
            |   |       locked.png
            |   |       login-background.jpg
            |   |       profile.jpg
            |   |       progress.png
            |   |       user.png
            |   |       
            |   +---js
            |   |   |   bootstrap.min.js
            |   |   |   cron.js
            |   |   |   jquery-ui-1.10.4.min.js
            |   |   |   jquery.contextMenu.min.js
            |   |   |   jquery.i18n.properties.min.js
            |   |   |   jquery.min.js
            |   |   |   jquery.tmpl.js
            |   |   |   resize-tabs.js
            |   |   |   three.min.js
            |   |   |   
            |   |   \---plugins
            |   |       +---metisMenu
            |   |       |       jquery.metisMenu.js
            |   |       |       
            |   |       \---slimscroll
            |   |               jquery.slimscroll.min.js
            |   |               
            |   \---ruoyi
            |       |   index.js
            |       |   login.js
            |       |   register.js
            |       |   
            |       +---css
            |       |       ry-ui.css
            |       |       
            |       \---js
            |               common.js
            |               ry-ui.js
            |               
            +---templates（网页html文件）
            |   |   include.html
            |   |   index-topnav.html
            |   |   index.html
            |   |   lock.html
            |   |   login.html
            |   |   main.html
            |   |   main_v1.html
            |   |   register.html
            |   |   skin.html
            |   |   
            |   +---demo
            |   |   +---form
            |   |   |       autocomplete.html
            |   |   |       basic.html
            |   |   |       button.html
            |   |   |       cards.html
            |   |   |       cxselect.html
            |   |   |       datetime.html
            |   |   |       duallistbox.html
            |   |   |       grid.html
            |   |   |       invoice.html
            |   |   |       jasny.html
            |   |   |       labels_tips.html
            |   |   |       localrefresh.html
            |   |   |       progress_bars.html
            |   |   |       select.html
            |   |   |       sortable.html
            |   |   |       summernote.html
            |   |   |       tabs_panels.html
            |   |   |       timeline.html
            |   |   |       upload.html
            |   |   |       validate.html
            |   |   |       wizard.html
            |   |   |       
            |   |   +---icon
            |   |   |       fontawesome.html
            |   |   |       glyphicons.html
            |   |   |       
            |   |   +---modal
            |   |   |   |   dialog.html
            |   |   |   |   form.html
            |   |   |   |   layer.html
            |   |   |   |   table.html
            |   |   |   |   
            |   |   |   \---table
            |   |   |           check.html
            |   |   |           frame1.html
            |   |   |           frame2.html
            |   |   |           parent.html
            |   |   |           radio.html
            |   |   |           
            |   |   +---operate
            |   |   |       add.html
            |   |   |       detail.html
            |   |   |       edit.html
            |   |   |       other.html
            |   |   |       table.html
            |   |   |       
            |   |   +---report
            |   |   |       echarts.html
            |   |   |       metrics.html
            |   |   |       peity.html
            |   |   |       sparkline.html
            |   |   |       
            |   |   \---table
            |   |           asynTree.html
            |   |           button.html
            |   |           child.html
            |   |           curd.html
            |   |           customView.html
            |   |           data.html
            |   |           detail.html
            |   |           dynamicColumns.html
            |   |           editable.html
            |   |           event.html
            |   |           export.html
            |   |           exportSelected.html
            |   |           fixedColumns.html
            |   |           footer.html
            |   |           groupHeader.html
            |   |           headerStyle.html
            |   |           image.html
            |   |           multi.html
            |   |           other.html
            |   |           pageGo.html
            |   |           params.html
            |   |           print.html
            |   |           refresh.html
            |   |           remember.html
            |   |           reorderColumns.html
            |   |           reorderRows.html
            |   |           resizable.html
            |   |           search.html
            |   |           subdata.html
            |   |           
            |   +---error
            |   |       404.html
            |   |       500.html
            |   |       service.html
            |   |       unauth.html
            |   |       
            |   +---his（LTHIS业务界面）
            |   |   +---catalogue
            |   |   |       add.html
            |   |   |       catalogue.html
            |   |   |       edit.html
            |   |   |       
            |   |   +---diagnosis
            |   |   |       add.html
            |   |   |       diagnosis.html
            |   |   |       edit.html
            |   |   |       
            |   |   +---entry
            |   |   |       add.html
            |   |   |       add2.html
            |   |   |       edit.html
            |   |   |       entry.html
            |   |   |       select.html
            |   |   |       
            |   |   +---inventory
            |   |   |       add.html
            |   |   |       dispensing.html
            |   |   |       edit.html
            |   |   |       inventory.html
            |   |   |       
            |   |   +---patients
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       patients.html
            |   |   |       
            |   |   +---plans
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       plans.html
            |   |   |       
            |   |   +---prescriptions
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       entry.html
            |   |   |       prescriptions.html
            |   |   |       
            |   |   +---purchase
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       purchase.html
            |   |   |       select.html
            |   |   |       
            |   |   +---registers
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       registers.html
            |   |   |       
            |   |   +---registration
            |   |   |       registration.html
            |   |   |       
            |   |   \---suppliers
            |   |           add.html
            |   |           edit.html
            |   |           suppliers.html
            |   |           
            |   +---monitor
            |   |   +---cache
            |   |   |       cache.html
            |   |   |       
            |   |   +---job
            |   |   |       add.html
            |   |   |       cron.html
            |   |   |       detail.html
            |   |   |       edit.html
            |   |   |       job.html
            |   |   |       jobLog.html
            |   |   |       
            |   |   +---logininfor
            |   |   |       logininfor.html
            |   |   |       
            |   |   +---online
            |   |   |       online.html
            |   |   |       
            |   |   +---operlog
            |   |   |       detail.html
            |   |   |       operlog.html
            |   |   |       
            |   |   \---server
            |   |           server.html
            |   |           
            |   +---system
            |   |   +---config
            |   |   |       add.html
            |   |   |       config.html
            |   |   |       edit.html
            |   |   |       
            |   |   +---dept
            |   |   |       add.html
            |   |   |       dept.html
            |   |   |       edit.html
            |   |   |       tree.html
            |   |   |       
            |   |   +---dict
            |   |   |   +---data
            |   |   |   |       add.html
            |   |   |   |       data.html
            |   |   |   |       edit.html
            |   |   |   |       
            |   |   |   \---type
            |   |   |           add.html
            |   |   |           edit.html
            |   |   |           tree.html
            |   |   |           type.html
            |   |   |           
            |   |   +---menu
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       icon.html
            |   |   |       menu.html
            |   |   |       tree.html
            |   |   |       
            |   |   +---notice
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       notice.html
            |   |   |       view.html
            |   |   |       
            |   |   +---post
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       post.html
            |   |   |       
            |   |   +---role
            |   |   |       add.html
            |   |   |       authUser.html
            |   |   |       dataScope.html
            |   |   |       edit.html
            |   |   |       role.html
            |   |   |       selectUser.html
            |   |   |       
            |   |   \---user
            |   |       |   add.html
            |   |       |   authRole.html
            |   |       |   deptTree.html
            |   |       |   edit.html
            |   |       |   resetPwd.html
            |   |       |   user.html
            |   |       |   view.html
            |   |       |   
            |   |       \---profile
            |   |               avatar.html
            |   |               profile.html
            |   |               resetPwd.html
            |   |               
            |   +---test
            |   |   +---patients
            |   |   |       add.html
            |   |   |       edit.html
            |   |   |       patients.html
            |   |   |       
            |   |   \---registration
            |   |           add.html
            |   |           
            |   \---tool
            |       +---build
            |       |       build.html
            |       |       
            |       \---gen
            |               createTable.html
            |               edit.html
            |               gen.html
            |               importTable.html
            |               
            \---vm
                +---html
                |       add.html.vm
                |       edit.html.vm
                |       list-tree.html.vm
                |       list.html.vm
                |       tree.html.vm
                |       
                +---java
                |       controller.java.vm
                |       domain.java.vm
                |       mapper.java.vm
                |       service.java.vm
                |       serviceImpl.java.vm
                |       sub-domain.java.vm
                |       
                +---sql
                |       sql.vm
                |       
                \---xml
                        mapper.xml.vm
                        
```
