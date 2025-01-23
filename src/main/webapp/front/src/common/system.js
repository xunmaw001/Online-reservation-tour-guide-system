export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","查看评论"],"menu":"导游","menuJump":"列表","tableName":"daoyou"}],"menu":"导游管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除","查看评论"],"menu":"旅游心得","menuJump":"列表","tableName":"lvyouxinde"}],"menu":"旅游心得管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","查看评论"],"menu":"旅游景点","menuJump":"列表","tableName":"lvyoujingdian"}],"menu":"旅游景点管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除","查看评论"],"menu":"旅游线路","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改","删除"],"menu":"预约订单","menuJump":"列表","tableName":"yuyuedingdan"}],"menu":"预约订单管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"景点分类","menuJump":"列表","tableName":"jingdianfenlei"}],"menu":"景点分类管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"系统公告","tableName":"news"},{"appFrontIcon":"cuIcon-circle","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","查看评论"],"menu":"导游列表","menuJump":"列表","tableName":"daoyou"}],"menu":"导游模块"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","查看评论"],"menu":"旅游心得列表","menuJump":"列表","tableName":"lvyouxinde"}],"menu":"旅游心得模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","查看评论"],"menu":"旅游景点列表","menuJump":"列表","tableName":"lvyoujingdian"}],"menu":"旅游景点模块"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","查看评论","预约"],"menu":"旅游线路列表","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改","删除","查看评论"],"menu":"预约订单","menuJump":"列表","tableName":"yuyuedingdan"}],"menu":"预约订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","查看评论"],"menu":"导游列表","menuJump":"列表","tableName":"daoyou"}],"menu":"导游模块"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","查看评论"],"menu":"旅游心得列表","menuJump":"列表","tableName":"lvyouxinde"}],"menu":"旅游心得模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","查看评论"],"menu":"旅游景点列表","menuJump":"列表","tableName":"lvyoujingdian"}],"menu":"旅游景点模块"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","查看评论","预约"],"menu":"旅游线路列表","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","查看评论"],"menu":"导游列表","menuJump":"列表","tableName":"daoyou"}],"menu":"导游模块"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","查看评论"],"menu":"旅游心得列表","menuJump":"列表","tableName":"lvyouxinde"}],"menu":"旅游心得模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","查看评论"],"menu":"旅游景点列表","menuJump":"列表","tableName":"lvyoujingdian"}],"menu":"旅游景点模块"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","查看评论","预约"],"menu":"旅游线路列表","menuJump":"列表","tableName":"lvyouxianlu"}],"menu":"旅游线路模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"导游","tableName":"daoyou"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
