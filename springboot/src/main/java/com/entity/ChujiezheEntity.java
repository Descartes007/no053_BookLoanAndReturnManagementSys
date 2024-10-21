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
 * 出借者
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
@TableName("chujiezhe")
public class ChujiezheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChujiezheEntity() {
		
	}
	
	public ChujiezheEntity(T t) {
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
	 * 出借账号
	 */
					
	private String chujiezhanghao;
	
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
