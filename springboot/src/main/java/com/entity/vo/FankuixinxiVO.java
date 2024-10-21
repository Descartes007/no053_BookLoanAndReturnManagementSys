package com.entity.vo;

import com.entity.FankuixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 反馈信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public class FankuixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 借阅姓名
	 */
	
	private String jieyuexingming;
		
	/**
	 * 反馈时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fankuishijian;
		
	/**
	 * 反馈内容
	 */
	
	private String fankuineirong;
				
	
	/**
	 * 设置：借阅姓名
	 */
	 
	public void setJieyuexingming(String jieyuexingming) {
		this.jieyuexingming = jieyuexingming;
	}
	
	/**
	 * 获取：借阅姓名
	 */
	public String getJieyuexingming() {
		return jieyuexingming;
	}
				
	
	/**
	 * 设置：反馈时间
	 */
	 
	public void setFankuishijian(Date fankuishijian) {
		this.fankuishijian = fankuishijian;
	}
	
	/**
	 * 获取：反馈时间
	 */
	public Date getFankuishijian() {
		return fankuishijian;
	}
				
	
	/**
	 * 设置：反馈内容
	 */
	 
	public void setFankuineirong(String fankuineirong) {
		this.fankuineirong = fankuineirong;
	}
	
	/**
	 * 获取：反馈内容
	 */
	public String getFankuineirong() {
		return fankuineirong;
	}
			
}
