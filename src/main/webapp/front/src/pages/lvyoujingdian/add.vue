<template>
<div :style='{"width":"100%","padding":"40px 7%","margin":"0 auto","position":"relative","background":"none"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="150px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="景点名称" prop="jingdianmingcheng">
            <el-input v-model="ruleForm.jingdianmingcheng" 
                placeholder="景点名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}'  label="景点分类" prop="jingdianfenlei">
            <el-select v-model="ruleForm.jingdianfenlei" placeholder="请选择景点分类"  >
              <el-option
                  v-for="(item,index) in jingdianfenleiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="景点图片" v-if="type!='cross' || (type=='cross' && !ro.jingdiantupian)" prop="jingdiantupian">
            <file-upload
            tip="点击上传景点图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.jingdiantupian?ruleForm.jingdiantupian:''"
            @change="jingdiantupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' class="upload" v-else label="景点图片" prop="jingdiantupian">
                <img v-if="ruleForm.jingdiantupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.jingdiantupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jingdiantupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}'  label="景点等级" prop="jingdiandengji">
            <el-select v-model="ruleForm.jingdiandengji" placeholder="请选择景点等级"  >
              <el-option
                  v-for="(item,index) in jingdiandengjiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="城市" prop="chengshi">
            <el-input v-model="ruleForm.chengshi" 
                placeholder="城市" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="具体地址" prop="jutidizhi">
            <el-input v-model="ruleForm.jutidizhi" 
                placeholder="具体地址" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="门票价格" prop="menpiaojiage">
            <el-input v-model="ruleForm.menpiaojiage" 
                placeholder="门票价格" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="开放时间" prop="kaifangshijian">
            <el-input v-model="ruleForm.kaifangshijian" 
                placeholder="开放时间" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="景点介绍" prop="jingdianjieshao">
            <editor 
                :style='{"padding":"0","boxShadow":"0 0 0px rgba(75,223,201,.5)","margin":"0","borderColor":"#eee","backgroundColor":"#fff","borderRadius":"0","borderWidth":"1px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.jingdianjieshao" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="注意事项" prop="zhuyishixiang">
            <editor 
                :style='{"padding":"0","boxShadow":"0 0 0px rgba(75,223,201,.5)","margin":"0","borderColor":"#eee","backgroundColor":"#fff","borderRadius":"0","borderWidth":"1px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.zhuyishixiang" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 10px","color":"#fff","minWidth":"140px","outline":"none","borderRadius":"60px","background":"#40a8c4","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 15px","margin":"0 10px","color":"#fff","minWidth":"140px","outline":"none","borderRadius":"60px","background":"#f7aa00","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            jingdianmingcheng : false,
            jingdianfenlei : false,
            jingdiantupian : false,
            jingdiandengji : false,
            chengshi : false,
            jutidizhi : false,
            menpiaojiage : false,
            jingdianjieshao : false,
            kaifangshijian : false,
            zhuyishixiang : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          jingdianmingcheng: '',
          jingdianfenlei: '',
          jingdiantupian: '',
          jingdiandengji: '',
          chengshi: '',
          jutidizhi: '',
          menpiaojiage: '',
          jingdianjieshao: '',
          kaifangshijian: '',
          zhuyishixiang: '',
        },
        jingdianfenleiOptions: [],
        jingdiandengjiOptions: [],


        rules: {
          jingdianmingcheng: [
            { required: true, message: '景点名称不能为空', trigger: 'blur' },
          ],
          jingdianfenlei: [
          ],
          jingdiantupian: [
          ],
          jingdiandengji: [
          ],
          chengshi: [
          ],
          jutidizhi: [
          ],
          menpiaojiage: [
          ],
          jingdianjieshao: [
          ],
          kaifangshijian: [
          ],
          zhuyishixiang: [
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='jingdianmingcheng'){
              this.ruleForm.jingdianmingcheng = obj[o];
              this.ro.jingdianmingcheng = true;
              continue;
            }
            if(o=='jingdianfenlei'){
              this.ruleForm.jingdianfenlei = obj[o];
              this.ro.jingdianfenlei = true;
              continue;
            }
            if(o=='jingdiantupian'){
              this.ruleForm.jingdiantupian = obj[o].split(",")[0];
              this.ro.jingdiantupian = true;
              continue;
            }
            if(o=='jingdiandengji'){
              this.ruleForm.jingdiandengji = obj[o];
              this.ro.jingdiandengji = true;
              continue;
            }
            if(o=='chengshi'){
              this.ruleForm.chengshi = obj[o];
              this.ro.chengshi = true;
              continue;
            }
            if(o=='jutidizhi'){
              this.ruleForm.jutidizhi = obj[o];
              this.ro.jutidizhi = true;
              continue;
            }
            if(o=='menpiaojiage'){
              this.ruleForm.menpiaojiage = obj[o];
              this.ro.menpiaojiage = true;
              continue;
            }
            if(o=='jingdianjieshao'){
              this.ruleForm.jingdianjieshao = obj[o];
              this.ro.jingdianjieshao = true;
              continue;
            }
            if(o=='kaifangshijian'){
              this.ruleForm.kaifangshijian = obj[o];
              this.ro.kaifangshijian = true;
              continue;
            }
            if(o=='zhuyishixiang'){
              this.ruleForm.zhuyishixiang = obj[o];
              this.ro.zhuyishixiang = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/jingdianfenlei/jingdianfenlei', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.jingdianfenleiOptions = res.data.data;
          }
        });
        this.jingdiandengjiOptions = "A,AA,AAA,AAAA,AAAAA".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('lvyoujingdian/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('lvyoujingdian/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('lvyoujingdian/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('lvyoujingdian/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
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
        this.$router.go(-1);
      },
      jingdiantupianUploadChange(fileUrls) {
          this.ruleForm.jingdiantupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 15px;
	  color: #333;
	  font-weight: 500;
	  width: 150px;
	  font-size: 15px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #eee;
	  border-radius: 30px;
	  padding: 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #eee;
	  border-radius: 30px;
	  padding: 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #eee;
	  border-radius: 30px;
	  padding: 0 10px 0 30px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
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
	  border: 1px dashed #ccc;
	  cursor: pointer;
	  border-radius: 20px;
	  color: #999;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #ccc;
	  cursor: pointer;
	  border-radius: 20px;
	  color: #999;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #ccc;
	  cursor: pointer;
	  border-radius: 20px;
	  color: #999;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #eee;
	  border-radius: 30px;
	  padding: 20px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
