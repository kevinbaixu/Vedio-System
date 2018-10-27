package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TPingjiaDAO;
import com.model.TPingjia;
import com.opensymphony.xwork2.ActionSupport;

public class pingjiaAction extends ActionSupport
{
	private Integer id;
	private String neirong;
	private String yinyueId;
	private String shijian;
	
	private TPingjiaDAO pingjiaDAO;
	
	
	public String pingjiaAdd()
	{
		TPingjia pingjia=new TPingjia();
		
		//pingjia.setId(id);
		pingjia.setYinyueId(yinyueId);
		pingjia.setNeirong(neirong);
		pingjia.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		
		pingjiaDAO.save(pingjia);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "��Ϣ�������");
		return "msg";
	}
	
	public String pingjiaAll()
	{
		String sql="from TPingjia where yinyueId="+yinyueId;
		List pingjiaList=pingjiaDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pingjiaList", pingjiaList);
		return ActionSupport.SUCCESS;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public String getyinyueId()
	{
		return yinyueId;
	}

	public void setyinyueId(String yinyueId)
	{
		this.yinyueId = yinyueId;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public TPingjiaDAO getPingjiaDAO()
	{
		return pingjiaDAO;
	}

	public void setPingjiaDAO(TPingjiaDAO pingjiaDAO)
	{
		this.pingjiaDAO = pingjiaDAO;
	}
	
}
