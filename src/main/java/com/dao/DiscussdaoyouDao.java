package com.dao;

import com.entity.DiscussdaoyouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdaoyouVO;
import com.entity.view.DiscussdaoyouView;


/**
 * 导游评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
public interface DiscussdaoyouDao extends BaseMapper<DiscussdaoyouEntity> {
	
	List<DiscussdaoyouVO> selectListVO(@Param("ew") Wrapper<DiscussdaoyouEntity> wrapper);
	
	DiscussdaoyouVO selectVO(@Param("ew") Wrapper<DiscussdaoyouEntity> wrapper);
	
	List<DiscussdaoyouView> selectListView(@Param("ew") Wrapper<DiscussdaoyouEntity> wrapper);

	List<DiscussdaoyouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdaoyouEntity> wrapper);
	
	DiscussdaoyouView selectView(@Param("ew") Wrapper<DiscussdaoyouEntity> wrapper);
	

}
