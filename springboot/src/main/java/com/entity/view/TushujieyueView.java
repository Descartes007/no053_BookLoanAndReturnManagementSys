package com.entity.view;

import com.entity.TushujieyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 图书借阅
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
@TableName("tushujieyue")
public class TushujieyueView  extends TushujieyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushujieyueView(){
	}
 
 	public TushujieyueView(TushujieyueEntity tushujieyueEntity){
 	try {
			BeanUtils.copyProperties(this, tushujieyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
