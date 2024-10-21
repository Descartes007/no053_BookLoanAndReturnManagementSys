package com.entity.view;

import com.entity.ChujiezheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 出借者
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
@TableName("chujiezhe")
public class ChujiezheView  extends ChujiezheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChujiezheView(){
	}
 
 	public ChujiezheView(ChujiezheEntity chujiezheEntity){
 	try {
			BeanUtils.copyProperties(this, chujiezheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
