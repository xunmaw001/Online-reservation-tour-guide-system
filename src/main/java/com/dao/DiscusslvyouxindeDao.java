package com.dao;

import com.entity.DiscusslvyouxindeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslvyouxindeVO;
import com.entity.view.DiscusslvyouxindeView;


/**
 * 旅游心得评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
public interface DiscusslvyouxindeDao extends BaseMapper<DiscusslvyouxindeEntity> {
	
	List<DiscusslvyouxindeVO> selectListVO(@Param("ew") Wrapper<DiscusslvyouxindeEntity> wrapper);
	
	DiscusslvyouxindeVO selectVO(@Param("ew") Wrapper<DiscusslvyouxindeEntity> wrapper);
	
	List<DiscusslvyouxindeView> selectListView(@Param("ew") Wrapper<DiscusslvyouxindeEntity> wrapper);

	List<DiscusslvyouxindeView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslvyouxindeEntity> wrapper);
	
	DiscusslvyouxindeView selectView(@Param("ew") Wrapper<DiscusslvyouxindeEntity> wrapper);
	

}
