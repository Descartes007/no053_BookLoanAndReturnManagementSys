package com.entity.model;

import com.entity.TushujieyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 图书借阅
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public class TushujieyueModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图书编号
	 */
	
	private String tushubianhao;
		
	/**
	 * 图书名称
	 */
	
	private String tushumingcheng;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 每日费用
	 */
	
	private Integer meirifeiyong;
		
	/**
	 * 借阅天数
	 */
	
	private Integer jieyuetianshu;
		
	/**
	 * 押金
	 */
	
	private Integer yajin;
		
	/**
	 * 金额
	 */
	
	private Integer jine;
		
	/**
	 * 借出时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jiechushijian;
		
	/**
	 * 借阅账号
	 */
	
	private String jieyuezhanghao;
		
	/**
	 * 借阅金额
	 */
	
	private String jieyuejine;
		
	/**
	 * 出借账号
	 */
	
	private String chujiezhanghao;
				
	
	/**
	 * 设置：图书编号
	 */
	 
	public void setTushubianhao(String tushubianhao) {
		this.tushubianhao = tushubianhao;
	}
	
	/**
	 * 获取：图书编号
	 */
	public String getTushubianhao() {
		return tushubianhao;
	}
				
	
	/**
	 * 设置：图书名称
	 */
	 
	public void setTushumingcheng(String tushumingcheng) {
		this.tushumingcheng = tushumingcheng;
	}
	
	/**
	 * 获取：图书名称
	 */
	public String getTushumingcheng() {
		return tushumingcheng;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：每日费用
	 */
	 
	public void setMeirifeiyong(Integer meirifeiyong) {
		this.meirifeiyong = meirifeiyong;
	}
	
	/**
	 * 获取：每日费用
	 */
	public Integer getMeirifeiyong() {
		return meirifeiyong;
	}
				
	
	/**
	 * 设置：借阅天数
	 */
	 
	public void setJieyuetianshu(Integer jieyuetianshu) {
		this.jieyuetianshu = jieyuetianshu;
	}
	
	/**
	 * 获取：借阅天数
	 */
	public Integer getJieyuetianshu() {
		return jieyuetianshu;
	}
				
	
	/**
	 * 设置：押金
	 */
	 
	public void setYajin(Integer yajin) {
		this.yajin = yajin;
	}
	
	/**
	 * 获取：押金
	 */
	public Integer getYajin() {
		return yajin;
	}
				
	
	/**
	 * 设置：金额
	 */
	 
	public void setJine(Integer jine) {
		this.jine = jine;
	}
	
	/**
	 * 获取：金额
	 */
	public Integer getJine() {
		return jine;
	}
				
	
	/**
	 * 设置：借出时间
	 */
	 
	public void setJiechushijian(Date jiechushijian) {
		this.jiechushijian = jiechushijian;
	}
	
	/**
	 * 获取：借出时间
	 */
	public Date getJiechushijian() {
		return jiechushijian;
	}
				
	
	/**
	 * 设置：借阅账号
	 */
	 
	public void setJieyuezhanghao(String jieyuezhanghao) {
		this.jieyuezhanghao = jieyuezhanghao;
	}
	
	/**
	 * 获取：借阅账号
	 */
	public String getJieyuezhanghao() {
		return jieyuezhanghao;
	}
				
	
	/**
	 * 设置：借阅金额
	 */
	 
	public void setJieyuejine(String jieyuejine) {
		this.jieyuejine = jieyuejine;
	}
	
	/**
	 * 获取：借阅金额
	 */
	public String getJieyuejine() {
		return jieyuejine;
	}
				
	
	/**
	 * 设置：出借账号
	 */
	 
	public void setChujiezhanghao(String chujiezhanghao) {
		this.chujiezhanghao = chujiezhanghao;
	}
	
	/**
	 * 获取：出借账号
	 */
	public String getChujiezhanghao() {
		return chujiezhanghao;
	}
			
}
