<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230329/eff4ea96c952463cb46b9c79d043ce56.gif) fixed,#f6f6f6"}' style="width: 100%;">
		<el-form
			:style='{"padding":"20px","boxShadow":"0 0px 0px #ddd","borderRadius":"0px","background":"none"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="线路名称" prop="xianlumingcheng">
					<el-input v-model="ruleForm.xianlumingcheng" placeholder="线路名称" clearable  :readonly="ro.xianlumingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="线路名称" prop="xianlumingcheng">
					<el-input v-model="ruleForm.xianlumingcheng" placeholder="线路名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="景点名称" prop="jingdianmingcheng">
					<el-input v-model="ruleForm.jingdianmingcheng" placeholder="景点名称" clearable  :readonly="ro.jingdianmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="景点名称" prop="jingdianmingcheng">
					<el-input v-model="ruleForm.jingdianmingcheng" placeholder="景点名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="景点地址" prop="jingdiandizhi">
					<el-input v-model="ruleForm.jingdiandizhi" placeholder="景点地址" clearable  :readonly="ro.jingdiandizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="景点地址" prop="jingdiandizhi">
					<el-input v-model="ruleForm.jingdiandizhi" placeholder="景点地址" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.xianlutupian" label="线路图片" prop="xianlutupian">
					<file-upload
						tip="点击上传线路图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.xianlutupian?ruleForm.xianlutupian:''"
						@change="xianlutupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.xianlutupian" label="线路图片" prop="xianlutupian">
					<img v-if="ruleForm.xianlutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.xianlutupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.xianlutupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="起点" prop="qidian">
					<el-input v-model="ruleForm.qidian" placeholder="起点" clearable  :readonly="ro.qidian"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="起点" prop="qidian">
					<el-input v-model="ruleForm.qidian" placeholder="起点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="途径路段" prop="tujingluduan">
					<el-input v-model="ruleForm.tujingluduan" placeholder="途径路段" clearable  :readonly="ro.tujingluduan"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="途径路段" prop="tujingluduan">
					<el-input v-model="ruleForm.tujingluduan" placeholder="途径路段" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="终点" prop="zhongdian">
					<el-input v-model="ruleForm.zhongdian" placeholder="终点" clearable  :readonly="ro.zhongdian"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="终点" prop="zhongdian">
					<el-input v-model="ruleForm.zhongdian" placeholder="终点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="交通方式" prop="jiaotongfangshi">
					<el-input v-model="ruleForm.jiaotongfangshi" placeholder="交通方式" clearable  :readonly="ro.jiaotongfangshi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="交通方式" prop="jiaotongfangshi">
					<el-input v-model="ruleForm.jiaotongfangshi" placeholder="交通方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="导游证号" prop="daoyouzhenghao">
					<el-input v-model="ruleForm.daoyouzhenghao" placeholder="导游证号" clearable  :readonly="ro.daoyouzhenghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="导游证号" prop="daoyouzhenghao">
					<el-input v-model="ruleForm.daoyouzhenghao" placeholder="导游证号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="导游姓名" prop="daoyouxingming">
					<el-input v-model="ruleForm.daoyouxingming" placeholder="导游姓名" clearable  :readonly="ro.daoyouxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="导游姓名" prop="daoyouxingming">
					<el-input v-model="ruleForm.daoyouxingming" placeholder="导游姓名" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="线路详情" prop="xianluxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.xianluxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.xianluxiangqing" label="线路详情" prop="xianluxiangqing">
                    <span :style='{"fontSize":"16px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.xianluxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"0px","background":"#339933","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"0px","background":"#FFCC33","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"0px","background":"#FFCC33","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				xianlumingcheng : false,
				jingdianmingcheng : false,
				jingdiandizhi : false,
				xianlutupian : false,
				qidian : false,
				tujingluduan : false,
				zhongdian : false,
				jiaotongfangshi : false,
				daoyouzhenghao : false,
				daoyouxingming : false,
				xianluxiangqing : false,
			},
			
			
			ruleForm: {
				xianlumingcheng: '',
				jingdianmingcheng: '',
				jingdiandizhi: '',
				xianlutupian: '',
				qidian: '',
				tujingluduan: '',
				zhongdian: '',
				jiaotongfangshi: '',
				daoyouzhenghao: '',
				daoyouxingming: '',
				xianluxiangqing: '',
			},
		

			
			rules: {
				xianlumingcheng: [
					{ required: true, message: '线路名称不能为空', trigger: 'blur' },
				],
				jingdianmingcheng: [
					{ required: true, message: '景点名称不能为空', trigger: 'blur' },
				],
				jingdiandizhi: [
				],
				xianlutupian: [
				],
				qidian: [
				],
				tujingluduan: [
				],
				zhongdian: [
				],
				jiaotongfangshi: [
				],
				daoyouzhenghao: [
				],
				daoyouxingming: [
				],
				xianluxiangqing: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='xianlumingcheng'){
							this.ruleForm.xianlumingcheng = obj[o];
							this.ro.xianlumingcheng = true;
							continue;
						}
						if(o=='jingdianmingcheng'){
							this.ruleForm.jingdianmingcheng = obj[o];
							this.ro.jingdianmingcheng = true;
							continue;
						}
						if(o=='jingdiandizhi'){
							this.ruleForm.jingdiandizhi = obj[o];
							this.ro.jingdiandizhi = true;
							continue;
						}
						if(o=='xianlutupian'){
							this.ruleForm.xianlutupian = obj[o];
							this.ro.xianlutupian = true;
							continue;
						}
						if(o=='qidian'){
							this.ruleForm.qidian = obj[o];
							this.ro.qidian = true;
							continue;
						}
						if(o=='tujingluduan'){
							this.ruleForm.tujingluduan = obj[o];
							this.ro.tujingluduan = true;
							continue;
						}
						if(o=='zhongdian'){
							this.ruleForm.zhongdian = obj[o];
							this.ro.zhongdian = true;
							continue;
						}
						if(o=='jiaotongfangshi'){
							this.ruleForm.jiaotongfangshi = obj[o];
							this.ro.jiaotongfangshi = true;
							continue;
						}
						if(o=='daoyouzhenghao'){
							this.ruleForm.daoyouzhenghao = obj[o];
							this.ro.daoyouzhenghao = true;
							continue;
						}
						if(o=='daoyouxingming'){
							this.ruleForm.daoyouxingming = obj[o];
							this.ro.daoyouxingming = true;
							continue;
						}
						if(o=='xianluxiangqing'){
							this.ruleForm.xianluxiangqing = obj[o];
							this.ro.xianluxiangqing = true;
							continue;
						}
				}
				











			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.daoyouzhenghao!=''&&json.daoyouzhenghao) || json.daoyouzhenghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.daoyouzhenghao = json.daoyouzhenghao
						this.ro.daoyouzhenghao = true;
					}
					if(((json.daoyouxingming!=''&&json.daoyouxingming) || json.daoyouxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.daoyouxingming = json.daoyouxingming
						this.ro.daoyouxingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `lvyouxianlu/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.xianluxiangqing = this.ruleForm.xianluxiangqing.replace(reg,'../../../ssmfx998/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {








	if(this.ruleForm.xianlutupian!=null) {
		this.ruleForm.xianlutupian = this.ruleForm.xianlutupian.replace(new RegExp(this.$base.url,"g"),"");
	}















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "lvyouxianlu/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `lvyouxianlu/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.lvyouxianluCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `lvyouxianlu/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.lvyouxianluCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.lvyouxianluCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    xianlutupianUploadChange(fileUrls) {
	    this.ruleForm.xianlutupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 180px;
	  	  font-size: 16px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  min-height: 120px;
	  	  height: auto;
	  	}
</style>
