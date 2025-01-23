package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussdaoyouDao;
import com.entity.DiscussdaoyouEntity;
import com.service.DiscussdaoyouService;
import com.entity.vo.DiscussdaoyouVO;
import com.entity.view.DiscussdaoyouView;

@Service("discussdaoyouService")
public class DiscussdaoyouServiceImpl extends ServiceImpl<DiscussdaoyouDao, DiscussdaoyouEntity> implements DiscussdaoyouService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdaoyouEntity> page = this.selectPage(
                new Query<DiscussdaoyouEntity>(params).getPage(),
                new EntityWrapper<DiscussdaoyouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdaoyouEntity> wrapper) {
		  Page<DiscussdaoyouView> page =new Query<DiscussdaoyouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdaoyouVO> selectListVO(Wrapper<DiscussdaoyouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdaoyouVO selectVO(Wrapper<DiscussdaoyouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdaoyouView> selectListView(Wrapper<DiscussdaoyouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdaoyouView selectView(Wrapper<DiscussdaoyouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
