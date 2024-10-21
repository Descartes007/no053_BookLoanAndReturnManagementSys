package com.dao;

import com.entity.ChujiezheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChujiezheVO;
import com.entity.view.ChujiezheView;


/**
 * 出借者
 * 
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public interface ChujiezheDao extends BaseMapper<ChujiezheEntity> {
	
	List<ChujiezheVO> selectListVO(@Param("ew") Wrapper<ChujiezheEntity> wrapper);
	
	ChujiezheVO selectVO(@Param("ew") Wrapper<ChujiezheEntity> wrapper);
	
	List<ChujiezheView> selectListView(@Param("ew") Wrapper<ChujiezheEntity> wrapper);

	List<ChujiezheView> selectListView(Pagination page,@Param("ew") Wrapper<ChujiezheEntity> wrapper);
	
	ChujiezheView selectView(@Param("ew") Wrapper<ChujiezheEntity> wrapper);
	

}
