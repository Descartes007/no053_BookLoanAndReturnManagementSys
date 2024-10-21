<template>
	<div class="addEdit-block" style="width: 100%;">
		<el-form
			:style='{"padding":"30px 15px","boxShadow":"0 0px 0px #999","borderRadius":"0px","flexWrap":"wrap","background":"none","display":"flex","justifyContent":"space-between"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="120px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'" label="借阅编号" prop="jieyuebianhao">
					<el-input v-model="ruleForm.jieyuebianhao" placeholder="借阅编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-else-if="ruleForm.jieyuebianhao" label="借阅编号" prop="jieyuebianhao">
					<el-input v-model="ruleForm.jieyuebianhao" placeholder="借阅编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="图书编号" prop="tushubianhao">
					<el-input v-model="ruleForm.tushubianhao" placeholder="图书编号" clearable  :readonly="ro.tushubianhao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="图书编号" prop="tushubianhao">
					<el-input v-model="ruleForm.tushubianhao" placeholder="图书编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="图书名称" prop="tushumingcheng">
					<el-input v-model="ruleForm.tushumingcheng" placeholder="图书名称" clearable  :readonly="ro.tushumingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="图书名称" prop="tushumingcheng">
					<el-input v-model="ruleForm.tushumingcheng" placeholder="图书名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="数量" prop="shuliang">
					<el-input v-model="ruleForm.shuliang" placeholder="数量" clearable  :readonly="ro.shuliang"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="数量" prop="shuliang">
					<el-input v-model="ruleForm.shuliang" placeholder="数量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="每日费用" prop="meirifeiyong">
					<el-input v-model="ruleForm.meirifeiyong" placeholder="每日费用" clearable  :readonly="ro.meirifeiyong"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="每日费用" prop="meirifeiyong">
					<el-input v-model="ruleForm.meirifeiyong" placeholder="每日费用" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="借阅天数" prop="jieyuetianshu">
					<el-input v-model="ruleForm.jieyuetianshu" placeholder="借阅天数" clearable  :readonly="ro.jieyuetianshu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="借阅天数" prop="jieyuetianshu">
					<el-input v-model="ruleForm.jieyuetianshu" placeholder="借阅天数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="押金" prop="yajin">
					<el-input v-model="ruleForm.yajin" placeholder="押金" clearable  :readonly="ro.yajin"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="押金" prop="yajin">
					<el-input v-model="ruleForm.yajin" placeholder="押金" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="金额" prop="jine">
					<el-input v-model="jine" placeholder="金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-else-if="ruleForm.jine" label="金额" prop="jine">
					<el-input v-model="ruleForm.jine" placeholder="金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="date" v-if="type!='info'" label="借出时间" prop="jiechushijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.jiechushijian" 
						type="date"
						:readonly="ro.jiechushijian"
						placeholder="借出时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-else-if="ruleForm.jiechushijian" label="借出时间" prop="jiechushijian">
					<el-input v-model="ruleForm.jiechushijian" placeholder="借出时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="借阅账号" prop="jieyuezhanghao">
					<el-input v-model="ruleForm.jieyuezhanghao" placeholder="借阅账号" clearable  :readonly="ro.jieyuezhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="借阅账号" prop="jieyuezhanghao">
					<el-input v-model="ruleForm.jieyuezhanghao" placeholder="借阅账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="借阅金额" prop="jieyuejine">
					<el-input v-model="ruleForm.jieyuejine" placeholder="借阅金额" clearable  :readonly="ro.jieyuejine"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="借阅金额" prop="jieyuejine">
					<el-input v-model="ruleForm.jieyuejine" placeholder="借阅金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="出借账号" prop="chujiezhanghao">
					<el-input v-model="ruleForm.chujiezhanghao" placeholder="出借账号" clearable  :readonly="ro.chujiezhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="出借账号" prop="chujiezhanghao">
					<el-input v-model="ruleForm.chujiezhanghao" placeholder="出借账号" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"0","margin":"20px 0 0"}' class="btn">
				<el-button :style='{"cursor":"pointer","padding":"0 30px","margin":"0 20px 0 0","borderColor":"#1fbfae","color":"#fff","minWidth":"100px","outline":"none","borderRadius":"0px","background":"#7ca065","borderWidth":"0px","width":"auto","lineHeight":"40px","fontSize":"14px","borderStyle":"solid double solid double","height":"44px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"cursor":"pointer","padding":"0 24px","margin":"0","borderColor":"#dc333b","color":"#fff","minWidth":"100px","outline":"none","borderRadius":"0px","background":"#b0a59a","borderWidth":"0px","width":"auto","lineHeight":"40px","fontSize":"14px","borderStyle":"solid double solid double","height":"44px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"cursor":"pointer","padding":"0 24px","margin":"0","borderColor":"#dc333b","color":"#fff","minWidth":"100px","outline":"none","borderRadius":"0px","background":"#b0a59a","borderWidth":"0px","width":"auto","lineHeight":"40px","fontSize":"14px","borderStyle":"solid double solid double","height":"44px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
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
            uObject: null,
			type: '',
			
			
			ro:{
				jieyuebianhao : false,
				tushubianhao : false,
				tushumingcheng : false,
				shuliang : false,
				meirifeiyong : false,
				jieyuetianshu : false,
				yajin : false,
				jine : false,
				jiechushijian : false,
				jieyuezhanghao : false,
				jieyuejine : false,
				chujiezhanghao : false,
			},
			
			
			ruleForm: {
				jieyuebianhao: this.getUUID(),
				tushubianhao: '',
				tushumingcheng: '',
				shuliang: '',
				meirifeiyong: '',
				jieyuetianshu: '',
				yajin: '',
				jine: '',
				jiechushijian: '',
				jieyuezhanghao: '',
				jieyuejine: '',
				chujiezhanghao: '',
			},
		
			
			rules: {
				jieyuebianhao: [
				],
				tushubianhao: [
				],
				tushumingcheng: [
				],
				shuliang: [
					{ required: true, message: '数量不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				meirifeiyong: [
					{ required: true, message: '每日费用不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				jieyuetianshu: [
					{ required: true, message: '借阅天数不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				yajin: [
					{ required: true, message: '押金不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				jine: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				jiechushijian: [
				],
				jieyuezhanghao: [
				],
				jieyuejine: [
				],
				chujiezhanghao: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



		jine:{
			
			get: function () {
				return 1*this.ruleForm.shuliang*this.ruleForm.meirifeiyong*this.ruleForm.jieyuetianshu+parseFloat(this.ruleForm.yajin==""?0:this.ruleForm.yajin)
			}
		},
	},
	created() {
		this.ruleForm.jiechushijian = this.getCurDate()
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
						if(o=='jieyuebianhao'){
							this.ruleForm.jieyuebianhao = obj[o];
							this.ro.jieyuebianhao = true;
							continue;
						}
						if(o=='tushubianhao'){
							this.ruleForm.tushubianhao = obj[o];
							this.ro.tushubianhao = true;
							continue;
						}
						if(o=='tushumingcheng'){
							this.ruleForm.tushumingcheng = obj[o];
							this.ro.tushumingcheng = true;
							continue;
						}
						if(o=='shuliang'){
							this.ruleForm.shuliang = obj[o];
							this.ro.shuliang = true;
							continue;
						}
						if(o=='meirifeiyong'){
							this.ruleForm.meirifeiyong = obj[o];
							this.ro.meirifeiyong = true;
							continue;
						}
						if(o=='jieyuetianshu'){
							this.ruleForm.jieyuetianshu = obj[o];
							this.ro.jieyuetianshu = true;
							continue;
						}
						if(o=='yajin'){
							this.ruleForm.yajin = obj[o];
							this.ro.yajin = true;
							continue;
						}
						if(o=='jine'){
							this.ruleForm.jine = obj[o];
							this.ro.jine = true;
							continue;
						}
						if(o=='jiechushijian'){
							this.ruleForm.jiechushijian = obj[o];
							this.ro.jiechushijian = true;
							continue;
						}
						if(o=='jieyuezhanghao'){
							this.ruleForm.jieyuezhanghao = obj[o];
							this.ro.jieyuezhanghao = true;
							continue;
						}
						if(o=='jieyuejine'){
							this.ruleForm.jieyuejine = obj[o];
							this.ro.jieyuejine = true;
							continue;
						}
						if(o=='chujiezhanghao'){
							this.ruleForm.chujiezhanghao = obj[o];
							this.ro.chujiezhanghao = true;
							continue;
						}
				}
				



				this.ruleForm.shuliang = 0
				this.ro.shuliang = false;









			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
                    this.uObject = data.data;
					if(((json.jieyuezhanghao!=''&&json.jieyuezhanghao) || json.jieyuezhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.jieyuezhanghao = json.jieyuezhanghao
						this.ro.jieyuezhanghao = true;
					}
					if(((json.jine!=''&&json.jine) || json.jine==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.jieyuejine = json.jine
						this.ro.jieyuejine = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `tushujieyue/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
        this.ruleForm.jine = this.jine

























var objcross = this.$storage.getObj('crossObj');
      var table = this.$storage.getObj('crossTable');
      if(objcross!=null) {
	      objcross.shuliang = objcross.shuliang - this.ruleForm.shuliang
	      if(objcross.shuliang<0){
		this.$message.error("数量不足");
		return
	      }
                }

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
                              this.$http({
                                  url: `${table}/update`,
                                  method: "post",
                                  data: objcross
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
				url: "tushujieyue/page", 
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
					   url: `tushujieyue/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
                         if(this.uObject.jine){
                             this.uObject.jine = parseFloat(this.uObject.jine) - parseFloat(this.ruleForm.jine)
                             this.$http({url: `${this.$storage.get('sessionTable')}/update`,method: "post",data: this.uObject}).then(res => {});
                         }
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.tushujieyueCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
                      this.$http({
                          url: `${table}/update`,
                          method: "post",
                          data: objcross
                        }).then(({ data }) => {});
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
			   url: `tushujieyue/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
                  if(this.uObject.jine){
                      this.uObject.jine = parseFloat(this.uObject.jine) - parseFloat(this.ruleForm.jine)
                      this.$http({url: `${this.$storage.get('sessionTable')}/update`,method: "post",data: this.uObject}).then(res => {});
                  }
                  this.$http({
                      url: `${table}/update`,
                      method: "post",
                      data: objcross
                    }).then(({ data }) => {});
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.tushujieyueCrossAddOrUpdateFlag = false;
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
      this.parent.tushujieyueCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
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
	  	  text-shadow: 0 1px 10px #fff;
	  	  color: #666;
	  	  background: none;
	  	  font-weight: 500;
	  	  display: block;
	  	  width: 120px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  background: rgba(149,141,130,.1);
	  	  width: 400px;
	  	  font-size: 14px;
	  	  border-color: #958d82;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  background: rgba(149,141,130,.1);
	  	  width: 400px;
	  	  font-size: 14px;
	  	  border-color: #958d82;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 0px solid #333;
	  	  padding: 0 10px 0 30px;
	  	  color: #666;
	  	  font-size: 14px;
	  	  border-color: #958d82;
	  	  border-radius: 0px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  background: rgba(149,141,130,.1);
	  	  width: 400px;
	  	  border-width: 1px;
	  	  border-style: solid;
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
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  color: #958d82;
	  	  font-size: 32px;
	  	  border-color: #958d82;
	  	  line-height: 90px;
	  	  border-radius: 0px;
	  	  background: rgba(149,141,130,.1);
	  	  width: 200px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  color: #958d82;
	  	  font-size: 32px;
	  	  border-color: #958d82;
	  	  line-height: 90px;
	  	  border-radius: 0px;
	  	  background: rgba(149,141,130,.1);
	  	  width: 200px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  color: #958d82;
	  	  font-size: 32px;
	  	  border-color: #958d82;
	  	  line-height: 90px;
	  	  border-radius: 0px;
	  	  background: rgba(149,141,130,.1);
	  	  width: 200px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  padding: 12px;
	  	  color: #666;
	  	  font-size: 14px;
	  	  border-color: #958d82;
	  	  min-height: 120px;
	  	  border-radius: 0px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  background: rgba(149,141,130,.1);
	  	  width: 500px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: auto;
	  	}
</style>
