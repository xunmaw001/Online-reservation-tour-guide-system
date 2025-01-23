package com.entity.view;

import com.entity.DiscusslvyouxindeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 旅游心得评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
@TableName("discusslvyouxinde")
public class DiscusslvyouxindeView  extends DiscusslvyouxindeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusslvyouxindeView(){
	}
 
 	public DiscusslvyouxindeView(DiscusslvyouxindeEntity discusslvyouxindeEntity){
 	try {
			BeanUtils.copyProperties(this, discusslvyouxindeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
