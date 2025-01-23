package com.entity.view;

import com.entity.LvyouxindeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 旅游心得
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
@TableName("lvyouxinde")
public class LvyouxindeView  extends LvyouxindeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LvyouxindeView(){
	}
 
 	public LvyouxindeView(LvyouxindeEntity lvyouxindeEntity){
 	try {
			BeanUtils.copyProperties(this, lvyouxindeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
