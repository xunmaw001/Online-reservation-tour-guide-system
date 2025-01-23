package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdaoyouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdaoyouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdaoyouView;


/**
 * 导游评论表
 *
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
public interface DiscussdaoyouService extends IService<DiscussdaoyouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdaoyouVO> selectListVO(Wrapper<DiscussdaoyouEntity> wrapper);
   	
   	DiscussdaoyouVO selectVO(@Param("ew") Wrapper<DiscussdaoyouEntity> wrapper);
   	
   	List<DiscussdaoyouView> selectListView(Wrapper<DiscussdaoyouEntity> wrapper);
   	
   	DiscussdaoyouView selectView(@Param("ew") Wrapper<DiscussdaoyouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdaoyouEntity> wrapper);
   	

}

