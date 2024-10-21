package com.dao;

import com.entity.FankuixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FankuixinxiVO;
import com.entity.view.FankuixinxiView;


/**
 * 反馈信息
 * 
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public interface FankuixinxiDao extends BaseMapper<FankuixinxiEntity> {
	
	List<FankuixinxiVO> selectListVO(@Param("ew") Wrapper<FankuixinxiEntity> wrapper);
	
	FankuixinxiVO selectVO(@Param("ew") Wrapper<FankuixinxiEntity> wrapper);
	
	List<FankuixinxiView> selectListView(@Param("ew") Wrapper<FankuixinxiEntity> wrapper);

	List<FankuixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FankuixinxiEntity> wrapper);
	
	FankuixinxiView selectView(@Param("ew") Wrapper<FankuixinxiEntity> wrapper);
	

}
