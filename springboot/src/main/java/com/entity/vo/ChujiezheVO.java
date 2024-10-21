package com.entity.vo;

import com.entity.ChujiezheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 出借者
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public class ChujiezheVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 出借姓名
	 */
	
	private String chujiexingming;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 手机号码
	 */
	
	private String shoujihaoma;
		
	/**
	 * 实得金额
	 */
	
	private Integer shidejine;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：出借姓名
	 */
	 
	public void setChujiexingming(String chujiexingming) {
		this.chujiexingming = chujiexingming;
	}
	
	/**
	 * 获取：出借姓名
	 */
	public String getChujiexingming() {
		return chujiexingming;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：手机号码
	 */
	 
	public void setShoujihaoma(String shoujihaoma) {
		this.shoujihaoma = shoujihaoma;
	}
	
	/**
	 * 获取：手机号码
	 */
	public String getShoujihaoma() {
		return shoujihaoma;
	}
				
	
	/**
	 * 设置：实得金额
	 */
	 
	public void setShidejine(Integer shidejine) {
		this.shidejine = shidejine;
	}
	
	/**
	 * 获取：实得金额
	 */
	public Integer getShidejine() {
		return shidejine;
	}
			
}
