package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FankuixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FankuixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FankuixinxiView;


/**
 * 反馈信息
 *
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public interface FankuixinxiService extends IService<FankuixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FankuixinxiVO> selectListVO(Wrapper<FankuixinxiEntity> wrapper);
   	
   	FankuixinxiVO selectVO(@Param("ew") Wrapper<FankuixinxiEntity> wrapper);
   	
   	List<FankuixinxiView> selectListView(Wrapper<FankuixinxiEntity> wrapper);
   	
   	FankuixinxiView selectView(@Param("ew") Wrapper<FankuixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FankuixinxiEntity> wrapper);
   	

}

