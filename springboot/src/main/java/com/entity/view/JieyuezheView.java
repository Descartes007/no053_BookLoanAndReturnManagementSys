package com.entity.view;

import com.entity.JieyuezheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 借阅者
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
@TableName("jieyuezhe")
public class JieyuezheView  extends JieyuezheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JieyuezheView(){
	}
 
 	public JieyuezheView(JieyuezheEntity jieyuezheEntity){
 	try {
			BeanUtils.copyProperties(this, jieyuezheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
