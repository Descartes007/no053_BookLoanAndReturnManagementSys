package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChujiezheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChujiezheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChujiezheView;


/**
 * 出借者
 *
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public interface ChujiezheService extends IService<ChujiezheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChujiezheVO> selectListVO(Wrapper<ChujiezheEntity> wrapper);
   	
   	ChujiezheVO selectVO(@Param("ew") Wrapper<ChujiezheEntity> wrapper);
   	
   	List<ChujiezheView> selectListView(Wrapper<ChujiezheEntity> wrapper);
   	
   	ChujiezheView selectView(@Param("ew") Wrapper<ChujiezheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChujiezheEntity> wrapper);
   	

}

