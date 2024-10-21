package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieyuezheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JieyuezheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JieyuezheView;


/**
 * 借阅者
 *
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public interface JieyuezheService extends IService<JieyuezheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JieyuezheVO> selectListVO(Wrapper<JieyuezheEntity> wrapper);
   	
   	JieyuezheVO selectVO(@Param("ew") Wrapper<JieyuezheEntity> wrapper);
   	
   	List<JieyuezheView> selectListView(Wrapper<JieyuezheEntity> wrapper);
   	
   	JieyuezheView selectView(@Param("ew") Wrapper<JieyuezheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JieyuezheEntity> wrapper);
   	

}

