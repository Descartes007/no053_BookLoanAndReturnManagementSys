package com.entity.vo;

import com.entity.ChuzushouruEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 出租收入
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public class ChuzushouruVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 出借账号
	 */
	
	private String chujiezhanghao;
		
	/**
	 * 出借姓名
	 */
	
	private String chujiexingming;
		
	/**
	 * 金额
	 */
	
	private Integer jine;
		
	/**
	 * 退还压金
	 */
	
	private String tuihaiyajin;
		
	/**
	 * 实得金额
	 */
	
	private String shidejine;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
				
	
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
	 * 设置：退还压金
	 */
	 
	public void setTuihaiyajin(String tuihaiyajin) {
		this.tuihaiyajin = tuihaiyajin;
	}
	
	/**
	 * 获取：退还压金
	 */
	public String getTuihaiyajin() {
		return tuihaiyajin;
	}
				
	
	/**
	 * 设置：实得金额
	 */
	 
	public void setShidejine(String shidejine) {
		this.shidejine = shidejine;
	}
	
	/**
	 * 获取：实得金额
	 */
	public String getShidejine() {
		return shidejine;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
			
}
