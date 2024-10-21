package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuzushouruEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuzushouruVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuzushouruView;


/**
 * 出租收入
 *
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public interface ChuzushouruService extends IService<ChuzushouruEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuzushouruVO> selectListVO(Wrapper<ChuzushouruEntity> wrapper);
   	
   	ChuzushouruVO selectVO(@Param("ew") Wrapper<ChuzushouruEntity> wrapper);
   	
   	List<ChuzushouruView> selectListView(Wrapper<ChuzushouruEntity> wrapper);
   	
   	ChuzushouruView selectView(@Param("ew") Wrapper<ChuzushouruEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuzushouruEntity> wrapper);
   	

}

