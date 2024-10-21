<template>
	<div class="main-content">
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"width":"100%","margin":"0px 0 0","flexWrap":"wrap","display":"flex"}' :inline="true" :model="searchForm">
				<el-row :style='{"minHeight":"100vh","padding":"34px 20px 140px","boxShadow":"0 2px 0px rgba(0,0,0,.1)","top":"94px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20221203/1f4690773fd84e218e0ef7d69885ee30.png) no-repeat left top,url(http://codegen.caihongy.cn/20221203/1057db36d2aa4bd4b375aa0ccb752a40.png) repeat-x left top,#7ca065","display":"block","width":"240px","position":"fixed","right":"0","order":"1"}' >
					<div :style='{"flexWrap":"wrap","margin":"0 0px 10px","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#fff","textAlign":"left","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">图书编号</label>
						<el-input v-model="searchForm.tushubianhao" placeholder="图书编号" clearable></el-input>
					</div>
					<div :style='{"flexWrap":"wrap","margin":"0 0px 10px","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#fff","textAlign":"left","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">图书名称</label>
						<el-input v-model="searchForm.tushumingcheng" placeholder="图书名称" clearable></el-input>
					</div>
					<el-button :style='{"cursor":"pointer","padding":"0 30px","boxShadow":"4px 4px 0px #9ea69a","borderColor":"#ea8501","margin":"10px auto","color":"#333","outline":"none","borderRadius":"0","background":"#fff","borderWidth":"0px","width":"90px","fontSize":"16px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"width":"100%","padding":"0","margin":"20px 0 10px","background":"none","display":"flex"}'>
					<el-button :style='{"border":"0px dotted #a347ea","cursor":"pointer","padding":"0 8px","boxShadow":"4px 4px 0px rgba(0,0,0,.1)","margin":"0 10px 10px 0","color":"#7ca065","minWidth":"68px","outline":"none","borderRadius":"0px","background":"rgba(124,160,101,.2)","width":"auto","fontSize":"14px","height":"36px"}' v-if="isAuth('tushujieyue','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"0px dotted #df2543","cursor":"pointer","padding":"0 8px","boxShadow":"4px 4px 0px rgba(0,0,0,.1)","margin":"0 10px 10px 0","color":"#d67081","minWidth":"68px","outline":"none","borderRadius":"0px","background":"rgba(223,37,67,.2)","width":"auto","fontSize":"14px","height":"36px"}' v-if="isAuth('tushujieyue','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>




				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='true'
					:style='{"padding":"0","borderColor":"#c7b9b0","margin":"0px 0 20px","borderRadius":"0px","borderWidth":"0px 1px 1px 1px","background":"none","width":"100%","borderStyle":"solid","order":"4"}' 
					v-if="isAuth('tushujieyue','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' label="索引" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='false'  
						prop="jieyuebianhao"
					label="借阅编号">
						<template slot-scope="scope">
							{{scope.row.jieyuebianhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="tushubianhao"
					label="图书编号">
						<template slot-scope="scope">
							{{scope.row.tushubianhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="tushumingcheng"
					label="图书名称">
						<template slot-scope="scope">
							{{scope.row.tushumingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shuliang"
					label="数量">
						<template slot-scope="scope">
							{{scope.row.shuliang}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="meirifeiyong"
					label="每日费用">
						<template slot-scope="scope">
							{{scope.row.meirifeiyong}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="jieyuetianshu"
					label="借阅天数">
						<template slot-scope="scope">
							{{scope.row.jieyuetianshu}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="yajin"
					label="押金">
						<template slot-scope="scope">
							{{scope.row.yajin}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="jine"
					label="金额">
						<template slot-scope="scope">
							{{scope.row.jine}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="jiechushijian"
					label="借出时间">
						<template slot-scope="scope">
							{{scope.row.jiechushijian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="jieyuezhanghao"
					label="借阅账号">
						<template slot-scope="scope">
							{{scope.row.jieyuezhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="jieyuejine"
					label="借阅金额">
						<template slot-scope="scope">
							{{scope.row.jieyuejine}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="chujiezhanghao"
					label="出借账号">
						<template slot-scope="scope">
							{{scope.row.chujiezhanghao}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"0px solid #18cfa5","cursor":"pointer","padding":"0 16px","boxShadow":"2px 2px 0px rgba(100,100,100,.1)","margin":"3px 6px 3px 0","outline":"none","color":"#18cfa5","borderRadius":"4px","background":"rgba(24,207,165,.1)","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('tushujieyue','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"0px solid #18cfa5","cursor":"pointer","padding":"0 16px","boxShadow":"2px 2px 0px rgba(100,100,100,.1)","margin":"3px 6px 3px 0","outline":"none","color":"#18cfa5","borderRadius":"4px","background":"rgba(24,207,165,.1)","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('tushujieyue','归还')" type="success" size="mini" @click="tushuguihaiCrossAddOrUpdateHandler(scope.row,'cross','','','')">归还</el-button>
							<el-button :style='{"border":"0px solid #1fbfae","cursor":"pointer","padding":"0 16px","boxShadow":"2px 2px 0px rgba(100,100,100,.1)","margin":"3px 6px 3px 0","outline":"none","color":"#4d9be3","borderRadius":"4px","background":"rgba(77,155,227,.1)","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('tushujieyue','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"0px solid #dc333b","cursor":"pointer","padding":"0 16px","boxShadow":"2px 2px 0px rgba(100,100,100,.1)","margin":"3px 6px 3px 0","outline":"none","color":"#dc333b","borderRadius":"4px","background":"rgba(220,51,59,.1)","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('tushujieyue','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="true"
					:style='{"padding":"8px 10px","margin":"20px 0 0","borderColor":"#2adbcb","whiteSpace":"nowrap","color":"#b35ff3","background":"none","borderWidth":"0px","width":"100%","lineHeight":"54px","borderStyle":"dotted dashed solid double","fontWeight":"500","order":"5","height":"54px"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<tushuguihai-cross-add-or-update v-if="tushuguihaiCrossAddOrUpdateFlag" :parent="this" ref="tushuguihaiCrossaddOrUpdate"></tushuguihai-cross-add-or-update>




	</div>
</template>

<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import tushuguihaiCrossAddOrUpdate from "../tushuguihai/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      tushuguihaiCrossAddOrUpdateFlag: false,
      layouts: ["total","prev","pager","next","sizes","jumper"],


    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
    tushuguihaiCrossAddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },

    tushuguihaiCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.tushuguihaiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','tushujieyue');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.tushuguihaiCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.tushuguihaiCrossaddOrUpdate.init(row.id,type);
      });
    },







    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.tushubianhao!='' && this.searchForm.tushubianhao!=undefined){
            params['tushubianhao'] = '%' + this.searchForm.tushubianhao + '%'
          }
           if(this.searchForm.tushumingcheng!='' && this.searchForm.tushumingcheng!=undefined){
            params['tushumingcheng'] = '%' + this.searchForm.tushumingcheng + '%'
          }
      this.$http({
        url: "tushujieyue/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "tushujieyue/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 4px solid #7ca065;
				border-radius: 0;
				padding: 0 20px;
				box-shadow: 0px 0px 0px #ccc;
				outline: none;
				color: #666;
				background: rgba(255,255,255,.9);
				width: 100%;
				font-size: 14px;
				height: 44px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 4px solid #7ca065;
				border-radius: 0px;
				padding: 0 20px;
				box-shadow: 0px 0px 0px #ccc;
				outline: none;
				color: #666;
				background: rgba(255,255,255,.9);
				width: 1005;
				font-size: 14px;
				height: 44px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 4px solid #7ca065;
				border-radius: 0px;
				padding: 0 20px 0 30px;
				box-shadow: 0px 0px 0px #ccc;
				outline: none;
				color: #666;
				background: rgba(255,255,255,.9);
				width: 100%;
				font-size: 14px;
				height: 44px;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 10px;
				color: #fff;
				background: #9e8d83;
				border-color: #c7b9b0;
				border-width: 1px 1px 1px 0px;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				border: 0;
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				border: 0;
				background: none;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 4px 0;
				color: #666;
				background: none;
				border-color: #c7b9b0;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
		.el-table /deep/ .el-table__body-wrapper tbody tr.el-table__row--striped td {
		background: rgba(158,141,131,.1);
	}
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 4px 0;
				color: #333;
				background: rgba(149,141,130,.1);
				border-color: #c7b9b0;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 4px 0;
				color: #666;
				background: none;
				border-color: #c7b9b0;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #999;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: 1px solid #999;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				min-width: 35px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: 1px solid #999;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				line-height: 28px;
				min-width: 35px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: 1px solid #999;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: 1px solid #999;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				border: 1px solid #999;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				text-align: center;
				min-width: 30px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				border: 0;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #7ca065;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				text-align: center;
				min-width: 30px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #7ca065;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				text-align: center;
				min-width: 30px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #999;
				cursor: pointer;
				border-radius: 3px;
				padding: 0 25px 0 8px;
				outline: 0;
				color: #999;
				background: #FFF;
				display: inline-block;
				width: 100%;
				font-size: 13px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #999;
				width: 25px;
				font-size: 14px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #999;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				position: relative;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #999;
				cursor: pointer;
				border-radius: 3px;
				padding: 0 3px;
				outline: 0;
				color: #999;
				background: #FFF;
				display: inline-block;
				width: 100%;
				font-size: 14px;
				text-align: center;
			}
</style>
