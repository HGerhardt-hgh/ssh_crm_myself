package cn.itcast.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
//属性注入
private LinkManService linkManService;
public void setLinkManService(LinkManService linkManService) {
	this.linkManService = linkManService;
}
private CustomerService customerService;
public void setCustomerService(CustomerService customerService){
    this.customerService=customerService;	
}

//驱动模型封装
private LinkMan linkMan=new LinkMan();
public LinkMan getModel() {
	return linkMan;
}
//1.到添加页面方法
public String toAddPage(){
	//查询所有客户，返回list集合
	//把客户的list集合传递到页面下拉表中
	List<Customer> listCustomer=customerService.findAll();
	ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
	return "toAddPage";
}

//定义两个变量，一个代表上传文件，一个代表上传文件名称
//上传文件
private File upload;
//上传的文件名，后面加FileName
private String uploadFileName;
//生成get和set方法

public File getUpload() {
	return upload;
}
public void setUpload(File upload) {
	this.upload = upload;
}
public String getUploadFileName() {
	return uploadFileName;
}
public void setUploadFileName(String uploadFileName) {
	this.uploadFileName = uploadFileName;
}

//2.添加方法+文件上传
public String add() throws Exception{
	linkManService.add(linkMan);
//判断是否需要上传文件
if (upload!=null) {
	//1.在上传到服务器文件夹里面创建文件
	File serverFile=new File("D:\\桌面\\黑马\\ssh框架综合项目开发资料\\fileupload"+"/"+uploadFileName);
	//2.把上传的本地文件复制到服务器的文件中
	//第一个参数：上传文件
	//第二个参数：服务器文件
	FileUtils.copyFile(upload, serverFile);
}
	
	return "add";
	
}

//3.到联系人列表页面
public String list(){
	//获取linkMan信息
	List<LinkMan> list=linkManService.findAll();
	ServletActionContext.getRequest().setAttribute("list", list);
	return "list";
}
//4.联系人跳转修改页面
public String showUpdate(){
	//根据id查询该联系人所有信息
	int lkmId=linkMan.getLkmId();
	LinkMan lkm=linkManService.findById(lkmId);
	ServletActionContext.getRequest().setAttribute("linkman", lkm);
	//查询所有客户信息
	List<Customer> listCustomer=customerService.findAll();
	ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
	return "showUpdate";
}
//5.修改联系人
public String update(){
	linkManService.update(linkMan);
	return "update";
}
//6.删除联系人
public String delete(){
	//1.通过id获取linkMan对象
	int id=linkMan.getLkmId();
	LinkMan linkMan=linkManService.findById(id);
	if (linkMan!=null) {
		//2.通过service方法删除
		linkManService.delete(linkMan);
	}
	
	return "delete";
}
//7.根据联系人名字查询
public String select(){
	
	List<LinkMan> list=linkManService.select(linkMan);
	ServletActionContext.getRequest().setAttribute("list", list);
	return "list";
}

//到查询页面
public String showFind(){
	List<Customer> list=customerService.findAll();
	ServletActionContext.getRequest().setAttribute("list", list);
	return "showFind";
}
//多条件查询
public String moreCondition(){
	List<LinkMan> list=linkManService.moreCondition(linkMan);
	ServletActionContext.getRequest().setAttribute("list", list);
	return "list";
}

}