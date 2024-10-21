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
 * 图书归还
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
@TableName("tushuguihai")
public class TushuguihaiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TushuguihaiEntity() {
		
	}
	
	public TushuguihaiEntity(T t) {
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
	 * 借阅编号
	 */
					
	private String jieyuebianhao;
	
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
	 * 押金
	 */
					
	private Integer yajin;
	
	/**
	 * 归还时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date guihaishijian;
	
	/**
	 * 借阅账号
	 */
					
	private String jieyuezhanghao;
	
	/**
	 * 出借账号
	 */
					
	private String chujiezhanghao;
	
	/**
	 * 归还备注
	 */
					
	private String guihaibeizhu;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：借阅编号
	 */
	public void setJieyuebianhao(String jieyuebianhao) {
		this.jieyuebianhao = jieyuebianhao;
	}
	/**
	 * 获取：借阅编号
	 */
	public String getJieyuebianhao() {
		return jieyuebianhao;
	}
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
	 * 设置：归还时间
	 */
	public void setGuihaishijian(Date guihaishijian) {
		this.guihaishijian = guihaishijian;
	}
	/**
	 * 获取：归还时间
	 */
	public Date getGuihaishijian() {
		return guihaishijian;
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
	 * 设置：归还备注
	 */
	public void setGuihaibeizhu(String guihaibeizhu) {
		this.guihaibeizhu = guihaibeizhu;
	}
	/**
	 * 获取：归还备注
	 */
	public String getGuihaibeizhu() {
		return guihaibeizhu;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
