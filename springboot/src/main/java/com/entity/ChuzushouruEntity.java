package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 出租收入
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
@TableName("chuzushouru")
public class ChuzushouruEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChuzushouruEntity() {
		
	}
	
	public ChuzushouruEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 主题
	 */
					
	private String zhuti;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date riqi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：主题
	 */
	public void setZhuti(String zhuti) {
		this.zhuti = zhuti;
	}
	/**
	 * 获取：主题
	 */
	public String getZhuti() {
		return zhuti;
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
